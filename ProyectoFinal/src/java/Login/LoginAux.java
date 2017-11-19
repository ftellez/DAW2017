/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
import Connection.ManageDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jfert
 */

public class LoginAux {
    private final String user;
    private final String pass;
    
    public LoginAux(String username, String password){
        this.user = username;
        this.pass = password;
    }
    
    public boolean getAuth(){
        String username = this.user;
        String password = this.pass;
        boolean isAuth = false;
        
        String query = "Select user,pass from login where user = ?";
        String[] parameters = {username};
        
        ManageDB database = new ManageDB();
        String[][] res = null;
        try {
            res = database.getQueryFromDB(query, parameters);
        } catch (SQLException ex) {
            Logger.getLogger(LoginAux.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(password.equals(res[0][1])){
            isAuth = true;
        }
        
        return isAuth;
    }
}