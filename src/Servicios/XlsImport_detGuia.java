package Servicios;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class XlsImport_detGuia extends DAO {

    //Debes crear una variable para cada campo
    ImeiModelo imei = new ImeiModelo();

    public void LeerExcel(String Ubicacion) throws SQLException, Exception {
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
                                imei.setImei(dato);
                                contador++;
                                break;
                            case 2:
                                imei.setEquipoI(dato);
                                contador = 1;
                                break;
                        }

                    }
                    //Con tu conexcion haces el inser into
                    if (!registrarImei(imei)) {
                        System.out.println(imei.getImei() + " , " + imei.getEquipoI());
                    }
                    imei = new ImeiModelo();
//                    System.out.println(imei.getImei() + " , " + imei.getEquipoI());
                }
            }
            System.out.println("Los anteriores no se ingresaron");
        } catch (IOException | IndexOutOfBoundsException | BiffException ioe) {
            System.out.println(ioe);
            System.out.println("Error");
        }
    }

    public static void importar(String ubi) throws SQLException, Exception {
        XlsImport_detGuia excel = new XlsImport_detGuia();
        excel.LeerExcel(ubi);
    }

    public static void main(String[] args) throws SQLException, Exception {
        importar("E:\\detguia.xls");
    }

    public boolean registrarImei(ImeiModelo Imei) throws Exception {
        try {
            this.Conectar();
            String sql = "INSERT INTO DETGUIA ( codim,codguia ) VALUES ( ?,? )";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Imei.getImei());
            ps.setString(2, Imei.getEquipoI());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            this.Cerrar();
        }
    }
    
    public void imei(){
        
    }

}
