package dominio;

import java.util.*;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String sexo;
    private String fecha;
    private String user;
    private String pwd;
    private String [] hobbys;

    public Usuario (String nombre, String apellidos, String sexo, String fecha, String user, String pwd, String[] hobbys)
    {
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.sexo=sexo;
        this.fecha=fecha;
        this.user=user;
        this.pwd=pwd;
        this.hobbys=hobbys;
    }

    public Usuario (String nombre, String user, String pwd)
    {
        this.nombre=nombre;
        this.user=user;
        this.pwd=pwd;
    }

    //metodos getters y setters siempre públicos
    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setApellidos (String apellidos)
    {
        this.apellidos = apellidos;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    public void setSexo (String sexo)
    {
        this.sexo=sexo;
    }

    public String getSexo()
    {
        return sexo;
    }

    public void setFecha (String fecha)
    {
        this.fecha=fecha;
    }

    public String getFecha()
    {
        return fecha;
    }
    public void setUser (String user)
    {
        this.user=user;
    }

    public String getUser()
    {
        return user;
    }
    public void setPassword (String pwd)
    {
        this.pwd=pwd;
    }

    public String getPassword()
    {
        return pwd;
    }
    public void setHobbys (String [] hobbys)
    {
        this.hobbys=hobbys;
    }

    public String [] getHobbys()
    {
        return hobbys;
    }
}
