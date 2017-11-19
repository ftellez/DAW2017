/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import java.io.Serializable;

public class horarios{
    private String hora;
    private String dias;
    
    public horarios(){
        hora = "";
        dias = "";
    }
    
    public horarios(String h, String d){
        hora = h;
        dias = d;
    }
    
    public void setHorarioHora(String h){
        hora = h;
    }
    
    public String getHorarioHora(){
        return hora;
    }
    
    public void setHorarioDias(String d){
        dias = d;
    }
    
    public String getHorarioDias(){
        return dias;
    }
}