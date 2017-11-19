/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursos;
import beans.horarios;

/**
 *
 * @author usuario
 */
public class cursos{
    private String clave;
    private int numGrupo;  
    private horarios cursoHorario;
    private horarios horarioLab;
    private String salon;
    private String profesor;
    private int porcentaje;
    private boolean ingles;
    private boolean honors;
    
    public cursos(){
        clave = "";
        numGrupo = -1;
        cursoHorario = new horarios();
        horarioLab = new horarios();
        salon = "";
        profesor = "";
        porcentaje = -1;
        ingles = false;
        honors = false;
    }
    
    public cursos(String key, int num, horarios cH, horarios hL, String room, String prof, int percent, boolean i, boolean h){
        clave = key;
        numGrupo = num;
        cursoHorario = cH;
        horarioLab = hL;
        salon = room;
        profesor = prof;
        porcentaje = percent;
        ingles = i;
        honors = h;
    }
    
    public void setCursoClave(String key){
        clave = key;
    }
    
    public String getCursoClave(){
        return clave;
    }
    
    public void setCursoNumGrupo(int num){
        numGrupo = num;
    }
    
    public int getCursoNumGrupo(){
        return numGrupo;
    }
    
    public void setCursoHorario(horarios cH){
        cursoHorario = cH;
    }
    
    public horarios getCursoHorario(){
        return cursoHorario;
    }
    
    public void setCursoHorarioLab(horarios hL){
        horarioLab = hL;
    }
    
    public horarios getCursoHorarioLab(){
        return horarioLab;
    }
    
    public void setCursoSalon(String room){
        salon = room;
    }
    
    public String getCursoSalon(){
        return salon;
    }
    
    public void setCursoProfesor(String prof){
        profesor = prof;
    }
    
    public String getCursoProfesor(){
        return profesor;
    }
    
    public void setCursoPorcentaje(int percent){
        porcentaje = percent;
    }
    
    public int getCursoPorcentaje(){
        return porcentaje;
    }
    
    public void setCursoIngles(boolean i){
        ingles = i;
    }
    
    public boolean getCursoIngles(){
        return ingles;
    }
    
    public void setCursoHonors(boolean h){
        honors = h;
    }
    
    public boolean getCursoHonors(){
        return honors;
    }
}