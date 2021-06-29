/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeloDAO.UsuarioDAO;
import modeloVO.UsuarioVO;

/**
 *
 * @author Hector
 */
@WebServlet(name = "Usuario", urlPatterns = {"/Usuario"})
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Recogemos datos
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        int usuarioid = Integer.parseInt(request.getParameter("textid"));
        String usuariologin = request.getParameter("textusuario");
        String usuarioPassword = request.getParameter("textclave");

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
                    miSesion.setAttribute("datosUsuario", listaUsuario);
                    
                    
                    if("administrador" != listaUsuario.get(0).getNombrerol() ){
                        System.out.print(listaUsuario.get(0).getNombrerol());
                    request.getRequestDispatcher("administrativo.jsp").forward(request, response);
                    
                    }else if (listaUsuario.indexOf("estudiante") != -1){
                        
                             request.getRequestDispatcher("estudiante.jsp").forward(request, response);
                    } else if(listaUsuario.indexOf("docente") != -1){
                    
                         request.getRequestDispatcher("docente.jsp").forward(request, response);
                    }else{
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
        processRequest(request, response);
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
        processRequest(request, response);
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
