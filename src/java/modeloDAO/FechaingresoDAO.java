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
public class FechaingresoDAO extends Conexion {

    //Declara elementos para manipulacion.
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    //almacenamos el resultado de la operacion.
    public boolean operacion = false;
    //almacenamos las sentencias.
    public String sql, consulta;
    int idDat ;


    private String fechaingreso = "", fechasalida = "";
    private int docenteid, datosnumeroid;
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


    public boolean agregarFechas(Integer datosnuemroid, Integer rol) {
        
        try {
                
     
            
             sql = "insert into rolYu(id_rolYu, rol,usuario,fechaingreso, fechasalida) values(?,?,?,?,?)";
            
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, datosnuemroid);
            puente.setInt(2, rol);
            puente.setInt(3, datosnuemroid);
            puente.setString(4,fechaingreso);
            puente.setString(5, fechasalida);
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

    

}
