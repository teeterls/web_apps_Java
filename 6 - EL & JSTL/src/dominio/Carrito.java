package dominio;

import java.util.*;
public class Carrito {
    private HashMap <Libro, Integer> carrito;
    //clave Libro
    //valor UNIDADES (Integer, tiene que ser un OBJETO) -> con get podemos obtener las unidades en un HM
    //con put podemos añadir <K,V> al HM (par de clave-valor). CLAVE ÚNICA
    public Carrito ()
    {
        carrito = new HashMap <Libro, Integer>(); //nueva instancia
    }

    public void addLibro(Libro l, int cantidad)
    {
        Integer unidades = carrito.get(l); //obtenemos las unidades, value
        if(unidades!=null) {
            carrito.put(l, unidades + cantidad);
        }
        else
            carrito.put(l, cantidad);
    }

    public void removeLibro(Libro l)
    {
        Integer unidades = carrito.get(l);
        if(unidades==1)
            carrito.remove(l); //lo borramos xq unidades 0
        else
            carrito.put(l, unidades - 1); //le quitamos una unidad
    }

    public int getCantidades(Libro l) //cuantas unidades TOTALES hay de cada libro
    {
        Integer unidades = carrito.get(l);
        if(unidades != null)
            return unidades;
        else
            return 0;
    }

    public void clear()
    {
        carrito.clear();
    }

    public Set<Libro> getLibros() //SET DE ELEMENTOS NO REPETIDOS (CLAVE)
    {
        return carrito.keySet();
    }

    public Collection<Integer> getUnidades() //COLLECTION DE ELEMENTOS PORQUE SE PUEDE REPETIR LAS UNIDADES (VALUES)
    {
        return carrito.values();
    }

    public HashMap <Libro, Integer> getMap()
    {
        return carrito;
    }

    public int getSize() //tamaño carrito (cuantos libros hay seleccionados)
    {
        return carrito.size();
    }
}
