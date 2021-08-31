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

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modeloDAO.DocenteDAO;
import modeloVO.ActividadCargadaVO;


/**
 *
 * @author Hector
 */
@WebServlet(name ="Docente", urlPatterns = {"/Docente"})
@MultipartConfig
public class Docentecontrolador extends HttpServlet {

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

        String opcion = request.getParameter("opcion");
        


        

        switch (opcion) {

            case "registrar": // cargar pdf
                
            Part urlDocumento = request.getPart("urlArchivo");
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String descripcion = request.getParameter("descripcion");
            InputStream is = urlDocumento.getInputStream();
            String nombreArchivo = urlDocumento.getSubmittedFileName();
            File arch = new File("/home/daniel/Escritorio/proyectosjava/chinoSena/web/Doc/documentos/pdf/"+nombreArchivo);
            FileOutputStream out = new FileOutputStream(arch);
            String rutaArchivo ="/Doc/documentos/pdf/"+nombreArchivo;
             
             
            ActividadCargadaVO actividadCargada = new ActividadCargadaVO(nombreArchivo, descripcion,rutaArchivo,idUsuario);
            DocenteDAO docenteDao = new DocenteDAO(actividadCargada);
             
             int dato = is.read();
             while(dato != -1){
             
                 out.write(dato);
                 dato = is.read();
             }
             
             out.close();
             is.close();
                     
           if(docenteDao.agregar()){
                request.setAttribute("mensajeExito", "¡La Actividad se registro correctamente!");
                request.getRequestDispatcher("listar_actividad.jsp").forward(request, response);
           
           }else{
            request.setAttribute("mensajeError", "¡La actividad no se pudo registrar  correctamente!");
                request.getRequestDispatcher("cargar_actividad.jsp").forward(request, response);
           
           }
                break;
                
            case "eliminar": //eliminar pdf 
               int idActividad = Integer.parseInt(request.getParameter("idAcrividad"));
               String urlArchiv= request.getParameter("urlArchivo");
                     File archivo = new File(urlArchiv);
                     archivo.delete();
                     
                DocenteDAO doce  = new DocenteDAO();
                if(doce.eliminar(idActividad)){
                 request.setAttribute("mensajeExito", "¡Se Elimino  correctamente la activida con id!"+ idActividad);
                request.getRequestDispatcher("listar_actividad.jsp").forward(request, response);
                    
                } else {
                    request.setAttribute("mensajeError", "¡La actividad no se pudo Eliminar!");
                request.getRequestDispatcher("listar_actividad.jsp").forward(request, response);
            }
            
                    break;
                    
            case "calificar":
                
                 String estado = request.getParameter("estado");
                 int idActivida = Integer.parseInt(request.getParameter("idAcrividad"));
                 int calificacion  = Integer.parseInt(request.getParameter("calificacion"));
                   DocenteDAO docetedao  = new DocenteDAO();
                   
                 if(docetedao.calificar(estado, calificacion, idActivida)){
                  request.setAttribute("mensajeExito", "¡Su calificaicon se registro correctamente!");
                request.getRequestDispatcher("listar_actividades_entregadas.jsp").forward(request, response);
                 
                 }else{
                 
                     request.setAttribute("mensajeError", "¡La actividad no se pudo ser Calificada!");
                request.getRequestDispatcher("listar_actividades_entregadas.jsp").forward(request, response);
                 }
                
                break;
                
            case "reporte":
                 
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
