/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.sql.*;

import javax.swing.JOptionPane;
/**
 *
 * @author raulr
 */
public class Carrera {
    public int idCarrera;
    public String nombreCarrera;
    public String estatus;
    
       public Carrera() {
    }
    

  public Carrera(String nombreCarrera) {
    this.nombreCarrera = nombreCarrera;
    this.estatus = "Activo";
}
   

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getnombreCarrera() {
        return nombreCarrera;
    }

    public void setnombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return nombreCarrera; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public boolean guardar(){
        try{
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.con;
        
        
        String sql = "INSERT INTO carrera (idCarrera, nombreCarrera, estatus) VALUES (NULL, ?, 1)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreCarrera);
       
        ps.executeUpdate();
        return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar" + e.getMessage());
            return false;
        }
    }
    
}
