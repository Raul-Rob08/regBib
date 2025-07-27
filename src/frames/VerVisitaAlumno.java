/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;
import clases.Alumno;
import clases.Carrera;
import clases.Conexion;
import clases.Grupo;
import clases.RegistroVisitaAlumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raulr
 */
public class VerVisitaAlumno extends javax.swing.JFrame {

    /**
     * Creates new form VerVisitaAlumno
     */
    public JPopupMenu menu;
    public VerVisitaAlumno() {
        initComponents();
        mostrarVisitaAlumno();
    }
    
    public void mostrarVisitaAlumno(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Matricula");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellido paterno");
        modelo.addColumn("Apellido materno");
        modelo.addColumn("Grupo");
        modelo.addColumn("Carrera");
        modelo.addColumn("Fecha de la visita");
        modelo.addColumn("Hora de la visita");
        modelo.addColumn("Estatus");
        tablaVisAlumn.setModel(modelo); 
        try{
            Conexion conexion = new Conexion();
            Connection con= conexion.con;
            String sql= "SELECT a.idAlumno, a.matricula, a.nombre, a.apaterno, a.amaterno, a.idGrupo, g.nombreGrupo,g.idCarrera,   c.carreraNombre, a.estatus, r.fechaVisita, r.horaVisita FROM registroVisitaAlumno r INNER JOIN alumno a ON r.idAlumno = a.idAlumno INNER JOIN grupo g ON a.idGrupo = g.idGrupo INNER JOIN carrera c ON g.idCarrera = c.idCarrera;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet datos = ps.executeQuery();
            ArrayList<RegistroVisitaAlumno> FrameVerAlumno = new ArrayList<>();
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
                String fechaVisita = datos.getString("fechaVisita");
                String horaVisita = datos.getString("horaVisita");   
                
                Grupo grupo1 = new Grupo(idGrupo, nombreGrupo, idCarrera);
                Carrera carrera1 = new Carrera(idCarrera, carreraNombre);
                
                //Instanciamos la clase Alumno que recibirá como parámetro los valores que recibió de la base de datos
                Alumno alumno1 = new Alumno(idAlumno, idGrupo, nombres, apaterno, amaterno, matricula, estatus);
                //Añade los elementos de la instancia de la clase a la tabla
              

                // Agregar a la tabla
                modelo.addRow(new Object[]{
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
                //FrameVerAlumno.add(alumno1);
            }
                tablaVisAlumn.setModel(modelo);
                  
         menu = new JPopupMenu();
         JMenuItem itemEliminar = new JMenuItem("Eliminar");
         menu.add(itemEliminar);

         tablaVisAlumn.addMouseListener(new java.awt.event.MouseAdapter(){
             public void mousePressed(java.awt.event.MouseEvent evt){
                 if (evt.isPopupTrigger()|| evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
                     int fila = tablaVisAlumn.rowAtPoint(evt.getPoint());
                 {
                             if (fila >= 0){
                                tablaVisAlumn.setRowSelectionInterval(fila, fila);
                                menu.show(tablaVisAlumn, evt.getX(), evt.getY());
                             }
         }
         }}
                 public void mouseReleased(java.awt.event.MouseEvent evt){
                 mousePressed(evt);
                 }});
        itemEliminar.addActionListener(e ->{
           int fila = tablaVisAlumn.getSelectedRow(); 
           if (fila >=0){
               //Alumno al= FrameVerAlumno.get(fila);
               RegistroVisitaAlumno rva= FrameVerAlumno.get(fila);
               int repuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar la visita?", "Advertencia", JOptionPane.YES_OPTION);
               if (repuesta == JOptionPane.YES_OPTION){
                   try{
                       PreparedStatement ps2 = con.prepareStatement("DELETE FROM registrovisitaalummno WHERE idRegistroVisitaAlum=? ");
                       ps2.setInt(1, rva.getIdAlumno());
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVisAlumn = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaVisAlumn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaVisAlumn);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 610, 322));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VerVisitaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerVisitaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerVisitaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerVisitaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerVisitaAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVisAlumn;
    // End of variables declaration//GEN-END:variables
}
