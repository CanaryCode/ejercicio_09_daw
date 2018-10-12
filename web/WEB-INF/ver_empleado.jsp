
<%@page import="innui.ejercicio_jsp_09.Empleados"%>
<%@ page import="java.util.Date"%>

<%
Empleados empleado=(Empleados)session.getAttribute("empleado");
int edad= new Date().getYear() - empleado.getFdn().getYear();
String departamento="";
if(empleado.getDepartamento().matches("1")){departamento="Sitemas";}
if(empleado.getDepartamento().matches("2")){departamento="Contabilidad";}
if(empleado.getDepartamento().matches("3")){departamento="Recursos humanos";}
if(empleado.getDepartamento().matches("4")){departamento="Administracion";}
if(empleado.getDepartamento().matches("5")){departamento="Servicios generales";}
%>
<td>
	<img  width="150" height="200" src="subidos/<%=empleado.getFoto()%>"/> 
</td>
<td>
	<table width="100%" border="0" cellspacing="0" cellpadding="1">
		<tr><td>ID</td><td><%=empleado.getId()%></td></tr>
		<tr>
  			<td>NOMBRE</td><td><%=empleado.getNombre()+" "+empleado.getApellido()%></td>
		</tr>
		<tr>
  			<td>IDENTIFICACIÓN</td><td><%=empleado.getIdentificacion()%></td>
		</tr>
		<tr>
   			<td>DEPARTAMENTO</td><td><%=departamento%></td>
		</tr>
		<tr>
    		<td>SUELDO</td><td><%=empleado.getSueldo()%></td>
  		</tr>
		<tr>
    		<td>AUXILIO</td><td><%=empleado.getTransporte()%></td>
  		</tr>
		<tr>
    		<td>TOTAL DEVENGADO</td><td><%=empleado.getTransporte()+empleado.getSueldo()%></td>
  		</tr>
	</table>
</td>	