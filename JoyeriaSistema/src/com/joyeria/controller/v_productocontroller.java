/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joyeria.controller;

import com.joyeria.Dao.V_productoDao;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.joyeria.model.v_producto;
/**
 *
 * @author jacQu
 */
public class v_productocontroller {
      V_productoDao cdi= new V_productoDao();
      
      public void filltablaproductos(JTable jtable,int id_sucursal){
        DefaultTableModel tModel = new DefaultTableModel();
        
        jtable.setModel(tModel);
        tModel.addColumn("#");
        tModel.addColumn("Nombre");
        tModel.addColumn("Descripcion ");
        tModel.addColumn("Peso en gramos");
        tModel.addColumn("Stock");
   
          
        Object[] colums=new Object[6];
        
        ArrayList<v_producto> listofproducto = cdi.obtenerProductos(id_sucursal);
        
        for (v_producto listOfProducto  : listofproducto) {
            System.err.println(listOfProducto.getNombre());
            colums[0] = listOfProducto.getId_producto();
            colums[1] = listOfProducto.getNombre();
            colums[2] = listOfProducto.getDescripcion();
            colums[3] = listOfProducto.getPeso_gramos();
            colums[4] = listOfProducto.getStock();
           
           
      
            tModel.addRow(colums);
        }
        
        
    }
    
    
}
