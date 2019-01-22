package Conexion;

import javax.swing.JOptionPane;

public class Test {
    
    Conexion conexion;
       
    
    public void testeo() {
        Conexion MySQL = new Conexion();
        java.sql.Connection cnx = MySQL.Conectar();
        if (!cnx.equals(null)) {
            JOptionPane.showMessageDialog(null, "Conectado");
            try {
                cnx.close();
            } catch (Exception e) {
                System.out.println("Error al desconectar" + e);
            }
        }
    }
}
