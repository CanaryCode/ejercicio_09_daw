<%@ page import="org.Model"%>
<html>
	<head>
		<title>TEST 01</title>
		<style type="text/css"><%@ include file="estilo.css"%></style>
		<!--En este ejercicio repasaremos por todas las funciones vistas anteriormente -->
	</head>
	<%
	Model model= (Model)application.getAttribute("model");
	if(model==null){
		model= new Model();
		model.setDriver("com.mysql.jdbc.Driver");
		model.setUrl("jdbc:mysql://localhost:3306/ejercicios");
		model.setNombre("root");
		model.setClave("");
		
		model.conectar();
		application.setAttribute("model",model);
	}
	%>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tr>
    			<td colspan="2" valign="top" align="right">
				  <div id="titulo" align="right"><img src="wallpaper.png" width="282" height="95"></div>
			    </td>
		  	</tr>
  			<tr>
    			<td valign="top">
					<jsp:include page="registro_empleado.jsp"/>
				</td>
    			<td>
					<div style="height:650px; overflow:scroll;">
						<jsp:include page="listar_empleado.jsp"/>
					</div>
				</td>
  			</tr>
		</table>
	</body>
</html>
