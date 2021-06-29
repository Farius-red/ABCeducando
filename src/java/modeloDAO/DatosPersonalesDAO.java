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
import modeloVO.DatosPersonalesVO;
import util.Conexion;
import util.Crud;

/**
 *
 * @author Hector
 */
public class DatosPersonalesDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    public boolean operacion = false;
    public String sql;

    private String datosnombres = "", datosapellidos = "", datostipoid = "", 
            datostelefono = "", datosemail = "", datosfechanac = "";
     private int idDatos;
    public DatosPersonalesDAO() {
    }

    public DatosPersonalesDAO(DatosPersonalesVO DatosVO) {
        super();

        try {

            conexion = this.obtenerConexion();
            datosnombres = DatosVO.getDatosnombres();
            datosapellidos = DatosVO.getDatosapellidos();
            datostipoid = DatosVO.getDatostipoid();
            idDatos = DatosVO.getIdDatos();
            datostelefono = DatosVO.getDatostelefono();
            datosemail = DatosVO.getDatosemail();
            datosfechanac = DatosVO.getDatosfechanac();

        } catch (Exception e) {
            Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    @Override
    public boolean agregar() {

        try {
            sql = "INSERT INTO DatosUsuario(datostipoid,idDatos,nombre,apellidos,telefono,email,fechaNacimiento) VALUES(?, ?, ?, ?, ?, ?, ?)";
             
                    
                    
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datostipoid);
            puente.setInt(2, idDatos);
            puente.setString(3, datosnombres);
            puente.setString(4, datosapellidos);
            puente.setString(5, datostelefono);
            puente.setString(6, datosemail);
            puente.setString(7, datosfechanac);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        return operacion;
    }
    
    public ArrayList<DatosPersonalesVO> listardocentes() {

        DatosPersonalesVO datosVO = null;
        ArrayList<DatosPersonalesVO> listadocentes = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT nombre,apellidos,datostipoid,idDatos,telefono, email, fechaNacimiento FROM rolYu INNER JOIN usuarios on usuarios.usuarioid = rolYu.usuario\n" +
"INNER JOIN DatosUsuario ON DatosUsuario.idDatos = usuarios.usuarioid\n" +
"WHERE rolYu.rol = 3";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                datosVO = new DatosPersonalesVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getInt(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7));

                listadocentes.add(datosVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        
        return listadocentes;

    }
    
    
    public ArrayList<DatosPersonalesVO> listarEstudiantes() {

        DatosPersonalesVO datosVO = null;
        ArrayList<DatosPersonalesVO> listadocentes = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT nombre,apellidos,datostipoid,idDatos,telefono, email, fechaNacimiento FROM rolYu INNER JOIN usuarios on usuarios.usuarioid = rolYu.usuario\n" +
"INNER JOIN DatosUsuario ON DatosUsuario.idDatos = usuarios.usuarioid\n" +
"WHERE rolYu.rol = 2";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                datosVO = new DatosPersonalesVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getInt(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7));

                listadocentes.add(datosVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        
        return listadocentes;

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
