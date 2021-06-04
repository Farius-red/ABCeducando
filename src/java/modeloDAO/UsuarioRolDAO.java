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
import modeloVO.UsuarioRolVO;
import util.Conexion;
import util.Crud;

/**
 *
 * @author Hector
 */
public class UsuarioRolDAO extends Conexion implements Crud {

    //Declara elementos para manipulacion.
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    //almacenamos el resultado de la operacion.
    public boolean operacion = false;
    //almacenamos las sentencias.
    public String sql;

    private String usuarioid = "", rolid = "";

    public UsuarioRolDAO(UsuarioRolVO usuariorolVO) {
        super();

        try {

            conexion = this.obtenerConexion();
            usuarioid = usuariorolVO.getUsuarioid();
            rolid = usuariorolVO.getRolid();

        } catch (Exception e) {
            Logger.getLogger(UsuarioRolDAO.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    @Override
    public boolean agregar() {
        try {
            sql = "insert into usuariorol(usuarioid, rolid) values(?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuarioid);
            puente.setString(2, rolid);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {

            Logger.getLogger(UsuarioRolDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                System.out.println(e.toString());
            }

        }
        return operacion;
    }

    @Override
    public boolean actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
