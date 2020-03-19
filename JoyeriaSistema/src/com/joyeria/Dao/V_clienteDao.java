/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joyeria.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.joyeria.model.V_cliente;
import java.sql.Connection;
/**
 *
 * @author jacQu
 */
public class V_clienteDao {
    conexionMysql con= new conexionMysql();
    private Connection cn= con.Conectar();
    
    public ArrayList<V_cliente> obtenerClientes(int id_sucursal) {
        ArrayList<V_cliente>listClientes=new ArrayList<>();
        String serverAnswer=null;
        
        try {
            Statement stament = cn.createStatement();
            ResultSet resultSet = stament.executeQuery("SELECT id_cliente,nombre,apellido_paterno,apellido_materno,telefono FROM cliente WHERE id_sucursal="+ id_sucursal);
            
            while (resultSet.next()) {                
                V_cliente auxcliente = new V_cliente();
                auxcliente.setId_cliente(resultSet.getInt(1));
                auxcliente.setNombre(resultSet.getString(2));
                auxcliente.setApellido_paterno(resultSet.getString(3));
                auxcliente.setApellido_materno(resultSet.getString(4));
                auxcliente.setTelefono(resultSet.getString(5));
                
                listClientes.add(auxcliente);
            }
        } catch (SQLException e) {
            System.out.println("SQLException"+ e.getMessage());
        }
        return listClientes;
    }
    
}
