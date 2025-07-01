/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import frames.FrameRegAlumno;
import javax.swing.ImageIcon;
/**
 *
 * @author raulr
 */
   
// ... dentro de tu clase
public class MiVentana extends FrameRegAlumno {
    public MiVentana() {
        // ...
        labUT label = new labUT();
        // Asigna la imagen al JLabel
        label.setIcon(new ImageIcon(getClass().getResource("/resources/mi_imagen.png")));
        // ...
    }
}

