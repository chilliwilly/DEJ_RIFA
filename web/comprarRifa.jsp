<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Comprar Rifa</title>
    </head>
    <body>
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <div id="contenedor">
            <%@include file="WEB-INF/banner.jspf" %>
            <%@include file="WEB-INF/menu.jspf" %>
            <div id="cuerpo">
                <div class="page-header">
                    <h1>Comprar Rifa</h1>
                </div>
                <form class="form-inline" role="form" action="<c:url value="/ComprarServlet" />" method="post">
                    <div class="form-group">
                        <label for="CampoOculto">Número Rifa</label> &nbsp;
                        <label for="NumeroRifa"><c:out value="${rifaNumero}"/></label>
                        <input type="hidden" name="numero" value="<c:out value="${rifaNumero}" />"/>
                    </div> <br>
                    <div class="form-group">
                        <label for="CampoOculto">Nombre     </label> &nbsp;
                        <input type="text" class="form-control" placeholder="Ingrese Nombre" required="true" name="nombre">
                    </div>
                    &nbsp;
                    <button type="submit" class="btn btn-primary btn-sm">Comprar Rifa</button>                  
                </form>
            </div>
        </div>
    </body>
</html>
