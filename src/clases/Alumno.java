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
public class Alumno {
    public int idAlumno, idGrupo;
    public String nombres, apaterno, amaterno, matricula, estatus;

    public Alumno(int idGrupo, String nombres, String apaterno, String amaterno, String matricula) {
        this.idGrupo = idGrupo;
        this.nombres = nombres;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.matricula = matricula;
        //this.estatus = estatus;
    }

    public Alumno(String estatus) {
        this.estatus = estatus;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
   
    
    //función para guardar. Elemento del CRUD de crear
    public boolean guardar(){
    try{
    Conexion conexion = new Conexion();
    Connection con= conexion.con;
    String sql = "INSERT INTO alumno(idAlumno, matricula, nombre, apaterno, amaterno, estatus, idGrupo) VALUES (NULL, ?, ?, ?, ?, 1, ?)";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, matricula);
    ps.setString(2, nombres);
    ps.setString(3, apaterno);
    ps.setString(4, amaterno);
    ps.setInt(5, idGrupo);
    ps.executeUpdate();
    return true;
    }catch(Exception e){
        showMessageDialog(null, "Error al guardar" + e.getMessage());
        return false;
    }
}
    
}
