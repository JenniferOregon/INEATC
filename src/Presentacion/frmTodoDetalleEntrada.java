/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.LogDetalleEntrada;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jenni
 */
public class frmTodoDetalleEntrada extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmTodoUsuario
     */
    public frmTodoDetalleEntrada() {
        initComponents();
        this.setTitle("DetalleEntrada");
        mostrar("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabladetalleentrada = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        Tabladetalleentrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabladetalleentrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabladetalleentradaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabladetalleentrada);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton1.setText("Agregar Detalle Entrada");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(255, 0, 0));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jButton1)
                .addGap(64, 64, 64)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnBuscar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

       void mostrar(String buscar){
        try {
            DefaultTableModel modelo;
            LogDetalleEntrada func = new LogDetalleEntrada();
            modelo=func.mostrar(buscar);
            Tabladetalleentrada.setModel(modelo);
           // ocultar_columnas();
            //lbltotalregistros.setText("Total de usuario: "+ Integer.toString(func.totalregistros));
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
          try {
            //Abriendo ventana trabajador

            frm_DetalleEntrada detalleentrada = new frm_DetalleEntrada();
            FrmPrincipal.escritorio.add(detalleentrada);
            detalleentrada.toFront();
            Dimension desktopSize = FrmPrincipal.escritorio.getSize();
            Dimension FrameSize = detalleentrada.getSize();
            detalleentrada.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            detalleentrada.toFront();
            detalleentrada.setVisible(true);
            detalleentrada.lblaccion.setText("guardar");
            
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error: " + e.toString());
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " + e.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void TabladetalleentradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabladetalleentradaMouseClicked
        try {
            int fila= Tabladetalleentrada.rowAtPoint(evt.getPoint());
            frm_DetalleEntrada ventana = new frm_DetalleEntrada();
        FrmPrincipal.escritorio.add(ventana);
        ventana.toFront();
        Dimension desktopSize = FrmPrincipal.escritorio.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        ventana.toFront();
        ventana.setVisible(true);  
        
        //Enviando la accion que se requerira segun la funcion
       frm_DetalleEntrada.lblaccion.setText("editar");
       frm_DetalleEntrada.btnaccion.setLabel("Editar");
       frm_DetalleEntrada.TxtidDetalleEntrada.setEnabled(false);
             
      //Asignando datos a elementos ventana trabajador
       frm_DetalleEntrada.TxtidDetalleEntrada.setText(Tabladetalleentrada.getValueAt(fila, 0).toString());
        frm_DetalleEntrada.TxtCantidad.setText(Tabladetalleentrada.getValueAt(fila, 1).toString());
        frm_DetalleEntrada.TxtidLibro.setText(Tabladetalleentrada.getValueAt(fila, 2).toString());
        frm_DetalleEntrada.TxtidEntrada.setText(Tabladetalleentrada.getValueAt(fila, 3).toString());


        } catch (Exception e) {
        }
    }//GEN-LAST:event_TabladetalleentradaMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
          mostrar("");
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Tabladetalleentrada;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}