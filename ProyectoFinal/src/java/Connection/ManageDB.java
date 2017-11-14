/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Testing.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author jfert
 */
public class ManageDB {
    private static String connectionString = "jdbc:mysql://localhost:3306/proyectofinal";
    private static String user = "root";
    private static String pass = "WX&balins07";
    
    public ManageDB(){}
    
    public String[][] getQueryFromDB(String query, String[] par) throws SQLException{
        Connection conn = null;
        String[][] arrList;
        
        //Load the driver
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectionString, user, pass);
        }
        catch(ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
            cnfex.printStackTrace();
            //System.exit(1);
        }
        catch(SQLException sqlex){
            System.err.println("Unable to connect");
            sqlex.printStackTrace();
        }        
        
        // Do query in Data base
        //String query = "SELECT * FROM cursos WHERE idcursos = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conn.prepareStatement(query);
            
            int i = 1;
            for (String parActual : par) {
                ps.setString(i, parActual);
                i++;
            }
            
            rs = ps.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int colNumber = rsmd.getColumnCount();
            
            int rowsNumber = 1;
            if (rs.last()) {
                rowsNumber = rs.getRow();
                // Move to beginning
                rs.beforeFirst();
            }
            
            arrList = new String[rowsNumber][colNumber];
            
            int rows = 0;
            while(rs.next()){ 
                for(int j = 1; j <= colNumber; j++){
                    arrList[rows][j-1] = (String) rs.getString(j);
                }
                rows++;
            }
        } catch (SQLException ex) {
            System.err.println("Error at prepareStatement");
            ex.printStackTrace();
            arrList = new String[1][1];
            arrList[0][0] = "ERROR";
        }
        
        // Disconnect from database
        try{
            conn.close();
        }
        catch( SQLException sqlex ){
            System.err.println("Unable to disconnect");
            sqlex.printStackTrace();
        }
        
        return arrList;
    }
    
    /**
     * Regresa un booleano indicando si se logro una insercion adecuada en 
     * la base de datos. Regresaria falso si hay algun problema en la conexion
     * o en el formato de los parametros.
     * 
     * Toma renglon por renglon de matriz 'datos' y va insertando los datos en
     * la base de datos. El formato de cada renglon de la matriz sigue el 
     * formato de la secuencia de columnas de la base de datos.
     * 
     * Posibles valores para el atributo tabla:
     *  - 'Login'
     *  - 'Maestros'
     *  - 'Cursos' 
     *  - 'Horario'
     *  - 'Materias' 
     *  - 'Salones'
     * 
     * Formato de datos:
     * 
     *  Ej. Login
     *    datos = {{'Ariel','12345'}
     *             {'Fernando','qwerty'}]
     *  Corresponde a:
     *    datos = [[0][0],[0][1]
     *             [1][0],[1][1]]
     *  Donde: 
     *    datos[0][0] -> 'Ariel'
     *    datos[0][1] -> '12345'
     *    datos[1][0] -> 'Fernando'
     *    datos[1][1] -> 'qwerty'
     *  
     *  Que sigue el formato:
     *    datos = [[user][pass]
     *             [user][pass]]
     * 
     * @param tabla String para seleccionar caso con la tabla a escoger. 
     * Opciones : "Login" - "Maestros" - "Cursos" - "Horario" - "Materias" -
     * "Salones"
     * @param datos Arreglo de Strings de datos a introducir.
     * @return      Booleano para indicar si la operacion fue exitosa.
     */
    
    
    public boolean insertDataToDB(String tabla, String[][] datos){
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isInserted = true;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(connectionString, user, pass);
            System.out.println("Connected database successfully...");
      
            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
      
            switch(tabla){
                case "Login":
                    for (String[] dato : datos) {
                        String sql = "INSERT INTO login (user,pass) VALUES (?,?)";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setString(2, dato[1]);
                        stmt.executeUpdate();
                    }
                    break;
                case "Maestros":
                    for (String[] dato : datos) {
                        //Test.infoBox(Test.Arr2ToString(dato),"DB");
                        String sql = "INSERT INTO maestros (Nomina,NombreMaestro,Telefono,Email,NoCursos)" 
                                + " VALUES (?,?,?,?,?)";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setString(2, dato[1]);
                        stmt.setString(3, dato[2]);
                        stmt.setString(4, dato[3]);
                        stmt.setInt(5, Integer.parseInt(dato[4]));
                        stmt.executeUpdate();
                    }
                    break;
                case "Cursos":
                    for (String[] dato : datos) {
                        String sql = "INSERT INTO cursos (claveMat,nomMaestro,nomSalon,numGrupo,horario,horarioLab," 
                                + "numMaestros,porcentajeMaestro,ingles,honors)"
                                + " VALUES (?,?,?,?,?,?,?,?,?,?)";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setString(2, dato[1]);
                        stmt.setString(3, dato[2]);
                        stmt.setInt(4, Integer.parseInt(dato[3]));
                        stmt.setString(5, dato[4]);
                        stmt.setString(6, dato[5]);
                        stmt.setInt(7, Integer.parseInt(dato[6]));
                        stmt.setInt(8, Integer.parseInt(dato[7]));
                        stmt.setInt(9, Integer.parseInt(dato[8]));
                        stmt.setInt(10, Integer.parseInt(dato[9]));
                        stmt.executeUpdate();
                    }
                    break;
                case "Horario":
                    for (String[] dato : datos) {
                        String sql = "INSERT INTO horario (Horario,claveCurso) VALUES (?,?)";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setString(2, dato[1]);
                        stmt.executeUpdate();
                    }
                    break;
                case "Materias":
                    for (String[] dato : datos) {
                        String sql = "INSERT INTO materias (ClaveMat,NombreMat,HorasLab) VALUES (?,?,?)";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setString(2, dato[1]);
                        stmt.setInt(3, Integer.parseInt(dato[2]));
                        stmt.executeUpdate();
                    }
                    break;
                case "Salones":
                    for (String[] dato : datos) {
                        String sql = "INSERT INTO salones (SalonNum,Capacidad,Admin) VALUES (?,?,?)";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setInt(2, Integer.parseInt(dato[1]));
                        stmt.setString(3, dato[2]);
                        stmt.executeUpdate();
                    }
                    break;
            }
            
            System.out.println("Inserted records into the table...");

            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
                isInserted = false;
                Test.infoBox(se.getMessage(), "JDBC");
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
                isInserted = false;
                Test.infoBox(e.getMessage(), "Class.forName");
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        conn.close();
                }catch(SQLException se){ }// do nothing
                
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try
        
        return isInserted;
    }
    
    /**
     * Regresa un booleano indicando si se logro el borrado adecuado de 
     * la base de datos. Regresaria falso si hay algun problema en la conexion
     * o en el formato de los parametros.
     * 
     * Toma renglon por renglon de matriz 'datos' y coloca cada dato de renglon
     * en la parte del query correspondiente. El formato de cada renglon de la 
     * matriz sigue el formato de la secuencia de columnas predefinido.
     * 
     * Posibles valores para el atributo tabla y su respectivo valor en matriz:
     *  - 'Login' - [user] - String con el nombre del usuario en BD.
     *  - 'Maestros' - [Nomina] - String con nomina del maestro en BD.
     *  - 'Cursos' - [ClaveMat] - String con clave de materia en BD. (No borra
     *                            materia de tabla de materias, solo de cursos) 
     *               [numGrupo] - String en la segunda columna de matriz con
     *                            numero de grupo a borrar.
     *  - 'Horario' - [Horario] - String con formato de horario a borrar.
     *  - 'Materias' - [ClaveMat] - String con clave de materia a borrar.
     *  - 'Salones' - [SalonNum] - String con numero de salon en BD.
     * 
     * Formato de datos:
     * 
     *  Ej. Login
     *    datos = {{'Ariel'}
     *             {'Fernando'}]
     *  Corresponde a:
     *    datos = [[0][0]
     *             [1][0]]
     *  Donde: 
     *    datos[0][0] -> 'Ariel'
     *    datos[1][0] -> 'Fernando'
     *  
     *  Que sigue el formato:
     *    datos = [[user]
     *             [user]]
     * 
     * @param tabla String para seleccionar caso con la tabla a escoger.
     * @param datos Arreglo de Strings de datos a borrar.
     * @return      Booleano para indicar si la operacion fue exitosa.
     */
    
    
    public boolean deleteFromDB(String tabla, String[][] datos){
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isErased = true;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(connectionString, user, pass);
            System.out.println("Connected database successfully...");
      
            //STEP 4: Execute a query
            System.out.println("Deleting records from the table...");
      
            switch(tabla){
                case "Login":
                    for (String[] dato : datos) {
                        String sql = "DELETE login WHERE user = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.executeUpdate();
                    }
                    break;
                case "Maestros":
                    for (String[] dato : datos) {
                        String sql = "DELETE FROM maestros WHERE Nomina= ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.executeUpdate();
                    }
                    break;
                case "Cursos":
                    for (String[] dato : datos) {
                        String sql = "DELETE FROM cursos WHERE claveMat = ? AND numGrupo = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setInt(2, Integer.parseInt(dato[1]));
                        stmt.executeUpdate();
                    }
                    break;
                case "Horario":
                    for (String[] dato : datos) {
                        String sql = "DELETE FROM horario WHERE Horario = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.executeUpdate();
                    }
                    break;
                case "Materias":
                    for (String[] dato : datos) {
                        String sql = "DELETE FROM materias WHERE ClaveMat = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.executeUpdate();
                    }
                    break;
                case "Salones":
                    for (String[] dato : datos) {
                        String sql = "DELETE FROM salones WHERE SalonNum = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.executeUpdate();
                    }
                    break;
            }
            
            System.out.println("Deleted records from the table...");

            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
                isErased = false;
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
                isErased = false;
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        conn.close();
                }catch(SQLException se){ }// do nothing
                
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try
        
        return isErased;
    }
    
    /**
     * Regresa un booleano indicando si se logro la actualizacion adecuada de 
     * la base de datos. Regresaria falso si hay algun problema en la conexion
     * o en el formato de los parametros.
     * 
     * Toma renglon por renglon de matriz 'datos' y coloca cada dato de renglon
     * en la parte del query correspondiente. El formato de cada renglon de la 
     * matriz sigue el formato de la secuencia de columnas predefinido.
     * 
     * Posibles valores para el atributo tabla y su respectivo valor en matriz:
     *  - 'Login'
     *  - 'Maestros'
     *  - 'Cursos'
     *  - 'Horario'
     *  - 'Materias'
     *  - 'Salones'
     * 
     * Formato de datos:
     * 
     *  Ej. Login
     *    datos = {{'Ariel','12345','Ariel'}
     *             {'Fernando','qwerty','Fernando'}]
     *  Corresponde a:
     *    datos = [[0][0],[0][1],[0][2]
     *             [1][0],[1][1],[1][2]]
     *  Donde: 
     *    datos[0][0] -> 'Ariel'
     *    datos[0][1] -> '12345'
     *    datos[1][0] -> 'Fernando'
     *    datos[1][1] -> 'qwerty'
     *  
     *  Que sigue el formato:
     *    datos = [[user],[pass]
     *             [user],[pass]]
     * 
     *  El primer par [user],[pass] corresponde a todas las columnas de la 
     *  tabla 'user' (para actualizar los datos se tienen que rellenar con
     *  valores todas las columnas).
     * 
     *  El valor de updateKey se utiliza para identificar la fila a modificar.
     *  Para los distintos queries, las palabras a introducir en updateKey
     *  son:
     * 
     *  - Para la tabla 'login', updateKey[0] = valor existente en 
     *    columna 'user'.
     *  - Para la tabla 'maestros', updateKey[0] = valor existente en 
     *    columna 'nomina'.
     *  - Para la tabla 'cursos', updateKey[0] = valor existente en 
     *    columna 'claveMat'; updateKey[1] = valor existente en columna 
     *    'numGrupo'.
     *  - Para la tabla 'horario', updateKey[0] = valor existente en 
     *    columna 'Horario'.
     *  - Para la tabla 'materias', updateKey[0] = valor existente en 
     *    columna 'ClaveMat'.
     *  - Para la tabla 'salones', updateKey[0] = valor existente en 
     *    columna 'SalonNum'.
     * 
     * @param tabla String para seleccionar caso con la tabla a escoger.
     * @param datos Arreglo de Strings de datos a actualizar.
     * @param updateKey Arreglo de Strings que indica el o los valores 
     * de referencia para busqueda.
     * @return      Booleano para indicar si la operacion fue exitosa.
     */
    
    
    public boolean updateDB(String tabla, String[][] datos, String[] updateKey){
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isUpdated = true;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(connectionString, user, pass);
            System.out.println("Connected database successfully...");
      
            //STEP 4: Execute a query
            System.out.println("Updating records from the table...");
      
            switch(tabla){
                case "Login":
                    for (String[] dato : datos) {
                        String sql = "UPDATE login SET user = ?, pass = ? WHERE user = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setString(2, dato[1]);
                        stmt.setString(3, updateKey[0]);
                        stmt.executeUpdate();
                    }
                    break;
                case "Maestros":
                    for (String[] dato : datos) {
                        String sql = "UPDATE maestros SET Nomina = ?, NombreMaestro = ?, Telefono = ?, Email = ?, NoCursos = ?"
                                + " WHERE Nomina= ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setString(2, dato[1]);
                        stmt.setString(3, dato[2]);
                        stmt.setString(4, dato[3]);
                        stmt.setInt(5, Integer.parseInt(dato[4]));
                        stmt.setString(6, updateKey[0]);
                        stmt.executeUpdate();
                    }
                    break;
                case "Cursos":
                    for (String[] dato : datos) {
                        String sql = "UPDATE cursos SET claveMat = ?, nomMaestro = ?, nomSalon = ?, numGrupo = ?, horario = ?"
                                + "horarioLab = ?, numMaestros = ?, porcentajeMaestro = ?, ingles = ?, honors = ?"
                                + " WHERE claveMat = ? AND numGrupo = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setString(2, dato[1]);
                        stmt.setString(3, dato[2]);
                        stmt.setInt(4, Integer.parseInt(dato[3]));
                        stmt.setString(5, dato[4]);
                        stmt.setString(6, dato[5]);
                        stmt.setInt(7, Integer.parseInt(dato[6]));
                        stmt.setInt(8, Integer.parseInt(dato[7]));
                        stmt.setInt(9, Integer.parseInt(dato[8]));
                        stmt.setInt(10, Integer.parseInt(dato[9]));
                        stmt.setString(11, updateKey[0]);
                        stmt.setInt(12, Integer.parseInt(updateKey[1]));
                        stmt.executeUpdate();
                    }
                    break;
                case "Horario":
                    for (String[] dato : datos) {
                        String sql = "UPDATE horario SET Horario = ?, claveCurso = ? WHERE Horario = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setString(2, dato[1]);
                        stmt.setString(3, updateKey[0]);
                        stmt.executeUpdate();
                    }
                    break;
                case "Materias":
                    for (String[] dato : datos) {
                        String sql = "UPDATE materias SET ClaveMat = ?, NombreMat = ?, HorasLab = ? WHERE ClaveMat = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setString(2, dato[1]);
                        stmt.setInt(3, Integer.parseInt(dato[2]));
                        stmt.setString(4, updateKey[0]);
                        stmt.executeUpdate();
                    }
                    break;
                case "Salones":
                    for (String[] dato : datos) {
                        String sql = "UPDATE salones SET SalonNum = ?, Capacidad = ?, Admin = ? WHERE SalonNum = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, dato[0]);
                        stmt.setInt(2, Integer.parseInt(dato[1]));
                        stmt.setString(3, dato[2]);
                        stmt.setString(4, updateKey[0]);
                        stmt.executeUpdate();
                    }
                    break;
            }
            
            System.out.println("Deleted records from the table...");

            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
                isUpdated = false;
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
                isUpdated = false;
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        conn.close();
                }catch(SQLException se){ }// do nothing
                
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try
        
        return isUpdated;
    }
}
