/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

import java.io.InputStream;

/**
 *
 * @author Hector
 */
public class ActividadEntregadaVO {
    
    private String  actividadentregadanombre, actividadentregadadescripcion, actividadentregadaestado;
            int actividadentregadaid, Estudianteid; 
            InputStream actividadentregadaarchivo;
            private byte[] actividadentregadaarchivo2;

    public ActividadEntregadaVO() {
    }

    public ActividadEntregadaVO(String actividadentregadanombre, String actividadentregadadescripcion, String actividadentregadaestado, int actividadentregadaid, int Estudianteid, byte[] actividadentregadaarchivo2) {
        this.actividadentregadanombre = actividadentregadanombre;
        this.actividadentregadadescripcion = actividadentregadadescripcion;
        this.actividadentregadaestado = actividadentregadaestado;
        this.actividadentregadaid = actividadentregadaid;
        this.Estudianteid = Estudianteid;
        this.actividadentregadaarchivo2 = actividadentregadaarchivo2;
    }

    public String getActividadentregadanombre() {
        return actividadentregadanombre;
    }

    public void setActividadentregadanombre(String actividadentregadanombre) {
        this.actividadentregadanombre = actividadentregadanombre;
    }

    public String getActividadentregadadescripcion() {
        return actividadentregadadescripcion;
    }

    public void setActividadentregadadescripcion(String actividadentregadadescripcion) {
        this.actividadentregadadescripcion = actividadentregadadescripcion;
    }

    public String getActividadentregadaestado() {
        return actividadentregadaestado;
    }

    public void setActividadentregadaestado(String actividadentregadaestado) {
        this.actividadentregadaestado = actividadentregadaestado;
    }

    public int getActividadentregadaid() {
        return actividadentregadaid;
    }

    public void setActividadentregadaid(int actividadentregadaid) {
        this.actividadentregadaid = actividadentregadaid;
    }

    public int getEstudianteid() {
        return Estudianteid;
    }

    public void setEstudianteid(int Estudianteid) {
        this.Estudianteid = Estudianteid;
    }

    public InputStream getActividadentregadaarchivo() {
        return actividadentregadaarchivo;
    }

    public void setActividadentregadaarchivo(InputStream actividadentregadaarchivo) {
        this.actividadentregadaarchivo = actividadentregadaarchivo;
    }

    public byte[] getActividadentregadaarchivo2() {
        return actividadentregadaarchivo2;
    }

    public void setActividadentregadaarchivo2(byte[] actividadentregadaarchivo2) {
        this.actividadentregadaarchivo2 = actividadentregadaarchivo2;
    }
    
}
