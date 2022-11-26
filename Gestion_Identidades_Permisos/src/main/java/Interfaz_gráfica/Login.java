/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz_gráfica;

//import Interfaz_gráfica.GetUserIdToRecoverPassword;
import db_connection.DBConnection;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author TomasUcu
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Login() {
        initComponents();
    }

    public static Login instance;

    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
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

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        iniciarSesionText = new javax.swing.JLabel();
        nameText = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        nameText1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        passwordInput = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JPanel();
        loginText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Calisto MT", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Bienvenido a Gestión de Permisos");
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, 60));

        image.setIcon(new javax.swing.ImageIcon("C:\\Users\\juan-\\OneDrive - Universidad Católica del Uruguay\\UCU\\2do\\2do semestre\\BD I\\bd-obligatorio\\Gestion_Identidades_Permisos\\src\\main\\java\\com\\images\\fondoHome.jpg")); // NOI18N
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 180));

        iniciarSesionText.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        iniciarSesionText.setForeground(new java.awt.Color(0, 0, 0));
        iniciarSesionText.setText("Iniciar Sesión");
        jPanel1.add(iniciarSesionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

        nameText.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        nameText.setForeground(new java.awt.Color(0, 0, 0));
        nameText.setText("Nombre");
        jPanel1.add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        nameInput.setBackground(new java.awt.Color(255, 255, 255));
        nameInput.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        nameInput.setForeground(new java.awt.Color(153, 153, 153));
        nameInput.setText("Ingrese su nombre/s");
        nameInput.setBorder(null);
        nameInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nameInputMousePressed(evt);
            }
        });
        nameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputActionPerformed(evt);
            }
        });
        jPanel1.add(nameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 290, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 290, -1));

        nameText1.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        nameText1.setForeground(new java.awt.Color(0, 0, 0));
        nameText1.setText("Contraseña");
        jPanel1.add(nameText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 290, -1));

        passwordInput.setBackground(new java.awt.Color(255, 255, 255));
        passwordInput.setForeground(new java.awt.Color(153, 153, 153));
        passwordInput.setText("**********");
        passwordInput.setBorder(null);
        passwordInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passwordInputMousePressed(evt);
            }
        });
        passwordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordInputActionPerformed(evt);
            }
        });
        jPanel1.add(passwordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 376, 290, 20));

        loginBtn.setBackground(new java.awt.Color(13, 81, 103));
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
        });

        loginText.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        loginText.setForeground(new java.awt.Color(255, 255, 255));
        loginText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginText.setText("Entrar");

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginText, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginText, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 210, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseClicked
        String inputNombreUsuario = nameInput.getText();
        String inputPassword = passwordInput.getText();

        Connection connection = DBConnection.getInstance().dbConnection;
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro al crear statement, error: " + e.toString());
        }

        //VERIFICAR PASS
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id, 32, 64);

        if (statement != null) {
            try {
                String sqlString = "EXEC sp_set_session_context 'nombreUser', " + inputNombreUsuario + "; "
                        + "SELECT * FROM [PERSONAS_LOGIN_PERMISO]";
                var res = statement.executeQuery(sqlString);
                boolean correctPsw = false;
                boolean permiso = false;
                while (res.next()) {
                    boolean validPassword = argon2.verify(res.getString("hashpwd"), inputPassword.toCharArray());
                    if (validPassword) {
                        correctPsw = true;
                        boolean tienePermiso = res.getInt("rol_neg_id") == 1
                                && res.getInt("app_id") == 1
                                && res.getString("estado").equals("ACTIVO");
                        if (tienePermiso) {
                            permiso = true;
                            nameInput.setText("");
                            passwordInput.setText("");
                            UserAccount.UserAccount.getInstance().setUserId(res.getInt("user_id"));
                            this.setVisible(false);
                            Home.getInstance().setVisible(true);
                        }
                    }
                }
                if (!correctPsw) {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                }
                if (!permiso && correctPsw) {
                    JOptionPane.showMessageDialog(null, "Usuario no cuenta con los permisos requeridos");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al obtener user, error: " + e.toString());
            }
        }

    }//GEN-LAST:event_loginBtnMouseClicked

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputActionPerformed

    private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordInputActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_passwordInputActionPerformed

    private void nameInputMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameInputMousePressed
        if (nameInput.getText().equals("Ingrese su nombre/s")) {
            nameInput.setText("");
            nameInput.setForeground(Color.black);
        }
        if (String.valueOf(passwordInput.getText()).isEmpty()) {
            passwordInput.setText("**********");
            passwordInput.setForeground(Color.gray);
        }
    }//GEN-LAST:event_nameInputMousePressed

    private void passwordInputMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordInputMousePressed
        if (passwordInput.getText().equals("**********")) {
            passwordInput.setText("");
            passwordInput.setForeground(Color.black);
        }
        if (String.valueOf(nameInput.getText()).isEmpty()) {
            nameInput.setText("Ingrese su nombre/s");
            nameInput.setForeground(Color.gray);
        }
    }//GEN-LAST:event_passwordInputMousePressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel image;
    private javax.swing.JLabel iniciarSesionText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginText;
    private javax.swing.JTextField nameInput;
    private javax.swing.JLabel nameText;
    private javax.swing.JLabel nameText1;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
