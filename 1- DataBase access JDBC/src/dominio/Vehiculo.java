package dominio;

public class Vehiculo {

    private Integer idvehiculo;
    private String matricula;
    private String marca;
    private String modelo;

    public Vehiculo(Integer idvehiculo, String matricula, String marca, String modelo)
    {
        this.idvehiculo = idvehiculo;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Integer getIdvehiculo()
    {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo)
    {
        this.idvehiculo = idvehiculo;
    }

    public String getMatricula()
    {
        return matricula;
    }

    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    @Override
    public String toString()
    {
        StringBuilder sb= new StringBuilder();
        sb.append("Id vehiculo: ");
        sb.append(this.getIdvehiculo());
        sb.append(" , ");
        sb.append("Matricula: ");
        sb.append(this.getMatricula());
        sb.append(" , ");
        sb.append("Marca: ");
        sb.append(this.getMarca());
        sb.append(" , ");
        sb.append("Modelo: ");
        sb.append(this.getModelo());

        return sb.toString();
    }

}





































