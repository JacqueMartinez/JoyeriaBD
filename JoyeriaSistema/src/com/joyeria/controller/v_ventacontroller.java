/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joyeria.controller;
import com.joyeria.Dao.V_ventaDao;
import com.joyeria.model.V_venta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jacQu
 */
public class v_ventacontroller {
     
    V_ventaDao dao = new V_ventaDao();
    DefaultTableModel model = new DefaultTableModel();
     public String iniciar_venta(int id_cliente,int id_sucursal,int id_vendedor) {
        V_venta newV_venta = new V_venta(id_cliente, id_sucursal, id_vendedor);
        String respuesta = null;
        newV_venta.setId_cliente(id_cliente);
        newV_venta.setId_sucursal(id_sucursal);
        newV_venta.setId_vendedor(id_vendedor);
        respuesta = dao.iniciar_venta(newV_venta); 
        return respuesta;
    }
     
      public int seleccionar_idVenta () throws SQLException{
        return dao.seleccionar_idVenta();
    }
       public int contar_venta (int id) {
          return dao.contar_venta(id);    
     }
        public double subtotal(int id_venta){
        return dao.subtotal(id_venta);
    }
         public double seleccionar_importe(int id_venta){
        return dao.seleccionar_importe(id_venta);
    }
          public double descuento(int id_venta){
        return dao.descuento(id_venta);
    }
        
           public boolean eliminar_producto(int id_venta,int id_producto){
        return dao.eliminar_producto(id_producto,id_venta);
    }
     public void fillProductos(JTable jtventa,int id_Venta) throws SQLException{
        jtventa.setModel(model);
        model.addColumn("# ");
        model.addColumn("CANTIDAD ");
        model.addColumn("NOMBRE");
        model.addColumn("DESCUENTO");
        model.addColumn("PRECIO ");
        model.addColumn("PRECIO FINAL ");
        
        
        Object[] columns = new Object[6];
          ResultSet rs2;
          
          
          rs2 =dao.datos_productos(id_Venta);
          ArrayList<String> lista = new ArrayList<>();
                        while (rs2.next()) {
                            lista = (ArrayList<String>) dao.datos_productos(id_Venta);
                            //columns[0] = rs2.getString(1);

                           // columns[1]= rs2.getString(2);

                           //columns[2] = rs2.getString(3);
                        
                           // columns[3] = rs2.getString(4);
                          
                           //// columns[4] = rs2.getString(5); 
                           
                            //columns[5] = rs2.getString(5); 
                          //model.addRow(columns);
                           
                        } 
        
                        
                    
      
        int filas = lista.size();
        
        for (int i = 0; i < filas; i++) {
            try {
               columns[0] = rs2.getString(1);

                           columns[1]= lista.get(1);

                           //columns[2] = rs2.getString(3);
                        
                           // columns[3] = rs2.getString(4);
                          
                           //// columns[4] = rs2.getString(5); 
                           
                            //columns[5] = rs2.getString(5); 
                model.addRow(columns);
            } catch (SQLException ex) {
                System.err.println("error" + ex);
            }
        }
        
          }

     public void refillProductos(JTable jtventa,int id_Venta) throws SQLException{
        jtventa.setModel(model);
         model.setRowCount(0);
        
        Object[] columns = new Object[6];
          ResultSet rs2;
          rs2 =dao.datos_productos(id_Venta);
                        while (rs2.next()) {
                            columns[0] = rs2.getString(1);

                            columns[1]= rs2.getString(2);

                           columns[2] = rs2.getString(3);
                        
                            columns[3] = rs2.getString(4);
                          
                            columns[4] = rs2.getString(5); 
                           
                            columns[5] = rs2.getString(5); 
                          model.addRow(columns);
                           
                        } 
        
        
          }
          
     public boolean finalizar_venta(int id_venta,String importe_total,String importe_final,String descuento){
         return  dao.finalizar_venta(id_venta, importe_total, importe_final, descuento);
     }
    
}
