/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author raulr
 */
public class Admin {
  public int idAdmin;
  public String nombreUsuario;
   public String clave;
   public String estatus;

   
   
   
   
    public Admin(int idAdmin, String nombreUsuario, String clave, String estatus) {
        this.idAdmin = idAdmin;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.estatus = estatus;
        
    }

    public Admin(int idAdmin,String nombreUsuario, String estatus) {
        this.idAdmin = idAdmin; 
        this.nombreUsuario = nombreUsuario;
        this.estatus = estatus;
        
    }

   

    public Admin(String estatus) {
        this.estatus = estatus;
    }

   
    

    

   
    
    
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
   
    public boolean guardar(){
          try{
          Conexion conexion = new Conexion();
          Connection con = conexion.con;
          
          String sql = "INSERT INTO Admin (idAdmin,nombreUsuario,clave,estatus) VALUES (null,?,?,1)";
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, nombreUsuario);          
          ps.setString(2, clave);
          ps.executeUpdate();
          return true;
          
          }catch (Exception e){
              JOptionPane.showMessageDialog(null, "Error al guardar" +e.getMessage());
              return false;
          }
          
      
    }    

    public boolean actualizar(){
        try{
            Conexion conexion = new Conexion ();
            Connection con = conexion.con;
            
            String sql = "UPDATE Admin SET nombreUsuario=?, clave=? WHERE idAdmin=?";
             PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreUsuario);
        ps.setString(2,clave );
         ps.setInt(3, idAdmin);
        
        
        ps.executeUpdate();
        return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guaradr"+e.getMessage());
            return false;
        }
    }

    public Admin(String nombreUsuario, String clave, String estatus) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.estatus = estatus;
    }

    

    
}
