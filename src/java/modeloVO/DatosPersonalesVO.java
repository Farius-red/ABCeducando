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
    
    private String datosnombres, datosapellidos, datostipoid, 
            datostelefono, datosemail, datosfechanac,eps,clave; 

    
    private int idDatos;

    public DatosPersonalesVO() {
    }
    
     public DatosPersonalesVO(String clave) {
         this.clave = clave;
    }

    public DatosPersonalesVO(String datosnombres, String datosapellidos, String datostipoid, Integer idDatos, String datostelefono, String datosemail, String datosfechanac,String eps, String clave) {
        this.datosnombres = datosnombres;
        this.datosapellidos = datosapellidos;
        this.datostipoid = datostipoid;
        this.idDatos = idDatos;
        this.datostelefono = datostelefono;
        this.datosemail = datosemail;
        this.datosfechanac = datosfechanac;   
        this.eps = eps;
        this.clave = clave;
    }

    
      public DatosPersonalesVO(String datosnombres, String datosapellidos, String datostipoid, Integer idDatos, String datostelefono, String datosemail, String datosfechanac,String eps) {
        this.datosnombres = datosnombres;
        this.datosapellidos = datosapellidos;
        this.datostipoid = datostipoid;
        this.idDatos = idDatos;
        this.datostelefono = datostelefono;
        this.datosemail = datosemail;
        this.datosfechanac = datosfechanac;   
        this.eps = eps;
        
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public DatosPersonalesVO(String datosnombres, String datosapellidos, String datostipoid, Integer idDatos, String datostelefono, String datosemail, String datosfechanac) {
        this.datosnombres = datosnombres;
        this.datosapellidos = datosapellidos;
        this.datostipoid = datostipoid;
        this.idDatos = idDatos;
        this.datostelefono = datostelefono;
        this.datosemail = datosemail;
        this.datosfechanac = datosfechanac;   
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
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

    public int getIdDatos() {
        return idDatos;
    }

    public void setIdDatos(int idDatos) {
        this.idDatos = idDatos;
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
