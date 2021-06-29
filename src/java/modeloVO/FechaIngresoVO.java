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
    
    private String fechaingreso, fechasalida;
    private int docenteid, datosnumerid;

    public FechaIngresoVO() {
    }

    public FechaIngresoVO(Integer docenteid, String fechaingreso, String fechasalida, Integer datosnumerid) {
        this.docenteid = docenteid;
        this.fechaingreso = fechaingreso;
        this.fechasalida = fechasalida;
        this.datosnumerid = datosnumerid;
    }

    public int getDocenteid() {
        return docenteid;
    }

    public void setDocenteid(int docenteid) {
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

    public int getDatosnumerid() {
        return datosnumerid;
    }

    public void setDatosnumerid(Integer datosnumerid) {
        this.datosnumerid = datosnumerid;
    }
    
}
