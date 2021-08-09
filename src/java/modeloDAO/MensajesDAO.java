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
import modeloVO.MensajesVO;

import util.Conexion;
import util.Crud;

public class MensajesDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;

    public String sql;

    private String mensaje, destinatario;

    public MensajesDAO(MensajesVO mensajesvo) {
        super();

        try {

            mensaje = mensajesvo.getMensaje();
            destinatario = mensajesvo.getDestinatario();

        } catch (Exception e) {
            Logger.getLogger(MensajesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public MensajesDAO() {
    }

    public boolean agregarl(String mensaje, String destinatario) {
        try {
            conexion = this.obtenerConexion();
            sql = "insert into mensajes(mensaje,destinatario) values(?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, mensaje);
            puente.setString(2, destinatario);

            puente.executeUpdate();

            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(MensajesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(MensajesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    public ArrayList<MensajesVO> listaMensajes() {

        MensajesVO mensVO = null;
        ArrayList<MensajesVO> listaMensajes = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM mensajes";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                mensVO = new MensajesVO(mensajero.getInt(1), mensajero.getString(2),
                        mensajero.getString(3));

                listaMensajes.add(mensVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }

        return listaMensajes;

    }

    @Override
    public boolean agregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public boolean eliminar(int id) {

        try {
            conexion = this.obtenerConexion();
            sql = "DELETE FROM mensajes WHERE id_mensaje =" + id;

            puente = conexion.prepareStatement(sql);
            puente.executeUpdate();

            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return operacion;
    }

    public boolean RecuperarClave(String receptor) {
        try {
            conexion = this.obtenerConexion();
            sql = "select usuariologin from usuarios where usuariologin = ? ";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, receptor);

            mensajero = puente.executeQuery();

            if (mensajero.next()) {

                operacion = true;

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public boolean CambiarClave(String contra, String correo) {

        operacion = false;
        try {
            conexion = this.obtenerConexion();
            sql = "select usuariologin from usuarios where usuariologin = ? ";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, correo);

            mensajero = puente.executeQuery();

            if (mensajero.next()) {

                String usuarioLogin = mensajero.getString(1);

                if (usuarioLogin.equals(correo)) {
                    operacion = true;
                }
            }

            if (operacion) {
                sql = "update usuarios set usuarioPassword=? WHERE usuariologin = ?";

                puente = conexion.prepareStatement(sql);
                puente.setString(1, contra);

                puente.setString(2, correo);

                puente.executeUpdate();
                operacion = true;

            }

        } catch (Exception e) {
            Logger.getLogger(MensajesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(MensajesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

}
