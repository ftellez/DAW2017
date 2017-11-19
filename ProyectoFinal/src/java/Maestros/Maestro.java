/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maestros;

/**
 *
 * @author jfert
 */
public class Maestro {
    private String nomina;
    private String nombre;
    private String telefono;
    private String email;
    private String numCursos;
    
    public Maestro(){
        this.nomina = "";
        this.nombre = "";
        this.telefono = "";
        this.email = "";
        this.numCursos = "";
    }
    
    public Maestro(String nominaNum, String nom, String numTel, String mail, String cantCursos){
        this.nomina = nominaNum;
        this.nombre = nom;
        this.telefono = numTel;
        this.email = mail;
        this.numCursos = cantCursos;
    }
    
    public Maestro(Maestro maestro){
        this.nomina = maestro.getNomina();
        this.nombre = maestro.getNombre();
        this.telefono = maestro.getTelefono();
        this.email = maestro.getEmail();
        this.numCursos = maestro.getCursos();
    }
    
    public void setNomina(String nom){
        this.nomina = nom;
    }
    
    public void setNombre(String nomMaestro){
        this.nombre = nomMaestro;
    }
    
    public void setTelefono(String numTel){
        this.telefono = numTel;
    }
    
    public void setEmail(String mail){
        this.email = mail;
    }
    
    public void setNumCursos(String cant){
        this.numCursos = cant;
    }
    
    public String getNomina(){
        return this.nomina;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getCursos(){
        return this.numCursos;
    }
    
    public String[] getArrayValues(){
        String[] arr = {this.nomina, this.nombre, this.telefono, this.email, this.numCursos};
        return arr;
    }
}