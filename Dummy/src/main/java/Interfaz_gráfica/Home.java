/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz_gráfica;

import db_connection.DBConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import UserAccount.UserAccount;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author TomasUcu
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        Connection connection = DBConnection.getInstance().dbConnection;
        Statement statement = null;
        HashMap<String, Integer[]> nombreAppRol = new HashMap<String, Integer[]>();
        HashMap<String, Integer> nombreAppID = new HashMap<String, Integer>();

        Integer[] roles1 = new Integer[10];
        Integer[] roles2 = new Integer[10];
        Integer[] roles3 = new Integer[10];

        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear statement, error: " + e.toString());
        }

        DefaultListModel aplicativos = new DefaultListModel();

        if (statement != null) {
            try {
                String sqlString = "EXEC sp_set_session_context 'user_id'," + UserAccount.getInstance().getUserId() + "; "
                        + "SELECT * FROM [APLICATIVOS_APROBADOS];";
                var res = statement.executeQuery(sqlString);
                int index1 = 0;
                int index2 = 0;
                int index3 = 0;
                while (res.next()) {
                    String nombre_app = res.getString("nombre_app");
                    Integer app_id = res.getInt("app_id");
                    Integer rol_id = res.getInt("rol_id");

                    if (nombre_app.equals("Gestión de Identidades y Permisos")) {
                        roles1[index1] = rol_id;
                        index1++;
                        nombreAppRol.put(nombre_app, roles1);
                    } else if (nombre_app.equals("Autoregistro de Usuarios")) {
                        roles2[index2] = rol_id;
                        index2++;
                        nombreAppRol.put(nombre_app, roles2);
                    } else if (nombre_app.equals("Dummy")) {
                        roles3[index3] = rol_id;
                        index3++;
                        nombreAppRol.put(nombre_app, roles3);
                    }
                    nombreAppID.put(nombre_app, app_id);
                    if (!aplicativos.contains(nombre_app)) {
                        aplicativos.addElement(nombre_app);
                    }

                }
                jListAplicativos.setModel(aplicativos);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al obtener aplicaciones, error: " + e.toString());
            }
        }

        jListAplicativos.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    Connection connection = DBConnection.getInstance().dbConnection;
                    Statement statement = null;

                    String nombreApp = jListAplicativos.getSelectedValue().toString();

                    try {
                        statement = connection.createStatement();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al crear statement, error: " + e.toString());
                    }

                    DefaultListModel menus = new DefaultListModel();

                    for (Integer integer : nombreAppRol.get(nombreApp)) {
                        if (integer != null) {
                            if (statement != null) {
                                try {
                                    String sqlString
                                            = "EXEC sp_set_session_context 'app_id', " + nombreAppID.get(nombreApp) + "; "
                                            + "EXEC sp_set_session_context 'rol_id', " + integer + "; "
                                            + "SELECT * FROM [MENU_APROBADOS];";
                                    var res = statement.executeQuery(sqlString);
                                    System.out.println(sqlString);
                                    while (res.next()) {
                                        String nombre_menu = res.getString("descripcion_menu");
                                        menus.addElement(nombre_menu);
                                    }
                                    jListMenus.setModel(menus);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Error al obtener user, error: " + e.toString());
                                }
                            }
                        }
                    }

                }
            }
        });
    }

    public static Home instance;

    public static Home getInstance() {
        if (instance == null) {
            instance = new Home();
        }
        return instance;
    }

    public static void closeInstance() {
        instance = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg15 = new javax.swing.JPanel();
        title11 = new javax.swing.JLabel();
        exitBtn12 = new javax.swing.JPanel();
        exitTxt12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        header = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        title12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListMenus = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListAplicativos = new javax.swing.JList<>();
        logOutBtn = new javax.swing.JPanel();
        logOutTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(800, 565));
        setUndecorated(true);
        setResizable(false);

        bg15.setBackground(new java.awt.Color(255, 255, 255));
        bg15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title11.setFont(new java.awt.Font("Calisto MT", 1, 36)); // NOI18N
        title11.setForeground(new java.awt.Color(0, 0, 0));
        title11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title11.setText("Aplicativos");
        bg15.add(title11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 340, 50));

        exitBtn12.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtn12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitBtn12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitBtn12MouseExited(evt);
            }
        });

        exitTxt12.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        exitTxt12.setForeground(new java.awt.Color(0, 0, 0));
        exitTxt12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt12.setText("X");

        javax.swing.GroupLayout exitBtn12Layout = new javax.swing.GroupLayout(exitBtn12);
        exitBtn12.setLayout(exitBtn12Layout);
        exitBtn12Layout.setHorizontalGroup(
            exitBtn12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitBtn12Layout.createSequentialGroup()
                .addComponent(exitTxt12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        exitBtn12Layout.setVerticalGroup(
            exitBtn12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtn12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTxt12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg15.add(exitBtn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 30, 30));
        bg15.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 320, -1));

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
            .addGap(0, 670, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        bg15.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 670, 30));
        bg15.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 320, -1));

        title12.setFont(new java.awt.Font("Calisto MT", 1, 36)); // NOI18N
        title12.setForeground(new java.awt.Color(0, 0, 0));
        title12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title12.setText("Menus");
        bg15.add(title12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 340, 50));

        jListMenus.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jListMenus.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jListMenus);

        bg15.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 370, 430));

        jListAplicativos.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jListAplicativos.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jScrollPane3.setViewportView(jListAplicativos);

        bg15.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 370, 430));

        logOutBtn.setBackground(new java.awt.Color(255, 255, 255));
        logOutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutBtnMouseExited(evt);
            }
        });

        logOutTxt.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        logOutTxt.setForeground(new java.awt.Color(0, 0, 0));
        logOutTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logOutTxt.setText("Cerrar sesión");

        javax.swing.GroupLayout logOutBtnLayout = new javax.swing.GroupLayout(logOutBtn);
        logOutBtn.setLayout(logOutBtnLayout);
        logOutBtnLayout.setHorizontalGroup(
            logOutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logOutTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        logOutBtnLayout.setVerticalGroup(
            logOutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logOutTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg15.add(logOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg15, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtn12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtn12MouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitBtn12MouseClicked

    private void exitBtn12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtn12MouseEntered
        exitBtn12.setBackground(Color.red);
    }//GEN-LAST:event_exitBtn12MouseEntered

    private void exitBtn12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtn12MouseExited
        exitBtn12.setBackground(Color.white);

    }//GEN-LAST:event_exitBtn12MouseExited

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

    private void logOutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseClicked
        UserAccount.getInstance().setUserId(0);
        this.setVisible(false);
        closeInstance();
        Login.getInstance().setVisible(true);
    }//GEN-LAST:event_logOutBtnMouseClicked

    private void logOutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseEntered
        logOutBtn.setBackground(Color.red);
    }//GEN-LAST:event_logOutBtnMouseEntered

    private void logOutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseExited
        logOutBtn.setBackground(Color.white);
    }//GEN-LAST:event_logOutBtnMouseExited

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg15;
    private javax.swing.JPanel exitBtn12;
    private javax.swing.JLabel exitTxt12;
    private javax.swing.JPanel header;
    private javax.swing.JList<String> jListAplicativos;
    private javax.swing.JList<String> jListMenus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel logOutBtn;
    private javax.swing.JLabel logOutTxt;
    private javax.swing.JLabel title11;
    private javax.swing.JLabel title12;
    // End of variables declaration//GEN-END:variables
}
