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
public class UsuarioRolVO {
    
    private String usuarioid, rolid;

    public UsuarioRolVO() {
    }

    public UsuarioRolVO(String usuarioid, String rolid) {
        this.usuarioid = usuarioid;
        this.rolid = rolid;
    }

    public String getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(String usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getRolid() {
        return rolid;
    }

    public void setRolid(String rolid) {
        this.rolid = rolid;
    }
    
}
