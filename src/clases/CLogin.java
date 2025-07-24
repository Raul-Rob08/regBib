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
}
