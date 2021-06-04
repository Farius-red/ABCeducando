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
public class DatosPersonalesVO {
    
    private String datosnombres, datosapellidos, datostipoid, datosnumeroid, 
            datostelefono, datosemail, datosfechanac; 

    public DatosPersonalesVO() {
    }

    public DatosPersonalesVO(String datosnombres, String datosapellidos, String datostipoid, String datosnumeroid, String datostelefono, String datosemail, String datosfechanac) {
        this.datosnombres = datosnombres;
        this.datosapellidos = datosapellidos;
        this.datostipoid = datostipoid;
        this.datosnumeroid = datosnumeroid;
        this.datostelefono = datostelefono;
        this.datosemail = datosemail;
        this.datosfechanac = datosfechanac;   
    }

    public String getDatosnombres() {
        return datosnombres;
    }

    public void setDatosnombres(String datosnombres) {
        this.datosnombres = datosnombres;
    }

    public String getDatosapellidos() {
        return datosapellidos;
    }

    public void setDatosapellidos(String datosapellidos) {
        this.datosapellidos = datosapellidos;
    }

    public String getDatostipoid() {
        return datostipoid;
    }

    public void setDatostipoid(String datotipoid) {
        this.datostipoid = datotipoid;
    }

    public String getDatosnumeroid() {
        return datosnumeroid;
    }

    public void setDatosnumeroid(String datonumeroid) {
        this.datosnumeroid = datonumeroid;
    }

    public String getDatostelefono() {
        return datostelefono;
    }

    public void setDatostelefono(String datotelefono) {
        this.datostelefono = datotelefono;
    }

    public String getDatosemail() {
        return datosemail;
    }

    public void setDatosemail(String datoemail) {
        this.datosemail = datoemail;
    }

    public String getDatosfechanac() {
        return datosfechanac;
    }

    public void setDatosfechanac(String datofechanac) {
        this.datosfechanac = datofechanac;
    }  
}
