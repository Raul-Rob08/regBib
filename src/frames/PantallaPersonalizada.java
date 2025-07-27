/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import clases.ImageDecore;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.UIManager;


/**
 *
 * @author gerar
 */
public class PantallaPersonalizada extends javax.swing.JFrame {
    
    private Color mTransparent;
    private Point mPoint;
     
    public PantallaPersonalizada() {
       mTransparent = new Color(0,0,0,0); 
      setUndecorated(true);  
        initComponents();
        setLocationRelativeTo(null);
        setBackground(mTransparent);
        
        ImageDecore mFondo = new ImageDecore(pnlBackground,"/imagenes/logo ute todo hermoso y chido.png" );
        pnlBackground.add(mFondo).repaint();
       pnlBackground.setOpaque(false);
       pnlBackground.setBorder(null);
       pnlBackground.setBackground(mTransparent);
       ProgressBarInicado();           
       
    }
    
   private void ProgressBarInicado() {
    Timer mTimer = new Timer(16, (ActionEvent e) -> {
        int valorActual = pbCarga.getValue();
        if (valorActual < 100) {
            pbCarga.setValue(valorActual + 1);
            pbCarga.setIndeterminate(false);
            pbCarga.setBorderPainted(false);
            pbCarga.setBackground(new Color(0, 153, 153)); 
            pbCarga.setForeground(new Color(0, 153, 153)); 
            pbCarga.setString("Cargando..." + pbCarga.getValue() + "%");
        } else {
            ((Timer) e.getSource()).stop(); // tiene el temporizador

            // cerrara el splash
            dispose();

            // Abrir AdminLogin
            LoginPrincipal login = new LoginPrincipal();
            login.setVisible(true);
        }
    });

    mTimer.start();
}
   
        
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pbCarga = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlBackgroundMouseDragged(evt);
            }
        });
        pnlBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBackgroundMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Cargando...");

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap(223, Short.MAX_VALUE)
                .addComponent(pbCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap(344, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pbCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlBackgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBackgroundMousePressed
     mPoint = evt.getPoint();
     getComponentAt(mPoint);

        // TODO add your handling code here:
    }//GEN-LAST:event_pnlBackgroundMousePressed

    private void pnlBackgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBackgroundMouseDragged
    int CurrentX = this.getLocation().x;
    int CurrentY = this.getLocation().y;
    
    int MoveX = (CurrentX + evt.getX()) - (CurrentX + mPoint.x);
    int MoveY = (CurrentY + evt.getY()) - (CurrentY + mPoint.y);
    
    int x = CurrentX + MoveX;
    int y = CurrentY + MoveY;
    
    this.setLocation(x, y);

        // TODO add your handling code here:
    }//GEN-LAST:event_pnlBackgroundMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPersonalizada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPersonalizada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPersonalizada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPersonalizada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPersonalizada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar pbCarga;
    private javax.swing.JPanel pnlBackground;
    // End of variables declaration//GEN-END:variables
}
