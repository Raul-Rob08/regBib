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
public class Docente {
    public int idDocente;
    public String codDocente;
      public String nombre;
        public String apaterno;
            public String amaterno;
                public String estatus;

    public Docente(int idDocente, String codDocente, String nombre, String apaterno, String amaterno, String estatus) {
        this.idDocente = idDocente;
        this.codDocente = codDocente;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.estatus = estatus;
        
        
    }

    public Docente(String codDocente, String nombre, String apaterno, String amaterno) {
        this.codDocente = codDocente;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        
        
    }

    public Docente(String estatus) {
        this.estatus = estatus;
    }
    

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(String codDocente) {
        this.codDocente = codDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
         public boolean guardar(){
        try{
        Conexion conexion = new Conexion ();
        Connection con = conexion.con;
        
        String sql = "INSERT INTO Docente (idDocente,codDocente,nombre,apaterno,amaterno,estatus) VALUES (NULL,?,?,?,?,'activo')";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, codDocente);
        ps.setString(2,nombre );    
        ps.setString(3,apaterno);
        ps.setString(4,amaterno );
        
        
        ps.executeUpdate();
        return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guaradr"+e.getMessage());
            return false;
        
        }
    }

    public boolean actualizar(){
        try{
        Conexion conexion = new Conexion ();
        Connection con = conexion.con;
        
        String sql = "UPDATE  Docente SET codDocente=?, nombre=?, apaterno=?, amaterno=?, estatus=? WHERE idDocente=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, codDocente);
        ps.setString(2,nombre );
        ps.setString(3,apaterno);
        ps.setString(4,amaterno );
         ps.setString(5,estatus);
        ps.setInt(6, idDocente);
        ps.executeUpdate();
        return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guaradr"+e.getMessage());
            return false;
        
        }
    
  }

    public Docente(int idDocente, String codDocente, String nombre, String apaterno, String amaterno) {
        this.idDocente = idDocente;
        this.codDocente = codDocente;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
    }

    
}

   
