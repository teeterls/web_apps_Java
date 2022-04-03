package dominio;

public class Libro {

    private String titulo;
    private int idlibro;

    public Libro (String titulo, int idlibro)
    {
        this.titulo=titulo;
        this.idlibro=idlibro;
    }

    public Libro (int idlibro)
    {
        this.idlibro=idlibro;
    }

    public void setTitulo(String titulo)
    {
        this.titulo=titulo;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setIdlibro( int cantidad)
    {
        this.idlibro=idlibro;
    }

    public int getIdlibro()
    {
        return idlibro;
    }
}
