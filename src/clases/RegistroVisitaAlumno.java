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

    
                
      
                
      public boolean registrarVisita(int idAlumno, int idAreaBiblioteca){
            try{
            Conexion conexion = new Conexion();
            Connection con= conexion.con;
            String sql = "INSERT INTO registrovisitaalumno(idRegistroVisitaAlum, horaVisita, fechaVisita, idAlumno, idAreaBiblioteca) VALUES (NULL, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, horaVisita);
            ps.setString(2, fechaVisita);
            ps.setInt(3, idAlumno);
            ps.setInt(4, idAreaBiblioteca);
            ps.executeUpdate();
            return true;
            }catch(Exception e){
                System.out.println("Error al registrar la visita " +e.getMessage());
                return false;
            }
        }  

    public int getIdRegistroVisitaAlumno() {
        return idRegistroVisitaAlumno;
    }

    public void setIdRegistroVisitaAlumno(int idRegistroVisitaAlumno) {
        this.idRegistroVisitaAlumno = idRegistroVisitaAlumno;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdAreaBiblioteca() {
        return idAreaBiblioteca;
    }

    public void setIdAreaBiblioteca(int idAreaBiblioteca) {
        this.idAreaBiblioteca = idAreaBiblioteca;
    }

    public FechaHora getFh() {
        return fh;
    }

    public void setFh(FechaHora fh) {
        this.fh = fh;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getHoraVisita() {
        return horaVisita;
    }

    public void setHoraVisita(String horaVisita) {
        this.horaVisita = horaVisita;
    }
      
      
      
}