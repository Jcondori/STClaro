package Controlador;

import Vistas.Equipo;
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

public class EquipoC {

    DefaultTableModel modelo;
    PreparedStatement preparedStatement;

    Conexion conectar;

    Conexion cnx = new Conexion();
    Connection link = cnx.Conectar();

    public void CbxValor() {
        try {
            Statement sent = link.createStatement();
            ResultSet rs = sent.executeQuery("SELECT * FROM Marcas WHERE NombMar = '" + Equipo.CbxMar.getSelectedItem() + "'");
            rs.next();
            Equipo.TxtCodMar.setText(rs.getString("CodMar"));
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en metodo CbxValor");
        }
    }

    public void ValorCorrec() {
        Equipo.CbxMar.setSelectedItem(Equipo.TxtCodMar.getText());
    }

    public void ListCbx() {
        try {
            Statement sent = link.createStatement();
            ResultSet rs = sent.executeQuery("SELECT * FROM Marcas");
            while (rs.next()) {
                Equipo.CbxMar.addItem(rs.getString("NombMar"));
            }
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en metodo ListCbx");
        }
    }

    public void SLetrasL(JTextField a, int z) {
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (a.getText().length() >= z | Character.isDigit(c)) {
                    e.consume();
                }
            }
        }
        );
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
        Equipo.BtnOtro.setEnabled(v);
        Equipo.BtnEliminar.setEnabled(v);
        Equipo.BtnEditar.setEnabled(v);
    }

    public void Nuevo() {
        Limpiar();
        Bloquear(true);
        Equipo.BtnGuardar.setEnabled(true);
        Equipo.BtnCancelar.setEnabled(true);
        BlocSave(false);
    }

    public void BlocInicio() {
        Equipo.BtnGuardar.setEnabled(false);
        Equipo.BtnActu.setEnabled(false);
        Equipo.BtnCancelar.setEnabled(false);
    }

    public void Cancelar() {
        Limpiar();
        Bloquear(false);
        BlocInicio();
        BlocSave(true);
    }

    public void Limpiar() {
        Equipo.TxtCod.setText(null);
        Equipo.TxtMod.setText(null);
        Equipo.TxtColor.setText(null);
    }

    public void Bloquear(Boolean a) {
        Equipo.TxtCod.setEnabled(a);
        Equipo.TxtCodMar.setEnabled(a);
        Equipo.TxtMod.setEnabled(a);
        Equipo.TxtColor.setEnabled(a);
        Equipo.CbxMar.setEnabled(a);
    }

    public void Busqueda() {
        String[] titulos = {"Codigo", "Codigo Marca", "Modelo", "Color"};
        String[] registros = new String[50];
        String sql = "Select Equipo.CodEq,Marcas.NombMar,Equipo.ModelEq,Equipo.ColorEq "
                + "From Equipo INNER JOIN Marcas ON Equipo.CodMar = Marcas.CodMar"
                + " Where Equipo.CodEq like'%" + Equipo.TxtBuscar.getText() + "%'"
                + "or Marcas.NombMar like '%" + Equipo.TxtBuscar.getText() + "%'"
                + "or Equipo.ModelEq like '%" + Equipo.TxtBuscar.getText() + "%';";
        modelo = new DefaultTableModel(null, titulos);
        try {
            Statement st = (Statement) link.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("Equipo.CodEq");
                registros[1] = rs.getString("Marcas.NombMar");
                registros[2] = rs.getString("Equipo.ModelEq");
                registros[3] = rs.getString("Equipo.ColorEq");
                modelo.addRow(registros);
            }
            Equipo.TblEvento.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Guardar() {
        String sql = "insert into Equipo (CodEq,CodMar,ModelEq,ColorEq) values (?,?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement psd = (com.mysql.jdbc.PreparedStatement) link.prepareStatement(sql);
            psd.setString(1, Equipo.TxtCod.getText());
            psd.setString(2, Equipo.TxtCodMar.getText());
            psd.setString(3, Equipo.TxtMod.getText());
            psd.setString(4, Equipo.TxtColor.getText());
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                Limpiar();
                 
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
        int fil = Equipo.TblEvento.getSelectedRow();
        if (fil > -1) {
            int jaja = JOptionPane.showConfirmDialog(null, "Desea Eliminar este registro", "", JOptionPane.YES_NO_OPTION);
            if (jaja == JOptionPane.YES_OPTION) {
                int fila = Equipo.TblEvento.getSelectedRow();
                String valor = Equipo.TblEvento.getValueAt(fila, 0).toString();
                if (fila >= 0) {
                    try {
                        PreparedStatement pps = link.prepareStatement("delete from Equipo where CodEq='" + valor + "'");
                        pps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "El registro debe tener relacion con otro registro en otra tabla");
                        System.out.println(ex);
                    }
                }
            }
            Busqueda();
        }
    }

    public void Editar() {
        if (Equipo.TblEvento.getSelectedRow() != -1) {
            int fila = Equipo.TblEvento.getSelectedRow();
            Equipo.TxtCod.setText(Equipo.TblEvento.getValueAt(fila, 0).toString());
            Equipo.TxtCodMar.setText(Equipo.TblEvento.getValueAt(fila, 1).toString());
            Equipo.TxtMod.setText(Equipo.TblEvento.getValueAt(fila, 2).toString());
            Equipo.TxtColor.setText(Equipo.TblEvento.getValueAt(fila, 3).toString());
            Bloquear(true);
            BlocSave(false);
            Equipo.TxtCod.setEnabled(false);
            Equipo.BtnActu.setEnabled(true);
            Equipo.BtnCancelar.setEnabled(true);
            ValorCorrec();
        }
    }

    public void Actualizar() {
        try {
            PreparedStatement pst = link.prepareStatement("update Equipo set CodMar='" + Equipo.TxtCodMar.getText() + "',"
                    + "ModelEq='" + Equipo.TxtMod.getText() + "',"
                    + "ColorEq='" + Equipo.TxtColor.getText() + "'"
                    + "where CodEq='" + Equipo.TxtCod.getText() + "';");
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
