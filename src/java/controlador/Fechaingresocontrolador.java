/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.FechaingresoDAO;
import modeloDAO.UsuarioDAO;
import modeloVO.FechaIngresoVO;
import modeloVO.UsuarioVO;

/**
 *
 * @author Hector
 */
@WebServlet(name = "Fechaingresocontrolador", urlPatterns = {"/Fechaingreso"})
public class Fechaingresocontrolador extends HttpServlet {

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
        String docenteid = request.getParameter("textid");
        String fechaingreso = request.getParameter("textfechaingreso");
        String fechasalida = request.getParameter("textfechasalida");
        String datosnumeroid = request.getParameter("textdocumentoid");

        //enviamos datos al vo
        FechaIngresoVO fechaVO = new FechaIngresoVO(docenteid, fechaingreso, fechasalida, datosnumeroid);

        //Llamar al DAO y mandarlo los datos del VO
        FechaingresoDAO fechaDAO = new FechaingresoDAO(fechaVO);
        
        switch (opcion) {

            
                
                case 1://Agregar Registro

                if (fechaDAO.agregar()) {

                    request.setAttribute("mensajeExito", "¡El usuario se registro correctamente!");
                    request.getRequestDispatcher("crear_usuario.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "¡El usuario no se registro correctamente!");

                }
                request.getRequestDispatcher("fechaingresoDocente.jsp").forward(request, response);
                

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
