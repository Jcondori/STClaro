package Controlador;

import Conexion.Conexion;
import Vistas.Imei;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class ImeiC {

    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date(System.currentTimeMillis());

    private final FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel", "xls");

    DefaultTableModel modelo;
    PreparedStatement preparedStatement;

    Conexion conectar;

    Conexion cnx = new Conexion();
    Connection link = cnx.Conectar();
    
    public int s;

    public void SdR() {
        try {            
            String a = "SELECT * FROM Equipo WHERE CodEq LIKE '" + Imei.TxtCodEq.getText() + "%';";
            Statement sen = link.createStatement();
            ResultSet rs;
            rs = sen.executeQuery(a);
            rs.next();
            a = rs.getString("CodEq");
            if (Imei.TxtCodEq.getText().equals(a)) {
                Imei.TxtCodEq.setBackground(Color.GREEN);
                Imei.LbSegur.setVisible(false);
                s=1;
            } else {
                Imei.TxtCodEq.setBackground(Color.WHITE);
                Imei.LbSegur.setVisible(true);
                s=0;
            }
        } catch (SQLException e) {            
        }
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

    public void Importar() {
        JFileChooser dlg = new JFileChooser();
        dlg.setFileFilter(filter);
        int option = dlg.showOpenDialog(dlg);
        if (option == JFileChooser.APPROVE_OPTION) {
            String file = dlg.getSelectedFile().getPath();
            try {
                Ubicacion(file);
            } catch (SQLException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Imei existente o Equipo no existe");
            }
        }
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
        Imei.BtnOtro.setEnabled(v);
        Imei.BtnEliminar.setEnabled(v);
        Imei.BtnEditar.setEnabled(v);
    }

    public void Nuevo() {
        Limpiar();
        Bloquear(true);
        BlocSave(false);
        Imei.BtnGuardar.setEnabled(true);
        Imei.BtnCancelar.setEnabled(true);
        Imei.TxtFecIng.setText(date.format(now));
    }

    public void BlocInicio() {
        Imei.BtnGuardar.setEnabled(false);
        Imei.BtnActu.setEnabled(false);
        Imei.BtnCancelar.setEnabled(false);
    }

    public void Cancelar() {
        Limpiar();
        Bloquear(false);
        BlocInicio();
        BlocSave(true);
    }

    public void Limpiar() {
        Imei.TxtCodImei.setText(null);
        Imei.TxtCodEq.setText(null);
        Imei.TxtFecIng.setText(null);
    }

    public void Bloquear(Boolean v) {
        Imei.TxtCodImei.setEnabled(v);
        Imei.TxtCodEq.setEnabled(v);
        Imei.TxtFecIng.setEnabled(v);
    }

    public void Busqueda() {
        String[] titulos = {"Codigo", "Nombre", "Fecha de Ingreso"};
        String[] registros = new String[50];
        String sql = "select * from Imei where CodIm like'%" + Imei.TxtBuscar.getText() + "%'"
                + "or CodEq like '%" + Imei.TxtBuscar.getText() + "%'";
        modelo = new DefaultTableModel(null, titulos);
        try {
            Statement st = (Statement) link.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("CodIm");
                registros[1] = rs.getString("CodEq");
                registros[2] = rs.getString("FecIng");
                modelo.addRow(registros);
            }
            Imei.TblEvento.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Guardar() {
        String sql = "insert into Imei (CodIm,CodEq,FecIng) values (?,?,?)";
        try {
            com.mysql.jdbc.PreparedStatement psd = (com.mysql.jdbc.PreparedStatement) link.prepareStatement(sql);
            psd.setString(1, Imei.TxtCodImei.getText());
            psd.setString(2, Imei.TxtCodEq.getText());
            psd.setString(3, Imei.TxtFecIng.getText());
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                Limpiar();
                Bloquear(true);
                Busqueda();
                BlocInicio();
                BlocSave(true);
            }
        } catch (SQLException ex) {
            if(s==1){
                JOptionPane.showMessageDialog(null, "Codigo Existente");
            }else{
                JOptionPane.showMessageDialog(null, "Equipo no existe");
            }
            
            System.out.println(ex);
        }
    }

    public void Eliminar() {
        int fil = Imei.TblEvento.getSelectedRow();
        if (fil > -1) {
            int jaja = JOptionPane.showConfirmDialog(null, "Desea Eliminar este registro", "", JOptionPane.YES_NO_OPTION);
            if (jaja == JOptionPane.YES_OPTION) {
                int fila = Imei.TblEvento.getSelectedRow();
                String valor = Imei.TblEvento.getValueAt(fila, 0).toString();
                if (fila >= 0) {
                    try {
                        PreparedStatement pps = link.prepareStatement("delete from Imei where CodIm='" + valor + "'");
                        pps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Imei.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "El registro debe tener relacion con otro registro en otra tabla");
                        System.out.println(ex);
                    }
                }
            }
            Busqueda();
        }
    }

    public void Editar() {
        if (Imei.TblEvento.getSelectedRow() != -1) {
            int fila = Imei.TblEvento.getSelectedRow();
            Imei.TxtCodImei.setText(Imei.TblEvento.getValueAt(fila, 0).toString());
            Imei.TxtCodEq.setText(Imei.TblEvento.getValueAt(fila, 1).toString());
            Imei.TxtFecIng.setText(Imei.TblEvento.getValueAt(fila, 2).toString());
            Bloquear(true);
            Imei.TxtCodImei.setEnabled(false);
            Imei.BtnActu.setEnabled(true);
            Imei.BtnCancelar.setEnabled(true);
            Imei.BtnOtro.setEnabled(false);
        }
    }

    public void Actualizar() {
        try {
            PreparedStatement pst = link.prepareStatement("update Imei set CodEq='" + Imei.TxtCodEq.getText() + "',"
                    + "FecIng='" + Imei.TxtFecIng.getText() + "'"
                    + "where CodIm='" + Imei.TxtCodImei.getText() + "';");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Resgistro actualizado");
            Limpiar();
            Bloquear(false);
            BlocSave(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        Busqueda();
        BlocInicio();
        Imei.BtnOtro.setEnabled(true);
    }

    public void Ubicacion(String Ub) throws SQLException {
        try {
            if (Ub.contains(".xls")) {
                XlsImport.importar(Ub);
                Busqueda();
            } else {
                JOptionPane.showMessageDialog(null, "solo se adminten Archivos.xls");
            }
        } catch (HeadlessException e) {
            System.out.println("FuncionesImei");
            System.out.println(e);
        }
    }
}
