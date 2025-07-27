/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author ari
 */
import frames.AdminLogin;
import java.util.logging.Level;
import java.util.logging.Logger;
import frames.PantallaPersonalizada;
public class ClasePantalla {
    
    public static void main(String[] args){
      
         Runnable mRun = () ->{
    
     PantallaPersonalizada pantallaPerso = new PantallaPersonalizada();
     pantallaPerso.setVisible(true);
     
             try {
                 Thread.sleep(5000);
             } catch (InterruptedException ex) {
                 Logger.getLogger(ClasePantalla.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             
       pantallaPerso.dispose();
       
       
       AdminLogin adminLog = new AdminLogin();
       adminLog.setVisible(true);
       
         
         };
         Thread mHiloSplash = new Thread(mRun);
         mHiloSplash.start();
     
     }
     
   }
    

