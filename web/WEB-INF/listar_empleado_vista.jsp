
<%@page import="innui.ejercicio_jsp_09.Empleados"%>
<%@page import="java.util.List, java.sql.Connection"%>
<jsp:useBean class="innui.ejercicio_jsp_09.Empleados" id="empleado"/>

<%
    String[] error = {""};
    boolean ret = true;
    double total_sueldo = 0.0;
    double total_ayuda_transporte = 0.0;
    Connection connection = (Connection) session.getAttribute("conexion");
    List<Empleados> empleados_lista = Empleados.listarEmpleados(error, connection);
%>
<table border="1" cellspacing="0" cellpadding="5">
    <tr><td colspan="2" align="center" >DATOS NÓMINA </td></tr>
    <%for (int i = 0; i < empleados_lista.size(); i++) {
            Empleados emp = (Empleados) empleados_lista.get(i);

            total_sueldo = total_sueldo + emp.getSueldo();
            total_ayuda_transporte = total_ayuda_transporte + emp.getTransporte();
            session.setAttribute("empleado", emp);
    %>
    <tr>
        <jsp:include page="ver_empleado.jsp"/>
    </tr>		
    <%}%>
    <tr><td>TOTAL SUELDO</td> <td><%=total_sueldo%></td> </tr>
    <tr><td>TOTAL AUXILIO</td> <td><%=total_ayuda_transporte%></td> </tr>
    <tr><td>TOTAL NÓMINA</td> <td><%=total_sueldo + total_ayuda_transporte%></td> </tr>
</table>

