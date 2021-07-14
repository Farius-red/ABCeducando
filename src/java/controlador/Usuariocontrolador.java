/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modeloDAO.DatosPersonalesDAO;
import modeloDAO.UsuarioDAO;
import modeloVO.DatosPersonalesVO;
import modeloVO.UsuarioVO;

/**
 *
 * @author Hector
 */
@WebServlet(name = "Usuario", urlPatterns = {"/Usuario"})
@MultipartConfig
public class Usuariocontrolador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        //Recogemos datos
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        int usuarioid = 0 ;
         String usuariologin="";
        String usuarioPassword="";
        if(opcion != 3 && opcion != 4){
         usuarioid = Integer.parseInt(request.getParameter("textid"));
         usuariologin = request.getParameter("textusuario");
         usuarioPassword = request.getParameter("textclave");
       

      
        
        }
        
          //enviamos datos al vo
        UsuarioVO usuVO = new UsuarioVO(usuariologin, usuarioPassword, usuarioid);
        
       
     
        //Llamar al DAO y mandarlo los datos del VO
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
        HttpSession miSesion = null; 
        switch (opcion) {
            
            case 1://Iniciar Sesion

                if (usuDAO.iniciarSesion(usuariologin, usuarioPassword)) {
                    
                   miSesion = request.getSession(true);
                  
                    UsuarioDAO usuDaO = new UsuarioDAO(); 
                    
                    ArrayList<UsuarioVO> listaUsuario = usuDaO.sesionROl(usuariologin, usuarioPassword);
                    
                     String nombreRol;
                       nombreRol = listaUsuario.get(0).getNombrerol();
                       
                       Integer idrolYu = listaUsuario.get(0).getUsuarioid();
                       miSesion.setAttribute("datosUsuario", listaUsuario);
                     
                    
                    if("administrador".equals(nombreRol)){
                         request.setAttribute("usuario", idrolYu);
                    
                    request.getRequestDispatcher("administrativo.jsp").forward(request, response);
                    
                    }else if ( "estudiante".equals(nombreRol)){
                          request.setAttribute("usuario", idrolYu);
                             request.getRequestDispatcher("estudiante.jsp").forward(request, response);
                    } else if("docente".equals(nombreRol)){
                      request.setAttribute("usuario", idrolYu);
                         request.getRequestDispatcher("cargar_actividad.jsp").forward(request, response);
                    }else{
                            request.setAttribute("mensajeError", "Datos incorrectos");
                             request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                    
                    
                  

                                   
                } else {
                    
                    request.setAttribute("mensajeError", "Datos incorrectos");
                     request.getRequestDispatcher("login.jsp").forward(request, response);
                }

                //} 
                //else {
                //    request.setAttribute("mensajeError", "Datos incorrectos");
                //  request.getRequestDispatcher("login.jsp").forward(request, response);
                //}
                break;            
            case 2://Agregar Registro
                    
                    
                if (usuDAO.agregar()) {
              

                    request.setAttribute("mensajeExito", "¡El usuario se registro correctamente!");
                   if(miSesion == request.getSession() ){
                       request.getRequestDispatcher("login.jsp").forward(request, response);
                       
                   }else{
                       request.getRequestDispatcher("fechaingresoDocente.jsp").forward(request, response);
    
                 
                   }
                    
                } else {
                    
                    request.setAttribute("mensajeError", "¡El usuario no se registro correctamente!");
                    
                }
                
                
                
                break;
              
            case 3: // cargaMasiva de matriculas
                
             Part urlDocumento = request.getPart("urlArchivo");
            String nombreArchivo = request.getParameter("nombreArchivo");
            InputStream is = urlDocumento.getInputStream();
             File arch = new File("/home/daniel/Escritorio/proyectosjava/chinoSena/web/Doc/documentos/Excel/"+nombreArchivo);
             FileOutputStream out = new FileOutputStream(arch);
             
             int dato = is.read();
             while(dato != -1){
             
                 out.write(dato);
                 dato = is.read();
             }
             
             out.close();
             is.close();
                
              
            String rutaYnombre =  arch.getAbsolutePath();
        
           
            
                    if(usuDAO.cargarMatriculas(rutaYnombre)){
                          request.getRequestDispatcher("listaMatriculas.jsp").forward(request, response);
                          
                    }else{
                         request.setAttribute("mensajeError", "¡El archivo no se almaceno correctamente!");
                         request.getRequestDispatcher("registrar_matricula.jsp").forward(request, response);
                    }
                   
                break;
                case 4:
                      String datosnombres = request.getParameter("textnombres");
        String datosapellidos = request.getParameter("textapellidos");
        String datostipoid = request.getParameter("texttipoid");
        int idDatos = Integer.parseInt(request.getParameter("textnumeroid"));
        String datostelefono = request.getParameter("texttelefono");
        String datosemail = request.getParameter("textemail");
        String datosfechanac = request.getParameter("textfechanacimiento");

        DatosPersonalesVO datosVO = new DatosPersonalesVO(datosnombres, datosapellidos,
                datostipoid, idDatos, datostelefono, datosemail, datosfechanac);

        DatosPersonalesDAO datosDAO = new DatosPersonalesDAO(datosVO);
                if (datosDAO.agregar()) {

                    request.setAttribute("mensajeExito", "Se registro"
                            + "correctamente");
                     request.getRequestDispatcher("crear_usuario.jsp").forward(request, response);
                } else {

                    request.setAttribute("mensajeError", "No se registro correctamente");
                    request.getRequestDispatcher("crear_usuario.jsp").forward(request, response);
                    
                }
             

                break;
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Usuariocontrolador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Usuariocontrolador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
