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

public class MensajesDAO extends Conexion  {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;

    public String sql;

 
    private String mensaje, destinatario;

    public MensajesDAO(MensajesVO mensajesvo) {
        super();

        try {
            conexion = this.obtenerConexion();
            
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

    

}
