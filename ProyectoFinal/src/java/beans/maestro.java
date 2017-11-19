package beans;

import java.beans.*;
import java.io.Serializable;

public class maestro
{
    private String nomina;
    private String nombre;
    private int telefono;
    private String correo;
    private int numCursos;
    
    public maestro()
    {
        nomina = "";
        nombre = "";
        telefono = -1;
        correo = "";
        numCursos = -1;
    }
    
    public maestro(String nomi, String nom, int tel, String corr, int numCur)
    {
        nomina = nomi;
        nombre = nom;
        telefono = tel;
        correo = corr;
        numCursos = numCur;
    }
    
    public void setMaestroNomina(String nomi)
    {
        nomina = nomi;
    }
    
    public String getMaestroNomina( )
    {
        return nomina;
    }
    
    public void setMaestroNombre(String nom)
    {
        nombre = nom;
    }
    
    public String getMaestroNombre( )
    {
        return nombre;
    }
    
    public void setMaestroTelefono(int tel)
    {
        telefono = tel;
    }
    
    public int getMaestroTelefono( )
    {
        return telefono;
    }
    
    public void setMaestroCorreo(String corr)
    {
        correo = corr;
    }
    
    public String getMaestroCorreo( )
    {
        return correo;
    }
    
    public void setMaestroNumCursos(int numCur)
    {
        numCursos = numCur;
    }
    
    public int getMaestroNumCursos( )
    {
        return numCursos;
    }
}
