<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/estilos.css" type="text/css"/>
        <title>Resultado Compra Rifa</title>
    </head>
    <body>
        <div id="contendor">
            <%@include file="WEB-INF/banner.jspf" %>
            <%@include file="WEB-INF/menu.jspf" %>
            <div id = "cuerpo">
                <br />
                <h1><u>Resultado Compra</u></h1>
                <h3><c:out value="${mensajeCompra}" /></h3>
            </div>
            <%@include file="WEB-INF/pie.jspf" %>
        </div>
    </body>
</html>
