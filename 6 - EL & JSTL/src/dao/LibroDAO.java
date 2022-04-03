package dao;

import dominio.Libro;
import java.sql.*;
import java.util.*;

public class LibroDAO {
    private static String QUERY_TODOSLIBROS = "SELECT * FROM libros ORDER BY titulo";
    private static String QUERY_LIBROSTITULO = "SELECT * FROM libros WHERE titulo = ?";

    public static Collection<Libro> mostrarLibros()
    {
    ArrayList<Libro> lista = new ArrayList<Libro>();
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(QUERY_TODOSLIBROS);
                ResultSet rs= ps.executeQuery();
                while (rs.next())
                {
                    String titulo= rs.getString("titulo");
                    int idlibro= rs.getInt("idlibro");
                    lista.add(new Libro(titulo, idlibro)); //añadimos el libro
                }
                rs.close();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            lista=null;
            e.printStackTrace();
        }
        return lista;
    }

    public static Libro encontrarLibrosTitulo(String titulo)
    {
        Libro l=null;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(QUERY_LIBROSTITULO);
                ps.setString(1, titulo) ;
                ResultSet rs= ps.executeQuery();
                while (rs.next())
                {
                    String t= rs.getString("titulo");
                    int idlibro= rs.getInt("idlibro");
                    l= new Libro(t, idlibro); //nuevo libro
                }
                rs.close();
                ps.close();
            }
            con.close();

        }catch (SQLException e) {
            l=null;
            e.printStackTrace();
        }
        return l;
    }

}


