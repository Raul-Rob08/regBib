/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import clases.Alumno;
import clases.Carrera;
import clases.Conexion;
import clases.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author raulr
 */
public class FrameVerAlumno extends javax.swing.JFrame {
public JPopupMenu menu;

    /**
     * Creates new form FrameVerAlumno
     */
    public FrameVerAlumno() {
        initComponents();
        mostrarAlumnos();
         this.setLocationRelativeTo(null);
        

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

    
    
    public void mostrarAlumnos(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Matricula");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellido paterno");
        modelo.addColumn("Apellido materno");
        modelo.addColumn("Grupo");
        modelo.addColumn("Carrera");
        modelo.addColumn("Estatus");
        try{
            Conexion conexion = new Conexion();
            Connection con= conexion.con;
            String sql= "SELECT al.*, g.idGrupo, c.idCarrera, g.nombreGrupo, c.carreraNombre FROM alumno al INNER JOIN grupo g ON al.idGrupo=g.idGrupo INNER JOIN carrera c ON g.idCarrera=c.idCarrera;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet datos = ps.executeQuery();
            ArrayList<Alumno> FrameVerAlumno = new ArrayList<>();
            while(datos.next()){
                //Declaramos variables que van a recibir los datos de la base de datos
                int idAlumno = datos.getInt("idAlumno");
                String nombres = datos.getString("nombre");
                String apaterno = datos.getString("apaterno");
                String amaterno = datos.getString("amaterno");
                String matricula = datos.getString("matricula");
                int idGrupo = datos.getInt("idGrupo");
                String nombreGrupo= datos.getString("nombreGrupo");
                int idCarrera= datos.getInt("idCarrera");
                String carreraNombre= datos.getString("carreraNombre");
                String estatus= datos.getString("estatus");
                
                Grupo grupo1 = new Grupo(idGrupo, nombreGrupo, idCarrera);
                Carrera carrera1 = new Carrera(idCarrera, carreraNombre);
                
                //Instanciamos la clase Alumno que recibirá como parámetro los valores que recibió de la base de datos
                Alumno alumno1 = new Alumno(idAlumno, idGrupo, nombres, apaterno, amaterno, matricula, estatus);
                
                //Añade los elementos de la instancia de la clase a la tabla
                modelo.addRow(new Object[]{
                    alumno1.getMatricula(),
                    alumno1.getNombres(),
                    alumno1.getApaterno(),
                    alumno1.getAmaterno(),
                    grupo1.getNombreGrupo(),
                    carrera1.getnombreCarrera(),
                    alumno1.getEstatus()
            });
                FrameVerAlumno.add(alumno1);
            }
                tablaAlumno.setModel(modelo);
                  tablaAlumno.setModel(modelo); 
         menu = new JPopupMenu();
         JMenuItem itemEditar = new JMenuItem("Editar");
         JMenuItem itemEliminar = new JMenuItem("Eliminar");
         menu.add(itemEditar);
         menu.add(itemEliminar);

         tablaAlumno.addMouseListener(new java.awt.event.MouseAdapter(){
             public void mousePressed(java.awt.event.MouseEvent evt){
                 if (evt.isPopupTrigger()|| evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
                     int fila = tablaAlumno.rowAtPoint(evt.getPoint());
                 {
                             if (fila >= 0){
                                tablaAlumno.setRowSelectionInterval(fila, fila);
                                menu.show(tablaAlumno, evt.getX(), evt.getY());
                             }
         }
         }}
                 public void mouseReleased(java.awt.event.MouseEvent evt){
                 mousePressed(evt);
                 }});
         itemEditar.addActionListener(e -> {
                 int fila = tablaAlumno.getSelectedRow();
                 if (fila >=0){
                       Alumno al = FrameVerAlumno.get(fila);
                    new EditarAlumno(al).setVisible(true);
                    
                 }
});
        itemEliminar.addActionListener(e ->{
           int fila = tablaAlumno.getSelectedRow(); 
           if (fila >=0){
               Alumno al= FrameVerAlumno.get(fila);
               int repuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar al alumno", "si", JOptionPane.YES_OPTION);
               if (repuesta == JOptionPane.YES_OPTION){
                   try{
                       PreparedStatement ps2 = con.prepareStatement("DELETE FROM Alumno WHERE idAlumno=? ");
                       ps2.setInt(1, al.getIdAlumno());
                       ps2.executeUpdate();
                       mostrarAlumnos();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumno = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Alumnos Registrados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 260, -1));

        tablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Nombres", "Apellido Paterno", "Apellido Materno", "Grupo", "Carrera", "Estatus"
            }
        ));
        jScrollPane1.setViewportView(tablaAlumno);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 710, 200));

        jButton1.setText("Registrar Alumno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icono alumno 33333.png"))); // NOI18N
        jLabel24.setText("jLabel1");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 37, -1));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Admin");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 70, 40));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Alumno");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 70, 40));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Docente");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 80, 40));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Grupos");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 80, 40));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Carreras");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 80, 40));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linea recta nia.png"))); // NOI18N
        jLabel32.setText("jLabel4");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 10));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono admin traka2222.png"))); // NOI18N
        jLabel33.setText("jLabel7");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 31, 40));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono carerra 22222.png"))); // NOI18N
        jLabel34.setText("jLabel8");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 37, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen grupo 222222.png"))); // NOI18N
        jLabel35.setText("jLabel5");
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 37, -1));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono docente 22222.png"))); // NOI18N
        jLabel36.setText("jLabel9");
        jPanel6.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 37, -1));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar sesion222222.png"))); // NOI18N
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Cerrar Sesion");
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 585, -1, -1));

        jLabel39.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel39.setText("Panel Admin");
        jPanel6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 170, -1));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo ute feo PEENEGE1111.png"))); // NOI18N
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/adminlogo222222.png"))); // NOI18N
        jPanel6.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, -1));

        jLabel42.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Visitas");
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    FrameRegAlumno regAlumn = new FrameRegAlumno(); //aqui se abrira el frame de veradmin
        regAlumn.setVisible(true);
        this.dispose();


        // TODO add your handling code here:
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
         LoginPrincipal ver = new LoginPrincipal(); //aqui se abrira el frame de veradmin
        ver.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        PanelAdmin panelAdmin = new PanelAdmin(); //aqui se abrira el frame de veradmin
        panelAdmin.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        VerAdmin veradmin = new VerAdmin(); //aqui se abrira el frame de veradmin
        veradmin.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        FrameVerAlumno veralumno = new FrameVerAlumno(); //aqui se abrira el frame de veradmin
        veralumno.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        FrameVerDocente verDocente = new FrameVerDocente(); //aqui se abrira el frame de veradmin
        verDocente.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        VerGrupo vergrupo = new VerGrupo(); //aqui se abrira el frame de veradmin
        vergrupo.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        VerCarrera vercarrera = new VerCarrera(); //aqui se abrira el frame de veradmin
        vercarrera.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        AdminLogin adminLogin = new AdminLogin(); //aqui se abrira el frame de veradmin
        adminLogin.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel38MouseClicked

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        PanelAdmin panelAdmin = new PanelAdmin(); //aqui se abrira el frame de veradmin
        panelAdmin.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel42MouseClicked

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
            java.util.logging.Logger.getLogger(FrameVerAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameVerAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameVerAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameVerAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameVerAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAlumno;
    // End of variables declaration//GEN-END:variables
}
