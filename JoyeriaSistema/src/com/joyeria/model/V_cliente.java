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
public class V_cliente {
    private int id_cliente;
    private String apellido_materno;
    private String apellido_paterno;
    private String cp;
    private String direccion;
    private int estado;
    private String fecha_ingreso;
    private int id_sucursal;
    private String nombre;
    private String rfc;
    private String telefono;

    public V_cliente(int id_cliente, String apellido_materno, String apellido_paterno, String cp, String direccion, int estado, String fecha_ingreso, int id_sucursal, String nombre, String rfc, String telefono) {
        this.id_cliente = id_cliente;
        this.apellido_materno = apellido_materno;
        this.apellido_paterno = apellido_paterno;
        this.cp = cp;
        this.direccion = direccion;
        this.estado = estado;
        this.fecha_ingreso = fecha_ingreso;
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
        this.rfc = rfc;
        this.telefono = telefono;
    }

    public V_cliente(String apellido_materno, String apellido_paterno, String cp, String direccion, int estado, String fecha_ingreso, int id_sucursal, String nombre, String rfc, String telefono) {
        this.apellido_materno = apellido_materno;
        this.apellido_paterno = apellido_paterno;
        this.cp = cp;
        this.direccion = direccion;
        this.estado = estado;
        this.fecha_ingreso = fecha_ingreso;
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
        this.rfc = rfc;
        this.telefono = telefono;
    }

    public V_cliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
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

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
