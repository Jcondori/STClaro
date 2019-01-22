package Vistas;

import Controlador.EmpleadoC;
import PanelControl.MenuAd;
import javax.swing.ImageIcon;

public class Empleado extends javax.swing.JFrame {

    EmpleadoC funcion = new EmpleadoC();

    public Empleado() {
        initComponents();
        setLocationRelativeTo(null);
//        this.setIconImage(new ImageIcon(getClass().getResource("..\\Materiales\\LogoClaro.png")).getImage());
//        funcion.ListCbx(CbxCargo,"Cargos", "NomCar");
//        funcion.ListCbx(CbxTienda, "Tiendas", "NombTie");
//        funcion.ListCbxEst();
//        funcion.Busqueda();
        funcion.Bloquear(false);
        funcion.BlocInicio();
        funcion.SNumerosL(TxtDNI, 8);
        funcion.SLetrasL(TxtNom, 30);
        funcion.SNumerosL(TxtTel, 9);
        funcion.SLetrasL(TxtApe, 50);
        funcion.SLetrasM(TxtEst, 1);
        TxtCar.setVisible(false);
        TxtTie.setVisible(false);
        TxtEst.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        TxtDNI = new javax.swing.JTextField();
        TxtNom = new javax.swing.JTextField();
        TxtApe = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();
        BtnOtro = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BtnActu = new javax.swing.JButton();
        TxtTel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtCar = new javax.swing.JTextField();
        TxtEst = new javax.swing.JTextField();
        TxtTie = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CbxCargo = new javax.swing.JComboBox<>();
        CbxTienda = new javax.swing.JComboBox<>();
        CbxEst = new javax.swing.JComboBox<>();
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
        TxtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDNIKeyTyped(evt);
            }
        });
        jPanel2.add(TxtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 30));

        TxtNom.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxtNomCaretUpdate(evt);
            }
        });
        TxtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNomActionPerformed(evt);
            }
        });
        TxtNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtNomKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtNomKeyReleased(evt);
            }
        });
        jPanel2.add(TxtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 120, -1));

        TxtApe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtApeActionPerformed(evt);
            }
        });
        jPanel2.add(TxtApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 122, -1));

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        BtnOtro.setText("Nuevo");
        BtnOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOtroActionPerformed(evt);
            }
        });
        jPanel2.add(BtnOtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        jLabel2.setText("DNI");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel3.setText("Nombre");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        jLabel4.setText("Apellido");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        BtnActu.setText("Guardar Actualizacion");
        BtnActu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnActu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActuActionPerformed(evt);
            }
        });
        jPanel2.add(BtnActu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 150, -1));

        TxtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTelActionPerformed(evt);
            }
        });
        jPanel2.add(TxtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 122, -1));

        jLabel5.setText("Telefono");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        TxtCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCarActionPerformed(evt);
            }
        });
        jPanel2.add(TxtCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 50, -1));

        TxtEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtEstActionPerformed(evt);
            }
        });
        jPanel2.add(TxtEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 40, -1));

        TxtTie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTieActionPerformed(evt);
            }
        });
        jPanel2.add(TxtTie, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 60, -1));

        jLabel6.setText("Cargo");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel7.setText("Estado");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        jLabel8.setText("Tienda");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        CbxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxCargoActionPerformed(evt);
            }
        });
        jPanel2.add(CbxCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, -1));

        CbxTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxTiendaActionPerformed(evt);
            }
        });
        jPanel2.add(CbxTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 140, -1));

        CbxEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxEstActionPerformed(evt);
            }
        });
        jPanel2.add(CbxEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 80, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 560, 210));

        TblEvento = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TblEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Apellido", "Telefono", "Cargo", "Tienda", "Estado"
            }
        ));
        TblEvento.getTableHeader().setReorderingAllowed(false);
        TblEvento.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                TblEventoComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(TblEvento);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 790, 110));

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        TxtBuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxtBuscarCaretUpdate(evt);
            }
        });
        jPanel1.add(TxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, -1));

        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/Menu.png"))); // NOI18N
        BtnSalir.setBorder(null);
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 58, 51));

        BtnEditar.setText("Editar");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 70, -1));

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        jLabel1.setText("EMPLEADOS");
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDNIActionPerformed
        TxtDNI.transferFocus();
    }//GEN-LAST:event_TxtDNIActionPerformed

    private void TxtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNomActionPerformed
        TxtNom.transferFocus();
    }//GEN-LAST:event_TxtNomActionPerformed

    private void TxtApeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtApeActionPerformed
        TxtApe.transferFocus();
    }//GEN-LAST:event_TxtApeActionPerformed

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

    private void TxtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTelActionPerformed

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

    private void TxtCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCarActionPerformed

    private void TxtEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtEstActionPerformed

    private void TxtTieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTieActionPerformed

    private void TxtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDNIKeyTyped

    }//GEN-LAST:event_TxtDNIKeyTyped

    private void TxtDNICaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TxtDNICaretUpdate

    }//GEN-LAST:event_TxtDNICaretUpdate

    private void TxtNomCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TxtNomCaretUpdate
        
    }//GEN-LAST:event_TxtNomCaretUpdate

    private void TxtNomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNomKeyReleased

    }//GEN-LAST:event_TxtNomKeyReleased

    private void TxtNomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNomKeyPressed
        
    }//GEN-LAST:event_TxtNomKeyPressed

    private void CbxCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxCargoActionPerformed
        funcion.CbxValor(CbxCargo, "Cargos", "NomCar", "CodCar", TxtCar);
    }//GEN-LAST:event_CbxCargoActionPerformed

    private void CbxTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxTiendaActionPerformed
        funcion.CbxValor(CbxTienda, "Tiendas", "NombTie", "CodTie", TxtTie);
    }//GEN-LAST:event_CbxTiendaActionPerformed

    private void CbxEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxEstActionPerformed
        funcion.CbxValorEst();
    }//GEN-LAST:event_CbxEstActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Empleado().setVisible(true);
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
    public static javax.swing.JComboBox<String> CbxCargo;
    public static javax.swing.JComboBox<String> CbxEst;
    public static javax.swing.JComboBox<String> CbxTienda;
    public static javax.swing.JTable TblEvento;
    public static javax.swing.JTextField TxtApe;
    public static javax.swing.JTextField TxtBuscar;
    public static javax.swing.JTextField TxtCar;
    public static javax.swing.JTextField TxtDNI;
    public static javax.swing.JTextField TxtEst;
    public static javax.swing.JTextField TxtNom;
    public static javax.swing.JTextField TxtTel;
    public static javax.swing.JTextField TxtTie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
