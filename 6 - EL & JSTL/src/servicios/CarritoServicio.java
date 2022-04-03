package servicios;
import dominio.Libro;
import dominio.Carrito;
import dao.LibroDAO;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CarritoServicio {

    private HttpServletRequest request; //peticion HTTP
    private Carrito carrito; //HASHMAP <Libro, cantidad>


    public CarritoServicio (HttpServletRequest request)
    {
        this.request = request;
        carrito = this.getCarrito();
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    private Carrito getCarrito()
    {
        //si ya había un carrito establecido en la sesión, recuperarlo
        HttpSession sesion = request.getSession();
        carrito = (Carrito) sesion.getAttribute("carrito");
        //no había un carrito inicializado en la sesión, lo añadimos
        if (carrito==null)
        {
            carrito = new Carrito();
            sesion.setAttribute("carrito", carrito);
        }

        return carrito;
    }

    public void comprar(String titulo, int cantidad) throws ClassNotFoundException, SQLException
    {
        Libro l = null;
        l = LibroDAO.encontrarLibrosTitulo(titulo);

        if(l!=null)
            getCarrito().addLibro(l, cantidad); //se añade un libro al HM
    }

    /*public void eliminar(int id)
    {
        Libro l = new Libro(id);
        getCarrito().removeLibro(l); //se elimina un libro del HM
    }*/

    public void vaciar()
    {
        getCarrito().clear();
    }


}
