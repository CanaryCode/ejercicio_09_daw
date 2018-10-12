<%@ page import="innui.ejercicio_jsp_09.Conexiones"%>


<%
    String[] error = {""};
    boolean ret = true;
    ret = Conexiones.controlador(session, error);
    String error_mensaje = error[0];
%>

<table width="100%" border="0" cellspacing="0" cellpadding="5">
    <tr>
        <td colspan="2" valign="top" align="right">
            <div id="titulo" align="right"><img src="imagenes/wallpaper.png" width="282" height="95"></div>
        </td>
    </tr>
    <tr>
        <td valign="top">
            <jsp:include page="registro_empleado_vista.jsp"/>
        </td>
        <td>
            <div style="height:650px; overflow:scroll;">

                <jsp:include page="listar_empleado_vista.jsp"/>
            </div>
        </td>
    </tr>
</table>

