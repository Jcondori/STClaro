package Controlador;

import Conexion.Conexion;
import Vistas.Usuarios;
import java.awt.Color;
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

public class UsuariosC {

    DefaultTableModel modelo;
    PreparedStatement preparedStatement;

    Conexion conectar;

    Conexion cnx = new Conexion();
    Connection link = cnx.Conectar();

    public void SdR() {
        try {
            String a = "select * from Empleado where DNIEmpl like '" + Usuarios.TxtDNI.getText() + "%'";
            Statement sen = link.createStatement();
            ResultSet rs;
            rs = sen.executeQuery(a);
            rs.next();
            a = rs.getString("DNIEmpl");
            if (Usuarios.TxtDNI.getText().equals(a)) {
                Usuarios.TxtDNI.setBackground(Color.GREEN);
                Usuarios.LbSeg.setVisible(false);
            } else {
                Usuarios.TxtDNI.setBackground(Color.WHITE);
                Usuarios.LbSeg.setVisible(true);
            }
        } catch (SQLException e) {
        }
    }

    public void CbxValor() {
        Usuarios.TxtNivel.setText((String) Usuarios.CbxNivel.getSelectedItem());
    }

    public void ValorCorrec() {
        try {
            Statement sent = link.createStatement();
            ResultSet rs = sent.executeQuery("SELECT * FROM Usuarios Where CodUs = '" + Usuarios.TxtCodigo.getText() + "'");
            rs.next();
            Usuarios.CbxNivel.setSelectedItem(rs.getString("NivUs"));
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en metodo ValorCorrec");
        }
    }

    public void ListCbx() {
        Usuarios.CbxNivel.addItem("1");
        Usuarios.CbxNivel.addItem("2");
        Usuarios.CbxNivel.addItem("3");
    }

    public void SNumerosL(JTextField b, int h) {
        b.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (b.getText().length() >= h | Character.isLetter(c)) {
                    evt.consume();
                }
            }
        });
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

    public void SLimit(JTextField a, int z) {
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getText().length() >= z) {
                    e.consume();
                }
            }
        }
        );
    }

    public void BlocSave(Boolean v) {
        Usuarios.BtnOtro.setEnabled(v);
        Usuarios.BtnEliminar.setEnabled(v);
        Usuarios.BtnEditar.setEnabled(v);
        Usuarios.BtnEditar.setEnabled(v);
    }

    public void Nuevo() {
        Limpiar();
        Bloquear(true);
        Usuarios.BtnGuardar.setEnabled(true);
        Usuarios.BtnCancelar.setEnabled(true);
    }

    public void BlocInicio() {
        Usuarios.BtnGuardar.setEnabled(false);
        Usuarios.BtnActu.setEnabled(false);
        Usuarios.BtnCancelar.setEnabled(false);
    }

    public void Cancelar() {
        Limpiar();
        Bloquear(false);
        BlocInicio();
        BlocSave(true);
    }

    public void Limpiar() {
        Usuarios.TxtCodigo.setText(null);
        Usuarios.TxtNomb.setText(null);
        Usuarios.TxtContra.setText(null);
        Usuarios.TxtDNI.setText(null);
    }

    public void Bloquear(Boolean a) {
        Usuarios.TxtCodigo.setEnabled(a);
        Usuarios.TxtNomb.setEnabled(a);
        Usuarios.TxtContra.setEnabled(a);
        Usuarios.TxtNivel.setEnabled(a);
        Usuarios.TxtDNI.setEnabled(a);
        Usuarios.CbxNivel.setEnabled(a);
    }

    public void Busqueda() {
        String[] titulos = {"Codigo", "Nombre", "Password", "DNI", "Nivel"};
        String[] registros = new String[50];
        String sql = "select * from Usuarios where CodUs like'%" + Usuarios.TxtBuscar.getText() + "%'"
                + "or NomUs like '%" + Usuarios.TxtBuscar.getText() + "%'"
                + "or DNIEmpl like '%" + Usuarios.TxtBuscar.getText() + "%'"
                + "or NivUs like '%" + Usuarios.TxtBuscar.getText() + "%';";
        modelo = new DefaultTableModel(null, titulos);
        try {
            Statement st = (Statement) link.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("CodUs");
                registros[1] = rs.getString("NomUs");
                registros[2] = rs.getString("PasUs");
                registros[3] = rs.getString("DNIEmpl");
                registros[4] = rs.getString("NivUs");
                modelo.addRow(registros);
            }
            Usuarios.TblEvento.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Guardar() {
        String sql = "insert into Usuarios (CodUs,NomUs,PasUs,DNIEmpl,NivUs) values (?,?,?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement psd = (com.mysql.jdbc.PreparedStatement) link.prepareStatement(sql);
            psd.setString(1, Usuarios.TxtCodigo.getText());
            psd.setString(2, Usuarios.TxtNomb.getText());
            psd.setString(3, Usuarios.TxtContra.getText());
            psd.setString(4, Usuarios.TxtDNI.getText());
            psd.setString(5, Usuarios.TxtNivel.getText());

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
        int fil = Usuarios.TblEvento.getSelectedRow();
        if (fil > -1) {
            int jaja = JOptionPane.showConfirmDialog(null, "Desea Eliminar este registro", "", JOptionPane.YES_NO_OPTION);
            if (jaja == JOptionPane.YES_OPTION) {
                int fila = Usuarios.TblEvento.getSelectedRow();
                String valor = Usuarios.TblEvento.getValueAt(fila, 0).toString();
                if (fila >= 0) {
                    try {
                        PreparedStatement pps = link.prepareStatement("delete from Usuarios where CodUs='" + valor + "'");
                        pps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "El registro debe tener relacion con otro registro en otra tabla");
                        System.out.println(ex);
                    }
                }
            }
            Busqueda();
        }
    }

    public void Editar() {
        if (Usuarios.TblEvento.getSelectedRow() != -1) {
            int fila = Usuarios.TblEvento.getSelectedRow();
            Usuarios.TxtCodigo.setText(Usuarios.TblEvento.getValueAt(fila, 0).toString());
            Usuarios.TxtNomb.setText(Usuarios.TblEvento.getValueAt(fila, 1).toString());
            Usuarios.TxtContra.setText(Usuarios.TblEvento.getValueAt(fila, 2).toString());
            Usuarios.TxtDNI.setText(Usuarios.TblEvento.getValueAt(fila, 3).toString());
            Usuarios.TxtNivel.setText(Usuarios.TblEvento.getValueAt(fila, 4).toString());
            Bloquear(true);
            Usuarios.TxtCodigo.setEnabled(false);
            Usuarios.BtnActu.setEnabled(true);
            Usuarios.BtnCancelar.setEnabled(true);
            BlocSave(false);
            ValorCorrec();
        }
    }

    public void Actualizar() {
        try {
            PreparedStatement pst = link.prepareStatement("update Usuarios set NomUs='" + Usuarios.TxtNomb.getText() + "',"
                    + "PasUs='" + Usuarios.TxtContra.getText() + "',"
                    + "DNIEmpl='" + Usuarios.TxtDNI.getText() + "',"
                    + "NivUs='" + Usuarios.TxtNivel.getText() + "'"
                    + "where CodUs='" + Usuarios.TxtCodigo.getText() + "';");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Resgistro actualizado");
            Limpiar();
            Bloquear(false);
            Busqueda();
            BlocInicio();
            BlocSave(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "uno de los codigos no exite");
            System.out.println(e);
        }
    }
}
