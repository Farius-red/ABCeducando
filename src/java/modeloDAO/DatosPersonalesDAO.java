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

    private String datosnombres = "", datosapellidos = "", datostipoid = "", datosnumeroid = "",
            datostelefono = "", datosemail = "", datosfechanac = "";

    public DatosPersonalesDAO() {
    }

    public DatosPersonalesDAO(DatosPersonalesVO DatosVO) {
        super();

        try {

            conexion = this.obtenerConexion();
            datosnombres = DatosVO.getDatosnombres();
            datosapellidos = DatosVO.getDatosapellidos();
            datostipoid = DatosVO.getDatostipoid();
            datosnumeroid = DatosVO.getDatosnumeroid();
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

            sql = "insert into datospersonales(Datosnombres,datosapellidos,"
                    + "datostipoid,datosnumeroid,datostelefono,datosemail,datosfechanac) \n"
                    + "values (?,?,?,?,?,?,?)";
                    
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datosnombres);
            puente.setString(2, datosapellidos);
            puente.setString(3, datostipoid);
            puente.setString(4, datosnumeroid);
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
            sql = "select * from datospersonales";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                datosVO = new DatosPersonalesVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
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
