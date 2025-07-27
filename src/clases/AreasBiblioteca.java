/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author raulr
 */
public class AreasBiblioteca {
    int idAreaBiblioteca;
    String nombreArea;
    

    public AreasBiblioteca(int idArea, String nombreArea) {
        this.idAreaBiblioteca = idArea;
        this.nombreArea = nombreArea;
    }

    
    

    public int getIdArea() {
        return idAreaBiblioteca;
    }

    public void setIdArea(int idArea) {
        this.idAreaBiblioteca = idArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    
}
