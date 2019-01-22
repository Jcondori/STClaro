package Servicios;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class XlsImport_Equipo extends DAO {

    //Debes crear una variable para cada campo
    EquipoModelo equipo = new EquipoModelo();

    public void LeerExcel(File file) throws SQLException, Exception {
        int contador = 1;
        try {
            Workbook ArchivoExcel = Workbook.getWorkbook(file);
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
                                equipo.setCodigoE(dato);
                                contador++;
                                break;
                            case 2:
                                equipo.setMarcaE(dato);
                                contador++;
                                break;
                            case 3:
                                equipo.setModeloE(dato);
                                contador++;
                                break;
                            case 4:
                                equipo.setColorE(dato);
                                contador = 1;
                                break;

                        }

                    }
                    //Con tu conexcion haces el inser into
//                    if (!RegistrarEquipo(equipo)) {
//                        System.out.println(equipo.getCodigoE() + " , " + equipo.getMarcaE() + " , " + equipo.getModeloE() + " , " + equipo.getColorE());
//                    }
//                    equipo = new EquipoModelo();
                    System.out.println(equipo.getCodigoE() + " , " + equipo.getMarcaE() + " , " + equipo.getModeloE() + " , " + equipo.getColorE());
                }
            }
            System.out.println("Los anteriores no se ingresaron");
        } catch (IOException | IndexOutOfBoundsException | BiffException ioe) {
            System.out.println(ioe);
            System.out.println("Error");
        }
    }

    public static void importar(String ubi) throws SQLException, Exception {
        XlsImport_Equipo excel = new XlsImport_Equipo();
        excel.LeerExcel(new File(ubi));
    }

    public static void main(String[] args) throws SQLException, Exception {
        importar("E:\\Equipos.xls");
    }

    public boolean RegistrarEquipo(EquipoModelo Eq) throws Exception {
        this.Conectar();
        try {
            String sql = "BEGIN SP_ADDEQUIPO(?,?,?,?,?); END;";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Eq.getCodigoE());
            ps.setString(2, Eq.getMarcaE());
            ps.setString(3, Eq.getModeloE());
            ps.setString(4, Eq.getColorE());
            ps.setString(5, Eq.getEstadoE());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            this.Cerrar();
        }
    }

}
