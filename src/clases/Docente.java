/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;



/**
 *
 * @author Jan Pardo
 */
public class Docente {
        public int  idDocente;   
        public String codCocente;
        public String nombre; 
        public String apaterno; 
        public String amaterno;
        public String estatus; 

    public Docente(String cod_docente, String nombre, String apaterno, String amaterno, String estatus) {
        this.codCocente = cod_docente;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.estatus = estatus;
    }
   
    
}
