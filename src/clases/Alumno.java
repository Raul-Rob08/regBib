/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author raulr
 */
public class Alumno {
    public int idAlumno, idGrupo;
    public String matricula;
    public String apaterno;
    public String amaterno;
    public char estatus;

    public Alumno(int idAlumno, int idGrupo, String matricula, String apaterno, String amaterno, char estatus) {
        this.idAlumno = idAlumno;
        this.idGrupo = idGrupo;
        this.matricula = matricula;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.estatus = estatus;
    }
}
