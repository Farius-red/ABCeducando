package modeloVO;

import java.io.InputStream;

public class ActividadCargadaVO {

//    /*Todo los atributos*/
//    int codigopdf;
//    String nombrepdf;
//    InputStream archivopdf;
//    private byte[] archivopdf2;
//
//    public ActividadCargadaVO(int id, String name, byte[] archivo) {
//        this.codigopdf = id;
//        this.nombrepdf = name;
//        this.archivopdf2 = archivo;
//    }
//
//    public ActividadCargadaVO() {
//    }
//
//    /*Todo los codigos get*/
//    public int getCodigopdf() {
//        return codigopdf;
//    }
//
//    public String getNombrepdf() {
//        return nombrepdf;
//    }
//
//    public InputStream getArchivopdf() {
//        return archivopdf;
//    }
//
//
//    /*Todo los codigos set*/
//    public void setCodigopdf(int codigopdf) {
//        this.codigopdf = codigopdf;
//    }
//
//    public void setNombrepdf(String nombrepdf) {
//        this.nombrepdf = nombrepdf;
//    }
//
//    public void setArchivopdf(InputStream archivopdf) {
//        this.archivopdf = archivopdf;
//    }
//
//    /**
//     * @return the archivopdf2
//     */
//    public byte[] getArchivopdf2() {
//        return archivopdf2;
//    }
//
//    /**
//     * @param archivopdf2 the archivopdf2 to set
//     */
//    public void setArchivopdf2(byte[] archivopdf2) {
//        this.archivopdf2 = archivopdf2;
//    }
    
    int actividadcargadaid;
    String actividadcargadanombre;
    String actividadcargadadescripcion;
    InputStream actcararchivo;
    private byte[] actcararchivo2;
    int docenteid;

    public ActividadCargadaVO() {
    }

    public ActividadCargadaVO(int actividadcargadaid, String actividadcargadanombre, String actividadcargadadescripcion, byte[] actcararchivo2, int docenteid) {
        this.actividadcargadaid = actividadcargadaid;
        this.actividadcargadanombre = actividadcargadanombre;
        this.actividadcargadadescripcion = actividadcargadadescripcion;
        this.actcararchivo2 = actcararchivo2;
        this.docenteid = docenteid;
    }

    public int getActividadcargadaid() {
        return actividadcargadaid;
    }

    public void setActividadcargadaid(int actividadcargadaid) {
        this.actividadcargadaid = actividadcargadaid;
    }

    public String getActividadcargadanombre() {
        return actividadcargadanombre;
    }

    public void setActividadcargadanombre(String actividadcargadanombre) {
        this.actividadcargadanombre = actividadcargadanombre;
    }

    public String getActividadcargadadescripcion() {
        return actividadcargadadescripcion;
    }

    public void setActividadcargadadescripcion(String actividadcargadadescripcion) {
        this.actividadcargadadescripcion = actividadcargadadescripcion;
    }

    public InputStream getActcararchivo() {
        return actcararchivo;
    }

    public void setActcararchivo(InputStream actcararchivo) {
        this.actcararchivo = actcararchivo;
    }

    public byte[] getActcararchivo2() {
        return actcararchivo2;
    }

    public void setActcararchivo2(byte[] actcararchivo2) {
        this.actcararchivo2 = actcararchivo2;
    }

    public int getDocenteid() {
        return docenteid;
    }

    public void setDocenteid(int docenteid) {
        this.docenteid = docenteid;
    }

    

    


}
