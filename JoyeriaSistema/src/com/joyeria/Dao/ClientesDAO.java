/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joyeria.Dao;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import Modelo.Clientes;
import Modelo.Conexion;
/**
 *
 * @author Esther
 */
public class ClientesDAO {
    Conexion conectar= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<Clientes> datos= new ArrayList<>();
        String sql="select * from cliente where estado= 1 ORDER BY id_cliente desc";
        
        try {
            con=conectar.getConexion();
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {  
                Clientes c= new Clientes();
                c.setIdCliente(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setApellidoPaterno(rs.getString(3));
                c.setApellidoMaterno(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setRFC(rs.getString(7));
                c.setCP(rs.getString(8));
                c.setFechaIngreso(rs.getString(9));
                datos.add(c);
            }
        } catch (Exception e) {
        }
        return datos;
        
    }
    
    
    
    public int agregarC(Clientes c){
        String sql= "insert into cliente(nombre, apellidoPaterno, apellidoMaterno, direccion,telefono, rfc, cp, fechaIngreso, estado, id_sucursal) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            con=conectar.getConexion();
            ps= con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellidoPaterno());
            ps.setString(3, c.getApellidoMaterno());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getTelefono());
            ps.setString(6, c.getRFC());
            ps.setString(7, c.getCP());
            ps.setString(8, c.getFechaIngreso());
            ps.setString(9, c.getEstado());
            ps.setString(10, c.getIdSucursal());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 1;
    }
    
    public void eliminar(int id){
        String sql= "update cliente set estado=0 where id_cliente="+id;
        try {
            con=conectar.getConexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public int modificar(Clientes c){
        String sql="update cliente set nombre=?, apellidoPaterno=?, apellidoMaterno=?, direccion=?, telefono=?, rfc=?, cp=? where id_cliente=? ";
        try {
            con=conectar.getConexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellidoPaterno());
            ps.setString(3, c.getApellidoMaterno());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getTelefono());
            ps.setString(6, c.getRFC());
            ps.setString(7, c.getCP());
            ps.setString(8, c.getIdCliente());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return 1;
    }
    
    public List buscarC(String nombreC){
        String sql= "SELECT * FROM cliente WHERE nombre=" + "'"+nombreC+"'";
        List<Clientes> datos= new ArrayList<>();
        try {
            con=conectar.getConexion();
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {  
                Clientes c= new Clientes();
                c.setIdCliente(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setApellidoPaterno(rs.getString(3));
                c.setApellidoMaterno(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setRFC(rs.getString(7));
                c.setCP(rs.getString(8));
                c.setFechaIngreso(rs.getString(9));
                datos.add(c);
            }
        } catch (Exception e) {
        }
        return datos;
        
    }
}
