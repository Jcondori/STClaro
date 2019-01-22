package Vistas;

import Controlador.LoginC;
import PanelControl.MenuAd;
import PanelControl.MenuVen;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    LoginC funcion = new LoginC();

    public static int cam = 0;

    public Login() {
        initComponents();        
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("..\\Materiales\\LogoClaro.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtUser = new javax.swing.JTextField();
        BtnAcceder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUserActionPerformed(evt);
            }
        });
        jPanel1.add(TxtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 112, -1));

        BtnAcceder.setBackground(new java.awt.Color(51, 255, 0));
        BtnAcceder.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BtnAcceder.setText("acceder");
        BtnAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAccederActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAcceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 120, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 40, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Password:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        TxtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(TxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 130, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/team.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 140, 150));

        jButton2.setText("X");
        jButton2.setBorder(null);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAccederActionPerformed
        try {
            funcion.BtnIngresar();
            switch (cam) {
                case 1:
                    MenuAd menua = new MenuAd();
                    menua.setVisible(true);
                    setVisible(false);
                    break;
                case 2:
                    MenuVen menuv = new MenuVen();
                    menuv.setVisible(true);
                    setVisible(false);
                    break;
                default:
                    break;
            }
            cam = 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error en Boton ingresar");
        }
    }//GEN-LAST:event_BtnAccederActionPerformed

    private void TxtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUserActionPerformed
        try {
            funcion.BtnIngresar();
            switch (cam) {
                case 1:
                    MenuAd menua = new MenuAd();
                    menua.setVisible(true);
                    setVisible(false);
                    break;
                case 2:
                    MenuVen menuv = new MenuVen();
                    menuv.setVisible(true);
                    setVisible(false);
                    break;
                default:
                    break;
            }
            cam = 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error en Boton ingresar");
        }
    }//GEN-LAST:event_TxtUserActionPerformed

    private void TxtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPasswordActionPerformed
        try {
            funcion.BtnIngresar();
            switch (cam) {
                case 1:
                    MenuAd menua = new MenuAd();
                    menua.setVisible(true);
                    setVisible(false);
                    break;
                case 2:
                    MenuVen menuv = new MenuVen();
                    menuv.setVisible(true);
                    setVisible(false);
                    break;
                default:
                    break;
            }
            cam = 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error en Boton ingresar");
        }
    }//GEN-LAST:event_TxtPasswordActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButton2MouseClicked

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAcceder;
    public static javax.swing.JPasswordField TxtPassword;
    public static javax.swing.JTextField TxtUser;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
