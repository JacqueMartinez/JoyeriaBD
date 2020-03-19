/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstherControlador;

import EstherModelo.ClientesDAO;
import EstherModelo.Clientes;
import EstherVistas.Clientes.AgregarC;
import EstherVistas.Clientes.V_Clientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JTable;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Esther
 */
public class Controlador implements ActionListener{
    
    ClientesDAO dao= new ClientesDAO();
    Clientes c=new Clientes();
    V_Clientes vistaC= new V_Clientes();
    AgregarC V_agregar= new AgregarC();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Controlador(V_Clientes v){
        this.vistaC=v;
        this.vistaC.btnAgregarC.addActionListener(this);
        this.vistaC.btnEliminar.addActionListener(this);
        this.vistaC.btnModificar.addActionListener(this);
        this.V_agregar.btnAgregar.addActionListener(this);
        this.vistaC.btnBuscar.addActionListener(this);
        listar(vistaC.tabla);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //ABRIR LA VENTANA DE AGREGAR CLIENTE
        if(e.getSource()==vistaC.btnAgregarC){
            irAgregarC();
            modificarTextoA();
        }
        //BOTON CANCELAR DE LA VISTA AGREGAR CLIENTE
        if (e.getSource()== V_agregar.btnCancelarC){
            limpiar();
        }
        
        //ELIMINAR CLIENTE
        if(e.getSource()==vistaC.btnEliminar){
            eliminar();
            limpiarT();
            listar(vistaC.tabla);
            
        }
        // IR A LA VENTANA DE MODIFICAR CLIENTE
        if(e.getSource()==vistaC.btnModificar){
            irAgregarC();
            modificarTextoM();
            mostrarInfoC();
        }
        
        if(e.getSource()==V_agregar.btnAgregar ){
            if (V_agregar.lTexto.getText()=="Modificar Cliente") {
                modificar();
                limpiarT();
                listar(vistaC.tabla);
                limpiar();
                V_agregar.setVisible(false);
            } else {
                agregar();
                limpiarT();
                listar(vistaC.tabla);
                limpiar();
                V_agregar.setVisible(false);
            }
            
        }
        
        if(e.getSource()==vistaC.btnBuscar){
            buscar(vistaC.tabla);
            limpiarT();
            buscar(vistaC.tabla);
        }
    }
    
    public void buscar(JTable tabla){
        String nombreC=vistaC.txtBusqueda.getText();
        modelo=(DefaultTableModel)tabla.getModel();
        List<Clientes>lista=dao.buscarC(nombreC);
        Object[]object= new Object[9];
        
        for(int i = 0;i< lista.size();i++){
            object[0]=lista.get(i).getIdCliente();
            object[1]=lista.get(i).getNombre();
            object[2]=lista.get(i).getApellidoPaterno();
            object[3]=lista.get(i).getApellidoMaterno();
            object[4]=lista.get(i).getDireccion();
            object[5]=lista.get(i).getTelefono();
            object[6]=lista.get(i).getRFC();
            object[7]=lista.get(i).getCP();
            object[8]=lista.get(i).getFechaIngreso();
            modelo.addRow(object);
            System.out.print("entro");
        }
        vistaC.tabla.setModel(modelo);
    }
    
    public void mostrarInfoC(){
        int fila=vistaC.tabla.getSelectedRow();
            if (fila==-1) {
                JOptionPane.showMessageDialog(vistaC, "Seleccione un usuario");
            } else {
                String id=(String)vistaC.tabla.getValueAt(fila, 0);
                String nom=(String)vistaC.tabla.getValueAt(fila, 1);
                String apellidoP= (String)vistaC.tabla.getValueAt(fila, 2);
                String apellidoM= (String)vistaC.tabla.getValueAt(fila, 3);
                String direccion=(String)vistaC.tabla.getValueAt(fila, 4);
                String telefono=(String)vistaC.tabla.getValueAt(fila, 5);
                String rfc=(String)vistaC.tabla.getValueAt(fila, 6);
                String cp=(String)vistaC.tabla.getValueAt(fila, 7);
                
                
                V_agregar.txtNombreC.setText(nom);
                V_agregar.txtApellidoPC.setText(apellidoP);
                V_agregar.txtApellidoMC.setText(apellidoM);
                V_agregar.txtDireccionC.setText(direccion);
                V_agregar.txtTelefonoC.setText(telefono);
                V_agregar.txtRfc.setText(rfc);
                V_agregar.txtCp.setText(cp);
               
            }
    }
    
    public void modificar(){
        int fila=vistaC.tabla.getSelectedRow();
        String id=(String)vistaC.tabla.getValueAt(fila, 0);
        String nombre=V_agregar.txtNombreC.getText();
        String apellidoP= V_agregar.txtApellidoPC.getText();
        String apellidoM= V_agregar.txtApellidoMC.getText();
        String direccion= V_agregar.txtDireccionC.getText();
        String telefono=V_agregar.txtTelefonoC.getText();
        String rfc=V_agregar.txtRfc.getText();
        String cp=V_agregar.txtCp.getText();
        c.setIdCliente(id);
        c.setNombre(nombre);
        c.setApellidoPaterno(apellidoP);
        c.setApellidoMaterno(apellidoM);
        c.setDireccion(direccion);
        c.setTelefono(telefono);
        c.setRFC(rfc);
        c.setCP(cp);
        int r=dao.modificar(c);
        if(r==1){
            JOptionPane.showMessageDialog(V_agregar, "Usuario modificado");
        }else{
            JOptionPane.showMessageDialog(V_agregar, "Error al modificar");
        }
        
    }
    
    public void irAgregarC(){
       V_agregar.setAlwaysOnTop(true); //Esto nos permite que el jFrame sea un modal
       V_agregar.setVisible(true);
        
    }
    
    public void modificarTextoM(){
        V_agregar.lTexto.setText("Modificar Cliente");
    }
    public void modificarTextoA(){
        V_agregar.lTexto.setText("Agregar Cliente");
    }
    
    
    public void eliminar(){
        int fila=vistaC.tabla.getSelectedRow();
            if (fila==-1) {
                JOptionPane.showMessageDialog(vistaC, "Seleccione un usuario");
            } else {
                int id=Integer.parseInt((String)vistaC.tabla.getValueAt(fila, 0).toString());
                dao.eliminar(id);
                JOptionPane.showMessageDialog(vistaC, "Usuario eliminado");
            }
        
    }
    
    public void limpiarT(){
        for (int i = 0; i < vistaC.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i=i-1;
        }
    }
    
    public void listar(JTable tabla){
        modelo=(DefaultTableModel)tabla.getModel();
        List<Clientes>lista=dao.listar();
        Object[]object= new Object[9];
        
        for(int i = 0;i< lista.size();i++){
            object[0]=lista.get(i).getIdCliente();
            object[1]=lista.get(i).getNombre();
            object[2]=lista.get(i).getApellidoPaterno();
            object[3]=lista.get(i).getApellidoMaterno();
            object[4]=lista.get(i).getDireccion();
            object[5]=lista.get(i).getTelefono();
            object[6]=lista.get(i).getRFC();
            object[7]=lista.get(i).getCP();
            object[8]=lista.get(i).getFechaIngreso();
            
            modelo.addRow(object);
            System.out.print(lista.get(i).getIdCliente());
        }
        vistaC.tabla.setModel(modelo);
    }
    
    public void agregar(){
        
        Calendar c1 = Calendar.getInstance();
        String dia= Integer.toString(c1.get(Calendar.DATE));
        String mes= Integer.toString(c1.get(Calendar.MONTH));
        String anio= Integer.toString(c1.get(Calendar.YEAR));
        System.out.println(dia+"/"+mes+"/"+anio);
        
        String nombre=V_agregar.txtNombreC.getText();
        String apellidoP= V_agregar.txtApellidoPC.getText();
        String apellidoM= V_agregar.txtApellidoMC.getText();
        String direccion= V_agregar.txtDireccionC.getText();
        String telefono=V_agregar.txtTelefonoC.getText();
        String rfc=V_agregar.txtRfc.getText();
        String cp=V_agregar.txtCp.getText();
        String fIngreso= dia+"/"+mes+"/"+anio;
        String estado= "1";
        String sucursal="1";
        
        c.setNombre(nombre);
        c.setApellidoPaterno(apellidoP);
        c.setApellidoMaterno(apellidoM);
        c.setDireccion(direccion);
        c.setTelefono(telefono);
        c.setRFC(rfc);
        c.setCP(cp);
        c.setFechaIngreso(fIngreso);
        c.setEstado(estado);
        c.setIdSucursal(sucursal);
        
        
        int r=dao.agregarC(c);
        if (r==1) {
            JOptionPane.showMessageDialog(vistaC, "Cliente agregado");
        } else {
            JOptionPane.showMessageDialog(vistaC, "Error");
        }
        
    }
    
    public void limpiar(){
        
        V_agregar.txtApellidoMC.setText(null);
        V_agregar.txtApellidoPC.setText(null);
        V_agregar.txtDireccionC.setText(null);
        V_agregar.txtNombreC.setText(null);
        V_agregar.txtRfc.setText(null);
        V_agregar.txtTelefonoC.setText(null);
        V_agregar.txtCp.setText(null);
                
        
    }
    
    
    
}
