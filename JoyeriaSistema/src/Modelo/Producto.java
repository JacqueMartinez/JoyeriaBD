/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alejandroreyesbautista
 */
public class Producto {
    
    private int id;
    private String nombre; 
    private String stock; 
    private int categoria; 
    private String categoriaString;
    private String peso; 
    private String descripcion; 
    private int sucursal; 
    private String sucursalString;

    public String getCategoriaString() {
        return categoriaString;
    }

    public void setCategoriaString(String categoriaString) {
        this.categoriaString = categoriaString;
    }

    public String getSucursalString() {
        return sucursalString;
    }

    public void setSucursalString(String sucursalString) {
        this.sucursalString = sucursalString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto(int id, String nombre, String stock, String categoriaString, String peso, String descripcion, String sucursalString) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.categoriaString = categoriaString;
        this.peso = peso;
        this.descripcion = descripcion;
        this.sucursalString = sucursalString;
    }
    
   

    public Producto(String nombre, String stock, int categoria, String peso, String descripcion, int sucursal) {
        this.nombre = nombre;
        this.stock = stock;
        this.categoria = categoria;
        this.peso = peso;
        this.descripcion = descripcion;
        this.sucursal = sucursal;
    }

    public Producto(int id, String nombre, String stock, int categoria, String peso, String descripcion, int sucursal) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.categoria = categoria;
        this.peso = peso;
        this.descripcion = descripcion;
        this.sucursal = sucursal;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }
         
   
    
}
