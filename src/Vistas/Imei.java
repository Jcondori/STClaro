package Vistas;

import Controlador.ImeiC;
import PanelControl.MenuAd;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Imei extends javax.swing.JFrame {

    ImeiC funcion = new ImeiC();
    private final FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel", "xls");

    public Imei() {
        initComponents();
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("..\\Materiales\\LogoClaro.png")).getImage());
        Imei.LbSegur.setVisible(false);
        funcion.Busqueda();
        funcion.Bloquear(false);
        funcion.BlocInicio();
        funcion.SNumerosL(TxtCodImei, 15);
        funcion.SNumerosL(TxtFecIng, 10);
        funcion.SLimitM(TxtCodEq, 8);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        TxtCodImei = new javax.swing.JTextField();
        TxtCodEq = new javax.swing.JTextField();
        TxtFecIng = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();
        BtnOtro = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BtnActu = new javax.swing.JButton();
        BtnImEx = new javax.swing.JButton();
        LbSegur = new javax.swing.JLabel();
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

        TxtCodImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCodImeiActionPerformed(evt);
            }
        });
        jPanel2.add(TxtCodImei, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 30));

        TxtCodEq.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxtCodEqCaretUpdate(evt);
            }
        });
        TxtCodEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCodEqActionPerformed(evt);
            }
        });
        jPanel2.add(TxtCodEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 120, 30));

        TxtFecIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFecIngActionPerformed(evt);
            }
        });
        jPanel2.add(TxtFecIng, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 122, -1));

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        BtnOtro.setText("Nuevo");
        BtnOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOtroActionPerformed(evt);
            }
        });
        jPanel2.add(BtnOtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jLabel2.setText("Codigo Imei");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel3.setText("Codigo Equipo");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        jLabel4.setText("Fecha de Ingreso");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        BtnActu.setText("Guardar Actualizacion");
        BtnActu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnActu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActuActionPerformed(evt);
            }
        });
        jPanel2.add(BtnActu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 150, -1));

        BtnImEx.setText("Importar Excel");
        BtnImEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImExActionPerformed(evt);
            }
        });
        jPanel2.add(BtnImEx, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        LbSegur.setText("No existe");
        jPanel2.add(LbSegur, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 620, 160));

        TblEvento = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TblEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Imei", "Equipo", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblEvento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TblEvento.setFocusable(false);
        TblEvento.getTableHeader().setReorderingAllowed(false);
        TblEvento.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TblEventoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(TblEvento);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 673, 110));

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        TxtBuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxtBuscarCaretUpdate(evt);
            }
        });
        jPanel1.add(TxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, -1));

        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materiales/Menu.png"))); // NOI18N
        BtnSalir.setBorder(null);
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 58, 51));

        BtnEditar.setText("Editar");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, -1, -1));

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        jLabel1.setText("IMEI");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 150, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtCodImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodImeiActionPerformed
        TxtCodImei.transferFocus();
    }//GEN-LAST:event_TxtCodImeiActionPerformed

    private void TxtCodEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodEqActionPerformed
        TxtCodEq.transferFocus();
    }//GEN-LAST:event_TxtCodEqActionPerformed

    private void TxtFecIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFecIngActionPerformed
        TxtFecIng.transferFocus();
    }//GEN-LAST:event_TxtFecIngActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        funcion.Guardar();
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOtroActionPerformed
        funcion.Nuevo();
    }//GEN-LAST:event_BtnOtroActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        funcion.Cancelar();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnActuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActuActionPerformed
        funcion.Actualizar();
    }//GEN-LAST:event_BtnActuActionPerformed

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

    private void BtnImExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnImExActionPerformed
        funcion.Importar();
    }//GEN-LAST:event_BtnImExActionPerformed

    private void TblEventoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TblEventoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_TblEventoAncestorAdded

    private void TxtCodEqCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TxtCodEqCaretUpdate
        funcion.SdR();
    }//GEN-LAST:event_TxtCodEqCaretUpdate

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
            java.util.logging.Logger.getLogger(Imei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Imei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Imei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Imei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Imei().setVisible(true);
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
    private javax.swing.JButton BtnImEx;
    public static javax.swing.JButton BtnOtro;
    private javax.swing.JButton BtnSalir;
    public static javax.swing.JLabel LbSegur;
    public static javax.swing.JTable TblEvento;
    public static javax.swing.JTextField TxtBuscar;
    public static javax.swing.JTextField TxtCodEq;
    public static javax.swing.JTextField TxtCodImei;
    public static javax.swing.JTextField TxtFecIng;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
