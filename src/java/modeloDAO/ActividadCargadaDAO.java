package modeloDAO;

import util.Conexion;
import modeloVO.ActividadCargadaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActividadCargadaDAO {

    /*Metodo listar*/
    public ArrayList<ActividadCargadaVO> Listar_ActividadCargadaVO() {
        ArrayList<ActividadCargadaVO> list = new ArrayList<ActividadCargadaVO>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM actividadcargada;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.obtenerConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ActividadCargadaVO vo = new ActividadCargadaVO();
                vo.setActividadcargadaid(rs.getInt(1));
                vo.setActividadcargadanombre(rs.getString(2));
                vo.setActividadcargadadescripcion(rs.getString(3));
                vo.setActcararchivo2(rs.getBytes(4));
                vo.setDocenteid(rs.getInt(5));
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
    public void Agregar_ActividadCargadaVO(ActividadCargadaVO vo) {
        Conexion conec = new Conexion();
        String sql = "INSERT INTO actividadcargada (actividadcargadaid, actividadcargadanombre, actividadcargadadescripcion, actcaraarchivo, docenteid) VALUES(?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.obtenerConexion().prepareStatement(sql);
            ps.setInt(1, vo.getActividadcargadaid());
            ps.setString(2, vo.getActividadcargadanombre());
            ps.setString(3, vo.getActividadcargadadescripcion());
            ps.setBlob(4, vo.getActcararchivo());
            ps.setInt(5, vo.getDocenteid());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
                        Logger.getLogger(ActividadCargadaDAO.class.getName()).log(Level.SEVERE, null, ex);

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
    public void Modificar_ActividadCargadaVO(ActividadCargadaVO vo) {
        Conexion conec = new Conexion();
        String sql = "UPDATE actividadcargada SET actividadcargadanombre = ?, actividadcargadadescripcion = ?, actcaraarchivo = ? WHERE actividadcargadaid = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.obtenerConexion().prepareStatement(sql);
            ps.setString(1, vo.getActividadcargadanombre());
            ps.setString(2, vo.getActividadcargadadescripcion());
            ps.setBlob(3, vo.getActcararchivo());
            ps.setInt(4, vo.getActividadcargadaid());
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
    public void Modificar_ActividadCargadaVO2(ActividadCargadaVO vo) {
        Conexion conec = new Conexion();
        String sql = "UPDATE actividadcargada SET actividadcargadanombre = ? WHERE actividadcargadaid = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.obtenerConexion().prepareStatement(sql);
            ps.setString(1, vo.getActividadcargadanombre());
            ps.setString(2, vo.getActividadcargadadescripcion());
            ps.setInt(3, vo.getActividadcargadaid());
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
    public void Eliminar_ActividadCargadaVO(int id) {
        Conexion conec = new Conexion();
        String sql = "DELETE FROM actividadcargada WHERE actividadcargadaid = ?;";
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
    public ActividadCargadaVO getPdfVOById(int studentId) {
        ActividadCargadaVO vo = new ActividadCargadaVO();
        Conexion db = new Conexion();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "SELECT * FROM actividadcargada WHERE actividadcargadaid = ?;";
        try {
            preparedStatement = db.obtenerConexion().prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                vo.setActividadcargadaid(rs.getInt(1));
                vo.setActividadcargadanombre(rs.getString(2));
                vo.setActividadcargadadescripcion(rs.getString(3));
                vo.setActcararchivo2(rs.getBytes(4));
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
