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

public class EstudianteDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false, validar;
    private Statement st;
    

    // datos de las tabla Actividad Cargada
    private int DocenteId;
    private String ActividadCargadaNombre, ActividadCargadaDescripcion, rutaArchivo;

    // tabla Actividad entregada 
    private int ActividadEntregadaId, idActividadCargada, calificacion;
    private String ActividadEntregadaRuta, EstudianteId, ActividadEntregadaEstado;
    
    private boolean comparacion;

    public EstudianteDAO() {
    }

    //almacenamos las sentencias.
    public String sql, consul, sql2;

    public EstudianteDAO(ActividadCargadaVO actividadCargada) {

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

    public EstudianteDAO(ActividadEntregadaVO actividadEntregada) {

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
            sql = "insert into ActividadEntregada(EstudianteId,idActividadCargada,ActividadEntregadaRuta ) values(?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, EstudianteId);
            puente.setInt(2, idActividadCargada);
            puente.setString(3, ActividadEntregadaRuta);
            

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

      public ArrayList<ActividadEntregadaVO> listarActivadesEntregadas(String idEstudiante) {

        ActividadEntregadaVO actiE = null;
        ArrayList<ActividadEntregadaVO> listaActi = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT ActividadEntregadaId,idActividadCargada,Calificacion,ActividadEntregadaRuta,ActividadEntregadaEstado FROM ActividadEntregada where ActividadEntregada.EstudianteId =?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idEstudiante);
              mensajero = puente.executeQuery();

            while (mensajero.next()) {
                actiE = new ActividadEntregadaVO(
                        mensajero.getInt(1),
                        mensajero.getInt(2),
                        mensajero.getInt(3),
                        mensajero.getString(4),
                        mensajero.getString(5)
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
      
      
       public ArrayList<ActividadEntregadaVO> listarNotas(String idEstudiante) {

        ActividadEntregadaVO actiC = null;
        ArrayList<ActividadEntregadaVO> listaActi = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT ActividadEntregadaId, idActividadCargada,Calificacion,ActividadEntregadaEstado FROM ActividadEntregada WHERE EstudianteId =?  ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idEstudiante);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                actiC = new ActividadEntregadaVO(
                        mensajero.getInt(1),
                        mensajero.getInt(2),
                        mensajero.getInt(3),
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
    public ArrayList<ActividadCargadaVO> listarActivadesPendientes(String Estudianteid) {

        ActividadCargadaVO actiC = null;
        ArrayList<ActividadCargadaVO> listaActi = new ArrayList<>();
        ActividadEntregadaVO actividEntregada = null;
        ArrayList<ActividadEntregadaVO> listaEntrega = new ArrayList<>();
        ArrayList<ActividadCargadaVO> pendientes = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT ActividadCargadaId,ActividadCargadaNombre,ActividadCargadaDescripcion,rutaActividad,DocenteId FROM ActividadCargada";
            puente = conexion.prepareStatement(sql);

            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                actiC = new ActividadCargadaVO(
                        mensajero.getInt(1),
                        mensajero.getString(2),
                        mensajero.getString(3),
                        mensajero.getString(4),
                        mensajero.getInt(5)
                );
                listaActi.add(actiC);

            }

            consul = "SELECT idActividadCargada  FROM ActividadEntregada where EstudianteId =?";
            puente = conexion.prepareStatement(consul);
            puente.setString(1, Estudianteid);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                actividEntregada = new ActividadEntregadaVO(
                        mensajero.getInt(1)
                );
                listaEntrega.add(actividEntregada);

            }

            for (int i = 0; i < listaActi.size(); i++) {
                idActividadCargada = listaActi.get(i).getActividadCargadaId();
            
           int j =0;
                if(listaEntrega.isEmpty()){
                     pendientes.add(listaActi.get(i));
            }
               
                while(j < listaEntrega.size()  ){
                    
            int actividad  =  listaEntrega.get(j).getIdActividadCargada();
                    
                 if( idActividadCargada != actividad){
                     
                     if(i==j){
                     pendientes.add(listaActi.get(i));
                     }else if(listaEntrega.size() != listaActi.size()){
                      pendientes.add(listaActi.get(i));
                     }
                   }
                 
                 j++;
                }
             
                
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

        return pendientes;

    }

    public ArrayList<ActividadEntregadaVO> listarActivadesEntregadas(int idDocente) {

        ActividadEntregadaVO actiE = null;
        ArrayList<ActividadEntregadaVO> listaActi = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT ActividadEntregadaId, EstudianteId,idActividadCargada, Calificacion, ActividadEntregadaRuta ,ActividadEntregadaEstado FROM ActividadEntregada"
                    + "where  ActividadCargada.DocenteId = ?";
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
