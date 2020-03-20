/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alejandroreyesbautista
 */

public class ConsultasProducto extends BD{

    public ConsultasProducto()  throws IOException, ClassNotFoundException, URISyntaxException {
        
    }
    
  public  void guardarProducto(Producto p){
        this.insertar("producto", "nombre, categoria, peso_gramos, stock, descripcion, id_sucursal, estado","'" + p.getNombre() +
                "','" + p.getCategoria()+ "','" + p.getPeso()+ "','" + p.getStock()+ "','" + p.getDescripcion()+ "','" + p.getSucursal()+"','1'");
  }
  
  public  void guardarCategoria(Categoria c){
        this.insertar("categoria_producto", "nombre, descripcion, precio, peso_gramos, estado","'" + c.getNombre() +
                "','" + c.getDesc()+ "','" + c.getPrecio()+ "','" + c.getPeso()+ "','1'");
    }
  
  public void modificarCategoria(Categoria c){
      this.modificar("categoria_producto", "nombre='"+c.getNombre()+"',descripcion='"+c.getDesc()
              +"',precio='"+c.getPrecio()+"',peso_gramos='"+c.getPeso()+"'", "id_categoria='"+c.getId()+"'");
  }
  
  public void modificarProducto(Producto p){
      this.modificar("producto", "nombre='"+p.getNombre()+"',descripcion='"+p.getDescripcion()
              +"',categoria='"+p.getCategoria()+"',stock='"+p.getStock()+"',peso_gramos='"+p.getPeso()+"'", "id_producto='"+p.getId()+"'");
  }
  
  public ResultSet obtenerCategorias(){
     return this.consultar("Select id_categoria,nombre, descripcion, peso_gramos, precio from categoria_producto where estado=1");
  }
  
   public ResultSet obtenerProductos(){
     return this.consultar("Select Id_producto, producto.nombre, categoria_producto.nombre, producto.peso_gramos, stock, producto.descripcion, direccion  from categoria_producto, producto, sucursal where producto.estado=1 and "
             + "producto.categoria = categoria_producto.Id_categoria and producto.id_sucursal=sucursal.id_sucursal order by producto.id_producto");
  }
  
  public ResultSet obtenerSucursales(){
     return this.consultar("Select Id_sucursal ,direccion  from sucursal");
  }
  
  public void eliminarCat(String id){
      this.modificar("categoria_producto", "estado=0", "id_categoria='"+id+"'" );
  }
  
  public void eliminarProducto(String id){
      this.modificar("producto", "estado=0", "id_producto='"+id+"'" );
  }
    
   public ResultSet buscarCoincidencias(String rfc, String campo) throws SQLException {
   String rfcLike = rfc + '%';
   return this.consultar("Select Id_producto, producto.nombre, categoria_producto.nombre, producto.peso_gramos, stock, producto.descripcion, direccion  from categoria_producto, producto, sucursal where producto."+campo+" like '"+rfcLike+"' and "
             + "producto.estado=1 and producto.categoria = categoria_producto.Id_categoria and producto.id_sucursal=sucursal.id_sucursal ");

    }
}

