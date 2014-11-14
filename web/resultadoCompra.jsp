<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Resultado Compra Rifa</title>
    </head>
    <body>
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <div id="contendor">
            <%@include file="WEB-INF/banner.jspf" %>
            <%@include file="WEB-INF/menu.jspf" %>
            <div id = "cuerpo">
                <div class="page-header">
                    <h1>Resultado de Compra</h1>
                </div>
                <p>
                    <c:if test="${not empty mensajeCompra}">
                        <c:if test="${empty error}">
                            <div class="alert alert-success"><c:out value="${mensajeCompra}" /></div>
                        </c:if>
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger"><c:out value="${mensajeCompra}" /></div>
                        </c:if>
                    </c:if>
                </p>
            </div>
            <%@include file="WEB-INF/pie.jspf" %>
        </div>
    </body>
</html>
