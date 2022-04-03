package dao;

import java.sql.*;

public class Conexion {

    private static final String USER= "root";
    private static final String PASSWORD= "root";
    private Connection conexion = null;

    public Conexion()
    {
        try{
            //cargo el driver
            Class.forName("com.mysql.jdbc.Driver");
            //hago la conexion con la BBDD MYSQL
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/libreria", USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConexion()
    {
        return this.conexion;
    }
}
