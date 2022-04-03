package servlets;
import dominio.Usuario;
import dao.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.*;

@WebServlet(name = "ServletRegistro")
public class ServletRegistro extends HttpServlet {
    private static final long serialVersionUID= 1L; //para el interface serializable

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre=request.getParameter("nombre");
        String user= request.getParameter("usuario");
        String pwd= request.getParameter("contrasena");
        String apellidos=request.getParameter("apellidos");
        String sexo=request.getParameter("genero");
        String fecha=request.getParameter("fecha");
        String [] hobbys= request.getParameterValues("hobbys");
        boolean sw;
        Usuario usuario= null;

        if ((apellidos.equals("") || sexo.equals("") || fecha.equals("") || hobbys==null))
        {
            //alguno de estos campos vacíos, usamos constructor simple
             usuario= new Usuario(nombre,user,pwd);
            sw= UsuarioDAO.agregarUsuario(usuario,0);
        } else
        {
            usuario= new Usuario(nombre,apellidos,sexo,fecha,user,pwd,hobbys);
            sw= UsuarioDAO.agregarUsuario(usuario,1);
        }

        if  (sw)
        {
            request.getRequestDispatcher("index-response.jsp").forward(request,response);
        } else
        {
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }

   /* protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/


}
