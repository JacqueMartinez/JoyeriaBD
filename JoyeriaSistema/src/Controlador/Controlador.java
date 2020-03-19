/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alejandroreyesbautista
 */
public class Controlador {
    
    ConsultasProducto model;

    public Controlador() throws IOException, ClassNotFoundException, URISyntaxException {
        this.model = new ConsultasProducto();
    }
    
    public void cargarTabla( JTable jt) throws SQLException{
        
        ResultSet rs= model.obtenerCategorias();
        Object[] columns = new String[]{"","Nombre", "Descripción", "Peso en gramos", "Precio"};
        DefaultTableModel dtm= new DefaultTableModel(columns,0);
        Object[] registros = new String[5];
        while(rs.next()){
            registros[0]=  rs.getString(1);
            registros[1] = rs.getString(2);
            registros[2] = rs.getString(3);
            registros[3] = rs.getString(4);
            registros[4] = rs.getString(5);
            dtm.addRow(registros);
        }
        jt.setModel(dtm);
        
    }
    
     public void cargarTablaProductos( JTable jt) throws SQLException{
        
        ResultSet rs= model.obtenerProductos();
        Object[] columns = new String[]{"","Nombre", "Categoría", "Peso", "Stock", "Descripción", "Sucursal"};
        DefaultTableModel dtm= new DefaultTableModel(columns,0);
        Object[] registros = new String[7];
        while(rs.next()){
            registros[0]=  rs.getString(1);
            registros[1] = rs.getString(2);
            registros[2] = rs.getString(3);
            registros[3] = rs.getString(4);
            registros[4] = rs.getString(5);
            registros[5] = rs.getString(6);
            registros[6] = rs.getString(7);
            dtm.addRow(registros);
        }
        jt.setModel(dtm);
        
    }
    
    public void cargarComboBoxCat(JComboBox cbx) throws SQLException{
          ResultSet rs= model.obtenerCategorias();
          while(rs.next()){
              cbx.addItem(rs.getString(2));
          }
    }
    
    public void cargarComboBoxSuc(JComboBox cbx) throws SQLException{
          ResultSet rs= model.obtenerSucursales();
          while(rs.next()){
              cbx.addItem(rs.getString(2));
          }
    }
    
    public void eliminarCat(String id){
        
          model.eliminarCat(id);
    }
    
    public void eliminarProducto(String id){
        
          model.eliminarProducto(id);
    }
    
    public void guardarProducto(Producto pm){
        
        if(pm.getId()>0){
            int opcion = JOptionPane.showConfirmDialog(null, "¿REALMENTE DESEA MODIFICAR EL PRODUCTO?", null, JOptionPane.YES_NO_OPTION);
        if (opcion == 0) {
            model.modificarProducto(pm);
        }
        }
        else{
            model.guardarProducto(pm);
        }
        
    }
    
    
    public void buscarCoincidencias(JTable jt, String rfc, String campo) throws SQLException{
        ResultSet rs= model.buscarCoincidencias(rfc, campo);
        Object[] columns = new String[]{"","Nombre", "Categoría", "Peso", "Stock", "Descripción", "Sucursal"};
        DefaultTableModel dtm= new DefaultTableModel(columns,0);
        Object[] registros = new String[7];
        while(rs.next()){
            registros[0]=  rs.getString(1);
            registros[1] = rs.getString(2);
            registros[2] = rs.getString(3);
            registros[3] = rs.getString(4);
            registros[4] = rs.getString(5);
            registros[5] = rs.getString(6);
            registros[6] = rs.getString(7);
            dtm.addRow(registros);
        }
        jt.setModel(dtm);
    }
}
