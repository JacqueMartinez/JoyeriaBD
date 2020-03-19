/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstherModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Esther
 */
public class LoginDAO {
        Conexion conectar= new Conexion();
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con= null;
        
        public boolean loginA(Usuario usr){
            String sql="SELECT u.id_administrador, u.nombre, u.apellidoPaterno, u.apellidoMaterno, u.nivel_usuario, u.contrasenia, t.nombreN FROM administrador as u INNER JOIN nivel_usuario AS t ON u.nivel_usuario=t.id_nivel  WHERE nombre=?";
            try {
                con=conectar.getConexion();
                ps=con.prepareStatement(sql);
                ps.setString(1, usr.getNombre());
                rs= ps.executeQuery();
                
                if(rs.next()){
                    if (usr.getPass().equals(rs.getString(6))) {
                        usr.setId(rs.getString(1));
                        usr.setNombre(rs.getString(2));
                        usr.setApellidoP(rs.getString(3));
                        usr.setApellidoM(rs.getString(4));
                        usr.setNivel(rs.getInt(5));
                        usr.setNombre_tipo(rs.getString(7));
                        return true;
                    }else{
                        return false;
                    }
                }
                return false;
            } catch (Exception e) {
                return false;
            }
            
        }
        
        public boolean loginG(Usuario usr){
            String sql="SELECT u.id_gerente, u.nombre, u.apellidoPaterno, u.apellidoMaterno, u.nivel_usuario, u.contrasenia, t.nombreN FROM gerente as u INNER JOIN nivel_usuario AS t ON u.nivel_usuario=t.id_nivel  WHERE nombre=?";
            try {
                con=conectar.getConexion();
                ps=con.prepareStatement(sql);
                ps.setString(1, usr.getNombre());
                rs= ps.executeQuery();
                
                if(rs.next()){
                    if (usr.getPass().equals(rs.getString(6))) {
                        usr.setId(rs.getString(1));
                        usr.setNombre(rs.getString(2));
                        usr.setApellidoP(rs.getString(3));
                        usr.setApellidoM(rs.getString(4));
                        usr.setNivel(rs.getInt(5));
                        usr.setNombre_tipo(rs.getString(7));
                        return true;
                    }else{
                        return false;
                    }
                }
                return false;
            } catch (Exception e) {
                return false;
            }
            
        }
        
        
        public boolean loginV(Usuario usr){
            String sql="SELECT u.id_vendedor, u.nombre, u.apellidoPaterno, u.apellidoMaterno, u.nivel_usuario, u.pass, t.nombreN FROM vendedor as u INNER JOIN nivel_usuario AS t ON u.nivel_usuario=t.id_nivel  WHERE nombre=?";
            try {
                con=conectar.getConexion();
                ps=con.prepareStatement(sql);
                ps.setString(1, usr.getNombre());
                rs= ps.executeQuery();
                
                if(rs.next()){
                    if (usr.getPass().equals(rs.getString(6)) ) {
                        usr.setId(rs.getString(1));
                        usr.setNombre(rs.getString(2));
                        usr.setApellidoP(rs.getString(3));
                        usr.setApellidoM(rs.getString(4));
                        usr.setNivel(rs.getInt(5));
                        usr.setNombre_tipo(rs.getString(7));
                        return true;
                    }else{
                        return false;
                    }
                }
                return false;
            } catch (Exception e) {
                return false;
            }
            
        }
        
        
        
}

    

