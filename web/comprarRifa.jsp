<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/estilos.css" type="text/css"/>
        <title>Comprar Rifa</title>
    </head>
    <body>
        <div id="contenedor">
            <%@include file="WEB-INF/banner.jspf" %>
            <%@include file="WEB-INF/menu.jspf" %>
            <div id="cuerpo">
                <br>
                <h1><u>Comprar Rifa</u></h1>
                <form action="<c:url value="/ComprarServlet" />" method="post">
                    <table>
                        <tr>
                            <td>
                                Numero a Comprar:
                            </td>
                            <td>
                                <c:out value="${rifaNumero}"/>
                                <input type="hidden"
                                    name="numero"
                                    value="<c:out value="${rifaNumero}" />"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Nombre:
                            </td>
                            <td>
                                <input type="text" 
                                       required="true" 
                                       name="nombre" 
                                       placeholder="Ingrese Su Nombre"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Comprar"/>
                            </td>
                        </tr>
                    </table>                     
                </form>
            </div>
        </div>
    </body>
</html>
