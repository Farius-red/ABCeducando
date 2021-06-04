package modeloDAO;

import util.Conexion;
import modeloVO.ActividadEntregadaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActividadEntregadaDAO {

    /*Metodo listar*/
    public ArrayList<ActividadEntregadaVO> Listar_ActividadEntregadaVO() {
        ArrayList<ActividadEntregadaVO> list = new ArrayList<ActividadEntregadaVO>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM actividadentregada;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.obtenerConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ActividadEntregadaVO vo = new ActividadEntregadaVO();
                vo.setActividadentregadaid(rs.getInt(1));
                vo.setActividadentregadanombre(rs.getString(2));
                vo.setActividadentregadadescripcion(rs.getString(3));
                vo.setActividadentregadaarchivo2(rs.getBytes(4));
                vo.setActividadentregadaestado(rs.getString(5));
                vo.setEstudianteid(rs.getInt(6));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.cerrarConexion();
            } catch (Exception ex) {
            }
        }
        return list;
    }


    /*Metodo agregar*/
    public void Agregar_ActividadEntregadaVO(ActividadEntregadaVO vo) {
        Conexion conec = new Conexion();
        String sql = "INSERT INTO actividadentregada (actividadentregadaid, actividadentregadanombre, actividadentregadadescripcion, actividadentregadaarchivo, actividadentregadaestado, estudianteid) VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.obtenerConexion().prepareStatement(sql);
            ps.setInt(1, vo.getActividadentregadaid());
            ps.setString(2, vo.getActividadentregadanombre());
            ps.setString(3, vo.getActividadentregadadescripcion());
            ps.setBlob(4, vo.getActividadentregadaarchivo());
            ps.setString(5, vo.getActividadentregadaestado());
            ps.setInt(6, vo.getEstudianteid());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
                        Logger.getLogger(ActividadEntregadaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.cerrarConexion();
            } catch (Exception ex) {
            }
        }
    }


    /*Metodo Modificar*/
    public void Modificar_ActividadEntregadaVO(ActividadEntregadaVO vo) {
        Conexion conec = new Conexion();
        String sql = "UPDATE actividadentregada SET actividadentregadaombre = ?, actividadentregadadescripcion = ?, actividadentregadaarchivo = ? WHERE actividadentregadaid = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.obtenerConexion().prepareStatement(sql);
            ps.setString(1, vo.getActividadentregadanombre());
            ps.setString(2, vo.getActividadentregadadescripcion());
            ps.setBlob(3, vo.getActividadentregadaarchivo());
            ps.setInt(4, vo.getActividadentregadaid());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.cerrarConexion();
            } catch (Exception ex) {
            }
        }
    }

    /*Metodo Modificar*/
    public void Modificar_ActividadEntregadaVO2(ActividadEntregadaVO vo) {
        Conexion conec = new Conexion();
        String sql = "UPDATE actividadentregada SET actividadentregadanombre = ? WHERE actividadentregadaid = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.obtenerConexion().prepareStatement(sql);
            ps.setString(1, vo.getActividadentregadanombre());
            ps.setString(2, vo.getActividadentregadadescripcion());
            ps.setInt(3, vo.getActividadentregadaid());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.cerrarConexion();
            } catch (Exception ex) {
            }
        }
    }

    /*Metodo Eliminar*/
    public void Eliminar_ActividadEntregadaVO(int id) {
        Conexion conec = new Conexion();
        String sql = "DELETE FROM actividadentregada WHERE actividadentregadaid = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.obtenerConexion().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.cerrarConexion();
            } catch (Exception ex) {
            }
        }
    }


    /*Metodo Consulta id*/
    public ActividadEntregadaVO getPdfVOById(int studentId) {
        ActividadEntregadaVO vo = new ActividadEntregadaVO();
        Conexion db = new Conexion();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "SELECT * FROM actividadentregada WHERE actividadentregadaid = ?;";
        try {
            preparedStatement = db.obtenerConexion().prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                vo.setActividadentregadaid(rs.getInt(1));
                vo.setActividadentregadanombre(rs.getString(2));
                vo.setActividadentregadadescripcion(rs.getString(3));
                vo.setActividadentregadaarchivo2(rs.getBytes(4));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                preparedStatement.close();
                db.cerrarConexion();
            } catch (Exception ex) {
            }
        }
        return vo;
    }

}
