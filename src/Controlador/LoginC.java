package Controlador;

import Conexion.Conexion;
import Vistas.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LoginC {   

    DefaultTableModel modelo;
    PreparedStatement preparedStatement;

    Conexion conectar;

    Conexion cnx = new Conexion();
    Connection link = cnx.Conectar();

    public String Usuario = "-";
    public String Password = "-";
    public int TipoUsuario = 0;
  

    public void ingresar(String us) throws SQLException {
        String pass = String.valueOf(Login.TxtPassword.getPassword());
        try {
            String sql = "select * from Usuarios where NomUs like'" + us + "';";
            Statement st = (Statement) link.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Usuario = rs.getString("NomUs");
                Password = rs.getString("PasUs");
                TipoUsuario = rs.getInt("NivUs");
            }
            if (!Usuario.equals(us)) {
                JOptionPane.showMessageDialog(null, "Usuario no existe");
            } else {
                if (Password.equals(pass)) {
                    Login.cam = TipoUsuario;                    
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en metodo ingresar");
        }
    }

    public void BtnIngresar() throws SQLException {
        String Us = String.valueOf(Login.TxtUser.getText());
        if ("".equals(Us)) {
            JOptionPane.showMessageDialog(null, "Ingrese Usuario");
        } else {
            ingresar(Us);
        }
    }
}
