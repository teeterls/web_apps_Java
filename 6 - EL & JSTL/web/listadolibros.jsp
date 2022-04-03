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

    <h5> <span> Hola, ${sessionScope.user}! </span> &nbsp Seleccione un libro:</h5>
<div id="Error"></div>

    <form action="ServletController" id="formulario" method="post" name="formulario" style="margin:20px;">
         <!--recorre el parametro libros, que es una Collection-->
      <select id="libro" name="libro" size="${fn:length(libros)}">
          <c:forEach var="l" items="${libros}">
          <option>${l.titulo}</option>
          </c:forEach>
      </select>
        <br>
        <label>Cantidad:</label> <input type="text" id="cantidad" name="cantidad" style="margin: 7px 0px" onclick="Borrar();">
        <br>
        <input type="submit" class="in" name="anadir" value="Añadir a la cesta" onclick="return Validar();"/> &nbsp
        <input type="submit" class="in" name="limpiar" value="Limpiar"/> <br><br>
        <input type="submit" class="in" id="fin" name="finalizar" value="Finalizar la compra" style="align-content: center"/>
    </form>

<!--carrito de compra de libros con mensajes de errores-->
    <ul>
    <c:if test="${not empty sessionScope.carrito.map}">
    <c:forEach var="libroCarrito" items="${sessionScope.carrito.map}"> <!--esta cogiendo el HM carrito, con el libro y la cantidad-->
     <div id="productos">*Añadido a la cesta ${libroCarrito.value} unidades del libro: ${libroCarrito.key.titulo}</div><br>
</c:forEach>
    </c:if>
        <c:if test="${empty sessionScope.carrito}">
        <div id="cesta"> <strong> Cesta vacía </strong><div>
        </c:if>
    </ul>
</body>
</html>