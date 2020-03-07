/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joyeria.controller;

import com.joyeria.Dao.V_clienteDao;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.joyeria.model.V_cliente;

/**
 *
 * @author jacQu
 */
public class v_clientecontroller {
    V_clienteDao cdi= new V_clienteDao();
    
    public void fillTableClienteFisico(JTable jtable,int id_sucursal){
        DefaultTableModel tModel = new DefaultTableModel();
        
        jtable.setModel(tModel);
        tModel.addColumn("No.");
        tModel.addColumn("Nombre");
        tModel.addColumn("Apellido Paterno");
        tModel.addColumn("Apellido Materno");
        tModel.addColumn("Telefono");
          
        Object[] colums=new Object[5];
        
        ArrayList<V_cliente> listOfCliente = cdi.obtenerClientes(id_sucursal);
        
        for (V_cliente listofCliente : listOfCliente) {
            colums[0] = listofCliente.getId_cliente();
            colums[1] = listofCliente.getNombre();
            colums[2] = listofCliente.getApellido_paterno();
            colums[3] = listofCliente.getApellido_paterno();
            colums[4] = listofCliente.getTelefono();
           
            
            tModel.addRow(colums);
        }
        
        
    }
}
