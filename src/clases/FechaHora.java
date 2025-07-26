/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author raulr
 */
public class FechaHora {
    public FechaHora(){
    
}
    public String getFecha(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        return fecha.format(calendar.getTime());
    }
    
    
    public String getHora(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat fecha = new SimpleDateFormat("hh:mm:ss a");
        return fecha.format(calendar.getTime());
    }
}