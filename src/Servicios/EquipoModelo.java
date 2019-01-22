package Servicios;

public class EquipoModelo {

    private String CodigoE;     //Codigo de Equipo

    private String MarcaE;         //Codigo de la Marca del Equipo

    private String ModeloE;     //Modelo del Equipo

    private String ColorE;      //Color del Equipo

    private String EstadoE = "A";     //Estado del Equipo (Activo / Inactivo)

    
    public String getCodigoE() {
        return CodigoE;
    }

    public void setCodigoE(String CodigoE) {
        this.CodigoE = CodigoE;
    }

    public String getModeloE() {
        return ModeloE;
    }

    public void setModeloE(String ModeloE) {
        this.ModeloE = ModeloE;
    }

    public String getColorE() {
        return ColorE;
    }

    public void setColorE(String ColorE) {
        this.ColorE = ColorE;
    }

    public String getEstadoE() {
        return EstadoE;
    }

    public void setEstadoE(String EstadoE) {
        this.EstadoE = EstadoE;
    }

    public String getMarcaE() {
        return MarcaE;
    }

    public void setMarcaE(String MarcaE) {
        this.MarcaE = MarcaE;
    }

}
