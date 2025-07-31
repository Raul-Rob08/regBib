/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import clases.Carrera;
import clases.Conexion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Jan Pardo
 */
public class VerCarrera extends javax.swing.JFrame {

    /**
     * Creates new form VerCarrera
     */
  private JPopupMenu menu;
  public VerCarrera() {
        initComponents();
         this.setLocationRelativeTo(null);
        mostrarCarrera();
        aplicarHover(jLabel13);
    aplicarHover(jLabel21);
    aplicarHover(jLabel16);
    aplicarHover(jLabel14);
    aplicarHover(jLabel15);
    aplicarHover(jLabel22);
    jButton1.setBackground(new java.awt.Color(37, 137, 126));
    jButton1.setForeground(java.awt.Color.black);
           Font fuenteMenu = new Font("Segoe UI", Font.BOLD, 14);
 Color colorTexto = Color.WHITE;
 Color colorFondo = new Color(0, 153, 153);
 


 jLabel13.setFont(fuenteMenu);
 jLabel13.setForeground(colorTexto);
 jLabel13.setOpaque(true);
 jLabel13.setBackground(colorFondo);

 JLabel[] menuLabels = { jLabel21, jLabel16, jLabel14, jLabel22,jLabel13 };

   for (JLabel label : menuLabels) {
    label.setFont(fuenteMenu);
    label.setForeground(colorTexto);
    label.setOpaque(true);
    label.setBackground(colorFondo);
    label.setIconTextGap(10); // espacio entre icono y texto
    label.setHorizontalAlignment(SwingConstants.LEFT);
        
        
    }
        
    }
  private void aplicarHover(JLabel label) {
    Color colorOriginal = label.getForeground(); // Guarda el color actual del texto

    label.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            label.setForeground(Color.WHITE); // Cambia a blanco al pasar el mouse
            label.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor tipo mano
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            label.setForeground(colorOriginal); // Vuelve al color original
            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Cursor normal
        }
    });
}

  
  
   public void mostrarCarrera(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre Carrera");
                modelo.addColumn("Estatus");
                
                                
       try{
           Conexion conexion = new Conexion();
           java.sql.Connection con = conexion.con; 
           String sql ="SELECT * FROM Carrera";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet datos = ps.executeQuery();
            ArrayList<Carrera> VerCarrera = new ArrayList<>();
            
            while(datos.next()){
            int idCarrera = datos.getInt("idCarrera");
            String carreraNombre = datos.getString("carreraNombre");
            String estatus = datos.getString("estatus");
             Carrera carrera = new Carrera(idCarrera,carreraNombre,estatus);
           
             modelo.addRow(new Object[]{
               
              carrera.getnombreCarrera(),
                carrera.getEstatus(),
                
                

            
             });
              VerCarrera.add(carrera);
            }
           
            
            tabla_carrera.setModel(modelo);
             tabla_carrera.setModel(modelo); 
         menu = new JPopupMenu();
         JMenuItem itemEditar = new JMenuItem("Editar");
         JMenuItem itemEliminar = new JMenuItem("Eliminar");
         menu.add(itemEditar);
         menu.add(itemEliminar);

         tabla_carrera.addMouseListener(new java.awt.event.MouseAdapter(){
             public void mousePressed(java.awt.event.MouseEvent evt){
                 if (evt.isPopupTrigger()|| evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
                     int fila = tabla_carrera.rowAtPoint(evt.getPoint());
                 {
                             if (fila >= 0){
                                tabla_carrera.setRowSelectionInterval(fila, fila);
                                menu.show(tabla_carrera, evt.getX(), evt.getY());
                             }
         }
         }}
                 public void mouseReleased(java.awt.event.MouseEvent evt){
                 mousePressed(evt);
                 }});
         itemEditar.addActionListener(e -> {
                 int fila = tabla_carrera.getSelectedRow();
                 if (fila >=0){
                      Carrera c = VerCarrera.get(fila);
                    new EditarCarrera(c).setVisible(true);
                    
                 }
});
        itemEliminar.addActionListener(e ->{
           int fila = tabla_carrera.getSelectedRow(); 
           if (fila >=0){
               Carrera c = VerCarrera.get(fila);
               int repuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?", "si", JOptionPane.YES_OPTION);
               if (repuesta == JOptionPane.YES_OPTION){
                   try{
                       PreparedStatement ps2 = con.prepareStatement("DELETE FROM carrera WHERE idCarrera=? ");
                       ps2.setInt(1, c.getIdCarrera());
                       ps2.executeUpdate();
                       mostrarCarrera();
                   }catch(Exception e2){
                       JOptionPane.showMessageDialog(null,"Error al guardar"+e2.getMessage());
                   }
               }
           }
        });

       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error al cargar" +e.getMessage());
      
}   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_carrera = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_carrera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre Carrera", "Estatus"
            }
        ));
        jScrollPane1.setViewportView(tabla_carrera);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 204, 657, 309));

        jButton1.setText("Registrar Carrera");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, -1, -1));

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icono alumno 33333.png"))); // NOI18N
        jLabel20.setText("jLabel1");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 37, -1));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Admin");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 70, 40));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Alumno");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 70, 40));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Docente");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 80, 40));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Grupos");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 80, 40));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Carreras");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 80, 40));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linea recta nia.png"))); // NOI18N
        jLabel18.setText("jLabel4");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 10));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono admin traka2222.png"))); // NOI18N
        jLabel10.setText("jLabel7");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 31, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono carerra 22222.png"))); // NOI18N
        jLabel11.setText("jLabel8");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 37, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen grupo 222222.png"))); // NOI18N
        jLabel19.setText("jLabel5");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 37, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono docente 22222.png"))); // NOI18N
        jLabel12.setText("jLabel9");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 37, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar sesion222222.png"))); // NOI18N
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Cerrar Sesion");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 585, -1, -1));

        jLabel31.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel31.setText("Panel Admin");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 170, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo ute feo PEENEGE1111.png"))); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/adminlogo222222.png"))); // NOI18N
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Visitas");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
crearCarrera creCarrera = new crearCarrera(); //aqui se abrira el frame de veradmin
        creCarrera.setVisible(true);
        this.dispose();

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        VerAdmin veradmin = new VerAdmin(); //aqui se abrira el frame de veradmin
        veradmin.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        FrameVerAlumno veralumno = new FrameVerAlumno(); //aqui se abrira el frame de veradmin
        veralumno.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        FrameVerDocente verDocente = new FrameVerDocente(); //aqui se abrira el frame de veradmin
        verDocente.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        VerGrupo vergrupo = new VerGrupo(); //aqui se abrira el frame de veradmin
        vergrupo.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        VerCarrera vercarrera = new VerCarrera(); //aqui se abrira el frame de veradmin
        vercarrera.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        AdminLogin adminLogin = new AdminLogin(); //aqui se abrira el frame de veradmin
        adminLogin.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        PanelAdmin panelAdmin = new PanelAdmin(); //aqui se abrira el frame de veradmin
        panelAdmin.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(VerCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerCarrera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_carrera;
    // End of variables declaration//GEN-END:variables
}
