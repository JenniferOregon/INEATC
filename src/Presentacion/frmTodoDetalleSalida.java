/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.LogDetalleSalida;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jenni
 */
public class frmTodoDetalleSalida extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmTodoUsuario
     */
    public frmTodoDetalleSalida() {
        initComponents();
        this.setTitle("DetalleSalida");
        //mostrar("");
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
        Tabladetallesalida = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        Tabladetallesalida.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabladetallesalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabladetallesalidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabladetallesalida);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton1.setText("Agregar Detalle Salida");
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
            LogDetalleSalida func = new LogDetalleSalida();
            modelo=func.mostrar(buscar);
            Tabladetallesalida.setModel(modelo);
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

            frm_DetalleSalida detallesalida= new frm_DetalleSalida();
            FrmPrincipal.escritorio.add(detallesalida);
            detallesalida.toFront();
            Dimension desktopSize = FrmPrincipal.escritorio.getSize();
            Dimension FrameSize = detallesalida.getSize();
            detallesalida.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            detallesalida.toFront();
            detallesalida.setVisible(true);
            detallesalida.lblaccion.setText("guardar");
            
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

    private void TabladetallesalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabladetallesalidaMouseClicked
        try {
            int fila= Tabladetallesalida.rowAtPoint(evt.getPoint());
            frm_DetalleSalida ventana = new frm_DetalleSalida();
        FrmPrincipal.escritorio.add(ventana);
        ventana.toFront();
        Dimension desktopSize = FrmPrincipal.escritorio.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        ventana.toFront();
        ventana.setVisible(true);  
        
        //Enviando la accion que se requerira segun la funcion
       frm_DetalleSalida.lblaccion.setText("editar");
       frm_DetalleSalida.btnaccion.setLabel("Editar");
       frm_DetalleSalida.TxtidDetalleSalida.setEnabled(false);
             
      //Asignando datos a elementos ventana trabajador
       frm_DetalleSalida.TxtidDetalleSalida.setText(Tabladetallesalida.getValueAt(fila, 0).toString());
       frm_DetalleSalida.TxtClave.setText(Tabladetallesalida.getValueAt(fila, 1).toString());
        frm_DetalleSalida.TxtCantidad.setText(Tabladetallesalida.getValueAt(fila, 2).toString());
        frm_DetalleSalida.TxtidSalida.setText(Tabladetallesalida.getValueAt(fila, 3).toString());


        } catch (Exception e) {
        }
    }//GEN-LAST:event_TabladetallesalidaMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
          mostrar("");
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Tabladetallesalida;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
