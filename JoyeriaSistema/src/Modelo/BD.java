/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class BD {

    protected Connection con;
    protected Statement pst = null;
    
        

    public BD() throws  IOException, ClassNotFoundException, URISyntaxException {
        
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdjoyeria","root","");
  
        } catch (SQLException ex) {
           Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);  
        }
          
        } 
     
    
    protected ResultSet consultar(String sql) {
        
        try {
            pst = con.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    protected void modificar(String tabla, String campos, String condicion) {
        try {
            pst = con.createStatement();
            pst.executeUpdate("update " + tabla + " set " + campos + " where " + condicion);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected void eliminarTabla(String tabla) throws SQLException{
        pst= con.createStatement();
        pst.executeQuery("Truncate "+ tabla+"");
    }
    
    protected void insertar(String tabla, String campos, String valores) {
        try {
            pst = con.createStatement();
            pst.executeUpdate("insert into " + tabla + " (" + campos + ") values(" + valores + ")");
         //   JOptionPane.showMessageDialog(null, "Datos guardados.");
        } catch (SQLException ex) {
            System.out.println(ex);
       //   JOptionPane.showMessageDialog(null,"Error al guardar. Revisar los datos.");

        }
    }

    protected void eliminar(String tabla, String rfc) {
        try {
            pst = con.createStatement();
            pst.executeUpdate("delete from " + tabla + " where nombre = '"+rfc+"'" );
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
