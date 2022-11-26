/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package db_connection;

import Interfaz_gráfica.Login;

/**
 *
 * @author juan-
 */
public class Gestion_Identidades_Permisos {

    public static void main(String[] args) {
        DBConnection.getInstance().establecerConexion();
        Login.getInstance().setVisible(true);
    }
}
