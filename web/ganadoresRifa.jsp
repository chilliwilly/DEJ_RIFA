<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Lista de Ganadores</title>
    </head>
    <body>
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <div id="contendor">
            <%@include file="WEB-INF/banner.jspf" %>
            <%@include file="WEB-INF/menu.jspf" %>
            <div id = "cuerpo">
                <div class="page-header">
                    <h1>Ganadores Rifa</h1>
                </div>
                <div class="row">
                    <div class="col-xs-6">
                        <c:if test="${!lista.isEmpty()}">
                            <table class = "table table-striped">
                                <tr>
                                    <th>Número</th>
                                    <th>Nombre Ganador</th>
                                    <th>Fecha de Compra</th>
                                </tr>
                                <c:forEach items="${lista}" var="num">
                                    <tr>
                                        <td><c:out value="${num.nro}" /></td>
                                        <td><c:out value="${num.nombre}" /></td>
                                        <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${num.fecha}"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>  
                    </div>
                </div>
            </div>
            <c:if test="${lista.isEmpty()}">
                <div class="alert alert-warning">No Se Han Comprado Números</div>
            </c:if>
            <%@include file="WEB-INF/pie.jspf" %>
        </div>
    </body>
</html>
