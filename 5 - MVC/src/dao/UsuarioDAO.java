package dao;

import dominio.Usuario;

import java.sql.*;
import java.util.*;

public class UsuarioDAO {

    public static boolean agregarUsuario (Usuario usuario, int flag) {
        boolean agregado = false;
        int iduser=0;
        int idhobbys=0;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                if (flag==1) {
                    PreparedStatement ps1 = con.prepareStatement("INSERT INTO usuario(nombre, apellidos, sexo, fecha, user, pwd) VALUES (?,?,?,?,?,?)");
                    ps1.setString(1, usuario.getNombre());
                    ps1.setString(2, usuario.getApellidos());
                    ps1.setString(3, usuario.getSexo());
                    ps1.setString(4, usuario.getFecha());
                    ps1.setString(5, usuario.getUser());
                    ps1.setString(6, usuario.getPassword());
                    ps1.execute();
                    ps1.close();

                    String intereses[] = usuario.getHobbys();

                    for (String temp : intereses)  //todos los hobbys contenidos en el vector
                    {
                        PreparedStatement ps3= con.prepareStatement("SELECT idusuario FROM usuario WHERE user = ?");
                        ps3.setString(1, usuario.getUser());
                        ResultSet rs=ps3.executeQuery();
                        while (rs.next()) {
                            iduser = rs.getInt(1);
                        }
                        rs.close();
                        ps3.close();

                        PreparedStatement ps2 = con.prepareStatement("SELECT idhobbys from hobbys where hobby=?");
                        ps2.setString(1, temp);
                        ResultSet rs1= ps2.executeQuery();
                        while (rs1.next())
                        {
                            idhobbys = rs1.getInt(1);
                            PreparedStatement ps4= con.prepareStatement("INSERT INTO usuario_hobbys (idusuario, idhobby) VALUES (?,?)");
                            ps4.setInt(1, iduser);
                            ps4.setInt(2, idhobbys);
                            ps4.execute();
                            ps4.close();
                        }
                        rs1.close();
                        ps2.close();
                    }
                    agregado = true;

                }
                else if (flag==0)
                {
                    PreparedStatement ps = con.prepareStatement("INSERT INTO usuario(nombre, user, pwd) VALUES (?,?,?)");
                    ps.setString(1, usuario.getNombre());
                    ps.setString(2, usuario.getUser());
                    ps.setString(3, usuario.getPassword());
                    ps.execute();
                    agregado = true;
                    ps.close();
                }
                con.close();
            }
        } catch (SQLException e) {
            agregado=false;
            e.printStackTrace();
        }
        return agregado;
    }
}
