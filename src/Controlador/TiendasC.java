package Controlador;

import Vistas.Tiendas;
import Conexion.Conexion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TiendasC {

    DefaultTableModel modelo;
    PreparedStatement preparedStatement;

    Conexion conectar;

    Conexion cnx = new Conexion();
    Connection link = cnx.Conectar(); 
        
    public void CbxValorEst() {
        Tiendas.TxtEst.setText((String) Tiendas.CbxEst.getSelectedItem());
    }

    public void ValorCorrecEst() {
        try {
            Statement sent = link.createStatement();
            ResultSet rs = sent.executeQuery("SELECT * FROM Tiendas Where CodTie = '" + Tiendas.TxtCod.getText() + "'");
            rs.next();
            Tiendas.CbxEst.setSelectedItem(rs.getString("NombTie"));
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en metodo ValorCorrec");
        }
    }

    public void ListCbxEst() {
        Tiendas.CbxEst.addItem("A");
        Tiendas.CbxEst.addItem("N");
    }
    
    public void SLimitM(JTextField a, int z) {
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLowerCase(c)) {
                    String cad = ("" + c).toUpperCase();
                    c = cad.charAt(0);
                    e.setKeyChar(c);
                }
                if (a.getText().length() >= z) {
                    e.consume();
                }
            }
        }
        );
    }

    public void BlocSave(Boolean v) {
        Tiendas.BtnOtro.setEnabled(v);
        Tiendas.BtnEliminar.setEnabled(v);
        Tiendas.BtnEditar.setEnabled(v);
    }

    public void Nuevo() {
        Limpiar();
        Bloquear(true);
        Tiendas.BtnGuardar.setEnabled(true);
        Tiendas.BtnCancelar.setEnabled(true);
    }

    public void BlocInicio() {
        Tiendas.BtnGuardar.setEnabled(false);
        Tiendas.BtnActu.setEnabled(false);
        Tiendas.BtnCancelar.setEnabled(false);
    }

    public void Cancelar() {
        Limpiar();
        Bloquear(false);
        BlocInicio();
        BlocSave(true);
    }

    public void Limpiar() {
        Tiendas.TxtCod.setText(null);
        Tiendas.TxtNom.setText(null);
    }

    public void Bloquear(Boolean v) {
        Tiendas.TxtCod.setEnabled(v);
        Tiendas.TxtNom.setEnabled(v);
        Tiendas.TxtEst.setEnabled(v);
        Tiendas.CbxEst.setEnabled(v);
    }

    public void Busqueda() {
        String[] titulos = {"Codigo", "Nombre", "Estado"};
        String[] registros = new String[50];
        String sql = "select * from Tiendas where CodTie like'%" + Tiendas.TxtBuscar.getText() + "%'"
                + "or NombTie like '%" + Tiendas.TxtBuscar.getText() + "%'";
        modelo = new DefaultTableModel(null, titulos);
        try {
            Statement st = (Statement) link.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("CodTie");
                registros[1] = rs.getString("NombTie");
                registros[2] = rs.getString("EstTie");
                modelo.addRow(registros);
            }
            Tiendas.TblEvento.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Guardar() {
        String sql = "insert into Tiendas (CodTie,NombTie,EstTie) values (?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement psd = (com.mysql.jdbc.PreparedStatement) link.prepareStatement(sql);
            psd.setString(1, Tiendas.TxtCod.getText());
            psd.setString(2, Tiendas.TxtNom.getText());
            psd.setString(3, Tiendas.TxtEst.getText());
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                Limpiar();
                Bloquear(false);
                Busqueda();
                BlocInicio();
                BlocSave(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Codigo Existente");
            System.out.println(ex);
        }
    }

    public void Eliminar() {
        int fil = Tiendas.TblEvento.getSelectedRow();
        if (fil > -1) {
            int jaja = JOptionPane.showConfirmDialog(null, "Desea Eliminar este registro", "", JOptionPane.YES_NO_OPTION);
            if (jaja == JOptionPane.YES_OPTION) {
                int fila = Tiendas.TblEvento.getSelectedRow();
                String valor = Tiendas.TblEvento.getValueAt(fila, 0).toString();
                if (fila >= 0) {
                    try {
                        PreparedStatement pps = link.prepareStatement("delete from Tiendas where CodTie='" + valor + "'");
                        pps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Tiendas.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "El registro debe tener relacion con otro registro en otra tabla");
                        System.out.println(ex);
                    }
                }
            }
            Busqueda();
        }
    }

    public void Editar() {
        if (Tiendas.TblEvento.getSelectedRow() != -1) {
            int fila = Tiendas.TblEvento.getSelectedRow();
            Tiendas.TxtCod.setText(Tiendas.TblEvento.getValueAt(fila, 0).toString());
            Tiendas.TxtNom.setText(Tiendas.TblEvento.getValueAt(fila, 1).toString());
            Tiendas.TxtEst.setText(Tiendas.TblEvento.getValueAt(fila, 2).toString());
            Bloquear(true);
            Tiendas.TxtCod.setEnabled(false);
            Tiendas.BtnActu.setEnabled(true);
            Tiendas.BtnCancelar.setEnabled(true);
            Tiendas.BtnOtro.setEnabled(false);
            BlocSave(false);
            ValorCorrecEst();
        }
    }

    public void Actualizar() {
        try {
            PreparedStatement pst = link.prepareStatement("update Tiendas set NombTie='" + Tiendas.TxtNom.getText() + "',"
                    + "EstTie='" + Tiendas.TxtEst.getText() + "'"
                    + "where CodTie='" + Tiendas.TxtCod.getText() + "';");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Resgistro actualizado");
            Limpiar();
            Bloquear(false);
            Busqueda();
            BlocInicio();
            BlocSave(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
