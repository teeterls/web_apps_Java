package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.*;
import java.util.Date;

@WebServlet(name = "ServletDesconexion")
public class ServletDesconexion extends HttpServlet {
    private static final long serialVersionUID= 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();

        Date duracion= new Date(sesion.getLastAccessedTime()- sesion.getCreationTime());
        InetAddress IP= InetAddress.getLocalHost();
        System.out.println("Dirección IP:" + IP.getHostAddress()+" "+"estuvo comprando:"+" "+ duracion.getTime()+ " "+"segundos");
        sesion.invalidate();
        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
