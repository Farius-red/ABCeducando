/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.UsuarioVO;
import util.Conexion;
import util.Crud;

/**
 *
 * @author Hector
 */
public class UsuarioDAO extends Conexion implements Crud {
    
    
    //Declara elementos para manipulacion.
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private   boolean operacion = false ;

    
   
    //almacenamos las sentencias.
    public String sql;

    private  String usuariologin, usuarioPassword,nombres,apellidos,email,nombrerol,telefono;
    private Integer usuarioid;
    private Date fechaNacimiento;

    public UsuarioDAO(UsuarioVO usuVO) {
        super();

        try {
            conexion = this.obtenerConexion();
            usuarioid = usuVO.getUsuarioid();
            usuariologin = usuVO.getUsuariologin();
            usuarioPassword = usuVO.getUsuarioPassword();
            nombres = usuVO.getNombre();
            apellidos = usuVO.getApellidos();
            email= usuVO.getEmail();
            nombrerol = usuVO.getNombrerol();
            telefono = usuVO.getTelefono();
           fechaNacimiento= usuVO.getFechaNacimiento();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }

    }

    public UsuarioDAO() {
      //To change body of generated methods, choose Tools | Templates.
    }
    
    // este metodo solicita dos parametros y retorna un objeto que contine los datos de la sesion
    public boolean iniciarSesion(String usuario, String clave) {

        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuarios where usuariologin = ? "
                    + "and usuarioPassword = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {
                operacion = true;
              
            }

        } catch (SQLException e) {
            System.err.println(e.toString());
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }


     public ArrayList<UsuarioVO> sesionROl(String usuariologin, String clave) {

        UsuarioVO usuVO ;
        ArrayList<UsuarioVO> listausu = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT usuarioid, usuariologin,nombreRol,rol,nombre,apellidos,email,fechaNacimiento,telefono FROM rolYu inner JOIN usuarios on usuarios.usuarioid = rolYu.usuario INNER JOIN DatosUsuario on DatosUsuario.idDatos = usuarios.datosUsuarioID INNER JOIN ROL ON ROL.idRol = rolYu.rol WHERE usuarios.usuariologin=? and usuarios.usuarioPassword=?";
              
            
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuariologin);
            puente.setString(2, clave);
            
        
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                  
                usuVO = new UsuarioVO(
                        mensajero.getInt("usuarioid"),
                        mensajero.getString("usuariologin"),
                        mensajero.getString("nombreRol"),
                        mensajero.getInt("rol"),
                        mensajero.getString("nombre"),
                        mensajero.getString("apellidos"),
                        mensajero.getString("email"),
                        mensajero.getDate("fechaNacimiento"),
                        mensajero.getString("telefono")
                        
                        
                );         

                listausu.add(usuVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        
        return listausu;

    }
     
 
    
    @Override
    public boolean agregar() {
        
        try {
            sql = "insert into usuarios(usuarioid,usuariologin, usuarioPassword) values(?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, usuarioid);
            puente.setString(2, usuariologin);
            puente.setString(3, usuarioPassword);
            
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                System.out.println(e.toString());
            }

        }
        return operacion;
        
    }
    
    public ArrayList<UsuarioVO> listarusu() {

        UsuarioVO usuVO = null;
        ArrayList<UsuarioVO> listausu = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT usuarioid, usuariologin,nombreRol,nombre,apellidos,email,fechaNacimiento,telefono FROM rolYu inner JOIN usuarios on usuarios.usuarioid = rolYu.id_rolYu INNER JOIN DatosUsuario on DatosUsuario.idDatos = usuarios.usuarioid INNER JOIN ROL ON ROL.idRol = DatosUsuario.idDatos ";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                  
                 usuVO.setUsuarioid(mensajero.getInt(1));
                usuVO.setUsuariologin(mensajero.getString(2));
                usuVO.setNombrerol(mensajero.getString("nombreRol"));
                usuVO.setNombre(mensajero.getString("nombre"));
                usuVO.setApellidos(mensajero.getString("apellidos"));
                usuVO.setTelefono(mensajero.getString("telefono"));
                usuVO.setEmail(mensajero.getString("email"));
                usuVO.setFechaNacimiento(mensajero.getDate("fechaNacimiento"));

                listausu.add(usuVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        
        return listausu;

    }

    @Override
    public boolean listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
