/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.FechaIngresoVO;
import modeloVO.UsuarioVO;
import util.Conexion;
import util.Crud;

/**
 *
 * @author Hector
 */
public class FechaingresoDAO extends Conexion implements Crud{

    //Declara elementos para manipulacion.
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    //almacenamos el resultado de la operacion.
    public boolean operacion = false;
    //almacenamos las sentencias.
    public String sql;

    private String docenteid = "", fechaingreso = "", fechasalida = "", datosnumeroid = "";

    public FechaingresoDAO(FechaIngresoVO fechaVO) {
        super();

        try {
            conexion = this.obtenerConexion();
            docenteid = fechaVO.getDocenteid();
            fechaingreso = fechaVO.getFechaingreso();
            fechasalida = fechaVO.getFechasalida();
            datosnumeroid = fechaVO.getDatosnumerid();
        } catch (Exception e) {
            Logger.getLogger(FechaingresoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregar() {
        
        try {
            sql = "insert into docente(fechaingreso, fechasalida, datosnumeroid) values(?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, fechaingreso);
            puente.setString(2, fechasalida);
            puente.setString(3, datosnumeroid);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {

            Logger.getLogger(FechaingresoDAO.class.getName()).log(Level.SEVERE, null, e);

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
