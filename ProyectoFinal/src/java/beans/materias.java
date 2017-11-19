/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class materias{
    private String clave;
    private String nombre;
    private int horasLab;
    
    public materias(){
        clave = "";
        nombre = "";
        horasLab = -1;
    }
    
    public materias(String c, String n, int h){
        clave = c;
        nombre = n;
        horasLab = h;
    }
    
    public void setMateriaClave(String c){
        clave = c;
    }
    
    public String getMateriaClave(){
        return clave;
    }
    
    public void setMateriaNombre(String n){
        nombre = n;
    }
    
    public String getMateriaNombre(){
        return nombre;
    }
    
    public void setMateriaHorasLab(int h){
        horasLab = h;
    }
    
    public int getMateriaHorasLab(){
        return horasLab;
    }
}