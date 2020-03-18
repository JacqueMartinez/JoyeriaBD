/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;

/**
 *
 * @author Esther
 */
public class Conexion {
         Connection con;
    public Connection getConexion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bdjoyeria","root","");
            System.out.print("Conexion establecida...");
        }catch(SQLException ex){
        
        }catch(Exception e){
            
        }
        System.out.print("Conexion establecida1...");
        return con;
    }
    
}
