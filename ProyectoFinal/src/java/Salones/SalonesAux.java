/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salones;

import Connection.ManageDB;
import Testing.Test;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author usuario
 */
public class SalonesAux {
    private final String salonTabla = "Salones";
    
    public SalonesAux(){ }
    
    public boolean addSalonToDB(Salones salon){
        boolean isAdded = false;
        ManageDB database = new ManageDB();
        
        Salones salonDB = getSalonFromDB(salon.getSalonNum());
        
        if (salonDB == null){
            String[][] insertSalon = {salon.getArrayValues()};
            isAdded = database.insertDataToDB(salonTabla, insertSalon);
        }        
        return isAdded;
    }
    
    public boolean modSalonFromDB(Salones salon){
        boolean isUpdated = false;
        ManageDB database = new ManageDB();
        //this.infoBox(this.ArrToString(arrMaestroParam), maestroTabla);
        
        Salones salonDB = getSalonFromDB(salon.getSalonNum());
        
        if(salonDB != null){
            String[][] modificarSalon = {salon.getArrayValues()};
            String[] param = {salon.getSalonNum()};
            isUpdated = database.updateDB(salonTabla, modificarSalon, param);
        }
        
        return isUpdated;
    }
    
    public boolean deleteSalonFromDB(Salones salon){
        ManageDB database = new ManageDB();
        //this.infoBox(this.ArrToString(arrMaestroParam), maestroTabla);
        boolean isDeleted = false;
        
        Salones maestroDB = getSalonFromDB(salon.getSalonNum());
        
        if(maestroDB != null){
            String[][] param = {{salon.getSalonNum()}};
            isDeleted = database.deleteFromDB(salonTabla, param);
        }
        
        return isDeleted;
    }
    
    public Salones getSalonFromDB(String num){
        ManageDB database = new ManageDB();
        //this.infoBox(this.ArrToString(arrMaestroParam), maestroTabla);
        String query = "Select * from salones where SalonNum = ?";
        String[] param = {num};
        String[][] result = null;
        
        try {
            result = database.getQueryFromDB(query, param);
            if (num.equals(result[0][1])){
                //Test.infoBox(result[0][1], "Alerta, Ya existe.");
            }
            else{
                result = null;
                //Test.infoBox("No existe el salon", "Muy bien");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalonesAux.class.getName()).log(Level.SEVERE, null, ex);
            Test.infoBox(ex.getMessage(), query);
        }
        
        Salones salon = null;
        
        if(result != null){
            salon = new Salones();
            salon.setSalonNum(result[0][1]);
            salon.setSalonCap(result[0][2]);
            salon.setSalonAdmin(result[0][3]);
        }
        
        return salon;
    }
            
    
}
