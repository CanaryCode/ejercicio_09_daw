<%@ page import="java.util.List"%>

<%@ page import="org.Empleado"%>
<%@ page import="org.Model"%>
	<%
		Model model=(Model)application.getAttribute("model");
		List lista_empleado=model.listaEmpleado();
		Double total_sueldo=0.0;
		Double total_auxili=0.0;
	 %>
		<table border="1" cellspacing="0" cellpadding="5">
			<tr><td colspan="2" align="center" >DATOS NOMINA </td></tr>
  				<%for(int i=0;i<lista_empleado.size();i++){
					Empleado empleado=(Empleado)lista_empleado.get(i);
			
					total_sueldo=total_sueldo+empleado.getSueldo();
					total_auxili=total_auxili+empleado.getTransporte();
					session.setAttribute("empleado",empleado);
			%>
			<tr>
				<jsp:include page="ver_empleado.jsp"/>
			</tr>		
		<%}%>
			<tr><td>TOTAL SUELDO</td> <td><%=total_sueldo%></td> </tr>
			<tr><td>TOTAL AUXILIO</td> <td><%=total_auxili%></td> </tr>
			<tr><td>TOTAL NOMINA</td> <td><%=total_sueldo+total_auxili%></td> </tr>
		</table>
	</body>
</html>
