<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/estilos.css" type="text/css"/>
        <title>Crear Rifa</title>
    </head>
    <body>
        <div id="contendor">
            <%@include file="WEB-INF/banner.jspf" %>
            <%@include file="WEB-INF/menu.jspf" %>
            <div id = "cuerpo">
                <br>
                <h1><u>Crear Rifa</u></h1>
                <form action="<c:url value="/CrearServlet" />" method="post">
                    <table>
                        <tr>
                            <td>Cantidad Cuotas &nbsp;</td>
                            <td>: &nbsp;</td>
                            <td>
                                <select name="cboCantNro" multiple>
                                    <option value="10">10</option>
                                    <option value="20">20</option>
                                    <option value="30">30</option>
                                    <option value="40">40</option>
                                    <option value="50">50</option>
                                    <option value="100">100</option>
                                </select>                             
                            </td>
                        </tr>
                        <tr id="tBoton">
                            <td colspan="3"><input type="submit" value="Crear"/></td>
                        </tr>
                    </table>
                </form>
            </div>
            <%@include file="WEB-INF/pie.jspf" %>
        </div>
    </body>
</html>
