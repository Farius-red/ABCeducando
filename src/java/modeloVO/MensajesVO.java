
package modeloVO;


public class MensajesVO {
    

    private String mensaje, destinatario;
    private Integer id_mensaje;

  
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Integer getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(Integer id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

  public MensajesVO(Integer id_mensaje, String mensaje, String destinatario) {
        this.mensaje = mensaje;
        this.destinatario = destinatario;
        this.id_mensaje = id_mensaje;
    }

    public MensajesVO() {
    }

 

   
}
