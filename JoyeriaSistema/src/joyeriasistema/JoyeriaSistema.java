/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joyeriasistema;

import FelixView.Usuario;
import Vistas.V_Inventario;
import com.joyeria.vistas.V_ventas;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import com.joyeria.vistas.V_ventas;
import java.sql.SQLException;
import EstherVistas.login;
/**
 *
 * @author jacQu
 */
public class JoyeriaSistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, URISyntaxException {
//        FelixView.Usuario inicio = new Usuario();
//        inicio.setVisible(true);
//       com.joyeria.vistas.V_ventas  ventas= new V_ventas();
//       ventas.setVisible(true);
        V_Inventario inv = new V_Inventario();
        inv.setVisible(true);
    public static void main(String[] args) throws SQLException {
       // FelixView.Usuario inicio = new Usuario();
        //inicio.setVisible(true);
        //V_ventas v= new V_ventas();
        //v.setVisible(true);
        
        login log= new login();
        log.setVisible(true);
        
    }
    
}
