/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.DatosDetalleSalida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jenni
 */
public class LogDetalleSalida {
   private Pool_conexion metodospool=new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
       public DefaultTableModel mostrar(String buscar) throws SQLException{
    DefaultTableModel modelo;
    
    String [] titulos = {"idDetalle_salida","Clave","Cantidad","idSalida"};
    String [] registro = new String [4];
    
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
         cn = metodospool.dataSource.getConnection();
         sSql="select * from detalle_salida where idSalida like'%"+buscar+"%' order by idDetalle_salida";
         Statement st = cn.createStatement();
         ResultSet rs=st.executeQuery(sSql);
         while(rs.next()){
            registro [0]=rs.getString("idDetalle_salida");
            registro [1]=rs.getString("Clave");
            registro [2]=rs.getString("Cantidad"); 
            registro [3]=rs.getString("idSalida"); 
            totalregistros=totalregistros+1;
            modelo.addRow(registro);
           
         }
         rs.close();
         st.close();
         return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar Detalle Salida: "+e);
            return null;
        }finally{
        try {
            
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
       }
    //MEtodo para insertar
    
    
        public boolean insertar(DatosDetalleSalida dts){
        try {
             cn=metodospool.dataSource.getConnection();
            sSql="insert into detalle_Salida(idDetalle_salida,Clave,Cantidad,idSalida)"+
                "values(?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
             pst.setInt(1, dts.getIdDetalle_Salida());
             pst.setString(2, dts.getClave());
             pst.setInt(3,dts.getCantidad());
             pst.setInt(4, dts.getIdsalida());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
        
         public boolean editar(DatosDetalleSalida dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update detalle_salida set  Clave=?, Cantidad=?, idSalida=? "+
                   "where idDetalle_Salida=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            
            pst.setString(1, dts.getClave());
            pst.setInt(2, dts.getCantidad());
            pst.setInt(3, dts.getIdsalida());
            pst.setInt(4, dts.getIdDetalle_Salida());
           
            int n=pst.executeUpdate();
            pst.close();
            if(n!=0){
                return true;
            }
            else{
                return false;
            } 
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
         
        
      public boolean eliminar(DatosDetalleSalida dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from detalle_salida where idDetalle_Salida=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdDetalle_Salida());
            int n=pst.executeUpdate();
            pst.close();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
             return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }       
        
        
}
