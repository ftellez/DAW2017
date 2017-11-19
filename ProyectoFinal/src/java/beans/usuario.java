package beans;

public class usuario
{
    private String user;
    private String password;
    
    public usuario()
    {
        user = "";
        password = "";
    }
    
    public usuario(String u, String p)
    {
        user = u;
        password = p;
    }
    
    public void setUser(String u)
    {
        user = u;
    }

    public String getUser()
    { 
        return user; 
    }
    
    public void setPassword(String p)
    {
        password = p;
    }
    
    public String getPassword()
    {
        return password;
    }
}
