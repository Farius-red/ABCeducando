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
import modeloVO.ListarUsuarioVO;
import modeloVO.RolVO;
import util.Conexion;

/**
 *
 * @author Hector
 */
public class ListarUsuarioDAO extends Conexion{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    public boolean operacion = false;
    public String sql;
    
    public ArrayList<ListarUsuarioVO> listarusuario() {

        ListarUsuarioVO listarusuarioVO = null;
        ArrayList<ListarUsuarioVO> listausuario = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select usuarioid, usuariologin from usuario";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                listarusuarioVO = new ListarUsuarioVO(mensajero.getString(1), mensajero.getString(2));

                listausuario.add(listarusuarioVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(ListarUsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ListarUsuarioVO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        
        return listausuario;

    }
    
}
