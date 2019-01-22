package Controlador;

import Vistas.Marcas;
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

public class FuncionesMar {

    DefaultTableModel modelo;
    PreparedStatement preparedStatement;

    Conexion conectar;

    Conexion cnx = new Conexion();
    Connection link = cnx.Conectar();
    
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

    public void Nuevo() {
        Limpiar();
        Desbloquear();
        Marcas.BtnGuardar.setEnabled(true);
        Marcas.BtnCancelar.setEnabled(true);
    }

    public void BlocInicio() {
        Marcas.BtnGuardar.setEnabled(false);
        Marcas.BtnActu.setEnabled(false);
        Marcas.BtnCancelar.setEnabled(false);
    }

    public void Cancelar() {
        Limpiar();
        Bloquear();
        BlocInicio();
        Marcas.BtnOtro.setEnabled(true);
    }

    public void Limpiar() {
        Marcas.TxtCod.setText(null);
        Marcas.TxtNom.setText(null);
    }

    public void Bloquear() {
        Marcas.TxtCod.setEnabled(false);
        Marcas.TxtNom.setEnabled(false);
    }

    public void Desbloquear() {
        Marcas.TxtCod.setEnabled(true);
        Marcas.TxtNom.setEnabled(true);
    }

    public void Busqueda() {
        String[] titulos = {"Codigo", "Marca"};
        String[] registros = new String[50];
        String sql = "select * from Marcas where CodMar like'%" + Marcas.TxtBuscar.getText() + "%'"
                + "or NombMar like '%" + Marcas.TxtBuscar.getText() + "%'";
        modelo = new DefaultTableModel(null, titulos);
        try {
            Statement st = (Statement) link.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("CodMar");
                registros[1] = rs.getString("NombMar");
                modelo.addRow(registros);
            }
            Marcas.TblEvento.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Guardar() {
        String sql = "insert into Marcas (CodMar,NombMar) values (?,?)";
        try {
            com.mysql.jdbc.PreparedStatement psd = (com.mysql.jdbc.PreparedStatement) link.prepareStatement(sql);
            psd.setString(1, Marcas.TxtCod.getText());
            psd.setString(2, Marcas.TxtNom.getText());
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                Limpiar();
                Bloquear();
                Busqueda();
                BlocInicio();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Codigo Existente");
            System.out.println(ex);
        }
    }

    public void Eliminar() {
        int fil = Marcas.TblEvento.getSelectedRow();
        if (fil > -1) {
            int jaja = JOptionPane.showConfirmDialog(null, "Desea Eliminar este registro", "", JOptionPane.YES_NO_OPTION);
            if (jaja == JOptionPane.YES_OPTION) {
                int fila = Marcas.TblEvento.getSelectedRow();
                String valor = Marcas.TblEvento.getValueAt(fila, 0).toString();
                if (fila >= 0) {
                    try {
                        PreparedStatement pps = link.prepareStatement("delete from Marcas where CodMar='" + valor + "'");
                        pps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "El registro debe tener relacion con otro registro en otra tabla");
                        System.out.println(ex);
                    }
                }
            }
            Busqueda();
        }
    }

    public void Editar() {
        if (Marcas.TblEvento.getSelectedRow() != -1) {
            int fila = Marcas.TblEvento.getSelectedRow();
            Marcas.TxtCod.setText(Marcas.TblEvento.getValueAt(fila, 0).toString());
            Marcas.TxtNom.setText(Marcas.TblEvento.getValueAt(fila, 1).toString());
            Desbloquear();
            Marcas.TxtCod.setEnabled(false);
            Marcas.BtnActu.setEnabled(true);
            Marcas.BtnCancelar.setEnabled(true);
            Marcas.BtnOtro.setEnabled(false);
        }
    }

    public void Actualizar() {
        try {
            PreparedStatement pst = link.prepareStatement("update Marcas set NombMar='" + Marcas.TxtNom.getText() + "'"
                    + "where CodMar='" + Marcas.TxtCod.getText() + "';");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Resgistro actualizado");
            Limpiar();
            Bloquear();
            Busqueda();
            BlocInicio();
            Marcas.BtnOtro.setEnabled(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
