package Controlador;

import Conexion.Conexion;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class XlsImport {
    
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date(System.currentTimeMillis());

    DefaultTableModel modelo;
    PreparedStatement preparedStatement;

    Conexion conectar;

    Conexion cnx = new Conexion();
    Connection link = cnx.Conectar();

    //Debes crear una variable para cada campo
    public static String Imei;
    public static String Equipo;
    public static String Fecha;

    public void LeerExcel(String Ubicacion) throws SQLException {
        int contador = 1;
        try {
            Workbook ArchivoExcel = Workbook.getWorkbook(new File(Ubicacion));
            //Recorre cada hoja
            for (int hojas = 0; hojas < ArchivoExcel.getNumberOfSheets(); hojas++) {
                Sheet hoja = ArchivoExcel.getSheet(hojas);
                int NumColumnas = hoja.getColumns();
                int NumFilas = hoja.getRows();
                String dato;
                //Recorre cada fila de la hoja
                for (int fila = 1; fila < NumFilas; fila++) {// Se pone uno, creo para que no lleva la fila 1 donde van los nombre de los capos
                    for (int columna = 0; columna < NumColumnas; columna++) {
                        dato = hoja.getCell(columna, fila).getContents();
                        //Funcion switch que evalua la variable contador
                        //Debes poner un case para cada columna junto con el incremento y en el ultimo case vuelves el contador a 1
                        switch (contador) {
                            case 1:
                                Imei = dato;
                                contador++;
                                break;
                            case 2:
                                Equipo = dato;
                                Fecha = date.format(now);
                                contador=1;
                                break;
                                
                        }

                    }
                    //Con tu conexcion haces el inser into
                    String sql = "insert into Imei (CodIm,CodEq,FecIng) values ('" + Imei + "','" + Equipo + "','" + Fecha + "')";
                    com.mysql.jdbc.PreparedStatement psd = (com.mysql.jdbc.PreparedStatement) link.prepareStatement(sql);
                    psd.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(null, "Importado con Exito");
        } catch (IOException | IndexOutOfBoundsException | BiffException ioe) {
            System.out.println(ioe);
            JOptionPane.showMessageDialog(null, "Error en Import");
        }
    }

    public static void importar(String ubi) throws SQLException {
        XlsImport excel = new XlsImport();
        excel.LeerExcel(ubi);
    }
}
