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
public class V_venta {
    private int id_venta;
    private String descripcion;
    private String descuento;
    private String fecha_venta;
    private int id_cliente;
    private int id_sucursal;
    private int id_vendedor;
    private String importe_final;
    private String importe_total;

    public V_venta(String descripcion, String descuento, String fecha_venta, int id_cliente, int id_sucursal, int id_vendedor, String importe_final, String importe_total) {
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.fecha_venta = fecha_venta;
        this.id_cliente = id_cliente;
        this.id_sucursal = id_sucursal;
        this.id_vendedor = id_vendedor;
        this.importe_final = importe_final;
        this.importe_total = importe_total;
    }

    public V_venta(int id_venta, String descripcion, String descuento, String fecha_venta, int id_cliente, int id_sucursal, int id_vendedor, String importe_final, String importe_total) {
        this.id_venta = id_venta;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.fecha_venta = fecha_venta;
        this.id_cliente = id_cliente;
        this.id_sucursal = id_sucursal;
        this.id_vendedor = id_vendedor;
        this.importe_final = importe_final;
        this.importe_total = importe_total;
    }

    public V_venta() {
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getImporte_final() {
        return importe_final;
    }

    public void setImporte_final(String importe_final) {
        this.importe_final = importe_final;
    }

    public String getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(String importe_total) {
        this.importe_total = importe_total;
    }
    
    
    
}
