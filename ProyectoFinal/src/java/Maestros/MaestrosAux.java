/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maestros;

import Connection.ManageDB;
import Testing.Test;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jfert
 */

public class MaestrosAux {
    private final String maestroTabla = "Maestros";
    
    public MaestrosAux(){ }
    
    public boolean addMaestroToDB(Maestro maestro){
        boolean isAdded = false;        
        ManageDB database = new ManageDB();
        //this.infoBox(this.ArrToString(arrMaestroParam), maestroTabla);
        Maestro maestroDB = getMaestroFromDB(maestro.getNomina());
        
        if(maestroDB == null){
            String[][] insertMaestro = {maestro.getArrayValues()};
            isAdded = database.insertDataToDB(maestroTabla, insertMaestro);
        }
        
        return isAdded;
    }
    
    public boolean modMaestroFromDB(Maestro maestro){
        boolean isUpdated = false;
        ManageDB database = new ManageDB();
        //this.infoBox(this.ArrToString(arrMaestroParam), maestroTabla);
        
        Maestro maestroDB = getMaestroFromDB(maestro.getNomina());
        
        if(maestroDB != null){
            String[][] insertMaestro = {maestro.getArrayValues()};
            String[] param = {maestro.getNomina()};
            isUpdated = database.updateDB(maestroTabla, insertMaestro, param);
        }
        
        return isUpdated;
    }
    
    public boolean deleteMaestroFromDB(Maestro maestro){
        ManageDB database = new ManageDB();
        //this.infoBox(this.ArrToString(arrMaestroParam), maestroTabla);
        boolean isDeleted = false;
        
        Maestro maestroDB = getMaestroFromDB(maestro.getNomina());
        
        if(maestroDB != null){
            String[][] param = {{maestro.getNomina()}};
            isDeleted = database.deleteFromDB(maestroTabla, param);
        }
        
        return isDeleted;
    }
    
    public Maestro getMaestroFromDB(String nomina){
        ManageDB database = new ManageDB();
        //this.infoBox(this.ArrToString(arrMaestroParam), maestroTabla);
        String query = "Select * from maestros where nomina = ?";
        String[] param = {nomina};
        String[][] result = null;
        
        try {
            result = database.getQueryFromDB(query, param);
            if (nomina.equals(result[0][1])){
                //Test.infoBox(result[0][1], "Ya existe.");
            }
            else{
                result = null;
                //Test.infoBox(result[0][1], "No existe.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaestrosAux.class.getName()).log(Level.SEVERE, null, ex);
            Test.infoBox(ex.getMessage(), query);
        }
        
        Maestro maestro = null;
        
        if(result != null){
            maestro = new Maestro();
            maestro.setNomina(result[0][1]);
            maestro.setNombre(result[0][2]);
            maestro.setTelefono(result[0][3]);
            maestro.setEmail(result[0][4]);
            maestro.setNumCursos(result[0][5]);
        } else {
        }
        
        return maestro;
    }
}