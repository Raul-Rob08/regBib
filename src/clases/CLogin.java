/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 * @author ari
 */
public class CLogin {
 
    
    
    public boolean clogin(String usuario, String clave){
        
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT * FROM Admin WHERE nombreUsuario = ? AND clave =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Intentelo de nuevo");
            return false;

        }
    }
    
    public Alumno loginAlumno(String codDocente){
        
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT * FROM Alumno WHERE matricula = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codDocente);
            ResultSet rs = ps.executeQuery();
             if (rs.next()) {
            int idAlumno = rs.getInt("idAlumno"); 
            int idGrupo = rs.getInt("idGrupo");
            String nombres = rs.getString("nombre");
            String apaterno = rs.getString("apaterno"); 
            String amaterno = rs.getString("amaterno"); 
            String matricula = rs.getString("matricula"); 
            String estatus = rs.getString("estatus");

            return new Alumno(idAlumno, idGrupo, nombres, apaterno, amaterno, matricula, estatus);
        } else {
        }
        } catch (Exception e) {
            System.out.println("Intentelo de nuevo" + e.getMessage());
        }
        return null;
    }
    
    public Docente loginDocente(String matricula){
         
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT * FROM Docente WHERE codDocente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();
             if (rs.next()) {
            int idDocente = rs.getInt("idAlumno"); 
            String codDocente = rs.getString("codDocente");
            String nombre = rs.getString("nombre");
            String apaterno = rs.getString("apaterno"); 
            String amaterno = rs.getString("amaterno"); 
            String estatus = rs.getString("estatus");
            return new Docente(idDocente, codDocente, nombre, apaterno, amaterno, estatus);
        } else {
        }
        } catch (Exception e) {
            System.out.println("Intentelo de nuevo" + e.getMessage());
        }
        return null;
    }
    
        public boolean loginAdmin(String usuario){
        
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT * FROM Admin WHERE nombreUsuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Intentelo de nuevo");
            return false;

        }
    }
}
