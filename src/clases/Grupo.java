/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author raulr
 */
public class Grupo {
      public int idGrupo;
    public String nombreGrupo;
    public String estatus;
    public int idCarrera;
    
    //Constructor de tarea

    public Grupo(String nombreGrupo, String estatus, int idCarrera) {
        this.nombreGrupo = nombreGrupo;
        this.estatus = estatus;
        this.idCarrera = idCarrera;
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
    
}
