/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz_gráfica;

import UserAccount.UserAccount;
import db_connection.DBConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author juan-
 */
public class Permisos_GestionPermisos extends javax.swing.JFrame {

    /**
     * Creates new form Permisos_AU
     */
    private HashMap<Integer, String> indexPermiso;

    public Permisos_GestionPermisos() {
        initComponents();
        this.completeList();
    }
    
    private void completeList(){
        Connection connection = DBConnection.getInstance().dbConnection;
        Statement statement = null;
        
        indexPermiso = new HashMap<Integer, String>();

        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear statement, error: " + e.toString());
        }

        DefaultListModel permisos = new DefaultListModel();

        if (statement != null) {
            try {
                int index = 0;
                String sqlString = "EXEC sp_set_session_context 'userID', " + UserAccount.getInstance().getUserId() + "; "
                        + "SELECT * FROM [PERMISOS_GESTION_PERMISOS];";
                var res = statement.executeQuery(sqlString);
                while (res.next()) {
                    Integer rol_neg_id = res.getInt("rol_neg_id");
                    Integer user_id = res.getInt("user_id");
                    String user_name = res.getString("nombres");
                    String rol_desc = res.getString("descripcion_rol_neg");
                    indexPermiso.put(index, String.valueOf(user_id) + "," + String.valueOf(rol_neg_id));
                    permisos.addElement("Nombre: " + user_name + " | Descripción del rol solicitado: " + rol_desc);
                    index++;
                }
                ListPermisos.setModel(permisos);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al obtener solicitudes, error: " + e.toString());
            }
        }
    }

    public static Permisos_GestionPermisos instance;

    public static Permisos_GestionPermisos getInstance() {
        if (instance == null) {
            instance = new Permisos_GestionPermisos();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        ScrollPanelPermisos = new javax.swing.JScrollPane();
        ListPermisos = new javax.swing.JList<>();
        aceptarPermisoBtn = new javax.swing.JPanel();
        aceptarPermisoTXT = new javax.swing.JLabel();
        denegarPermisoBtn = new javax.swing.JPanel();
        denegarPermisoTxt = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        goBackBtn = new javax.swing.JPanel();
        goBackTxt = new javax.swing.JLabel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        header = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(800, 570));
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListPermisos.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        ScrollPanelPermisos.setViewportView(ListPermisos);

        bg.add(ScrollPanelPermisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 550, 460));

        aceptarPermisoBtn.setBackground(new java.awt.Color(0, 153, 153));
        aceptarPermisoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aceptarPermisoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptarPermisoBtnMouseClicked(evt);
            }
        });

        aceptarPermisoTXT.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        aceptarPermisoTXT.setForeground(new java.awt.Color(255, 255, 255));
        aceptarPermisoTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aceptarPermisoTXT.setText("Aceptar");

        javax.swing.GroupLayout aceptarPermisoBtnLayout = new javax.swing.GroupLayout(aceptarPermisoBtn);
        aceptarPermisoBtn.setLayout(aceptarPermisoBtnLayout);
        aceptarPermisoBtnLayout.setHorizontalGroup(
            aceptarPermisoBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aceptarPermisoTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        aceptarPermisoBtnLayout.setVerticalGroup(
            aceptarPermisoBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aceptarPermisoTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        bg.add(aceptarPermisoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 140, 50));

        denegarPermisoBtn.setBackground(new java.awt.Color(255, 51, 51));
        denegarPermisoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        denegarPermisoTxt.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        denegarPermisoTxt.setForeground(new java.awt.Color(255, 255, 255));
        denegarPermisoTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        denegarPermisoTxt.setText("Denegar");

        javax.swing.GroupLayout denegarPermisoBtnLayout = new javax.swing.GroupLayout(denegarPermisoBtn);
        denegarPermisoBtn.setLayout(denegarPermisoBtnLayout);
        denegarPermisoBtnLayout.setHorizontalGroup(
            denegarPermisoBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(denegarPermisoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        denegarPermisoBtnLayout.setVerticalGroup(
            denegarPermisoBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(denegarPermisoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        bg.add(denegarPermisoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, -1, -1));

        title.setFont(new java.awt.Font("Calisto MT", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Permisos Gestión de Permisos");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 620, 70));

        goBackBtn.setBackground(new java.awt.Color(255, 255, 255));
        goBackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goBackBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                goBackBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                goBackBtnMouseExited(evt);
            }
        });

        goBackTxt.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        goBackTxt.setForeground(new java.awt.Color(0, 0, 0));
        goBackTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goBackTxt.setText("<");

        javax.swing.GroupLayout goBackBtnLayout = new javax.swing.GroupLayout(goBackBtn);
        goBackBtn.setLayout(goBackBtnLayout);
        goBackBtnLayout.setHorizontalGroup(
            goBackBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(goBackTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        goBackBtnLayout.setVerticalGroup(
            goBackBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(goBackTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(goBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitBtnMouseExited(evt);
            }
        });

        exitTxt.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(0, 0, 0));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 40, 40));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 720, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goBackBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackBtnMouseEntered
        goBackBtn.setBackground(Color.red);
    }//GEN-LAST:event_goBackBtnMouseEntered

    private void goBackBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackBtnMouseExited
        goBackBtn.setBackground(Color.white);
    }//GEN-LAST:event_goBackBtnMouseExited

    private void goBackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackBtnMouseClicked
        this.setVisible(false);
        Home.getInstance().setVisible(true);
    }//GEN-LAST:event_goBackBtnMouseClicked

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitBtnMouseClicked

    private void exitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseEntered
        exitBtn.setBackground(Color.red);
    }//GEN-LAST:event_exitBtnMouseEntered

    private void exitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseExited
        exitBtn.setBackground(Color.white);
    }//GEN-LAST:event_exitBtnMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    int xMouse, yMouse;
    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void aceptarPermisoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarPermisoBtnMouseClicked

        int indexList = ListPermisos.getSelectedIndex();

        String valuesIndex = indexPermiso.get(indexList);
        String[] values = valuesIndex.split(",");
        int user_id = Integer.valueOf(values[0]);
        int rol_neg_id = Integer.valueOf(values[1]);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);

        Connection connection = DBConnection.getInstance().dbConnection;
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear statement, error: " + e.toString());
        }

        if (statement != null) {
            try {
                String sqlString = "UPDATE PERMISOS "
                        + "SET estado='ACTIVO' " 
                        + ",fecha_autorizacion='" + strDate +"' "
                        + "WHERE user_id=" + user_id + " AND " + "app_id=" + 1 + " AND " + "rol_neg_id=" + rol_neg_id;
                System.out.println(sqlString);
                int rs = statement.executeUpdate(sqlString);
                System.out.println(rs);
                if (rs != 0) {
                    JOptionPane.showMessageDialog(null, "Cambio de estado realizado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Problema al cambiar el estado. Prueba otra vez.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cambiar el estado, error: " + e.toString());
            }
        }
        this.completeList();

    }//GEN-LAST:event_aceptarPermisoBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Permisos_GestionPermisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Permisos_GestionPermisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Permisos_GestionPermisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Permisos_GestionPermisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Permisos_GestionPermisos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListPermisos;
    private javax.swing.JScrollPane ScrollPanelPermisos;
    private javax.swing.JPanel aceptarPermisoBtn;
    private javax.swing.JLabel aceptarPermisoTXT;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel denegarPermisoBtn;
    private javax.swing.JLabel denegarPermisoTxt;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel goBackBtn;
    private javax.swing.JLabel goBackTxt;
    private javax.swing.JPanel header;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
