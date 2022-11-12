/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author TomasUcu
 */
public class DBConnection {
    Connection conectar = null;
    
    String usuario = "usersql";
    String contrasena = "root";
    String bd = "ObligatorioDB";
    String ip = "localhost";
    String puerto = "1434";
    
    String cadena = "jdbc:sqlserver://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion() {
        try {
            String cadena = "jdbc:sqlserver://localhost"+puerto+";"+"databaseName="+bd;
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            JOptionPane.showMessageDialog(null, "Se conectó bien a la base de datos");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos, error: " + e.toString());
        }
        return conectar;
    }
    
}
