/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.dummy;

import db_connection.DBConnection;
import Interfaz_gráfica.Login;

/**
 *
 * @author juan-
 */
public class Dummy {

    public static void main(String[] args) {
        DBConnection.getInstance().establecerConexion();
        Login app = new Login();
        app.setVisible(true);
    }
}
