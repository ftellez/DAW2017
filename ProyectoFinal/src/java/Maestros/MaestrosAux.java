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
        String[][] arrMaestroParam = {maestro.getArrayValues()};
        
        ManageDB database = new ManageDB();
        //this.infoBox(this.ArrToString(arrMaestroParam), maestroTabla);
        String query = "Select nomina from maestros where nomina = ?";
        String[] param = {maestro.getNomina()};
        String[][] result = null;
        
        try {
            result = database.getQueryFromDB(query, param);
            //Test.infoBox(result[0][0], "Ya existe.");
        } catch (SQLException ex) {
            Logger.getLogger(MaestrosAux.class.getName()).log(Level.SEVERE, null, ex);
            Test.infoBox(ex.getMessage(), query);
        }
        
        if(!maestro.getNomina().equals(result[0][0])){
            isAdded = database.insertDataToDB(maestroTabla, arrMaestroParam);
        } else {
            //Test.infoBox("No se va a agregar", "Else.");
        }
        
        return isAdded;
    }
    
    public boolean modMaestroFromDB(Maestro maestro){
        boolean isUpdated = false;
        ManageDB database = new ManageDB();
        //this.infoBox(this.ArrToString(arrMaestroParam), maestroTabla);
        String query = "Select * from maestros where nomina = ?";
        String[] param = {maestro.getNomina()};
        String[][] result = null;
        
        try {
            result = database.getQueryFromDB(query, param);
            //Test.infoBox(result[0][0], "Ya existe.");
        } catch (SQLException ex) {
            Logger.getLogger(MaestrosAux.class.getName()).log(Level.SEVERE, null, ex);
            Test.infoBox(ex.getMessage(), query);
        }
        
        String[][] insertMaestro = new String[1][result[0].length];
        if(maestro.getNomina().equals(result[0][0])){
            insertMaestro[0] = maestro.getArrayValues();
            isUpdated = database.updateDB(maestroTabla, insertMaestro, param);
        }
        
        return isUpdated;
    }
}
