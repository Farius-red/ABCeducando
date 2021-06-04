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
import modeloVO.RolVO;
import modeloVO.UsuarioRolVO;
import util.Conexion;

/**
 *
 * @author Hector
 */
public class RolDAO extends Conexion{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    public boolean operacion = false;
    public String sql;
    
    public ArrayList<RolVO> listar() {

        RolVO rolVO = null;
        ArrayList<RolVO> listaRol = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from rol";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                rolVO = new RolVO(mensajero.getString(1), mensajero.getString(2));

                listaRol.add(rolVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        
        return listaRol;

    }
    
}
