package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.*;

import static java.lang.StrictMath.round;

//@WebServlet (name="Servlet5")
public class Servlet5 extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try{
            if (request.getParameter("num1").equals("") || request.getParameter("num2").equals(""))
                throw new Exception();
            else {
                double param1 = Double.parseDouble(request.getParameter("num1"));
                double param2 = Double.parseDouble(request.getParameter("num2"));

                String operacion = request.getParameter("calcular");

                double result = 0;

                if (operacion.equals("Sumar"))
                    result = param1 + param2;
                else if (operacion.equals("Restar"))
                    result = param1 - param2;
                else if (operacion.equals("Multiplicar"))
                    result = param1 * param2;
                else {
                    if (param2 != 0)
                        result = (param1 / param2);
                    else
                        throw new ArithmeticException();
                }

                InetAddress IP=  InetAddress.getLocalHost();

                response.setStatus(200); //status HTTP
                PrintWriter out = response.getWriter();
            out.println("");
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"css/estilo.css\" rel=StyleSheet type=\"text/css\">"); //link .css
            out.println("<title>Servlet5</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"mensajes\">");
            out.println("El resultado es..." + " " + result + " " + "!");
            out.println("<br>");
            out.println("<br>");
            out.println("Dirección IP:" + " " + IP.getLocalHost());
            out.println("<br>");
            out.println("Fecha y hora actual:" + " " +new Date());
            out.println("<br>");
            out.println("Navegador utilizado:" + " " + request.getHeader("User-Agent"));
            out.println("<a href= \"Practica5.html\"> <br> Volver a calcular...</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            }
        } catch (NumberFormatException e) {

            response.sendError(500,"Digito no valido! Ha de introducir los decimales con puntos.");
        } catch (ArithmeticException a)
        {
            response.sendError(500,"No se puede dividir por 0!.");
        } catch (Exception b)
        {
            response.sendError(500, "Introduzca 2 números!");
        }

    }


}
