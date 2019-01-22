package Controlador;

import Vistas.Cargo;
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

public class CargoC {

    DefaultTableModel modelo;
    PreparedStatement preparedStatement;

    Conexion conectar;

    Conexion cnx = new Conexion();
    Connection link = cnx.Conectar();

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
        Cargo.BtnOtro.setEnabled(v);
        Cargo.BtnEliminar.setEnabled(v);
        Cargo.BtnEditar.setEnabled(v);
    }

    public void Nuevo() {
        Limpiar();
        Bloquear(true);
        Cargo.BtnGuardar.setEnabled(true);
        Cargo.BtnCancelar.setEnabled(true);
    }

    public void BlocInicio() {
        Cargo.BtnGuardar.setEnabled(false);
        Cargo.BtnActu.setEnabled(false);
        Cargo.BtnCancelar.setEnabled(false);
    }

    public void Cancelar() {
        Limpiar();
        Bloquear(false);
        BlocInicio();
        BlocSave(true);
    }

    public void Limpiar() {
        Cargo.TxtCod.setText(null);
        Cargo.TxtNom.setText(null);

    }

    public void Bloquear(Boolean v) {
        Cargo.TxtCod.setEnabled(v);
        Cargo.TxtNom.setEnabled(v);

    }

    public void Busqueda() {
        String[] titulos = {"Codigo", "Cargo"};
        String[] registros = new String[50];
        String sql = "select * from Cargos where CodCar like'%" + Cargo.TxtBuscar.getText() + "%'"
                + "or NomCar like '%" + Cargo.TxtBuscar.getText() + "%'";
        modelo = new DefaultTableModel(null, titulos);
        try {
            Statement st = (Statement) link.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("CodCar");
                registros[1] = rs.getString("NomCar");
                modelo.addRow(registros);
            }
            Cargo.TblEvento.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }   

    public void Guardar() {
        String sql = "insert into Cargos (CodCar,NomCar) values (?,?)";
        try {
            com.mysql.jdbc.PreparedStatement psd = (com.mysql.jdbc.PreparedStatement) link.prepareStatement(sql);
            psd.setString(1, Cargo.TxtCod.getText());
            psd.setString(2, Cargo.TxtNom.getText());
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
        int fil = Cargo.TblEvento.getSelectedRow();
        if (fil > -1) {
            int jaja = JOptionPane.showConfirmDialog(null, "Desea Eliminar este registro", "", JOptionPane.YES_NO_OPTION);
            if (jaja == JOptionPane.YES_OPTION) {
                int fila = Cargo.TblEvento.getSelectedRow();
                String valor = Cargo.TblEvento.getValueAt(fila, 0).toString();
                if (fila >= 0) {
                    try {
                        PreparedStatement pps = link.prepareStatement("delete from Cargos where CodCar='" + valor + "'");
                        pps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Cargo.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "El registro debe tener relacion con otro registro en otra tabla");
                        System.out.println(ex);
                    }
                }
            }
            Busqueda();
        }
    }

    public void Editar() {
        if (Cargo.TblEvento.getSelectedRow() != -1) {
            int fila = Cargo.TblEvento.getSelectedRow();
            Cargo.TxtCod.setText(Cargo.TblEvento.getValueAt(fila, 0).toString());
            Cargo.TxtNom.setText(Cargo.TblEvento.getValueAt(fila, 1).toString());
            Bloquear(true);
            Cargo.TxtCod.setEnabled(false);
            Cargo.BtnActu.setEnabled(true);
            Cargo.BtnCancelar.setEnabled(true);
            BlocSave(false);
        }
    }

    public void Actualizar() {
        try {
            PreparedStatement pst = link.prepareStatement("update Cargos set NomCar='" + Cargo.TxtNom.getText() + "'"
                    + "where CodCar='" + Cargo.TxtCod.getText() + "';");
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
