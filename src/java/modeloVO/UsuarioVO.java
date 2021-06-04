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
public class UsuarioVO {
    
    private String usuarioId, usuarioLogin, usuarioPassword, DatosNumeroId;

    
    public UsuarioVO() {
    }
    
    public UsuarioVO(String usuarioId, String usuarioLogin) {
        this.usuarioId = usuarioId;
        this.usuarioLogin = usuarioLogin;
    }

    public UsuarioVO(String usuarioId, String usuarioLogin, String usuarioPassword, String DatosNumeroId) {
        this.usuarioId = usuarioId;
        this.usuarioLogin = usuarioLogin;
        this.usuarioPassword = usuarioPassword;
        this.DatosNumeroId = DatosNumeroId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public String getDatosNumeroId() {
        return DatosNumeroId;
    }

    public void setDatosNumeroId(String DatosNumeroId) {
        this.DatosNumeroId = DatosNumeroId;
    }

    
    
}
