/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joyeria.Dao;
import com.joyeria.model.V_venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author jacQu
 */
public class V_ventaDao {
    conexionMysql con= new conexionMysql();
    private Connection cn= con.Conectar();
    
      public String iniciar_venta(V_venta newventa){
        String respuesta=null;
        try (  CallableStatement sta=  cn.prepareCall("{Call crearVenta (?,?,?)}")){
              sta.setInt(1, newventa.getId_cliente());
              sta.setInt(2 ,newventa.getId_sucursal());
              sta.setInt(3, newventa.getId_vendedor());
           
              sta.executeQuery();
              respuesta="se a agregado exitosamente";
        } catch (SQLException e) {
                System.out.println(e.getMessage());
           
        }
        return respuesta;
      
    }
       public int seleccionar_idVenta ()throws SQLException{
        PreparedStatement pst;
        ResultSet rs=null;
        int var=0;
        try{
            pst= cn.prepareStatement("select id_venta from venta order by id_venta desc limit 1  ");
            rs = pst.executeQuery();
            rs.next();
            var=rs.getInt(1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return var;
        
    }
        public ResultSet seleccionar_id (int id)throws SQLException{
        PreparedStatement pst;
        ResultSet rs=null;
        try{
            pst= cn.prepareStatement("select v.id_venta, v.fecha_venta,v.id_cliente,v.id_vendedor, c.nombre from venta v inner JOIN cliente c on c.id_cliente= v.id_cliente WHERE v.id_venta=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
        }catch(Exception e){
            
        }
        return rs;
    }
         
         
         public boolean insertarVentaProducto(int id_producto,String cantidad,String precio,String descuento,
                 String precio_final,int id_venta){
             boolean temp = false;
             try {
                 PreparedStatement ps = cn.prepareStatement("INSERT INTO `venta_producto` (`id_producto`, `cantidad`, `precio`, `descuento`, `precio_final`, `id_venta`,`estado`) VALUES (?, ?, ?, ?, ?, ?,1)");
            ps.setInt(1, id_producto);
            ps.setString(2,cantidad);
            ps.setString(3, precio);
            ps.setString(4, descuento);
            ps.setString(5, precio_final);

            ps.setInt(6, id_venta);
            
            int result = ps.executeUpdate();
            if (result > 0) {
                temp = true;
            }
             } catch (Exception e) {
                 System.err.println("error"+ e);
             }
        return temp;
         }
         
          public boolean actualizar_stock(int id_producto,int cantidad){
             boolean temp = false;
             try {
                 PreparedStatement ps = cn.prepareStatement("UPDATE producto set stock ="+cantidad+" WHERE id_producto=?");
            ps.setInt(1, id_producto);
            int result = ps.executeUpdate();
            if (result > 0) {
                temp = true;
            }
             } catch (Exception e) {
                 System.err.println("error"+ e);
             }
        return temp;
         }
          public int contar_venta (int id) {
        PreparedStatement pst;
        ResultSet rs=null;
        int var =0;
        try{
            pst= cn.prepareStatement(" SELECT SUM(cantidad) FROM venta_producto WHERE estado=1 and id_venta=?");
             pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            var=rs.getInt(1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return var;
    }
          public double subtotal(int id_venta){
        PreparedStatement pst;
        ResultSet rs=null;
        double var =0;
        try{
            pst= cn.prepareStatement("SELECT SUM( precio * cantidad ) FROM venta_producto WHERE estado=1 and id_venta=?");
             pst.setInt(1, id_venta);
            rs = pst.executeQuery();
            rs.next();
            var=rs.getDouble(1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return var;
      }
            public double seleccionar_importe (int id) {
        PreparedStatement pst;
        ResultSet rs=null;
        double var =0;
        try{
            pst= cn.prepareStatement("SELECT SUM(precio_final) FROM venta_producto WHERE estado=1 AND id_venta =?");
             pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            var=rs.getDouble(1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return var;
    }
              public double descuento(int id_venta){
        PreparedStatement pst;
        ResultSet rs=null;
        double var =0;
        try{
            pst= cn.prepareStatement("SELECT SUM( descuento * cantidad ) FROM venta_producto WHERE estado=1 and id_venta=?");
             pst.setInt(1, id_venta);
            rs = pst.executeQuery();
            rs.next();
            var=rs.getDouble(1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return var;
      }
               public ResultSet datos_productos (int venta)throws SQLException{
        PreparedStatement pst;
        ResultSet rs=null;
        try{
            pst= cn.prepareStatement("SELECT vp.id_producto,vp.cantidad, (select p.nombre from producto WHERE vp.id_producto=p.id_producto),vp.descuento,vp.precio,vp.precio_final FROM venta_producto vp INNER JOIN producto p on p.id_producto= vp.id_producto WHERE id_venta=?");
            pst.setInt(1, venta);
            rs = pst.executeQuery();
        }catch(Exception e){
            System.err.println("error"+ e);
        }
        return rs;
               }
               
               public boolean eliminar_producto(int id_producto,int id_venta){
             boolean temp = false;
             try {
                 PreparedStatement ps = cn.prepareStatement("UPDATE venta_producto set estado=0 where id_producto=? and id_venta=?");
            ps.setInt(1, id_producto);
            ps.setInt(2, id_venta);
            int result = ps.executeUpdate();
            if (result > 0) {
                temp = true;
            }
             } catch (Exception e) {
                 System.err.println("error"+ e);
             }
        return temp;
         }
               
        public boolean finalizar_venta(int id_venta,String importe_total,String importe_final,String descuento){
             boolean temp = false;
             try {
                 PreparedStatement ps = cn.prepareStatement("UPDATE venta set importe_total=?,importe_final=?,descuento=? where id_venta=?");
                
                ps.setString(1,importe_total);
                ps.setString(2, importe_final);
                ps.setString(3, descuento);
                ps.setInt(4, id_venta);

            int result = ps.executeUpdate();
            if (result > 0) {
                temp = true;
            }
             } catch (Exception e) {
                 System.err.println("error"+ e);
             }
        return temp;
         }
}
