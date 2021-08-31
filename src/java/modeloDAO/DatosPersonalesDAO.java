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
    public String sql,sql2;

    private String datosnombres = "", datosapellidos = "", datostipoid = "", contra, 
            datostelefono = "", datosemail = "", datosfechanac = "",eps;
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
            eps = DatosVO.getEps();

        } catch (Exception e) {
            Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    @Override
    public boolean agregar() {

        try {
            sql = "INSERT INTO DatosUsuario(datostipoid,idDatos,nombre,apellidos,telefono,email,fechaNacimiento,EPS) VALUES(?,?,?,?,?,?,?,?)";
             
                    
                    
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datostipoid);
            puente.setInt(2, idDatos);
            puente.setString(3, datosnombres);
            puente.setString(4, datosapellidos);
            puente.setString(5, datostelefono);
            puente.setString(6, datosemail);
            puente.setString(7, datosfechanac);
             puente.setString(8, eps);
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
            sql = "SELECT nombre,apellidos,datostipoid,idDatos,telefono, email, fechaNacimiento,EPS FROM rolYu INNER JOIN usuarios on usuarios.usuarioid = rolYu.usuario\n" +
"INNER JOIN DatosUsuario ON DatosUsuario.idDatos = usuarios.usuarioid\n" +
"WHERE rolYu.rol = 3";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                datosVO = new DatosPersonalesVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getInt(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8)
                );

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
            sql = "SELECT nombre,apellidos,datostipoid,idDatos,telefono, email, fechaNacimiento,EPS,usuarioPassword FROM rolYu INNER JOIN usuarios on usuarios.usuarioid = rolYu.usuario\n" +
"INNER JOIN DatosUsuario ON DatosUsuario.idDatos = usuarios.usuarioid\n" +
"WHERE rolYu.rol = 2";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                datosVO = new DatosPersonalesVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getInt(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8),
                        mensajero.getString(9)
                );

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
   public boolean actualizar() {
         try {
            sql = "UPDATE DatosUsuario SET datostipoid=?,nombre=?,apellidos=?,telefono=?,email=? WHERE DatosUsuario.idDatos = ?";
             
                    
                    
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datostipoid);
           
            puente.setString(2, datosnombres);
            puente.setString(3, datosapellidos);
            puente.setString(4, datostelefono);
            puente.setString(5, datosemail);
         
            puente.setInt(6, idDatos);
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
    

    @Override
    public boolean listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean actualizarClave(String cla) {
         try {
            sql = "UPDATE DatosUsuario SET datostipoid=?,nombre=?,apellidos=?,telefono=?,email=? WHERE DatosUsuario.idDatos = ?";
             
                    
                    
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datostipoid);
           
            puente.setString(2, datosnombres);
            puente.setString(3, datosapellidos);
            puente.setString(4, datostelefono);
            puente.setString(5, datosemail);
         
            puente.setInt(6, idDatos);
            puente.executeUpdate();
            
            sql2 = "UPDATE usuarios SET usuariologin=?,usuarioid=?,usuarioPassword=?,datosUsuarioID=? WHERE datosUsuarioID = ?";
                    
            puente = conexion.prepareStatement(sql2);
            puente.setString(1,datosemail);
           
            puente.setInt(2, idDatos);
            puente.setString(3, cla);
            puente.setInt(4, idDatos);
             puente.setInt(5, idDatos);
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

    @Override
    public boolean eliminar(int id) {
        
        
              try {
                  
                  
                  
            conexion = this.obtenerConexion();
            
             sql2 = "DELETE FROM rolYu where id_rolYu =" + id;
            puente = conexion.prepareStatement(sql2);
            puente.executeUpdate();
            
            
            
               sql2 = "DELETE FROM usuarios where usuarioid =" + id;
            puente = conexion.prepareStatement(sql2);
            puente.executeUpdate();
           
           
            sql = "DELETE FROM DatosUsuario where idDatos =" + id;

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

    public boolean consultaClave(int idDatos) {
        
         DatosPersonalesVO datosVO = new DatosPersonalesVO();
        

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT usuarioPassword FROM usuarios WHERE usuarioid ="+idDatos;
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                
                datosVO = new DatosPersonalesVO(mensajero.getString(1));

                

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
        
        return operacion;
    }
    

}
