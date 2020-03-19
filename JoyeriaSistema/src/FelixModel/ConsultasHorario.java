/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FelixModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FELIX
 */

public class ConsultasHorario extends Conexion {
    
    public ResultSet obtenerH() throws ClassNotFoundException {
        return this.consultarHorarios("SELECT id_horario, nombre, hora_inicio, hora_fin FROM horario WHERE estado=1");
    }
    
    public ResultSet getHparaComboBoxH(){
        return this.consultarHorarios("select nombre from horario where estado=1");
    }
    public ResultSet getHparaComboBoxP(){
        return this.consultarHorarios("select nombre from nivel_usuario");
    }
    public ResultSet getHparaComboBoxS(){
        return this.consultarHorarios("select direccion from sucursal");
    }

    public boolean guardarHorario(HorarioModelo hm) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO horario(nombre, hora_inicio, hora_fin, estado) VALUES(?, ?, ?, 1)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, hm.getNombre());
            ps.setString(2, hm.getHoraE());
            ps.setString(3, hm.getHoraS());

            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificarHorario(HorarioModelo hm){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE horario SET nombre=?, hora_inicio=?, hora_fin=? WHERE id_horario=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, hm.getNombre());
            ps.setString(2, hm.getHoraE());
            ps.setString(3, hm.getHoraS());
            ps.setInt(4, hm.getId_Horario());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
     }    }
    public boolean eliminarHorario(int id){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "Update horario set estado=0  where id_horario=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
}
