package FelixController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import FelixModel.Conexion;
import FelixModel.ConsultasHorario;
import FelixModel.ConsultasUsuario;
import FelixModel.UsuarioModelo;
import FelixView.Horario1;
import FelixView.UsuarioAgregar;
import FelixView.UsuarioModificar;

/**
 *
 * @author FELIX
 */
public class Controller {

    private UsuarioModelo uMod;
    private ConsultasUsuario cUser;
    private ConsultasHorario cHor = new ConsultasHorario();
    private ConsultasUsuario cUsuario= new ConsultasUsuario();
    private UsuarioAgregar userAdd;
    private Horario1 h1;

    public void iniciar() {
        userAdd.setTitle("Usuarios");
        userAdd.setLocationRelativeTo(null);
        
        //userAdd.txtNombre.setVisible(false);
    }

    
    public void cargarTablaU(JTable jt) throws SQLException, ClassNotFoundException {
        DefaultTableModel modeloTable = new DefaultTableModel();
      
        modeloTable.addColumn("ID");
        modeloTable.addColumn("NOMBRE");
        modeloTable.addColumn("APELLIDO PATERNO");
        modeloTable.addColumn("APELLIDO MATERNO");
        modeloTable.addColumn("DIRECCIÓN");
        modeloTable.addColumn("TELEFÓNO");
        modeloTable.addColumn("NIVEL USUARIO");
        modeloTable.addColumn("SUCURSAL");
        modeloTable.addColumn("HORARIO");
        modeloTable.addColumn("FECHA DE INGRESO");
        modeloTable.addColumn("DETALLES");
        
        Object[] registros = new Object[11];
        ResultSet rs = cUsuario.obtenerU();
        
        while (rs.next()) {
            
            registros[0] = rs.getString(1);
            registros[1] = rs.getString(2);
            registros[2] = rs.getString(3);
            registros[3] = rs.getString(4);
            registros[4] = rs.getString(5);
            registros[5] = rs.getString(6);
            registros[6] = rs.getString(7);
            registros[7] = rs.getString(8);
            registros[8] = rs.getString(9);
            registros[9] = rs.getString(10);
            registros[10] = rs.getString(11);
            modeloTable.addRow(registros);
        }  
           jt.setModel(modeloTable);
    }
    
    public void cargarTablaH(JTable jt) throws SQLException, ClassNotFoundException {
        DefaultTableModel modeloTable = new DefaultTableModel();
        
        jt.setModel(modeloTable);
        modeloTable.addColumn("ID");
        modeloTable.addColumn("NOMBRE");
        modeloTable.addColumn("HORA DE ENTRADA");
        modeloTable.addColumn("HORA DE SALIDA");
        
        Object[] registros = new Object[4];
        ResultSet rs = cHor.obtenerH();
        
        while (rs.next()) {
            
            registros[0] = rs.getString(1);
            registros[1] = rs.getString(2);
            registros[2] = rs.getString(3);
            registros[3] = rs.getString(4);
            modeloTable.addRow(registros);
        }  
    }
    
    public void llenarComboBoxH(JComboBox cbx) throws SQLException{
       ResultSet rs=  cHor.getHparaComboBoxH();
       while(rs.next()){
           System.out.println(rs.getString(1));
           cbx.addItem(rs.getString(1));
       }
    }
    public void llenarComboBoxP(JComboBox cbx) throws SQLException{
       ResultSet rs=  cHor.getHparaComboBoxP();
       while(rs.next()){
           System.out.println(rs.getString(1));
           cbx.addItem(rs.getString(1));
       }
    }
    public void llenarComboBoxS(JComboBox cbx) throws SQLException{
       ResultSet rs=  cHor.getHparaComboBoxS();
       while(rs.next()){
           System.out.println(rs.getString(1));
           cbx.addItem(rs.getString(1));
       }
    }
}

    