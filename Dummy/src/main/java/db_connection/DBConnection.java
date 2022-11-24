/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author TomasUcu
 */
public class DBConnection {
    
    static private DBConnection connection = null;
    
    public Connection dbConnection = null;
    
    static public DBConnection getInstance(){
        if (connection == null){
            connection = new DBConnection();
        }
        return connection;
    }
    
    String usuario = "usersql";
    String contrasena = "obligatorioDB";
    String bd = "ObligatorioDB";
    String puerto = "1433";
    
    public Connection establecerConexion(){
        try{
            String cadena = "jdbc:sqlserver://localhost:" + puerto + ";" + "DatabaseName=" + bd + ";encrypt=true;trustServerCertificate=true;";
            dbConnection = DriverManager.getConnection(cadena, usuario, contrasena);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro al conectar a la base de datos, error: " + e.toString());
        }
        return dbConnection;
    }
}