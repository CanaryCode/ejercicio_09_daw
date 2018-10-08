<%@ page import="java.util.List"%>
<%@ page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="java.io.File" %>

<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@ page import="org.Empleado"%>
<%@ page import="org.Model"%>

<%
   	/*FileItemFactory es una interfaz para crear FileItem*/
    FileItemFactory file_factory = new DiskFileItemFactory();
		
	/*ServletFileUpload esta clase convierte los input file a FileItem*/
    ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
	/*sacando los FileItem del ServletFileUpload en una lista */
    List items = servlet_up.parseRequest(request);
	
	/*declaramos un hashmap donde guardaremos los parametros*/	
	HashMap<String,String> parametros=new HashMap<String,String>();
    for(int i=0;i<items.size();i++){
		/*FileItem representa un archivo en memoria que puede ser pasado al disco duro*/
        FileItem item = (FileItem) items.get(i);
		/*item.isFormField() false=input file; true=text field*/
		String valor="";
        if (item.isFormField()){
			valor=item.getString();
        }else{
			/*creamos un nombre, para que no se sobbre-escriban archivos*/
			valor=(new Date().getTime())+item.getName();
			/*cual sera la ruta al archivo en el servidor*/
			File archivo_server = new File("c:/Archivos de programa/Apache Software Foundation/Apache Tomcat 6.0.24(stand)/webapps/ejercicio09/subidos/"+valor);
			/*y lo escribimos en el servido*/
			item.write(archivo_server);
		}
		/*guardamos los parametros dentro del hashmap*/
		parametros.put(item.getFieldName().toLowerCase(),valor);
	}
%>
<!--A este punto hemos copiado los archivos al disco duro del servidor -->
<!--y hemos guardado todos los parametros en el hashmap llamado parametros -->
<!--ahora sacaremos los datos para guardarlos en un objeto -->
<%
	DateFormat formato_fecha = new SimpleDateFormat("dd/MM/yyyy");
	/*utilizamos la DateFormat para convertir un string a Date*/
	Empleado empleado = new Empleado();
	empleado.setNombre(parametros.get("nombre"));
	empleado.setApellido(parametros.get("apellido"));
	empleado.setIdentificacion(Integer.parseInt(parametros.get("identificacion")));
	empleado.setDepartamento(parametros.get("departamento"));
	empleado.setSueldo(Double.parseDouble(parametros.get("sueldo")) );
	empleado.setTransporte(Double.parseDouble(parametros.get("transporte")));
	empleado.setFdn(formato_fecha.parse(parametros.get("fdn")));
	empleado.setFoto(parametros.get("foto"));
	Model model=(Model)application.getAttribute("model");
	model.agregarEmpleado(empleado);
%>
<!--La parte del hasmap lo quise poner de esa forma, pero cada quien es libre de -->
<!--hacerlo como mas le gusta mas adelante lo veran de forma bastante diferente -->
<jsp:forward page="index.jsp"/>