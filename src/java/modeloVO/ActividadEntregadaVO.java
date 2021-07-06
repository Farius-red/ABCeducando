
package modeloVO;



/**
 *
 * @author Hector
 */
public class ActividadEntregadaVO {
    
   
    private int  ActividadEntregadaId,  idActividadCargada, calificacion;
    private String  ActividadEntregadaRuta,EstudianteId, ActividadEntregadaEstado;

    public ActividadEntregadaVO() {
    }

    public ActividadEntregadaVO(int idActividadCargada) {
        this.idActividadCargada = idActividadCargada;
    }
    
    
    

    public ActividadEntregadaVO(String EstudianteId,int idActividadCargada, String ActividadEntregadaRuta ) {
        this.EstudianteId = EstudianteId;
        this.idActividadCargada = idActividadCargada;
        this.ActividadEntregadaRuta = ActividadEntregadaRuta;
        
    }
public ActividadEntregadaVO(int ActividadEntregadaId,  int idActividadCargada, int calificacion, String ActividadEntregadaRuta, String ActividadEntregadaEstado) {
        this.ActividadEntregadaId = ActividadEntregadaId;
        
        this.idActividadCargada = idActividadCargada;
        this.calificacion = calificacion;
        this.ActividadEntregadaRuta = ActividadEntregadaRuta;
        this.ActividadEntregadaEstado = ActividadEntregadaEstado;
    }
    
    public ActividadEntregadaVO(int ActividadEntregadaId,  int idActividadCargada, int calificacion,  String ActividadEntregadaEstado) {
        this.ActividadEntregadaId = ActividadEntregadaId;
        this.idActividadCargada = idActividadCargada;
        this.calificacion = calificacion;
       this.ActividadEntregadaEstado = ActividadEntregadaEstado;
    }

    public ActividadEntregadaVO(int ActividadEntregadaId, String EstudianteId, int idActividadCargada, int calificacion, String ActividadEntregadaRuta, String ActividadEntregadaEstado) {
        this.ActividadEntregadaId = ActividadEntregadaId;
        this.EstudianteId = EstudianteId;
        this.idActividadCargada = idActividadCargada;
        this.calificacion = calificacion;
        this.ActividadEntregadaRuta = ActividadEntregadaRuta;
        this.ActividadEntregadaEstado = ActividadEntregadaEstado;
    }

  
    public int getActividadEntregadaId() {
        return ActividadEntregadaId;
    }

    public void setActividadEntregadaId(int ActividadEntregadaId) {
        this.ActividadEntregadaId = ActividadEntregadaId;
    }

    public String getEstudianteId() {
        return EstudianteId;
    }

    public void setEstudianteId(String EstudianteId) {
        this.EstudianteId = EstudianteId;
    }

    public int getIdActividadCargada() {
        return idActividadCargada;
    }

    public void setIdActividadCargada(int idActividadCargada) {
        this.idActividadCargada = idActividadCargada;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getActividadEntregadaRuta() {
        return ActividadEntregadaRuta;
    }

    public void setActividadEntregadaRuta(String ActividadEntregadaRuta) {
        this.ActividadEntregadaRuta = ActividadEntregadaRuta;
    }

    public String getActividadEntregadaEstado() {
        return ActividadEntregadaEstado;
    }

    public void setActividadEntregadaEstado(String ActividadEntregadaEstado) {
        this.ActividadEntregadaEstado = ActividadEntregadaEstado;
    }
    
    
}
