package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import dominio.Vehiculo;

public class ConexionDAO
        {
            //constantes
            private static final String USER= "root";
            private static final String PASSWORD= "root";
            private Connection conexion;

            public ConexionDAO()
            {
                this.conexion = conexion;
                try{
                    //cargo el driver
                    Class.forName("com.mysql.jdbc.Driver");
                    //hago la conexion con la BBDD MYSQL
                    this.conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vehiculos", USER, PASSWORD);
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
