/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosSalida;
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
public class LogSalida {
   private Pool_conexion metodospool=new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
       public DefaultTableModel mostrar(String buscar) throws SQLException{
    DefaultTableModel modelo;
    
    String [] titulos = {"idSalida","Fecha","Hora","RFC","idusuario"};
    String [] registro = new String [5];
    
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
         cn = metodospool.dataSource.getConnection();
         sSql="select * from Salida where idSalida like'%"+buscar+"%' order by idSalida";
         Statement st = cn.createStatement();
         ResultSet rs=st.executeQuery(sSql);
         while(rs.next()){
            registro [0]=rs.getString("idSalida");
            registro [1]=rs.getString("Fecha");
            registro [2]=rs.getString("Hora");
            registro [3]=rs.getString("RFC"); 
            registro [4]=rs.getString("idusuario"); 
            totalregistros=totalregistros+1;
            modelo.addRow(registro);
           
         }
         rs.close();
         st.close();
         return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar Salida: "+e);
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
    
    
        public boolean insertar(DatosSalida dts){
        try {
             cn=metodospool.dataSource.getConnection();
            sSql="insert into Salida( idSalida,Fecha,Hora,RFC,idusuario)"+
                "values(?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
             pst.setInt(1, dts.getIdSalida());
             pst.setString(2, dts.getFecha());
             pst.setString(3,dts.getHora());
             pst.setString(4,dts.getRFC());
             pst.setInt(5,dts.getIdusuario());
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
        
         public boolean editar(DatosSalida dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update Salida set  Fecha=?,Hora=?,RFC=?,idusuario=? "+
                   "where idSalida=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
           
            pst.setString(1, dts.getFecha());
            pst.setString(2, dts.getHora());
            pst.setString(3, dts.getRFC());
            pst.setInt(4, dts.getIdusuario());
            pst.setInt(5, dts.getIdSalida());
           
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
         
        
      public boolean eliminar(DatosSalida dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from Salida where idSalida=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdSalida());
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
