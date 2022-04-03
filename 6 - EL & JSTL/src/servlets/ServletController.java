package servlets;

import dao.LibroDAO;
import dominio.Carrito;
import dominio.Libro;
import dominio.Usuario;
import servicios.CarritoServicio;

import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;
import static java.util.logging.Level.*;

@WebServlet(name = "ServletController")
public class ServletController extends HttpServlet {
    private static final long serialVersionUID= 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String mensajeError="";
        String vista="/listadolibros.jsp";

        try {
            HttpSession sesion = request.getSession();
            String usuario = (String) sesion.getAttribute("user");
            if (usuario==null)
            {
                mensajeError = "No se ha registrado ni ha accedido";
                request.setAttribute("mensajeError", mensajeError);
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
            String libro="";
            Collection<Libro> libros = null; //colection donde se guardaran los libros de la BBDD
            //mostramos toda la lista de libros
            libros = LibroDAO.mostrarLibros();
            request.setAttribute("libros", libros);
            if (request.getParameter("libro")!=null)
            libro = request.getParameter("libro"); //opcion del libro seleccionada
           /* if (request.getParameter("cantidad")!=null)
            cantidad=Integer.parseInt(request.getParameter("cantidad")); //cantidad a comprar*/
            //controlar los submits, que hacen diferentes operaciones

            /*Collection<String> cookiesOrdenadas = (Collection<String>)request.getSession().getAttribute("cookiesSet");
            if(cookiesOrdenadas==null){
                Cookie cookies[] = request.getCookies();
                cookiesOrdenadas = new TreeSet<String>();
                if(cookies!=null)
                {
                    for(Cookie c:cookies)
                    {
                        if(c.getName().equals("librosBuscados"))
                        {
                            String librosBuscados = c.getValue();
                            String palabras[] = librosBuscados.split(":");
                            for(String palabra:palabras)
                                cookiesOrdenadas.add(palabra);
                        }
                    }
                    request.getSession().setAttribute("cookiesSet", cookiesOrdenadas);
                }
            }

            if(libro != null) {
                cookiesOrdenadas.add(libro.toLowerCase());

                //StringBuffer cookieSB = new StringBuffer();
                for (String busqueda : cookiesOrdenadas) {
                    //   cookieSB.append(busqueda + ":");

                    //cookieSB.deleteCharAt(cookieSB.length() - 1);

                    Cookie cookieBusqueda = new Cookie("librosBuscados", busqueda);
                    cookieBusqueda.setHttpOnly(true);
                    cookieBusqueda.setPath("/");
                    cookieBusqueda.setMaxAge(Integer.MAX_VALUE);
                    response.addCookie(cookieBusqueda);
                }
                }*/

           /* if (libro!=null)
            {
                Cookie libroBuscado=new Cookie("librosBuscados",libro);
                libroBuscado.setMaxAge(Integer.MAX_VALUE);
                response.addCookie(libroBuscado);
                request.getSession().setAttribute("cookiesSet", libroBuscado);

            }*/

                if (request.getParameter("anadir") != null)
                {
                    if (request.getParameter("cantidad")!=null)
                    new CarritoServicio(request).comprar(libro, parseInt(request.getParameter("cantidad")));
            }
                else if (request.getParameter("limpiar") != null)
                    new CarritoServicio(request).vaciar();
                else if (request.getParameter("finalizar") != null)
                    vista = "/comprar.jsp";
        }catch(NumberFormatException e)
        {
            Logger.getLogger(ServletController.class.getName()).log(SEVERE, null, e);
            mensajeError = "Cantidad numérica no válida";
            request.setAttribute("mensajeError", mensajeError);
            vista = "/error.jsp";
        } catch (SQLException e) {
            Logger.getLogger(ServletController.class.getName()).log(SEVERE, null, e);
            mensajeError = "Error interno de la BBDD";
            request.setAttribute("mensajeError", mensajeError);
            vista = "/error.jsp";
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ServletController.class.getName()).log(SEVERE, null, e);
            mensajeError = "Error de conexión con la BBDD";
            request.setAttribute("mensajeError", mensajeError);
            vista = "/error.jsp";
        }

        request.getRequestDispatcher(vista).forward(request,response); //envia los recursos a jsp correspondiente según se haya cometido o no un error
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
