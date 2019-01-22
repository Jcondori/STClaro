package Conexion;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    Connection link = null;

    public Connection Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            link = DriverManager.getConnection("jdbc:mysql://localhost:3306/STClaro", "root", "");//XAMPP
            link = DriverManager.getConnection("jdbc:mysql://localhost:3305/STClaro", "root", "root");//MySQL Server
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar Servidor");            
            System.out.println(" no " + e);
        }
        return link;
    }
}