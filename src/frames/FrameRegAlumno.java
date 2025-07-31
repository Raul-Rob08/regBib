/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import static javax.swing.JOptionPane.showMessageDialog;
import clases.Alumno;
import clases.Carrera;
import clases.Grupo;
import clases.Conexion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


/**
 *
 * @author raulr
 */
public class FrameRegAlumno extends javax.swing.JFrame {

    /**
     * Creates new form FrameRegAlumno
     */
    public FrameRegAlumno() {
        initComponents();
         this.setLocationRelativeTo(null);
        cargarCarreras();
        comboGrupo.setEnabled(false);
      comboCarrera.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        Carrera carrera = (Carrera) comboCarrera.getSelectedItem();
        if (carrera != null) {
            comboGrupo.removeAllItems(); // limpia antes de cargar
            cargarGruposPorCarrera(carrera.getIdCarrera());
            comboGrupo.setEnabled(true);
        } else {
            comboGrupo.removeAllItems();
            comboGrupo.setEnabled(false);
        }
    }
});

        //cargarGrupos();
        btnGuardar.setBackground(new java.awt.Color(37, 137, 126));
        btnGuardar.setForeground(java.awt.Color.black);
        JLabel lblRegresar = new JLabel(" Regresar");
JLabel jLabel19 = new JLabel("← Regresar");
lblRegresar.setForeground(Color.BLACK);  // Mantén el color del texto
lblRegresar.setFont(new Font("Segoe UI", Font.BOLD, 14));
lblRegresar.setHorizontalAlignment(SwingConstants.CENTER);
// lblRegresar.setBackground(...)  // No pongas fondo
lblRegresar.setBorder(null);  // También puedes quitar el borde si lo deseas
lblRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
lblRegresar.setBounds(30, 480, 120, 35);


         aplicarHover(jLabel13);
    aplicarHover(jLabel21);
    aplicarHover(jLabel16);
    aplicarHover(jLabel14);
    aplicarHover(jLabel15);
    aplicarHover(jLabel22);
    aplicarHover(jLabel19);
    
           Font fuenteMenu = new Font("Segoe UI", Font.BOLD, 14);
 Color colorTexto = Color.WHITE;
 Color colorFondo = new Color(0, 153, 153);
 


 jLabel13.setFont(fuenteMenu);
 jLabel13.setForeground(colorTexto);
 jLabel13.setOpaque(true);
 jLabel13.setBackground(colorFondo);

 JLabel[] menuLabels = { jLabel21, jLabel16, jLabel14, jLabel22,jLabel13,jLabel19 };

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
        
        
     public void cargarCarreras(){
        try{
            Conexion conexion = new Conexion();
            Connection con= conexion.con;
            
            String sql= "SELECT idCarrera, carreraNombre, estatus FROM carrera";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet datos = ps.executeQuery();
            
            while(datos.next()){
                int idCarrera= datos.getInt("idCarrera");
                String carreraNombre= datos.getString("carreraNombre");
                String estatus= datos.getString("estatus");
                Carrera carrera1= new Carrera(idCarrera, carreraNombre, estatus);
                comboCarrera.addItem(carrera1);
            }    
            datos.close();
            ps.close();
            con.close();
        }catch(Exception e){
            showMessageDialog(null, "Error al cargar la base de datos" + e.getMessage());  
        }
    }
 

     
     
public void cargarGruposPorCarrera(int idCarrera) {
    comboGrupo.removeAllItems(); // Limpia el combo

    try {
        Conexion conexion = new Conexion();
        Connection con = conexion.con;

        String sql = "SELECT idGrupo, nombreGrupo, estatus, idCarrera FROM grupo WHERE idCarrera = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCarrera);
        ResultSet datos = ps.executeQuery();

        while (datos.next()) {
            int idGrupo = datos.getInt("idGrupo");
            String nombreGrupo = datos.getString("nombreGrupo");
            String estatus = datos.getString("estatus");

            Grupo grupo1 = new Grupo(idGrupo, nombreGrupo, estatus, idCarrera);
            comboGrupo.addItem(grupo1);
        }

        datos.close();
        ps.close();
        con.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar los grupos: " + e.getMessage());
    }
}

    
    





    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApaterno = new javax.swing.JTextField();
        txtAmaterno = new javax.swing.JTextField();
        comboCarrera = new javax.swing.JComboBox<>();
        comboGrupo = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
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
        jLabel23 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lbLibros = new javax.swing.JLabel();
        lbFlechas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });
        jPanel2.add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 160, -1));

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 150, -1));

        txtApaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApaternoActionPerformed(evt);
            }
        });
        jPanel2.add(txtApaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 125, -1));

        txtAmaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmaternoActionPerformed(evt);
            }
        });
        jPanel2.add(txtAmaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 125, -1));

        comboCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCarreraActionPerformed(evt);
            }
        });
        jPanel2.add(comboCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 130, -1));

        comboGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGrupoActionPerformed(evt);
            }
        });
        jPanel2.add(comboGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 130, -1));

        btnGuardar.setBackground(new java.awt.Color(29, 136, 120));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar Alumno");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 540, -1, -1));

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

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen grupo 222222.png"))); // NOI18N
        jLabel23.setText("jLabel5");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 37, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono docente 22222.png"))); // NOI18N
        jLabel12.setText("jLabel9");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 37, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar sesion222222.png"))); // NOI18N
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));

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

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 620));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Registra un nuevo alumno:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-usuario.png"))); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel25.setText("Ingresa la matricula");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel26.setText("Ingresa tu grupo");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, -1, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel27.setText("Ingresa los nombres");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel29.setText("Ingresa tu apellido paterno");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel32.setText("Ingresa tu apellido materno");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        jLabel33.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel33.setText("Ingresa tu carrera");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jLabel34.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel34.setText("Ingresa tu grupo");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, -1, -1));

        lbLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libros.png"))); // NOI18N
        jPanel2.add(lbLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, -1, 110));

        lbFlechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flecha-hacia-atras.png"))); // NOI18N
        lbFlechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFlechasMouseClicked(evt);
            }
        });
        jPanel2.add(lbFlechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        PanelAdmin panelAdmin = new PanelAdmin(); //aqui se abrira el frame de veradmin
        panelAdmin.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        AdminLogin adminLogin = new AdminLogin(); //aqui se abrira el frame de veradmin
        adminLogin.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        VerCarrera vercarrera = new VerCarrera(); //aqui se abrira el frame de veradmin
        vercarrera.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        VerGrupo vergrupo = new VerGrupo(); //aqui se abrira el frame de veradmin
        vergrupo.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        FrameVerDocente verDocente = new FrameVerDocente(); //aqui se abrira el frame de veradmin
        verDocente.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        FrameVerAlumno veralumno = new FrameVerAlumno(); //aqui se abrira el frame de veradmin
        veralumno.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        VerAdmin veradmin = new VerAdmin(); //aqui se abrira el frame de veradmin
        veradmin.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String estatus=" ";
        Alumno alumno2 = new Alumno(estatus);

        String nombres= txtNombres.getText();
        String apaterno= txtApaterno.getText();
        String amaterno= txtAmaterno.getText();
        String matricula= txtMatricula.getText();
        estatus= alumno2.getEstatus();
        Grupo idGrupo2= (Grupo)comboGrupo.getSelectedItem();
        int idGrupo= idGrupo2.getIdGrupo();
        if (matricula.length() !=9) {
            JOptionPane.showMessageDialog(null, "La Matricula debe tener exactamente 9 valores.");
            return;
        }
        if (nombres.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del alumno no puede quedar vacio.");
            return;
        }
        if (apaterno.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El apellido del alumno no puede quedar vacio.");
            return;
        }
        if (matricula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La matricula del alumno no puede quedar vacio.");
            return;
        }
        Alumno alumno1 = new Alumno(idGrupo, nombres, apaterno, amaterno, matricula);

        if(alumno1.guardar()){
            //si se ejecuta lbien, enviará este mensaje
            showMessageDialog(null, "Guardado");
            FrameVerAlumno veralumno = new FrameVerAlumno(); //aqui se abrira el frame de verAlumno
            veralumno.setVisible(true);
            this.dispose();
            //instanciamos la clase de la lista
            //ListaUsuario lista = new ListaUsuario();
            //indicamos que esa lista sea visible
            //lista.setVisible(true);
            dispose();
        }else{
            //si no, enviará este mensaje
            showMessageDialog(null, "Error al guardar");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void comboGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGrupoActionPerformed

    private void comboCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCarreraActionPerformed

    }//GEN-LAST:event_comboCarreraActionPerformed

    private void txtAmaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmaternoActionPerformed

    private void txtApaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApaternoActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void lbFlechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFlechasMouseClicked
         FrameVerAlumno veralumno = new FrameVerAlumno(); //aqui se abrira el frame de veradmin
        veralumno.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbFlechasMouseClicked

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
            java.util.logging.Logger.getLogger(FrameRegAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameRegAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameRegAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameRegAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameRegAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Carrera> comboCarrera;
    private javax.swing.JComboBox<Grupo> comboGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbFlechas;
    private javax.swing.JLabel lbLibros;
    private javax.swing.JTextField txtAmaterno;
    private javax.swing.JTextField txtApaterno;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
