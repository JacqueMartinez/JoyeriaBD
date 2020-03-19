/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joyeria.model;

/**
 *
 * @author jacQu
 */
public class v_producto {
    private int id_producto;
    private int categoria;
    private String descripcion;
    private int estado;
    private int id_sucursal;
    private String nombre;
    private String peso_gramos;
    private int stock;
    private String nombre_cat;

    //Constructor con todos los campos a excepcion del String categoria
    public v_producto(int id_producto, int categoria, String descripcion, int estado, int id_sucursal, String nombre, String peso_gramos, int stock) {
        this.id_producto = id_producto;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estado = estado;
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
        this.peso_gramos = peso_gramos;
        this.stock = stock;
    }

    //Constructor utilizado para obterner el nombre de la categoria y no su ID
    public v_producto(int id_producto, int categoria, String descripcion, int estado, int id_sucursal, String nombre, String peso_gramos, int stock, String nombre_cat) {
        this.id_producto = id_producto;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estado = estado;
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
        this.peso_gramos = peso_gramos;
        this.stock = stock;
        this.nombre_cat = nombre_cat;
    }

    
    public v_producto() {
    }
    //Constructor sin ID de categoria
    public v_producto(int categoria, String descripcion, int estado, int id_sucursal, String nombre, String peso_gramos, int stock) {
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estado = estado;
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
        this.peso_gramos = peso_gramos;
        this.stock = stock;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeso_gramos() {
        return peso_gramos;
    }

    public void setPeso_gramos(String peso_gramos) {
        this.peso_gramos = peso_gramos;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre_cat() {
        return nombre_cat;
    }

    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }
    
    
    
    
    
}
