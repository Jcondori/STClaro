package Controlador;

import Vistas.Empleado;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EmpleadoC {

    DefaultTableModel modelo;
    PreparedStatement preparedStatement;

    Conexion conectar;

    Conexion cnx = new Conexion();
    Connection link = cnx.Conectar();

    public void CbxValorEst() {
        Empleado.TxtEst.setText((String) Empleado.CbxEst.getSelectedItem());
    }

    public void ValorCorrecEst() {
        try {
            Statement sent = link.createStatement();
            ResultSet rs = sent.executeQuery("SELECT * FROM Empleado Where DNIEmpl = '" + Empleado.TxtDNI.getText() + "'");
            rs.next();
            Empleado.CbxEst.setSelectedItem(rs.getString("EstEmpl"));
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en metodo ValorCorrecEst");
        }
    }

    public void ListCbxEst() {
        Empleado.CbxEst.addItem("A");
        Empleado.CbxEst.addItem("D");
    }

    public void CbxValor(JComboBox h, String tabla, String CamCbx, String txt, JTextField a) {
        try {
            Statement sent = link.createStatement();
            ResultSet rs = sent.executeQuery("SELECT * FROM " + tabla + " WHERE " + CamCbx + " = '" + h.getSelectedItem() + "'");
            rs.next();
            a.setText(rs.getString(txt));
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en metodo CbxValor");
        }
    }

    public void ValorCorrec(JComboBox h, JTextField a) {
        h.setSelectedItem(a.getText());
    }

    public void ListCbx(JComboBox h, String tabla, String campo) {
        try {
            String estado = "";
            if ("Tiendas".equals(tabla)) {
                estado = " Where EstTie like 'A'";
            }
            Statement sent = link.createStatement();
            ResultSet rs = sent.executeQuery("SELECT * FROM " + tabla + estado);
            while (rs.next()) {
                h.addItem(rs.getString(campo));
            }
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en metodo ListCbx");
        }
    }

    public void SLetrasM(JTextField a, int z) {
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLowerCase(c)) {
                    String cad = ("" + c).toUpperCase();
                    c = cad.charAt(0);
                    e.setKeyChar(c);
                }
                if (a.getText().length() >= z | Character.isDigit(c)) {
                    e.consume();
                }
            }
        }
        );
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

    public void BlocSave(Boolean v) {
        Empleado.BtnOtro.setEnabled(v);
        Empleado.BtnEliminar.setEnabled(v);
        Empleado.BtnEditar.setEnabled(v);
    }

    public void Nuevo() {
        Limpiar();
        Bloquear(true);
        Empleado.BtnGuardar.setEnabled(true);
        Empleado.BtnCancelar.setEnabled(true);
    }

    public void BlocInicio() {
        Empleado.BtnGuardar.setEnabled(false);
        Empleado.BtnActu.setEnabled(false);
        Empleado.BtnCancelar.setEnabled(false);
    }

    public void Cancelar() {
        Limpiar();
        Bloquear(false);
        BlocInicio();
        BlocSave(true);
    }

    public void Limpiar() {
        Empleado.TxtDNI.setText(null);
        Empleado.TxtNom.setText(null);
        Empleado.TxtApe.setText(null);
        Empleado.TxtTel.setText(null);
    }

    public void Bloquear(Boolean a) {
        Empleado.TxtDNI.setEnabled(a);
        Empleado.TxtNom.setEnabled(a);
        Empleado.TxtApe.setEnabled(a);
        Empleado.TxtTel.setEnabled(a);
        Empleado.TxtCar.setEnabled(a);
        Empleado.TxtTie.setEnabled(a);
        Empleado.TxtEst.setEnabled(a);
        Empleado.CbxCargo.setEnabled(a);
        Empleado.CbxTienda.setEnabled(a);
        Empleado.CbxEst.setEnabled(a);
    }

    public void Busqueda() {
        String[] titulos = {"DNI", "Nombre", "Apelido", "Telefono", "Cargo", "Tienda", "Estado"};
        String[] registros = new String[50];
        String sql = "select Empleado.DNIEmpl,Empleado.NombEmpl,Empleado.ApellEmpl,Empleado.TelefEmpl,Cargos.NomCar,Tiendas.NombTie,Empleado.EstEmpl"
                + " From Empleado INNER JOIN Cargos INNER JOIN Tiendas ON Empleado.CodCar = Cargos.Codcar AND Empleado.CodTie = Tiendas.CodTie"
                + " where Empleado.DNIEmpl like'%" + Empleado.TxtBuscar.getText() + "%'"
                + "or Empleado.NombEmpl like '%" + Empleado.TxtBuscar.getText() + "%'"
                + "or Empleado.ApellEmpl like '%" + Empleado.TxtBuscar.getText() + "%';";
        modelo = new DefaultTableModel(null, titulos);
        try {
            Statement st = (Statement) link.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("Empleado.DNIEmpl");
                registros[1] = rs.getString("Empleado.NombEmpl");
                registros[2] = rs.getString("Empleado.ApellEmpl");
                registros[3] = rs.getString("Empleado.TelefEmpl");
                registros[4] = rs.getString("Cargos.NomCar");
                registros[5] = rs.getString("Tiendas.NombTie");
                registros[6] = rs.getString("Empleado.EstEmpl");
                modelo.addRow(registros);
            }
            Empleado.TblEvento.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Guardar() {
        String sql = "insert into Empleado (DNIEmpl,NombEmpl,ApellEmpl,TelefEmpl,CodCar,CodTie,EstEmpl) values (?,?,?,?,?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement psd = (com.mysql.jdbc.PreparedStatement) link.prepareStatement(sql);
            psd.setString(1, Empleado.TxtDNI.getText());
            psd.setString(2, Empleado.TxtNom.getText());
            psd.setString(3, Empleado.TxtApe.getText());
            psd.setString(4, Empleado.TxtTel.getText());
            psd.setString(5, Empleado.TxtCar.getText());
            psd.setString(6, Empleado.TxtTie.getText());
            psd.setString(7, Empleado.TxtEst.getText());
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
            JOptionPane.showMessageDialog(null, "DNI Existente");
            System.out.println(ex);
        }
    }

    public void Eliminar() {
        int fil = Empleado.TblEvento.getSelectedRow();
        if (fil > -1) {
            int jaja = JOptionPane.showConfirmDialog(null, "Desea Eliminar este registro", "", JOptionPane.YES_NO_OPTION);
            if (jaja == JOptionPane.YES_OPTION) {
                int fila = Empleado.TblEvento.getSelectedRow();
                String valor = Empleado.TblEvento.getValueAt(fila, 0).toString();
                if (fila >= 0) {
                    try {
                        PreparedStatement pps = link.prepareStatement("delete from Empleado where DNIEmpl='" + valor + "'");
                        pps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "El registro debe tener relacion con otro registro en otra tabla");
                        System.out.println(ex);
                    }
                }
            }
            Busqueda();
        }
    }

    public void Editar() {
        if (Empleado.TblEvento.getSelectedRow() != -1) {
            int fila = Empleado.TblEvento.getSelectedRow();
            Empleado.TxtDNI.setText(Empleado.TblEvento.getValueAt(fila, 0).toString());
            Empleado.TxtNom.setText(Empleado.TblEvento.getValueAt(fila, 1).toString());
            Empleado.TxtApe.setText(Empleado.TblEvento.getValueAt(fila, 2).toString());
            Empleado.TxtTel.setText(Empleado.TblEvento.getValueAt(fila, 3).toString());
            Empleado.TxtCar.setText(Empleado.TblEvento.getValueAt(fila, 4).toString());
            Empleado.TxtTie.setText(Empleado.TblEvento.getValueAt(fila, 5).toString());
            Empleado.TxtEst.setText(Empleado.TblEvento.getValueAt(fila, 6).toString());
            Bloquear(true);
            Empleado.TxtDNI.setEnabled(false);
            Empleado.BtnActu.setEnabled(true);
            Empleado.BtnCancelar.setEnabled(true);
            BlocSave(false);
            ValorCorrec(Empleado.CbxCargo, Empleado.TxtCar);
            ValorCorrec(Empleado.CbxTienda, Empleado.TxtTie);
            ValorCorrecEst();
        }
    }

    public void Actualizar() {
        try {
            PreparedStatement pst = link.prepareStatement("update Empleado set NombEmpl='" + Empleado.TxtNom.getText() + "',"
                    + "ApellEmpl='" + Empleado.TxtApe.getText() + "',"
                    + "TelefEmpl='" + Empleado.TxtTel.getText() + "',"
                    + "CodCar='" + Empleado.TxtCar.getText() + "',"
                    + "CodTie='" + Empleado.TxtTie.getText() + "',"
                    + "EstEmpl='" + Empleado.TxtEst.getText() + "'"
                    + "where DNIEmpl='" + Empleado.TxtDNI.getText() + "';");
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
