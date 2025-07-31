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
    public String carreraNombre;
    public String estatus;

    public Carrera(int idCarrera, String carreraNombre, String estatus) {
        this.idCarrera = idCarrera;
        this.carreraNombre = carreraNombre;
        this.estatus = estatus;
    }

    public Carrera() {
    }

    public Carrera(int idCarrera, String nombreCarrera) {
        this.idCarrera = idCarrera;
        this.carreraNombre= nombreCarrera;
    }

    
    
  public Carrera(String nombreCarrera) {
    this.carreraNombre = nombreCarrera;
    this.estatus = "Activo";
}

    public Carrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }
   

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getnombreCarrera() {
        return carreraNombre;
    }

    public void setnombreCarrera(String nombreCarrera) {
        this.carreraNombre = nombreCarrera;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return carreraNombre; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public boolean guardar(){
        try{
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.con;
        
        
        String sql = "INSERT INTO carrera (idCarrera, carreraNombre, estatus) VALUES (NULL, ?, 'activa')";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, carreraNombre);
       
        ps.executeUpdate();
        return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar" + e.getMessage());
            return false;
        }
    }

    
    
    
     public boolean actualizar(){
        try{
        Conexion conexion = new Conexion ();
        Connection con = conexion.con;
        
        String sql = "UPDATE  Carrera SET  carreraNombre=? WHERE idCarrera=?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1,carreraNombre );
        ps.setInt(2, idCarrera);
        ps.executeUpdate();
        return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guaradr"+e.getMessage());
            return false;
        
        }
     }
}
