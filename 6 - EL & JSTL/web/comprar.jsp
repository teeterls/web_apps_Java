<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="dominio.Libro"%>
<%@page import="java.util.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="Teresa González García 3º GITT+ADE">
    <meta name="description" content="Práctica 7-Programación Aplicaciones Telemáticas">
    <link href="css/estiloresponse.css" rel=StyleSheet type="text/css"> <!--link CSS StyleSheet-->
    <script src="js/libros.js" type="text/javascript"></script>
    <title>${initParam.titulo}</title>
</head>
<body>
    <h3>${initParam.titulo} <img height="90" width="200" src="./images/logo.png"/></h3>
<c:if test="${not empty sessionScope.carrito.map}">
    <span>Este es el detalle de su pedido:</span>
    <br><br><br>
        <table border="1">
            <tr>
                <td><strong>Cantidad</strong></td>
                <td><strong>Titulo</strong></td>
            </tr>
    <c:forEach var="libroCarrito" items="${sessionScope.carrito.map}">
            <tr>
                <td>${libroCarrito.value}</td>
                <td>${libroCarrito.key.titulo}</td>
            </tr>
    </c:forEach>
        </table>
    <br>
    <span>Gracias por confiar en nosotros!</span>
<br>
</c:if>

    <c:if test="${empty sessionScope.carrito.map}">
    <span> No ha seleccionado ningún producto. Gracias por confiar en nosotros </span>
    </c:if>
        <br><br>
    <div id="links"> [<a href="ServletController">Seguir comprando</a>] [<a href="ServletDesconexion">Cerrar sesión</a>]</div>
</body>
</html>
