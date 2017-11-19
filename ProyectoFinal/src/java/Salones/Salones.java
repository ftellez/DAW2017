/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salones;

public class Salones{
    private String numSalon;
    private String capacidad;
    private String administracion;
    
    public Salones(){
        this.numSalon = "";
        this.capacidad = "";
        this.administracion = "";
    }
    
    public Salones(String num, String cap, String admin){
        this.numSalon = num;
        this.capacidad = cap;
        this.administracion = admin;
    }
    
    public Salones(Salones salon){
        this.numSalon = salon.getSalonNum();
        this.capacidad = salon.getSalonCap();
        this.administracion = salon.getSalonAdmin();
    }
    
    public void setSalonNum(String num){
        this.numSalon = num;
    }
    
    public void setSalonCap(String cap){
        this.capacidad = cap;
    }
    
    public void setSalonAdmin(String admin){
        this.administracion = admin;
    }
    
    public String getSalonNum(){
        return this.numSalon;
    }
    
    public String getSalonCap(){
        return this.capacidad;
    }   
    
    public String getSalonAdmin(){
        return this.administracion;
    }
    
    public String[] getArrayValues(){
        String[] arr = {this.numSalon, this.capacidad, this.administracion};
        return arr;
    }
}