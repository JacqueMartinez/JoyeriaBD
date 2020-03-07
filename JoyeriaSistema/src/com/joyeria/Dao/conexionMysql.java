/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joyeria.Dao;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jacQu
 */

public class conexionMysql {
    
    static  Connection conexion = null;
    public static String usuario="root";
    public static String passw="";
    public static boolean status= false;

   
    public  Connection Conectar(){
         String url="jdbc:mysql://localhost:3306/bdjoyeria?zeroDateTimeBehavior=convertToNull";
       
        try{
            conexion = DriverManager.getConnection(url, this.usuario, this.passw);
            status= true;
            JOptionPane.showMessageDialog(null, status);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "eror"+ e.getMessage(),"error de conexiones",JOptionPane.ERROR_MESSAGE);
        }
       return conexion;
     
       
    }
    
    
    
    
}
