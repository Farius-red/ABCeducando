/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.Connection;
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

    //almacenamos el resultado de la operacion.
    public boolean operacion = false;
    //almacenamos las sentencias.
    public String sql;

    private String usuarioId = "", usuarioLogin = "", usuarioPassword = "", DatosNumeroId = "";

    public UsuarioDAO(UsuarioVO usuVO) {
        super();

        try {
            conexion = this.obtenerConexion();
            usuarioId = usuVO.getUsuarioId();
            usuarioLogin = usuVO.getUsuarioLogin();
            usuarioPassword = usuVO.getUsuarioPassword();
            DatosNumeroId = usuVO.getDatosNumeroId();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }

    }
    
    
    public boolean iniciarSesion(String usuario, String clave) {

        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario where usuarioLogin = ? "
                    + "and usuarioPassword = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {
                operacion = true;
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }finally{
            try {
                this.cerrarConexion();
            } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }

    @Override
    public boolean agregar() {
        
        try {
            sql = "insert into usuario(usuariologin, usuariopassword, DatosNumeroId) values(?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuarioLogin);
            puente.setString(2, usuarioPassword);
            puente.setString(3, DatosNumeroId);
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
            sql = "select usuarioid, usuariologin from usuario";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2));

                listausu.add(usuVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
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
