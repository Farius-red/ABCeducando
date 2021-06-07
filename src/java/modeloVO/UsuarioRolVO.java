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
    
    
    private String usuarioid;
    private String rolid;

    public UsuarioRolVO () {
}

    public UsuarioRolVO(int aInt, String string) {
      //To change body of generated methods, choose Tools | Templates.
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
