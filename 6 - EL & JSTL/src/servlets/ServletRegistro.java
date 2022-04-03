package servlets;

import dao.UsuarioDAO;
import dominio.Usuario;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletRegistro")
public class ServletRegistro extends HttpServlet {
    private static final long serialVersionUID= 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user= request.getParameter("user");
        String pwd= request.getParameter("pwd");
        Usuario usuario=null;
        boolean existe;
        boolean agregado;
        String mensajeError="";
         if(user!= null && pwd!=null)
         {
             usuario=new Usuario(user,pwd);
             existe= UsuarioDAO.buscarUsuario(usuario);

             if (request.getParameter("acceder")!=null) //click boton acceder
             {
                 if (existe) {
                 HttpSession sesion=request.getSession(); //sesion
                 sesion.setAttribute("user", user);
                 response.sendRedirect("ServletController");

             }else{
                     mensajeError = "Todavía no se ha registrado como usuario de la tienda. Regístrese como usuario.";
                     request.setAttribute("mensajeError", mensajeError);
                     request.getRequestDispatcher("error.jsp").forward(request,response);
                 }
             }

             else if (request.getParameter("registrarse")!=null) //click boton acceder
             {
                 if (existe){
                     mensajeError = "Ya se ha registrado anteriormente como usuario de la tienda. Acceda a la tienda.";
                     request.setAttribute("mensajeError", mensajeError);
                     request.getRequestDispatcher("error.jsp").forward(request,response);
                 }else {
                     agregado=UsuarioDAO.agregarUsuario(usuario);

                     if (agregado) {
                         HttpSession sesion = request.getSession();
                         sesion.setAttribute("user", usuario);
                         String mensajeRegistro="Registro satisfactorio! Ya puede acceder a la tienda";
                         request.setAttribute("mensajeRegistro", mensajeRegistro);
                         request.getRequestDispatcher("index.jsp").forward(request,response);
                     } else {
                         mensajeError = "Error al registrarse en la BBDD. Vuelva a intentarlo.";
                         request.setAttribute("mensajeError", mensajeError);
                         request.getRequestDispatcher("error.jsp").forward(request,response);
                     }
                 }

             }
         }
    }





    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/


}
