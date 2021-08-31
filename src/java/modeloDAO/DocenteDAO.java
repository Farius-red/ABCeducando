package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.ActividadCargadaVO;
import modeloVO.ActividadEntregadaVO;

import util.Conexion;
import util.Crud;

public class DocenteDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private Statement st;

    // datos de las tabla Actividad Cargada
    private int DocenteId;
    private String ActividadCargadaNombre, ActividadCargadaDescripcion, rutaArchivo;

    // tabla Actividad entregada 
    private int ActividadEntregadaId,  idActividadCargada, calificacion;
    private String ActividadEntregadaRuta,EstudianteId, ActividadEntregadaEstado;

    public DocenteDAO() {
    }

    //almacenamos las sentencias.
    public String sql, consul, sql2;

    public DocenteDAO(ActividadCargadaVO actividadCargada) {

        super();

        try {
            conexion = this.obtenerConexion();
            DocenteId = actividadCargada.getDocenteId();
            ActividadCargadaNombre = actividadCargada.getActividadCargadaNombre();
            ActividadCargadaDescripcion = actividadCargada.getActividadCargadaDescripcion();
            rutaArchivo = actividadCargada.getRutaArchivo();

        } catch (Exception e) {
            Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public DocenteDAO(ActividadEntregadaVO actividadEntregada) {

        super();

        try {
            conexion = this.obtenerConexion();
            ActividadEntregadaId = actividadEntregada.getActividadEntregadaId();
            EstudianteId = actividadEntregada.getEstudianteId();
            idActividadCargada = actividadEntregada.getIdActividadCargada();
            calificacion = actividadEntregada.getCalificacion();
            ActividadEntregadaRuta = actividadEntregada.getActividadEntregadaRuta();
            ActividadEntregadaEstado = actividadEntregada.getActividadEntregadaEstado();

        } catch (Exception e) {
            Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregar() {
        try {
            sql = "insert into ActividadCargada(ActividadCargadaNombre,ActividadCargadaDescripcion,rutaActividad,DocenteId ) values(?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ActividadCargadaNombre);
            puente.setString(2, ActividadCargadaDescripcion);
            puente.setString(3, rutaArchivo);
            puente.setInt(4, DocenteId);

            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {

            Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                System.out.println(e.toString());
            }

        }
        return operacion;
    }

    public ArrayList<ActividadCargadaVO> listarActivades(Integer idDocente) {

        ActividadCargadaVO actiC = null;
        ArrayList<ActividadCargadaVO> listaActi = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT ActividadCargadaId,ActividadCargadaNombre,ActividadCargadaDescripcion,rutaActividad FROM ActividadCargada where Docenteid =?";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, idDocente);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                actiC = new ActividadCargadaVO(
                        mensajero.getInt(1),
                        mensajero.getString(2),
                        mensajero.getString(3),
                        mensajero.getString(4)
                );
                listaActi.add(actiC);

            }
        } catch (SQLException e) {
            Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }

        return listaActi;

    }

    public ArrayList<ActividadEntregadaVO> listarActivadesEntregadas(int idDocente) {

        ActividadEntregadaVO actiE = null;
        ArrayList<ActividadEntregadaVO> listaActi = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT ActividadEntregadaId, EstudianteId,idActividadCargada, Calificacion, ActividadEntregadaRuta ,ActividadEntregadaEstado FROM ActividadEntregada INNER JOIN ActividadCargada on ActividadCargada.ActividadCargadaId =idActividadCargada\n" +
"where  ActividadCargada.DocenteId = ? ";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, idDocente);
              mensajero = puente.executeQuery();

            while (mensajero.next()) {
                actiE = new ActividadEntregadaVO(
                        mensajero.getInt(1),
                        mensajero.getString(2),
                        mensajero.getInt(3),
                        mensajero.getInt(4),
                        mensajero.getString(5),
                        mensajero.getString(6)
                );
                listaActi.add(actiE);

            }
        } catch (SQLException e) {
            Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }

        return listaActi;

    }
    
    
    public ArrayList<ActividadEntregadaVO> listarnotas(int idDocente) {

        ActividadEntregadaVO actiE = null;
        ArrayList<ActividadEntregadaVO> listaActi = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT ActividadEntregadaId, EstudianteId,idActividadCargada, Calificacion, ActividadEntregadaRuta ,ActividadEntregadaEstado FROM ActividadEntregada INNER JOIN ActividadCargada on ActividadCargada.ActividadCargadaId =idActividadCargada\n" +
"where  ActividadCargada.DocenteId = ? and ActividadEntregadaEstado ='calificado' GROUP BY EstudianteId";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, idDocente);
              mensajero = puente.executeQuery();

            while (mensajero.next()) {
                actiE = new ActividadEntregadaVO(
                        mensajero.getInt(1),
                        mensajero.getString(2),
                        mensajero.getInt(3),
                        mensajero.getInt(4),
                        mensajero.getString(5),
                        mensajero.getString(6)
                );
                listaActi.add(actiE);

            }
        } catch (SQLException e) {
            Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }

        return listaActi;

    }
    
    
    public boolean calificar(String estado, int calificacion, int idActividad) {
        try {
             conexion = this.obtenerConexion();
            sql = "UPDATE ActividadEntregada SET  ActividadEntregadaEstado=?, Calificacion=? WHERE ActividadEntregada.ActividadEntregadaId =?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, estado);
            puente.setInt(2, calificacion);
            puente.setInt(3, idActividad);
            

            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {

            Logger.getLogger(DocenteDAO.class.getName()).log(Level.SEVERE, null, e);

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
    public boolean eliminar(int id) {

        try {
            conexion = this.obtenerConexion();
            sql = "DELETE FROM ActividadCargada where ActividadCargadaId =" + id;

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

}
