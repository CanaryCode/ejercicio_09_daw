
<form action="WEB-INF/proceso_vista." method="post" enctype="multipart/form-data" >
	<table id="registro" width="110" border="0" cellspacing="0" cellpadding="5">
		<tr align="center">
			<td colspan="2" align="center">DATOS EMPLEADO</td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td><input name="nombre" type="text"> </td>
		</tr>
		<tr>
			<td>Apellido</td>
			<td><input name="apellido" type="text"></td>
		</tr>
		<tr>
			<td>Identificacion</td>
			<td><input name="identificacion" type="text"></td>
		</tr>
		<tr>
			<td>Fecha de nacimiento</td>
    		<td><input name="fdn" type="text" value="dd/MM/yyyy"></td>
  		</tr>
  		<tr>
    		<td valign="top">Departamento</td>
    		<td> 
				<input type="radio" name="departamento" value="1">Sitemas<br>
    			<input type="radio" name="departamento" value="2">Contabilidad<br>
				<input type="radio" name="departamento" value="3">Recursos humanos<br>
				<input type="radio" name="departamento" value="4">Administracion<br>
				<input type="radio" name="departamento" value="5">Servicios generales
	    	</td>
  		</tr>
  		<tr>
    		<td>Sueldo</td>
    		<td><input name="sueldo" type="text"></td>
  		</tr>
  		<tr>
    		<td>Auxilio de transporte</td>
    		<td><input name="transporte" type="text"></td>
  		</tr>
  		<tr>
    		<td>Foto</td>
    		<td><input name="foto" type="file"></td>
  		</tr>
  		<tr align="center">
    		<td colspan="2" align="center"><input type="submit" value="Guargar"></td>
  		</tr>
	</table>
</form>
