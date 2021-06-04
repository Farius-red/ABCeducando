/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hector
 */
public class Conexion {
    
    public String driver, usuario, clave, bd, urlBd;
    public Connection conexion;

    public Conexion() {
        
        //Valores para conexion
        driver = "com.mysql.jdbc.Driver";
        usuario = "root";
        clave = "";
        bd = "abceducando2";
        urlBd = "jdbc:mysql://localhost:3306/" + bd;

        //Conexion
        try {
            
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlBd, usuario, clave);
            System.out.println("Conexion OK");
            
        } catch (Exception e) {
            
            System.out.println("Error al conectarse" + e.toString());
            
        }
    }
    
    //Obtenerconexion

    public Connection obtenerConexion() {
        
        return conexion;
        
    }

    public Connection cerrarConexion() throws SQLException {
        
        conexion.close();
        conexion = null;
        return conexion;
        
    }
    
    public static void main(String[] args) {
        new Conexion();
    }
    
}
