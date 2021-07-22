package modeloVO;

import java.sql.Date;
import java.util.ArrayList;

public class UsuarioVO {

    private String usuariologin, usuarioPassword, nombre, apellidos, email, nombrerol, telefono, datostipoid;
    private Integer usuarioid, rol;
    private Date fechaNacimiento;
    private ArrayList<UsuarioVO> usuLog = new ArrayList<>();

    public UsuarioVO(String usuariologin, String usuarioPassword, Integer usuarioid) {
        this.usuariologin = usuariologin;
        this.usuarioPassword = usuarioPassword;
        this.usuarioid = usuarioid;
    }

    public UsuarioVO(
            Integer usuarioid,
            String usuarioPassword,
            String datostipoid,
            String nombre,
            String Apellidos,
            String email,
            Date fechaNacimiento
    ) {
        this.usuarioid = usuarioid;
        this.usuarioPassword = usuarioPassword;
        this.datostipoid = datostipoid;
        this.nombre = nombre;
        this.apellidos = Apellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;

    }

    public UsuarioVO(Integer usuarioid, String usuariologin, String nombrerol, Integer rol, String nombre, String apellidos, String email, Date fechaNacimiento, String telefono) {
        this.usuarioid = usuarioid;
        this.usuariologin = usuariologin;
        this.nombrerol = nombrerol;
        this.rol = rol;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;

    }

    public UsuarioVO() {
    }

   

    public String getUsuariologin() {
        return usuariologin;
    }

    public void setUsuariologin(String usuariologin) {
        this.usuariologin = usuariologin;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDatostipoid() {
        return datostipoid;
    }

    public void setDatostipoid(String datostipoid) {
        this.datostipoid = datostipoid;
    }

    public Integer getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Integer usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<UsuarioVO> getUsuLog() {
        return usuLog;
    }

    public void setUsuLog(ArrayList<UsuarioVO> usuLog) {
        this.usuLog = usuLog;
    }

}
