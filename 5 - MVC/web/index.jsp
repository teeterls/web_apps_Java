
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="Teresa González García 3º GITT+ADE">
    <meta name="description" content="Práctica 7-Programación Aplicaciones Telemáticas">
    <link href="css/estilo.css" rel=StyleSheet type="text/css"> <!--link CSS StyleSheet-->
   <script src="js/main.js" type="text/javascript"></script>
    <title>Práctica 6- index</title>
</head>
<body>

    <form action= "ServletRegistro" method="POST" onsubmit="return Validar()"; onreset="BorrarError();">

        <h2>Información personal</h2>

       <div class="obligatorio"> <label>*</label> <b>Nombre:</b> <br> <input type="text" id="nom" name="nombre"/> </div>
        <br/><br/>
       <b> Apellidos:</b><br><input type="text" name="apellidos"/>
        <br/><br/>
        <b>Sexo:</b> <br> <input type="radio" name ="genero" value ="Hombre"/> <label>Hombre</label>
        <br>
            <input type="radio" name ="genero" value ="Mujer"/><label>Mujer</label>
        <br/><br/>
        <b> Fecha de nacimiento:</b> <br> <input type="date" name="fecha">

        <h2>Datos de acceso</h2>
        <div class="obligatorio"><label>*</label><b>Usuario:</b> <br> <input type="text" id="usr" name="usuario"/></div>
        <br/><br/>
        <div class="obligatorio"><label>*</label><b>Contraseña:</b> <br> <input type="password" id="pwd" name="contrasena"/></div>

        <h2>Información general</h2>
        <b>Intereses:</b> <br> <input type="checkbox" name="hobbys" value="Deporte"/><label>Deporte</label>
                    <br/>
                    <input type="checkbox" name="hobbys" value="Lectura"/><label>Lectura</label>
                     <br/>
                    <input type="checkbox" name="hobbys" value="Cine"/><label>Cine</label>
                    <br/>
                    <input type="checkbox" name="hobbys" value="Viajes"/><label>Viajes</label>
        <br/><br/>
        <div id="inputs">
             <input type="submit" class="in" value="Registrar"/>
            <input type="reset"  class="in" value="Borrar"/>
        </div>
    </form>
    <br>
    <div id="Error"></div>
</body>
</html>
