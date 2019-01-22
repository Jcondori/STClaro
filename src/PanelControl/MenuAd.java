package PanelControl;

import Vistas.Login;
import Vistas.Cargo;
import Conexion.Test;
import Vistas.Empleado;
import Vistas.Equipo;
import Vistas.Imei;
import Vistas.Marcas;
import Vistas.Tiendas;
import Vistas.Usuarios;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MenuAd extends javax.swing.JFrame {

    

    public MenuAd() {
        initComponents();        
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("..\\Materiales\\LogoClaro.png")).getImage());
        BtnTest.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnSalir = new javax.swing.JButton();
        BtnUsuarios = new javax.swing.JButton();
        BtnTest = new javax.swing.JButton();
        BtnEquipo = new javax.swing.JButton();
        BtnImei = new javax.swing.JButton();
        BtnTiendas = new javax.swing.JButton();
        BtnCargo = new javax.swing.JButton();
        BtnEmpl = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BtnMarca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnSalir.setText("Cerrar Session");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        BtnUsuarios.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BtnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/usuarios.png"))); // NOI18N
        BtnUsuarios.setText("Usuarios");
        BtnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(BtnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 190, 70));

        BtnTest.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        BtnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/server.png"))); // NOI18N
        BtnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTestActionPerformed(evt);
            }
        });
        jPanel1.add(BtnTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 80));

        BtnEquipo.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BtnEquipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/smartphones.png"))); // NOI18N
        BtnEquipo.setText("Equipos");
        BtnEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEquipoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 170, 70));

        BtnImei.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BtnImei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/smartphoneImei.png"))); // NOI18N
        BtnImei.setText("Imei");
        BtnImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImeiActionPerformed(evt);
            }
        });
        jPanel1.add(BtnImei, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 150, 70));

        BtnTiendas.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BtnTiendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/store.png"))); // NOI18N
        BtnTiendas.setText("Tiendas");
        BtnTiendas.setBorder(null);
        BtnTiendas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTiendasActionPerformed(evt);
            }
        });
        jPanel1.add(BtnTiendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 180, 70));

        BtnCargo.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BtnCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/boss.png"))); // NOI18N
        BtnCargo.setText("Cargos");
        BtnCargo.setMargin(new java.awt.Insets(2, 14, 1, 14));
        BtnCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 190, 70));

        BtnEmpl.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BtnEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/network.png"))); // NOI18N
        BtnEmpl.setText("Empleados");
        BtnEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEmplActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/log.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        BtnMarca.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BtnMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/price-tag.png"))); // NOI18N
        BtnMarca.setText("Marca");
        BtnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(BtnMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 160, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/Fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTestActionPerformed
        Test test = new Test();
        test.testeo();
    }//GEN-LAST:event_BtnTestActionPerformed

    private void BtnEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEquipoActionPerformed
        Equipo equipos = new Equipo();
        equipos.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BtnEquipoActionPerformed

    private void BtnTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTiendasActionPerformed
        Tiendas tiendas = new Tiendas();
        tiendas.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BtnTiendasActionPerformed

    private void BtnImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnImeiActionPerformed
        Imei imei = new Imei();
        imei.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BtnImeiActionPerformed

    private void BtnCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargoActionPerformed
         Cargo cargo = new Cargo();
        cargo.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BtnCargoActionPerformed

    private void BtnEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEmplActionPerformed
        Empleado empleado = new Empleado();
        empleado.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BtnEmplActionPerformed

    private void BtnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMarcaActionPerformed
        Marcas marca = new Marcas();
        marca.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BtnMarcaActionPerformed

    private void BtnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUsuariosActionPerformed
       Usuarios usuarios = new Usuarios();
        usuarios.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BtnUsuariosActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        int jaja = JOptionPane.showConfirmDialog(null, "¿Cerrar Sesion?", "", JOptionPane.YES_NO_OPTION);
        if (jaja == JOptionPane.YES_OPTION) {
            Login login = new Login();
            login.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_BtnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCargo;
    private javax.swing.JButton BtnEmpl;
    private javax.swing.JButton BtnEquipo;
    private javax.swing.JButton BtnImei;
    private javax.swing.JButton BtnMarca;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JButton BtnTest;
    private javax.swing.JButton BtnTiendas;
    private javax.swing.JButton BtnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
