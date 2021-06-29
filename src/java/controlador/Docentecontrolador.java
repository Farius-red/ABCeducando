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
import modeloDAO.DatosPersonalesDAO;
import modeloVO.DatosPersonalesVO;

/**
 *
 * @author Hector
 */
@WebServlet(name = "Docente", urlPatterns = {"/Docente"})
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

        int opcion = Integer.parseInt(request.getParameter("opcion"));
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

        switch (opcion) {

            case 1:

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
