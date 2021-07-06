package modeloVO;



public class ActividadCargadaVO {

private int DocenteId, ActividadCargadaId;

   
private String ActividadCargadaNombre, ActividadCargadaDescripcion, rutaArchivo;



    public ActividadCargadaVO(String ActividadCargadaNombre, String ActividadCargadaDescripcion, String rutaArchivo,int DocenteId) {
        
        this.ActividadCargadaNombre = ActividadCargadaNombre;
        this.ActividadCargadaDescripcion = ActividadCargadaDescripcion;
        this.rutaArchivo = rutaArchivo;
        this.DocenteId = DocenteId;
    }
    
        public ActividadCargadaVO(Integer ActividadCargadaId,String ActividadCargadaNombre, String ActividadCargadaDescripcion, String rutaArchivo) {
        this.ActividadCargadaId = ActividadCargadaId;
        this.ActividadCargadaNombre = ActividadCargadaNombre;
        this.ActividadCargadaDescripcion = ActividadCargadaDescripcion;
        this.rutaArchivo = rutaArchivo;

    }
    
        public ActividadCargadaVO(Integer ActividadCargadaId,String ActividadCargadaNombre, String ActividadCargadaDescripcion, String rutaArchivo, int DocenteId) {
        this.ActividadCargadaId = ActividadCargadaId;
        this.ActividadCargadaNombre = ActividadCargadaNombre;
        this.ActividadCargadaDescripcion = ActividadCargadaDescripcion;
        this.rutaArchivo = rutaArchivo;
        this.DocenteId = DocenteId;

    }
    

    public ActividadCargadaVO() {
    }

    
     public int getActividadCargadaId() {
        return ActividadCargadaId;
    }

    public void setActividadCargadaId(int ActividadCargadaId) {
        this.ActividadCargadaId = ActividadCargadaId;
    }
    public int getDocenteId() {
        return DocenteId;
    }

    public void setDocenteId(int DocenteId) {
        this.DocenteId = DocenteId;
    }

    public String getActividadCargadaNombre() {
        return ActividadCargadaNombre;
    }

    public void setActividadCargadaNombre(String ActividadCargadaNombre) {
        this.ActividadCargadaNombre = ActividadCargadaNombre;
    }

    public String getActividadCargadaDescripcion() {
        return ActividadCargadaDescripcion;
    }

    public void setActividadCargadaDescripcion(String ActividadCargadaDescripcion) {
        this.ActividadCargadaDescripcion = ActividadCargadaDescripcion;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    


}
