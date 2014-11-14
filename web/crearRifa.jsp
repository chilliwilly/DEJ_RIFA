<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Crear Rifa</title>
    </head>
    <body>
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <div id="contendor">
            <%@include file="WEB-INF/banner.jspf" %>
            <%@include file="WEB-INF/menu.jspf" %>
            <div id = "cuerpo">
                <div class="page-header">
                    <h1>Crear Rifa</h1>
                </div>
                <form class="form-inline" role="form" action="<c:url value="/CrearServlet" />" method="post">
                    <div class="form-group">
                        <label for="nomCampo">Cantidad de Números</label> &nbsp;
                        <select name="cboCantNro" class="form-control">
                            <option value="10" selected>10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                            <option value="40">40</option>
                            <option value="50">50</option>
                            <option value="100">100</option>
                        </select>
                    </div>
                    &nbsp;
                    <button type="submit" class="btn btn-primary btn-sm">Crear Rifa</button>
                    <p>
                        <c:if test="${not empty estado}">
                            <div class="alert alert-success"><c:out value="${estado}" /></div>
                        </c:if>
                    </p>
                </form>
            </div>
            <%@include file="WEB-INF/pie.jspf" %>
        </div>
    </body>
</html>
