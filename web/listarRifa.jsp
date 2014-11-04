<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/estilos.css" type="text/css"/>
        <title>Lista de Números</title>
    </head>
    <body>
        <div id="contendor">
            <%@include file="WEB-INF/banner.jspf" %>
            <%@include file="WEB-INF/menu.jspf" %>
            <div id = "cuerpo">
                <br />
                <h1><u>Lista de Números</u></h1>
                <table id="tblRifa">
                    <tr>
                        <td>Num</td>
                        <td>Nombre</td>
                        <td>Fecha</td>
                        <td>Comprar</td>
                    </tr>
                    
                    <c:forEach items="${lista}" var="num">
                    <tr>
                        <td><c:out value="${num.nro}" /></td>
                        <td><c:out value="${num.nombre}" /></td>
                        <td><c:out value="${num.fecha}" /></td>
                        <td>
                            <c:url var="urlComprar" value="/ServletComprar">
                                <c:param name="numero" value="${num.nro}" />
                            </c:url>
                            <a href="${urlComprar}">
                                Comprar
                            </a>
                        </td>
                    </tr>
                    </c:forEach>
                    
                </table>
            </div>
            <%@include file="WEB-INF/pie.jspf" %>
        </div>
    </body>
</html>
