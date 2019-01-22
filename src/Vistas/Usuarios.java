package Vistas;

import Controlador.UsuariosC;
import PanelControl.MenuAd;
import javax.swing.ImageIcon;

public class Usuarios extends javax.swing.JFrame {

    UsuariosC funcion = new UsuariosC();

    public Usuarios() {
        initComponents();
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("..\\Materiales\\LogoClaro.png")).getImage());
        funcion.ListCbx();
        funcion.Busqueda();
        funcion.Bloquear(false);
        funcion.BlocInicio();
        funcion.SLimitM(TxtCodigo, 3);
        funcion.SLimit(TxtNomb, 10);
        funcion.SLimit(TxtContra, 15);
        funcion.SNumerosL(TxtDNI, 8);
        funcion.SNumerosL(TxtNivel, 1);
        TxtNivel.setVisible(false);
        LbSeg.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        TxtCodigo = new javax.swing.JTextField();
        TxtNomb = new javax.swing.JTextField();
        TxtContra = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();
        BtnOtro = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        hik = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BtnActu = new javax.swing.JButton();
        TxtNivel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtDNI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CbxNivel = new javax.swing.JComboBox<>();
        LbSeg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblEvento = new javax.swing.JTable();
        BtnBuscar = new javax.swing.JButton();
        TxtBuscar = new javax.swing.JTextField();
        BtnSalir = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Modificaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCodigoActionPerformed(evt);
            }
        });
        jPanel2.add(TxtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 30));

        TxtNomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombActionPerformed(evt);
            }
        });
        jPanel2.add(TxtNomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 120, -1));

        TxtContra.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxtContraCaretUpdate(evt);
            }
        });
        TxtContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtContraActionPerformed(evt);
            }
        });
        jPanel2.add(TxtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 122, -1));

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        BtnOtro.setText("Nuevo");
        BtnOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOtroActionPerformed(evt);
            }
        });
        jPanel2.add(BtnOtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        hik.setText("Codigo");
        jPanel2.add(hik, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel.setText("Nombre");
        jPanel2.add(jLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        jLabel4.setText("Contraseña");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        BtnActu.setText("Guardar Actualizacion");
        BtnActu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnActu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActuActionPerformed(evt);
            }
        });
        jPanel2.add(BtnActu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 150, -1));

        TxtNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNivelActionPerformed(evt);
            }
        });
        jPanel2.add(TxtNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 30, -1));

        jLabel5.setText("Nivel");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, -1));

        TxtDNI.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxtDNICaretUpdate(evt);
            }
        });
        TxtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDNIActionPerformed(evt);
            }
        });
        jPanel2.add(TxtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 122, -1));

        jLabel6.setText("DNI");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        CbxNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxNivelActionPerformed(evt);
            }
        });
        jPanel2.add(CbxNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 90, -1));

        LbSeg.setText("No existe");
        jPanel2.add(LbSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 84, 60, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 750, 160));

        TblEvento = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TblEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Password", "DNI", "Nivel"
            }
        ));
        TblEvento.getTableHeader().setReorderingAllowed(false);
        TblEvento.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                TblEventoComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(TblEvento);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 790, 110));

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        TxtBuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxtBuscarCaretUpdate(evt);
            }
        });
        jPanel1.add(TxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 110, -1));

        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/Menu.png"))); // NOI18N
        BtnSalir.setBorder(null);
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 58, 51));

        BtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/edit32.png"))); // NOI18N
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 50, -1));

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        jLabel1.setText("USUARIOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 320, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodigoActionPerformed
        TxtCodigo.transferFocus();
    }//GEN-LAST:event_TxtCodigoActionPerformed

    private void TxtNombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombActionPerformed
        TxtNomb.transferFocus();
    }//GEN-LAST:event_TxtNombActionPerformed

    private void TxtContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtContraActionPerformed
        TxtContra.transferFocus();
    }//GEN-LAST:event_TxtContraActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        funcion.Guardar();
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOtroActionPerformed
        funcion.Nuevo();
        funcion.BlocSave(false);
    }//GEN-LAST:event_BtnOtroActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        funcion.Cancelar();

    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnActuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActuActionPerformed
        funcion.Actualizar();
    }//GEN-LAST:event_BtnActuActionPerformed

    private void TxtNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNivelActionPerformed

    private void TblEventoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_TblEventoComponentAdded

    }//GEN-LAST:event_TblEventoComponentAdded

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        funcion.Busqueda();
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void TxtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TxtBuscarCaretUpdate
        funcion.Busqueda();
    }//GEN-LAST:event_TxtBuscarCaretUpdate

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        MenuAd menu = new MenuAd();
        menu.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        funcion.Editar();
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        funcion.Eliminar();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void TxtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDNIActionPerformed

    private void CbxNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxNivelActionPerformed
        funcion.CbxValor();
    }//GEN-LAST:event_CbxNivelActionPerformed

    private void TxtContraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TxtContraCaretUpdate

    }//GEN-LAST:event_TxtContraCaretUpdate

    private void TxtDNICaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TxtDNICaretUpdate
        funcion.SdR();
    }//GEN-LAST:event_TxtDNICaretUpdate

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BtnActu;
    public static javax.swing.JButton BtnBuscar;
    public static javax.swing.JButton BtnCancelar;
    public static javax.swing.JButton BtnEditar;
    public static javax.swing.JButton BtnEliminar;
    public static javax.swing.JButton BtnGuardar;
    public static javax.swing.JButton BtnOtro;
    private javax.swing.JButton BtnSalir;
    public static javax.swing.JComboBox<String> CbxNivel;
    public static javax.swing.JLabel LbSeg;
    public static javax.swing.JTable TblEvento;
    public static javax.swing.JTextField TxtBuscar;
    public static javax.swing.JTextField TxtCodigo;
    public static javax.swing.JTextField TxtContra;
    public static javax.swing.JTextField TxtDNI;
    public static javax.swing.JTextField TxtNivel;
    public static javax.swing.JTextField TxtNomb;
    private javax.swing.JLabel hik;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
