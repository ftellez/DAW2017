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
    private int numCursos;
    
    public Maestro(){
        this.nomina = null;
        this.nombre = null;
        this.telefono = null;
        this.email = null;
        this.numCursos = 0;
    }
    
    public Maestro(String nominaNum, String nom, String numTel, String mail, int cantCursos){
        this.nomina = nominaNum;
        this.nombre = nom;
        this.telefono = numTel;
        this.email = mail;
        this.numCursos = cantCursos;
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
    
    public void setNumCursos(int cant){
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
    
    public int getCursos(){
        return this.numCursos;
    }
    
    public String[] getArrayValues(){
        String[] arr = {this.nomina, this.nombre, this.telefono, this.email, Integer.toString(this.numCursos)};
        return arr;
    }
}
