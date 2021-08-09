/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.UsuarioVO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.Conexion;
import util.Crud;
import util.Excel;

/**
 *
 * @author Hector
 */
public class UsuarioDAO extends Conexion implements Crud {

    //Declara elementos para manipulacion.
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
  
    //almacenamos las sentencias.
    public String sql, consul,sql2;

    private String usuariologin, usuarioPassword, nombres, apellidos, email, nombrerol, telefono;
    private Integer usuarioid;
    private Date fechaNacimiento;

    public UsuarioDAO(UsuarioVO usuVO) {
        super();

        try {
            conexion = this.obtenerConexion();
            usuarioid = usuVO.getUsuarioid();
            usuariologin = usuVO.getUsuariologin();
            usuarioPassword = usuVO.getUsuarioPassword();
            nombres = usuVO.getNombre();
            apellidos = usuVO.getApellidos();
            email = usuVO.getEmail();
            nombrerol = usuVO.getNombrerol();
            telefono = usuVO.getTelefono();
            fechaNacimiento = usuVO.getFechaNacimiento();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public UsuarioDAO() {
        //To change body of generated methods, choose Tools | Templates.
    }

    // este metodo solicita dos parametros y retorna un objeto que contine los datos de la sesion
    public boolean iniciarSesion(String usuario, String clave) {

        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuarios where usuariologin = ? "
                    + "and usuarioPassword = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {
                operacion = true;

            }

        } catch (SQLException e) {
             Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public ArrayList<UsuarioVO> sesionROl(String usuariologin, String clave) {

        UsuarioVO usuVO;
        ArrayList<UsuarioVO> listausu = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT usuarioid, usuariologin,nombreRol,rol,nombre,apellidos,email,fechaNacimiento,telefono FROM rolYu inner JOIN usuarios on usuarios.usuarioid = rolYu.usuario INNER JOIN DatosUsuario on DatosUsuario.idDatos = usuarios.datosUsuarioID INNER JOIN ROL ON ROL.idRol = rolYu.rol WHERE usuarios.usuariologin=? and usuarios.usuarioPassword=?";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuariologin);
            puente.setString(2, clave);

            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                usuVO = new UsuarioVO(
                        mensajero.getInt("usuarioid"),
                        mensajero.getString("usuariologin"),
                        mensajero.getString("nombreRol"),
                        mensajero.getInt("rol"),
                        mensajero.getString("nombre"),
                        mensajero.getString("apellidos"),
                        mensajero.getString("email"),
                        mensajero.getDate("fechaNacimiento"),
                        mensajero.getString("telefono")
                );

                listausu.add(usuVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }

        return listausu;

    }

    public boolean cargarMatriculas(String urlDocumento) throws IOException, SQLException {

        Excel excel = new Excel();
  UsuarioVO usuvo = new UsuarioVO();
  ArrayList <UsuarioVO>cargarMatricula = new ArrayList<>();
        try {
            
               FileInputStream archivo = new FileInputStream(urlDocumento);
        XSSFWorkbook libro = new XSSFWorkbook(archivo);
        XSSFSheet hoja = libro.getSheetAt(0);
        
        
        int numero_filas = hoja.getLastRowNum();
       for (int i = 0; i <= numero_filas; i++) {

                Row fila = hoja.getRow(i);
                
                 // crea datos usuario 
                consul="insert into DatosUsuario(idDatos,datostipoid,nombre,apellidos,telefono,email) values(?,?,?,?,?,?)";
                puente = conexion.prepareStatement(consul);
                double cellu = fila.getCell(0).getNumericCellValue();
                int idu = (int) cellu;
                
              email = fila.getCell(6).getStringCellValue();
                
                
                puente.setInt(1, idu);
                puente.setString(2, fila.getCell(2).getStringCellValue());
                puente.setString(3,fila.getCell(3).getStringCellValue());
                puente.setString(4, fila.getCell(4).getStringCellValue());
                  double tel = fila.getCell(5).getNumericCellValue();
                  int tele = (int) tel;
                  String telefono = String.valueOf(tele);
                puente.setString(5, telefono);
                puente.setString(6, email);
            
                
                
                puente.executeUpdate();
                
                
                // crear usuario 
                
                sql = "insert into usuarios(usuarioid,usuariologin, usuarioPassword,datosUsuarioID) values(?,?,?,?)";
                puente = conexion.prepareStatement(sql);
                puente.setInt(1, idu);
               puente.setString(2, email);
                puente.setString(3, "123456");
                puente.setInt(4, idu);
               puente.executeUpdate();
                
               
               // crea el rol 
               
               sql2 = "insert into rolYu(id_rolYu,rol,usuario) values(?,?,?)";
                 puente = conexion.prepareStatement(sql2);
               puente.setInt(1, idu);
                puente.setInt(2, 2);
                 puente.setInt(3, idu);

               puente.executeUpdate();
                
               
               
                
            }
           
           
            
            
     
            // si la lista que trae de el metodo de carga de matriculas tiene datos 
            // los itera y los inserta en la base de datos
         //   if(!cargarMatricula.isEmpty()){
          // for (int i = 0; i < cargarMatricula.size(); i++) {
                //usuvo= (UsuarioVO) cargarMatricula.get(i);
            
                
                // consul="insert into DatosUsuario(idDatos,datostipoid,nombre,apellidos,telefono,email,EPS) values(?,?,?,?,?,?,?)";
               // puente = conexion.prepareStatement(consul);
               // puente.setInt(1, usuvo.getUsuarioid());
               // puente.setString(2, usuvo.getDatostipoid());
               // puente.setString(3, usuvo.getNombre());
               // puente.setString(4, usuvo.getApellidos());
               // puente.setString(5, usuvo.getTelefono());
               // puente.setString(6, usuvo.getEmail());
               // puente.setDate(7, usuvo.getFechaNacimiento());
                
              //  puente.executeUpdate();
                
               // sql = "insert into usuarios(usuarioid,usuariologin, usuarioPassword) values(?,?,?)";
                //puente = conexion.prepareStatement(sql);
                //puente.setInt(1, usuvo.getUsuarioid());
               // puente.setString(2, usuvo.getEmail());
                //puente.setString(3, usuvo.getUsuarioPassword());

               // puente.executeUpdate();
            
                 
                //  sql2 = "insert into rolYu(id_rolYu,rol,usuario) values(?,?,?,?)";
                //  puente = conexion.prepareStatement(sql2);
               //  puente.setInt(1, usuvo.getUsuarioid());
               // puente.setInt(2, 2);
                 // puente.setInt(3, usuvo.getUsuarioid());

               // puente.executeUpdate();
                
                
                 
               // sql2 = "insert into Matricula(MatriculaId,EstudianteId) values(?,?)";
               // puente = conexion.prepareStatement(sql2);
           //puente.setInt(1, usuvo.getUsuarioid());
             //   puente.setInt(2, usuvo.getUsuarioid());

              //  puente.executeUpdate();
            
            
                   
           
                   operacion = true;
             
            //}

        } catch (IOException | SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.cerrarConexion();
        }

        return operacion;
    }

   

    @Override
    public boolean agregar() {

        try {
            sql = "insert into usuarios(usuarioid,usuariologin, usuarioPassword,datosUsuarioID) values(?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, usuarioid);
            puente.setString(2, usuariologin);
            puente.setString(3, usuarioPassword);
             puente.setInt(4, usuarioid);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                System.out.println(e.toString());
            }

        }
        return operacion;

    }

    public ArrayList<UsuarioVO> listarusu() {

        UsuarioVO usuVO = null;
        ArrayList<UsuarioVO> listausu = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT usuarioid, usuariologin,nombreRol,nombre,apellidos,email,fechaNacimiento,telefono FROM rolYu inner JOIN usuarios on usuarios.usuarioid = rolYu.id_rolYu INNER JOIN DatosUsuario on DatosUsuario.idDatos = usuarios.usuarioid INNER JOIN ROL ON ROL.idRol = DatosUsuario.idDatos ";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                usuVO.setUsuarioid(mensajero.getInt(1));
                usuVO.setUsuariologin(mensajero.getString(2));
                usuVO.setNombrerol(mensajero.getString("nombreRol"));
                usuVO.setNombre(mensajero.getString("nombre"));
                usuVO.setApellidos(mensajero.getString("apellidos"));
                usuVO.setTelefono(mensajero.getString("telefono"));
                usuVO.setEmail(mensajero.getString("email"));
                usuVO.setFechaNacimiento(mensajero.getDate("fechaNacimiento"));

                listausu.add(usuVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }

        return listausu;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
