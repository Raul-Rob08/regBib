/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
/**
 *
 * @author Jan Pardo
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
   public Connection con;


    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return con;
    }
}

