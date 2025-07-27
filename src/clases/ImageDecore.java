/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author gerar
 */
public class ImageDecore extends javax.swing.JLabel {
  private int width;
  private int height;
  private String path;
  
  public ImageDecore(JPanel jPanel, String path){
    this.path = path;
    this.width = jPanel.getWidth();
    this.height = jPanel.getHeight();
    this.setSize(width, height);
    
      
  }
  public void paint (Graphics graphics){
     ImageIcon img = new ImageIcon(getClass().getResource(path));
     graphics.drawImage(img.getImage(), 0 ,0, width, height, null);
      
      
  }  
  
  
  
}

