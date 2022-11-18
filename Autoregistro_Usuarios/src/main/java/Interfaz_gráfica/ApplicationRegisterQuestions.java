/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interfaz_gráfica;

import UserAccount.UserAccount;
import db_connection.DBConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author TomasUcu
 */
public class ApplicationRegisterQuestions extends javax.swing.JFrame {

    public static ApplicationRegisterQuestions instance;
    private Map<String, Integer> preguntasId;

    public static ApplicationRegisterQuestions getInstance() {
        if (instance == null) {
            instance = new ApplicationRegisterQuestions();
        }
        return instance;
    }

    public ApplicationRegisterQuestions() {
        initComponents();
        Connection connection = DBConnection.getInstance().dbConnection;
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear statement, error: " + e.toString());
        }

        preguntasId = new HashMap<String, Integer>();

        if (statement != null) {
            try {
                String sqlString = "SELECT * "
                        + "FROM PREGUNTAS";
                var res = statement.executeQuery(sqlString);
                while (res.next()) {
                    String pregunta = res.getString("pregunta");
                    Integer id = res.getInt("preg_id");
                    preguntasId.put(pregunta, id);
                }
                Pregunta1.setModel(new DefaultComboBoxModel<String>(preguntasId.keySet().toArray(new String[0])));
                Pregunta2.setModel(new DefaultComboBoxModel<String>(preguntasId.keySet().toArray(new String[0])));
                Pregunta3.setModel(new DefaultComboBoxModel<String>(preguntasId.keySet().toArray(new String[0])));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al obtener user, error: " + e.toString());
            }
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

        jButton1 = new javax.swing.JButton();
        bg = new javax.swing.JPanel();
        Pregunta1 = new javax.swing.JComboBox<>();
        title = new javax.swing.JLabel();
        Pregunta2 = new javax.swing.JComboBox<>();
        Pregunta3 = new javax.swing.JComboBox<>();
        Respuesta1 = new javax.swing.JTextField();
        Respuesta2 = new javax.swing.JTextField();
        Respuesta3 = new javax.swing.JTextField();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        bgImage = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        registerBtn = new javax.swing.JPanel();
        registerTxt = new javax.swing.JLabel();

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 570));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pregunta1.setBackground(new java.awt.Color(255, 255, 255));
        Pregunta1.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        Pregunta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pregunta1ActionPerformed(evt);
            }
        });
        bg.add(Pregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 280, 30));

        title.setFont(new java.awt.Font("Calisto MT", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Preguntas de Seguridad");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, 50));

        Pregunta2.setBackground(new java.awt.Color(255, 255, 255));
        Pregunta2.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        Pregunta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pregunta2ActionPerformed(evt);
            }
        });
        bg.add(Pregunta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 280, 30));

        Pregunta3.setBackground(new java.awt.Color(255, 255, 255));
        Pregunta3.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        Pregunta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pregunta3ActionPerformed(evt);
            }
        });
        bg.add(Pregunta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 280, 30));

        Respuesta1.setBackground(new java.awt.Color(255, 255, 255));
        Respuesta1.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        Respuesta1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Respuesta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Respuesta1ActionPerformed(evt);
            }
        });
        bg.add(Respuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 280, 40));

        Respuesta2.setBackground(new java.awt.Color(255, 255, 255));
        Respuesta2.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        Respuesta2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bg.add(Respuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 280, 40));

        Respuesta3.setBackground(new java.awt.Color(255, 255, 255));
        Respuesta3.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        Respuesta3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bg.add(Respuesta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 280, 40));

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        exitTxt.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(0, 0, 0));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 30, 30));

        bgImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\juan-\\OneDrive - Universidad Católica del Uruguay\\UCU\\2do\\2do semestre\\BD I\\bd-obligatorio\\Images\\Auto-Registro\\fondoQuestions.jpg")); // NOI18N
        bg.add(bgImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 570));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 360, 10));

        registerBtn.setBackground(new java.awt.Color(13, 63, 126));
        registerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerBtnMouseClicked(evt);
            }
        });

        registerTxt.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        registerTxt.setForeground(new java.awt.Color(255, 255, 255));
        registerTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerTxt.setText("Registrarse");

        javax.swing.GroupLayout registerBtnLayout = new javax.swing.GroupLayout(registerBtn);
        registerBtn.setLayout(registerBtnLayout);
        registerBtnLayout.setHorizontalGroup(
            registerBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        registerBtnLayout.setVerticalGroup(
            registerBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 120, 60));

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
    }// </editor-fold>//GEN-END:initComponents

    private void Pregunta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pregunta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pregunta1ActionPerformed

    private void Pregunta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pregunta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pregunta2ActionPerformed

    private void Pregunta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pregunta3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pregunta3ActionPerformed

    private void Respuesta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Respuesta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Respuesta1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitBtnMouseClicked

    private void exitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseEntered
        exitBtn.setBackground(Color.red);
    }//GEN-LAST:event_exitBtnMouseEntered

    private void exitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseExited
        exitBtn.setBackground(Color.white);
    }//GEN-LAST:event_exitBtnMouseExited

    private void registerBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnMouseClicked
        String pregunta1 = Pregunta1.getSelectedItem().toString();
        String pregunta2 = Pregunta2.getSelectedItem().toString();
        String pregunta3 = Pregunta3.getSelectedItem().toString();

        String respuesta1 = Respuesta1.getText();
        String respuesta2 = Respuesta2.getText();
        String respuesta3 = Respuesta3.getText();

        if (pregunta1.equals(pregunta2) | pregunta1.equals(pregunta3) | pregunta2.equals(pregunta3)) {
            JOptionPane.showMessageDialog(null, "Debe elegir preguntas diferentes.");
            return;
        } else if (respuesta1.isEmpty() | respuesta2.isEmpty() | respuesta3.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Las respuestas no pueden estar vacias.");
            return;
        }

        Connection connection = DBConnection.getInstance().dbConnection;

        Statement statement = null;
        try {
            statement = connection.createStatement();
            if (statement != null) {
                String sqlStringPreg1 = "INSERT INTO PERSONAS_PREGUNTAS (user_id, preg_id, respuesta) "
                        + "VALUES (" + UserAccount.getInstance().getUserId() + ", " + preguntasId.get(pregunta1.toString()) + ", '" + respuesta1.toString() + "')";
                
                String sqlStringPreg2 = "INSERT INTO PERSONAS_PREGUNTAS (user_id, preg_id, respuesta) "
                        + "VALUES (" + UserAccount.getInstance().getUserId() + ", " + preguntasId.get(pregunta2.toString()) + ", '" + respuesta2.toString() + "')";
                
                String sqlStringPreg3 = "INSERT INTO PERSONAS_PREGUNTAS (user_id, preg_id, respuesta) "
                        + "VALUES (" + UserAccount.getInstance().getUserId() + ", " + preguntasId.get(pregunta3.toString()) + ", '" + respuesta3.toString() + "')";
                
                statement.executeUpdate(sqlStringPreg1);
                statement.executeUpdate(sqlStringPreg2);
                statement.executeUpdate(sqlStringPreg3);
                
                this.setVisible(false);
                ApplicationLogin.getInstance().setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar usuario, error: " + e.toString());
        }
    }//GEN-LAST:event_registerBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Pregunta1;
    private javax.swing.JComboBox<String> Pregunta2;
    private javax.swing.JComboBox<String> Pregunta3;
    private javax.swing.JTextField Respuesta1;
    private javax.swing.JTextField Respuesta2;
    private javax.swing.JTextField Respuesta3;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel bgImage;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel registerBtn;
    private javax.swing.JLabel registerTxt;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
