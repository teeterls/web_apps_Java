
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="Teresa González García 3º GITT+ADE">
    <meta name="description" content="Práctica 7-Programación Aplicaciones Telemáticas">
    <link href="css/estiloresponse.css" rel=StyleSheet type="text/css"> <!--link CSS StyleSheet-->
    <title>Práctica 6- index-response</title>
</head>
<body>
    <h2>Registro satisfactorio!</h2>
    <div id="respuesta">

      <div class="label"> Nombre y Apellidos: </div> <%=request.getParameter("nombre") %> <%=request.getParameter("apellidos")%>
        <br>
        <div class="label"> Sexo:</div> <%=request.getParameter("genero") %>
        <br>
            <div class="label"> Fecha de nacimiento: </div> <%=request.getParameter("fecha") %>
        <br><br>
                <div class="label"> Usuario:</div> <%=request.getParameter("usuario") %>
        <br>
                    <div class="label"> Contraseña:</div> <%=request.getParameter("contrasena") %>
        <br><br>
                        <div class="label"> Intereses:</div>
        <ul>
            <%
            String [] intereses= request.getParameterValues("hobbys");
            //int i;
                if (intereses!=null) {
                    for (String temp : intereses) {
                        out.println ("-"+ temp + "<br>");

                    }
                }else{
                    out.println("-");
                }

                /*for (i=0;i<intereses.length;i++) //
                {
                    out.println("<li>"+intereses[i] + "\n" + "</li>");
                }*/
            %>
        </ul>
    </div>
</body>
</html>
