<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="author" content="Teresa González García 3º GITT+ADE">
    <meta name="description" content="Práctica 7-Programación Aplicaciones Telemáticas">
    <link href="css/estilo.css" rel=StyleSheet type="text/css"> <!--link CSS StyleSheet-->
    <script src="js/main.js" type="text/javascript"></script>
    <title>${initParam.titulo}</title>
  </head>
  <body>
  <h3>Bienvenido a ${initParam.titulo} </h3>
  <img src="./images/logo.png">
<br><br>
  <form name="registro" action="ServletRegistro" method="POST" onsubmit="return Validar()">
    <label>&nbsp&nbspUsuario:&nbsp</label> <input type="text"  id="user" name="user" /><br/>
    <label>Contraseña:</label> <input type="password"  id="pwd" name="pwd" style="margin: 7px 0px"/><br/><br/>
    <input type="submit" class="in" name="registrarse" value="Registrarse"/>
    <input type="submit" class="in" name="acceder" value="Acceder"/>
  </form>
<br>
<div id="Error"></div>
  <strong>${mensajeRegistro}</strong>
  </body>
</html>
