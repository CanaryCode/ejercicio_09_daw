<%
String pagina = "inicio";
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/cabecera.jspf" %>
    </head>
    <body>
        <jsp:include page = '<%=("WEB-INF/"+pagina+".jsp")%>' />
    </body>
</html>
