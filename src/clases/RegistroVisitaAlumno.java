/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.sql.*;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author raulr
 */
public class RegistroVisitaAlumno {
                int idRegistroVisitaAlumno, idAlumno, idAreaBiblioteca;
                FechaHora fh = new FechaHora();
                String fechaVisita= fh.getFecha();
                String horaVisita= fh.getHora();
      public boolean registrarVisita(){
            try{
            Conexion conexion = new Conexion();
            Connection con= conexion.con;
            String sql = "INSERT INTO registroVisitaAlumno(idRegistroVisitaAlumno, horaVisita, fechaVisita, idAlumno, idAreaBiblioteca) VALUES (NULL, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, horaVisita);
            ps.setString(1, fechaVisita);
            
            ps.executeUpdate();
            
            return true;
            }catch(Exception e){
                showMessageDialog(null, "Error al registrar la visita " +e.getMessage());
                return false;
            }
        }  
}