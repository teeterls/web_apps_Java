package dao;

import dominio.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {
    private static String QUERY_AGREGAR= "INSERT INTO usuario(user, pwd) VALUES (?,?)";
    private static  String QUERY_BUSCAR= "SELECT * FROM usuario WHERE user = ? AND pwd = ?";

    //private static UsuarioDAO dao;

    /*public static UsuarioDAO getInstance()
    {
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (dao == null || !con.isValid(0) || con.isClosed()) {
                dao = new UsuarioDAO();
                System.out.println("Debug: Nueva DAO");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return dao;
    }*/

    public static boolean agregarUsuario(Usuario usuario) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                    PreparedStatement ps = con.prepareStatement(QUERY_AGREGAR);
                    ps.setString(1, usuario.getUser());
                    ps.setString(2, usuario.getPwd());
                    ps.execute();
                    agregado = true;
                    ps.close();
                }
                con.close();
        } catch (SQLException e) {
            agregado = false;
            e.printStackTrace();
        }
        return agregado;
    }

    public static boolean buscarUsuario(Usuario usuario) {
        boolean existe = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                PreparedStatement ps= con.prepareStatement(QUERY_BUSCAR);
                ps.setString(1, usuario.getUser());
                ps.setString(2, usuario.getPwd());
                ResultSet rs= ps.executeQuery();
                if (rs.next())
                    existe=true;
                else
                    existe=false;
                con.close();
            }
        }catch(SQLException e) {
            existe = false;
            e.printStackTrace();
        }
        return existe;
    }
}




