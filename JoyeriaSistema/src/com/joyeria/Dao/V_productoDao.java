/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joyeria.Dao;

import java.sql.Connection;
import com.joyeria.model.v_producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jacQu
 */
public class V_productoDao {
    conexionMysql con= new conexionMysql();
    private Connection cn= con.Conectar();
    
    public ArrayList<v_producto> obtenerProductos(int id_sucursal) {
        ArrayList<v_producto> listproductos =new ArrayList<>();
        String serverAnswer=null;
        try {
            Statement stament = cn.createStatement();
            ResultSet resultSet = stament.executeQuery("SELECT p.id_producto,p.nombre,p.descripcion,p.peso_gramos,p.stock, s.nombre FROM producto p INNER JOIN sucursal s on p.id_sucursal = s.id_sucursal WHERE p.estado=1 and p.stock>1 and s.id_sucursal=1");
            
            while (resultSet.next()) {                
                v_producto auxproducto = new v_producto();
                auxproducto.setId_producto(resultSet.getInt(1));
                auxproducto.setNombre(resultSet.getString(2));
                auxproducto.setDescripcion(resultSet.getString(3));
                auxproducto.setPeso_gramos(resultSet.getString(4));
                auxproducto.setStock(resultSet.getInt(5));
              
                
                listproductos.add(auxproducto);
            }
        } catch (SQLException e) {
            System.out.println("SQLException"+ e.getMessage());
        }
     
        return listproductos;
    }
    
     public ArrayList<v_producto> informacionProducto(int id_sucursal,int id_producto) {
        ArrayList<v_producto> listproductos =new ArrayList<>();
        String serverAnswer=null;
        try {
            Statement stament = cn.createStatement();
            ResultSet resultSet = stament.executeQuery("SELECT p.id_producto,p.nombre,p.descripcion,p.peso_gramos,p.stock, s.nombre FROM producto p INNER JOIN sucursal s on p.id_sucursal = s.id_sucursal WHERE p.estado=1 and p.stock>1 and s.id_sucursal=1");
            
            while (resultSet.next()) {                
                v_producto auxproducto = new v_producto();
                auxproducto.setId_producto(resultSet.getInt(1));
                auxproducto.setNombre(resultSet.getString(2));
                auxproducto.setDescripcion(resultSet.getString(3));
                auxproducto.setPeso_gramos(resultSet.getString(4));
                auxproducto.setStock(resultSet.getInt(5));
              
                
                listproductos.add(auxproducto);
            }
        } catch (SQLException e) {
            System.out.println("SQLException"+ e.getMessage());
        }
     
        return listproductos;
    }
     
     //DEVUELVE LOS DATOS DEL PRODUCTO POR 
       public ResultSet datos_producto (int clave_producto)throws SQLException{
        PreparedStatement pst;
        ResultSet rs=null;
        try{
            pst= cn.prepareStatement("SELECT p.nombre, p.descripcion,p.peso_gramos,(SELECT  cp.nombre from categoria_producto WHERE cp.id_categoria= p.categoria) as categoria , (cp.precio/cp.peso_gramos) as precio_gramo, (p.peso_gramos * cp.precio/ cp.peso_gramos) as precio, p.stock from producto p inner JOIN categoria_producto cp on p.categoria= cp.id_categoria where p.estado=1 and id_producto=?");
            pst.setInt(1, clave_producto);
            rs = pst.executeQuery();
        }catch(Exception e){
            
        }
        return rs;
        
    }
    
  
}
