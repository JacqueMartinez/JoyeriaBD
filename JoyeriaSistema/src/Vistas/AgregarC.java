/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Controlador;

/**
 *
 * @author Esther
 */
public class AgregarC extends javax.swing.JDialog {

    /**
     * Creates new form AgregarC
     */
    public AgregarC() {
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtApellidoMC = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtApellidoPC = new javax.swing.JTextField();
        txtDireccionC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefonoC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCp = new javax.swing.JTextField();
        btnCancelarC = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lTexto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtApellidoMC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 30));

        jLabel11.setText("Nombre:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel21.setText("Apellido materno:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel22.setText("Dirección:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));
        getContentPane().add(txtNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 250, 30));

        jLabel23.setText("Apellido paterno:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        getContentPane().add(txtApellidoPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 250, 30));
        getContentPane().add(txtDireccionC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 250, 30));

        jLabel3.setText("Teléfono:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));
        getContentPane().add(txtTelefonoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 250, 30));

        jLabel4.setText("RFC:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));
        getContentPane().add(txtRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 250, 30));

        jLabel5.setText("CP:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));
        getContentPane().add(txtCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 250, 30));

        btnCancelarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/joyeria/imagenes/cancelar.png"))); // NOI18N
        btnCancelarC.setText("Cancelar");
        btnCancelarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 583, 130, 40));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/joyeria/imagenes/aceptar.png"))); // NOI18N
        btnAgregar.setText("Aceptar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 583, 110, 40));

        lTexto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lTexto.setText("Agregar Cliente");
        getContentPane().add(lTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/joyeria/imagenes/fondo-vistas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarCActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       AgregarC v= new AgregarC();
        v.setVisible(true);
        v.setLocationRelativeTo(v);
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCancelarC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel lTexto;
    public javax.swing.JTextField txtApellidoMC;
    public javax.swing.JTextField txtApellidoPC;
    public javax.swing.JTextField txtCp;
    public javax.swing.JTextField txtDireccionC;
    public javax.swing.JTextField txtNombreC;
    public javax.swing.JTextField txtRfc;
    public javax.swing.JTextField txtTelefonoC;
    // End of variables declaration//GEN-END:variables
}
