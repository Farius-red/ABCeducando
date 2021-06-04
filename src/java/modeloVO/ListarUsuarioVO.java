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
public class ListarUsuarioVO {
    
    private String usuarioid, usuariologin;

    public ListarUsuarioVO() {
    }

    public ListarUsuarioVO(String usuarioid, String usuariologin) {
        this.usuarioid = usuarioid;
        this.usuariologin = usuariologin;
    }

    public String getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(String usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getUsuariologin() {
        return usuariologin;
    }

    public void setUsuariologin(String usuariologin) {
        this.usuariologin = usuariologin;
    }
    
}
