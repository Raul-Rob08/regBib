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
public class Grupo {
      public int idGrupo;
    public String nombreGrupo;
    public String estatus;
    public int idCarrera;
    
  

    public Grupo(int idGrupo, String nombreGrupo, String estatus, int idCarrera) {
        this.idGrupo= idGrupo;
        this.nombreGrupo = nombreGrupo;
        this.estatus = estatus;
        this.idCarrera = idCarrera;
    }

    public Grupo(int idGrupo, String nombreGrupo, int idCarrera) {
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
        this.idCarrera = idCarrera;
    }

    public Grupo(int idGrupo, String nombreGrupo) {
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
    }
    
    

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override
    public String toString() {
        return nombreGrupo.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
 public Grupo(String nombreGrupo, int idCarrera) {
    this.nombreGrupo = nombreGrupo;
    this.idCarrera = idCarrera;
    this.estatus = "1";
}

   public boolean Guardar() {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.con;

            String sql = "INSERT INTO grupo (nombreGrupo, idCarrera, estatus) VALUES (?, ?, 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreGrupo);
            ps.setInt(2, idCarrera);
            ps.executeUpdate();

            ps.close();
            con.close();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar grupo: " + e.getMessage());
            return false;
        }
    }
    
}