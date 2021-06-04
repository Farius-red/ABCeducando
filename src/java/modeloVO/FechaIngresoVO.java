/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author Hector
 */
public class FechaIngresoVO {
    
    private String docenteid, fechaingreso, fechasalida, datosnumerid;

    public FechaIngresoVO() {
    }

    public FechaIngresoVO(String docenteid, String fechaingreso, String fechasalida, String datosnumerid) {
        this.docenteid = docenteid;
        this.fechaingreso = fechaingreso;
        this.fechasalida = fechasalida;
        this.datosnumerid = datosnumerid;
    }

    public String getDocenteid() {
        return docenteid;
    }

    public void setDocenteid(String docenteid) {
        this.docenteid = docenteid;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getDatosnumerid() {
        return datosnumerid;
    }

    public void setDatosnumerid(String datosnumerid) {
        this.datosnumerid = datosnumerid;
    }
    
}
