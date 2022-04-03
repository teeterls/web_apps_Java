package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;

import dominio.Vehiculo;

public class VehiculoDAO {

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public VehiculoDAO(ConexionDAO conDAO, Integer flag, String matricula)
    {
        this.vehiculos = vehiculos;
        if (flag == 0) {
                try {
                    Statement s = conDAO.getConexion().createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM vehiculos");
                    while (rs.next()) {
                        vehiculos.add(new Vehiculo(rs.getInt(1), rs.getString(3), rs.getString(2), rs.getString(4)));
                    }
                    rs.close();
                    s.close();
                    conDAO.getConexion().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }else if (flag == 1) {
            try {
                PreparedStatement ps = conDAO.getConexion().prepareStatement("SELECT * FROM vehiculos WHERE matricula = ?" );
                ps.setString(1, matricula); //siempre es 1 con preparedStatement
                ResultSet rs= ps.executeQuery();
                while(rs.next()) {
                    vehiculos.add(new Vehiculo(rs.getInt(1), rs.getString(3), rs.getString(2), rs.getString(4)));
                }
                rs.close();
                ps.close();
                conDAO.getConexion().close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("Error. Usage: VehiculoDAO(ConexionDAO conDAO, Integer flag); flag = [0, 1]");
        }
    }

    public ArrayList<Vehiculo> findAllVehiculos()
    {
        return this.vehiculos;
    }

    public ArrayList<Vehiculo> findByMatricula(String matricula)
    {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        Vehiculo v = null;
        Iterator<Vehiculo> it = this.vehiculos.iterator();
        while(it.hasNext()) {
            v = it.next();
            if (v.getMatricula().equals(matricula)) {
                resultado.add(v);
                System.out.println(v.toString());
            }
        }
        return resultado;
    }

    public ArrayList<Vehiculo> findByMatriculaSegura(String matricula)
    {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        Vehiculo v = null;
        Iterator<Vehiculo> it = this.vehiculos.iterator();
        while(it.hasNext()) {
            v = it.next();
            if (v.getMatricula().equals(matricula)) {
                resultado.add(v);
                System.out.println(v.toString());

            }
        }
        return resultado;
    }

}
