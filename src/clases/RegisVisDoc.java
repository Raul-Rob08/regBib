/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author angel
 */
public class RegisVisDoc {
    int idRegistroVisitaDoc,idDocente,idAreaBiblioteca;
    FechaHora fh = new FechaHora();
                String fechaVisita= fh.getFecha();
                String horaVisita= fh.getHora();

    public RegisVisDoc(int idRegistroVisitaDoc, int idDocente, int idAreaBiblioteca) {
        this.idRegistroVisitaDoc = idRegistroVisitaDoc;
        this.idDocente = idDocente;
        this.idAreaBiblioteca = idAreaBiblioteca;
    }

    public RegisVisDoc() {
        
    }
    

    public RegisVisDoc(int idRegistroVisitaDoc, int idDocente) {
        this.idRegistroVisitaDoc = idRegistroVisitaDoc;
        this.idDocente = idDocente;
    }

    public RegisVisDoc(int idDocente) {
        this.idDocente = idDocente;
    }
                

    public int getIdRegistroVisitaDoc() {
        return idRegistroVisitaDoc;
    }

    public void setIdRegistroVisitaDoc(int idRegistroVisitaDoc) {
        this.idRegistroVisitaDoc = idRegistroVisitaDoc;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
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
                
                public boolean registrarVisita(int idDocente, int idAreaBiblioteca){
            try{
            Conexion conexion = new Conexion();
            Connection con= conexion.con;
            String sql = "INSERT INTO registrovisitadoc(idRegistroVisitaDoc, horaVisita, fechaVisita, idDocente, idAreaBiblioteca) VALUES (NULL, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, horaVisita);
            ps.setString(2, fechaVisita);
            ps.setInt(3, idDocente);
            ps.setInt(4, idAreaBiblioteca);
            ps.executeUpdate();
            
            return true;
            }catch(Exception e){
                System.out.println("Error al registrar la visita " +e.getMessage());
                return false;
            }
    
}
}
