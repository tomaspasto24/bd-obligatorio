/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz_gráfica;

import db_connection.DBConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author juan-
 */
public class RecoverPassword extends javax.swing.JFrame {

    /**
     * Creates new form RecoverPassword
     */
    private Map<Integer, String> respuestasId;
    private Map<String, Integer> preguntasId;

    public RecoverPassword() {
        initComponents();
        Connection connection = DBConnection.getInstance().dbConnection;
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear statement, error: " + e.toString());
        }

        respuestasId = new HashMap<Integer, String>();
        preguntasId = new HashMap<String, Integer>();

        if (statement != null) {
            try {
                String sqlString
                        = "EXEC sp_set_session_context 'user_id', " + UserAccount.UserAccount.getInstance().getUserId() + "; "
                        + "SELECT * FROM [PREGUNTAS_RESPUESTAS]";
                var res = statement.executeQuery(sqlString);
                while (res.next()) {
                    String pregunta = res.getString("pregunta");
                    String respuesta = res.getString("respuesta");
                    Integer id = res.getInt("preg_id");
                    preguntasId.put(pregunta, id);
                    respuestasId.put(id, respuesta);
                }
                Object[] set = preguntasId.keySet().toArray();
                question1.setText(set[0].toString());
                question2.setText(set[1].toString());
                question3.setText(set[2].toString());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al obtener usuario, error: " + e.toString());
            }
        }
    }

    public static RecoverPassword instance;

    public static RecoverPassword getInstance() {
        if (instance == null) {
            instance = new RecoverPassword();
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
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        goBackBtn = new javax.swing.JPanel();
        goBackTxt = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        question1 = new javax.swing.JTextField();
        answer1 = new javax.swing.JTextField();
        question2 = new javax.swing.JTextField();
        answer2 = new javax.swing.JTextField();
        question3 = new javax.swing.JTextField();
        answer3 = new javax.swing.JTextField();
        subTitle = new javax.swing.JLabel();
        recoverBtn = new javax.swing.JPanel();
        recoverTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 570));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            .addComponent(exitTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 40, 40));

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
            .addComponent(goBackTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        goBackBtnLayout.setVerticalGroup(
            goBackBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(goBackTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(goBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

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
            .addGap(0, 710, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 710, 30));

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon("C:\\Users\\juan-\\OneDrive - Universidad Católica del Uruguay\\UCU\\2do\\2do semestre\\BD I\\bd-obligatorio\\Autoregistro_Usuarios\\src\\main\\java\\com\\images\\fondoRecoverPassword.jpg")); // NOI18N
        bg.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 570));

        title.setFont(new java.awt.Font("Calisto MT", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Recuperar contraseña");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 360, 60));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 340, 10));

        question1.setEditable(false);
        question1.setBackground(new java.awt.Color(255, 255, 255));
        question1.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        question1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(question1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 340, 30));

        answer1.setBackground(new java.awt.Color(255, 255, 255));
        answer1.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        answer1.setForeground(new java.awt.Color(153, 153, 153));
        answer1.setText("Ingrese la respuesta...");
        answer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answer1MouseClicked(evt);
            }
        });
        bg.add(answer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 340, 30));

        question2.setEditable(false);
        question2.setBackground(new java.awt.Color(255, 255, 255));
        question2.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        question2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(question2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 340, 30));

        answer2.setBackground(new java.awt.Color(255, 255, 255));
        answer2.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        answer2.setForeground(new java.awt.Color(153, 153, 153));
        answer2.setText("Ingrese la respuesta...");
        answer2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answer2MouseClicked(evt);
            }
        });
        bg.add(answer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 340, 30));

        question3.setEditable(false);
        question3.setBackground(new java.awt.Color(255, 255, 255));
        question3.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        question3.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(question3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 340, 30));

        answer3.setBackground(new java.awt.Color(255, 255, 255));
        answer3.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        answer3.setForeground(new java.awt.Color(153, 153, 153));
        answer3.setText("Ingrese la respuesta...");
        answer3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answer3MouseClicked(evt);
            }
        });
        bg.add(answer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 340, 30));

        subTitle.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        subTitle.setForeground(new java.awt.Color(0, 0, 0));
        subTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitle.setText("Conteste las preguntas");
        bg.add(subTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 340, 30));

        recoverBtn.setBackground(new java.awt.Color(43, 121, 195));
        recoverBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recoverBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recoverBtnMouseClicked(evt);
            }
        });

        recoverTxt.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        recoverTxt.setForeground(new java.awt.Color(255, 255, 255));
        recoverTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recoverTxt.setText("Recuperar");

        javax.swing.GroupLayout recoverBtnLayout = new javax.swing.GroupLayout(recoverBtn);
        recoverBtn.setLayout(recoverBtnLayout);
        recoverBtnLayout.setHorizontalGroup(
            recoverBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recoverTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        recoverBtnLayout.setVerticalGroup(
            recoverBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recoverTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(recoverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 260, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitBtnMouseClicked

    private void exitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseEntered
        exitBtn.setBackground(Color.red);
    }//GEN-LAST:event_exitBtnMouseEntered

    private void exitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseExited
        exitBtn.setBackground(Color.white);
    }//GEN-LAST:event_exitBtnMouseExited

    private void goBackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackBtnMouseClicked
        this.setVisible(false);
        GetUserIdToRecoverPassword.getInstance().setVisible(true);
    }//GEN-LAST:event_goBackBtnMouseClicked

    private void goBackBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackBtnMouseEntered
        goBackBtn.setBackground(Color.red);
    }//GEN-LAST:event_goBackBtnMouseEntered

    private void goBackBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackBtnMouseExited
        goBackBtn.setBackground(Color.white);
    }//GEN-LAST:event_goBackBtnMouseExited

    int xMouse, yMouse;
    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void answer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answer1MouseClicked
        if (answer1.getText().equals("Ingrese la respuesta...")) {
            answer1.setText("");
            answer1.setForeground(Color.black);
        }
        if (String.valueOf(answer2.getText()).isEmpty()) {
            answer2.setText("Ingrese la respuesta...");
            answer2.setForeground(Color.gray);
        }
        if (String.valueOf(answer3.getText()).isEmpty()) {
            answer3.setText("Ingrese la respuesta...");
            answer3.setForeground(Color.gray);
        }
    }//GEN-LAST:event_answer1MouseClicked

    private void answer2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answer2MouseClicked
        if (answer2.getText().equals("Ingrese la respuesta...")) {
            answer2.setText("");
            answer2.setForeground(Color.black);
        }
        if (String.valueOf(answer1.getText()).isEmpty()) {
            answer1.setText("Ingrese la respuesta...");
            answer1.setForeground(Color.gray);
        }
        if (String.valueOf(answer3.getText()).isEmpty()) {
            answer3.setText("Ingrese la respuesta...");
            answer3.setForeground(Color.gray);
        }
    }//GEN-LAST:event_answer2MouseClicked

    private void answer3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answer3MouseClicked
        if (answer3.getText().equals("Ingrese la respuesta...")) {
            answer3.setText("");
            answer3.setForeground(Color.black);
        }
        if (String.valueOf(answer1.getText()).isEmpty()) {
            answer1.setText("Ingrese la respuesta...");
            answer1.setForeground(Color.gray);
        }
        if (String.valueOf(answer2.getText()).isEmpty()) {
            answer2.setText("Ingrese la respuesta...");
            answer2.setForeground(Color.gray);
        }
    }//GEN-LAST:event_answer3MouseClicked

    private void recoverBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recoverBtnMouseClicked
        String respuesta1 = answer1.getText();
        String respuesta2 = answer2.getText();
        String respuesta3 = answer3.getText();

        if (respuesta1.equals("Ingrese la respuesta...") || respuesta2.equals("Ingrese la respuesta...")
                || respuesta3.equals("Ingrese la respuesta...")) {
            JOptionPane.showMessageDialog(null, "Debe contestar todas las preguntas");
        } else {
            //Comparar si las respuestas ingresadas coinciden con las respuestas en la bd
            String pregunta1 = question1.getText();
            String pregunta2 = question2.getText();
            String pregunta3 = question3.getText();

            if (respuestasId.get(preguntasId.get(pregunta1)).equalsIgnoreCase(respuesta1)
                    && respuestasId.get(preguntasId.get(pregunta2)).equalsIgnoreCase(respuesta2)
                    && respuestasId.get(preguntasId.get(pregunta3)).equalsIgnoreCase(respuesta3)) {
                this.setVisible(false);
                ChangePassword.getInstance().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Respuestas incorrectas.");
            }
        }
    }//GEN-LAST:event_recoverBtnMouseClicked

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
            java.util.logging.Logger.getLogger(RecoverPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecoverPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecoverPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecoverPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecoverPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answer1;
    private javax.swing.JTextField answer2;
    private javax.swing.JTextField answer3;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel goBackBtn;
    private javax.swing.JLabel goBackTxt;
    private javax.swing.JPanel header;
    private javax.swing.JLabel image;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField question1;
    private javax.swing.JTextField question2;
    private javax.swing.JTextField question3;
    private javax.swing.JPanel recoverBtn;
    private javax.swing.JLabel recoverTxt;
    private javax.swing.JLabel subTitle;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
