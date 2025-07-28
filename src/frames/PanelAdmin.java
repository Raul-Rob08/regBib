/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import clases.Alumno;
import clases.Carrera;
import clases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import clases.Docente;
import clases.Grupo;
import clases.RegisVisDoc;
import clases.RegistroVisitaAlumno;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author gerar
 */
public class PanelAdmin extends javax.swing.JFrame {
    public JPopupMenu menu;

    /**
     * Creates new form PanelAdmin
     */
    public PanelAdmin() {
        initComponents();
        mostrarDoc();
        mostrarVisitaAlumno();
        
    }
    public void mostrarDoc(){
        DefaultTableModel modelodc = new DefaultTableModel();
        modelodc.addColumn("Codigo");
                modelodc.addColumn("Nombre");
                modelodc.addColumn("Apellido paterno");
                        modelodc.addColumn("Apellido materno");                              
                                 modelodc.addColumn("FechaVisita");
                                  modelodc.addColumn("HoraVisita");
                                  modelodc.addColumn("Estatus");
                                   try{
           Conexion conexion = new Conexion();
           Connection con = conexion.con; 
           String sql ="SELECT  r.idRegistroVisitaDoc, d.idDocente, d.codDocente, d.nombre, d.apaterno, .d.amaterno, d.estatus, r.fechaVisita, r.horaVisita FROM registrovisitadoc r INNER JOIN docente d ON r.idDocente = d.idDocente; ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet datos = ps.executeQuery();
             ArrayList<RegisVisDoc> PanelAdmin = new ArrayList<>();
            while(datos.next()){
                
            int idDocente = datos.getInt("idDocente");
           int idRegistroVisitaDoc = datos.getInt("idRegistroVisitaDoc");
            String codDocente = datos.getString("codDocente");
            String nombre = datos.getString("nombre");
            String apaterno = datos.getString("apaterno");
            String amaterno = datos.getString("amaterno");
            String estatus = datos.getString("estatus");
            String fechaVisita = datos.getString("fechaVisita");
            String horaVisita = datos.getString("horaVisita");
            
            Docente docente = new Docente(idDocente,codDocente,nombre,apaterno,amaterno,estatus);
            RegisVisDoc reg = new  RegisVisDoc(idRegistroVisitaDoc,idDocente);
            modelodc.addRow(new Object[]{
               
              docente.getCodDocente(),
                docente.getNombre(),
                docente.getApaterno(),
                docente.getAmaterno(),
                fechaVisita,
                horaVisita,
                docente.getEstatus(),
                
              
            
             });
           PanelAdmin.add(reg);
}
            tabla_verdc.setModel(modelodc);
           
              
         JPopupMenu menuDoc = new JPopupMenu();
         
         JMenuItem itemdocEliminar = new JMenuItem("Eliminar");
        
         menuDoc.add(itemdocEliminar);

         tabla_verdc.addMouseListener(new java.awt.event.MouseAdapter(){
             public void mousePressed(java.awt.event.MouseEvent evt){
                 if (evt.isPopupTrigger()|| evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
                     int fila = tabla_verdc.rowAtPoint(evt.getPoint());
                 {
                             if (fila >= 0){
                               tabla_verdc.setRowSelectionInterval(fila, fila);
                                menuDoc.show(tabla_verdc, evt.getX(), evt.getY());
                             }
         }
         }}
                 public void mouseReleased(java.awt.event.MouseEvent evt){
                 mousePressed(evt);
                 }});
        
        itemdocEliminar.addActionListener(e ->{
           int fila = tabla_verdc.getSelectedRow(); 
           if (fila >=0){
               RegisVisDoc r = PanelAdmin.get(fila);
               int repuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar al docente", "si", JOptionPane.YES_OPTION);
               if (repuesta == JOptionPane.YES_OPTION){
                   try{
                       PreparedStatement ps2 = con.prepareStatement("DELETE FROM registrovisitadoc WHERE idRegistroVisitaDoc=? ");
                       ps2.setInt(1, r.getIdRegistroVisitaDoc());
                       ps2.executeUpdate();
                       mostrarDoc();
                   }catch(Exception e2){
                       JOptionPane.showMessageDialog(null,"Error al guardar"+e2.getMessage());
                   }
               }
           }
        });
    }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error al cargar" +e.getMessage());
      
}   }
    public void mostrarVisitaAlumno(){
        DefaultTableModel modeloal = new DefaultTableModel();
        modeloal.addColumn("Matricula");
        modeloal.addColumn("Nombres");
        modeloal.addColumn("Apellido paterno");
        modeloal.addColumn("Apellido materno");
        modeloal.addColumn("Grupo");
        modeloal.addColumn("Carrera");
        modeloal.addColumn("Fecha de la visita");
        modeloal.addColumn("Hora de la visita");
        modeloal.addColumn("Estatus");
         
        try{
            Conexion conexion = new Conexion();
            Connection con= conexion.con;
            String sql= "SELECT  r.idRegistroVisitaAlum,a.idAlumno, a.matricula, a.nombre, a.apaterno, a.amaterno, a.idGrupo, g.nombreGrupo,g.idCarrera,   c.carreraNombre, a.estatus, r.fechaVisita, r.horaVisita FROM registroVisitaAlumno r INNER JOIN alumno a ON r.idAlumno = a.idAlumno INNER JOIN grupo g ON a.idGrupo = g.idGrupo INNER JOIN carrera c ON g.idCarrera = c.idCarrera;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet datos = ps.executeQuery();
            ArrayList<RegistroVisitaAlumno> PanelAdmin = new ArrayList<>();
            while(datos.next()){
                //Declaramos variables que van a recibir los datos de la base de datos
                
                int idAlumno = datos.getInt("idAlumno");
                int idRegistroVisitaAlum = datos.getInt("idRegistroVisitaAlum");
                String nombres = datos.getString("nombre");
                String apaterno = datos.getString("apaterno");
                String amaterno = datos.getString("amaterno");
                String matricula = datos.getString("matricula");
                int idGrupo = datos.getInt("idGrupo");
                String nombreGrupo= datos.getString("nombreGrupo");
                int idCarrera= datos.getInt("idCarrera");
                String carreraNombre= datos.getString("carreraNombre");
                String estatus= datos.getString("estatus");
                String fechaVisita = datos.getString("fechaVisita");
                String horaVisita = datos.getString("horaVisita");   
                
                Grupo grupo1 = new Grupo(idGrupo, nombreGrupo, idCarrera);
                Carrera carrera1 = new Carrera(idCarrera, carreraNombre);
                
                //Instanciamos la clase Alumno que recibirá como parámetro los valores que recibió de la base de datos
                Alumno alumno1 = new Alumno(idAlumno, idGrupo, nombres, apaterno, amaterno, matricula, estatus);
                //Añade los elementos de la instancia de la clase a la tabla
                 RegistroVisitaAlumno reg = new RegistroVisitaAlumno (idRegistroVisitaAlum,idAlumno);
                 
                // Agregar a la tabla
                modeloal.addRow(new Object[]{
                    alumno1.getMatricula(),
                    alumno1.getNombres(),
                    alumno1.getApaterno(),
                    alumno1.getAmaterno(),
                    grupo1.getNombreGrupo(),
                    carrera1.getnombreCarrera(),
                    fechaVisita,
                    horaVisita,
                    alumno1.getEstatus()
                });
                PanelAdmin.add(reg);
                
                
                
            }
            
               
                tablaVisAlumn.setModel(modeloal);
                JPopupMenu menualu = new JPopupMenu();
         JMenuItem itemaluEliminar = new JMenuItem("Eliminar");
         menualu.add(itemaluEliminar);

         tablaVisAlumn.addMouseListener(new java.awt.event.MouseAdapter(){
             public void mousePressed(java.awt.event.MouseEvent evt){
                 if (evt.isPopupTrigger()|| evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
                     int fila = tablaVisAlumn.rowAtPoint(evt.getPoint());
                 {
                             if (fila >= 0){
                                tablaVisAlumn.setRowSelectionInterval(fila, fila);
                                menualu.show(tablaVisAlumn, evt.getX(), evt.getY());
                             }
         }
         }}
                 public void mouseReleased(java.awt.event.MouseEvent evt){
                 mousePressed(evt);
                 }});
        itemaluEliminar.addActionListener(e ->{
           int fila = tablaVisAlumn.getSelectedRow(); 
           if (fila >=0){
               //Alumno al= FrameVerAlumno.get(fila);
               RegistroVisitaAlumno rva= PanelAdmin.get(fila);
               int repuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar la visita?", "Advertencia", JOptionPane.YES_OPTION);
               if (repuesta == JOptionPane.YES_OPTION){
                   try{
                       PreparedStatement ps2 = con.prepareStatement("DELETE FROM registrovisitaalumno WHERE idRegistroVisitaAlum=? ");
                       ps2.setInt(1, rva.getIdRegistroVisitaAlumno());
                       ps2.executeUpdate();
                       mostrarVisitaAlumno();
                   }catch(Exception e2){
                       System.out.println("Error al guardar"+e2.getMessage());
                   }
               }
           }
        });

       }catch(Exception e){
           System.out.println("Error al cargar" +e.getMessage());
      
}   }
                
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVisAlumn = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_verdc = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icono alumno 33333.png"))); // NOI18N
        jLabel20.setText("jLabel1");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 37, -1));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Admin");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 70, 40));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Alumno");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 70, 40));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Docente");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 80, 40));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Grupos");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 80, 40));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Carreras");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 80, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linea recta nia.png"))); // NOI18N
        jLabel7.setText("jLabel4");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 10));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono admin traka2222.png"))); // NOI18N
        jLabel10.setText("jLabel7");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 31, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono carerra 22222.png"))); // NOI18N
        jLabel11.setText("jLabel8");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 37, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen grupo 222222.png"))); // NOI18N
        jLabel6.setText("jLabel5");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 37, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono docente 22222.png"))); // NOI18N
        jLabel12.setText("jLabel9");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 37, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar sesion222222.png"))); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cerrar Sesion");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Panel Admin");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 170, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo ute feo PEENEGE1111.png"))); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 600));

        tablaVisAlumn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Nombres", "Apellido paterno", "Apellido materno", "Grupo", "Carrera", "Fecha de visita", "Hora de visita", "Estatus"
            }
        ));
        jScrollPane1.setViewportView(tablaVisAlumn);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 560, 150));

        tabla_verdc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Apellido paterno", "Apellido materno", "FechaVisita", "HoraVisita", "Estatus"
            }
        ));
        jScrollPane2.setViewportView(tabla_verdc);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 560, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
     AdminLogin adminLogin = new AdminLogin(); //aqui se abrira el frame de veradmin
        adminLogin.setVisible(true);
        this.dispose();


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
      FrameVerDocente verDocente = new FrameVerDocente(); //aqui se abrira el frame de veradmin
        verDocente.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaVisAlumn;
    private javax.swing.JTable tabla_verdc;
    // End of variables declaration//GEN-END:variables
}
