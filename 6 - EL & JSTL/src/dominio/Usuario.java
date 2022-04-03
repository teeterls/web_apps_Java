package dominio;

public class Usuario {

    private String user;
    private String pwd;

    public Usuario (String user, String pwd)
    {
        this.user=user;
        this.pwd=pwd;
    }

    public void setUser (String user)

    {
        this.user=user;
    }

    public String getUser()
    {
        return user;
    }

    public void setPwd (String pwd)
    {
        this.pwd=pwd;
    }

    public String getPwd()
    {
        return pwd;
    }
}
