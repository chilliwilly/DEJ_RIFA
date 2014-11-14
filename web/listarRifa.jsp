<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--c:out value=num.fecha-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Lista de Números</title>
    </head>
    <body>
        <div id="contendor">
            <%@include file="WEB-INF/banner.jspf" %>
            <%@include file="WEB-INF/menu.jspf" %>
            <div class="page-header">
                <h1>Lista Números de Rifa</h1>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <table class = "table table-striped">
                        <tr>
                            <th>Número</th>
                            <th>Nombre</th>
                            <th>Fecha Compra</th>
                            <th>Comprar</th>
                        </tr>
                        <c:forEach items="${lista}" var="num">
                            <tr>
                                <td><c:out value="${num.nro}" /></td>
                                <td><c:out value="${num.nombre}" /></td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${num.fecha}"/></td>
                                <td>
                                    <div class="btn-toolbar" role="toolbar">
                                        <c:url var="urlComprar" value="/ComprarServlet">
                                            <c:param name="numero" value="${num.nro}" />
                                        </c:url>
                                        <a href="${urlComprar}">
                                            <button type="button" class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-shopping-cart"></span> Comprar
                                            </button>
                                        </a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <%@include file="WEB-INF/pie.jspf" %>
        </div>
    </body>
</html>
