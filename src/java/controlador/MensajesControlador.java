package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.MensajesDAO;
import modeloVO.MensajesVO;
import util.Mensajes;

@WebServlet(name = "Mensajes", urlPatterns = {"/Mensajes"})
public class MensajesControlador extends HttpServlet {

    private String host;
    private String puerto;
    private String usuario;
    private String clave;
    private String receptor;
    private String asunto;
    private String contenido;
    private String mensaje;

    public void init() {

        ServletContext contexto = getServletContext();
        host = contexto.getInitParameter("host");
        puerto = contexto.getInitParameter("puerto");
        usuario = contexto.getInitParameter("usuario");
        clave = contexto.getInitParameter("clave");
    }

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

        int idMensaje = 0;

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        if (opcion != 1 && opcion != 3) {

            idMensaje = Integer.parseInt(request.getParameter("idMensaje"));

        }

        switch (opcion) {

            case 1: // Enviar y registar mensajes
                receptor = request.getParameter("receptor");
                asunto = request.getParameter("asunto");
                contenido = request.getParameter("contenido");

                MensajesVO mensVO = new MensajesVO(null, contenido, receptor);
                MensajesDAO mensDAO = new MensajesDAO(mensVO);

                try {

                    Mensajes.envioMensajes(host, puerto, usuario, clave, receptor, asunto, contenido);

                    if (mensDAO.agregarl(contenido, receptor)) {
                        mensaje = "El mensaje se almaceno correactamente y fue enviado";
                        request.setAttribute("mensajeExito", mensaje);
                        getServletContext().getRequestDispatcher("/crearmensaje.jsp").forward(request, response);

                    }

                } catch (Exception e) {
                    Logger.getLogger(MensajesControlador.class.getName()).log(Level.SEVERE, null, e);
                    mensaje = "error el mensaje no fue enviado";
                    request.setAttribute("mensajeError", mensaje);
                    getServletContext().getRequestDispatcher("/crearmensaje.jsp").forward(request, response);

                }

                break;

            case 2: // Eliminar mensajes 
                MensajesDAO eliminarM = new MensajesDAO();
                 {

                    if (eliminarM.eliminar(idMensaje)) {

                        request.setAttribute("mensajeExito", "El mensaje Se elimino correctamente");
                        getServletContext().getRequestDispatcher("/crearmensaje.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensajeError", "El No Se elimino correctamente");
                        getServletContext().getRequestDispatcher("/crearmensaje.jsp").forward(request, response);
                    }
                }
                break;

            case 3: // recuperar Contraseña 

                receptor = request.getParameter("receptor");
                asunto = "recuperar Contraseña";

                MensajesVO mensVo = new MensajesVO(null, contenido, receptor);
                MensajesDAO mensDAo = new MensajesDAO(mensVo);

                try {

                    
                     int clav = (int)(Math.random()*7350 +1131);
                     
                     String contra = String.valueOf(clav);
                        contenido = "su clave es :" + contra ;

                        if (mensDAo.CambiarClave(contra, receptor)) {
                            Mensajes.envioMensajes(host, puerto, usuario, clave, receptor, asunto, contenido);
                            request.setAttribute("mensajeExito", "El correo es valido enviamos la contraseña a su correo");
                            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                        }
                     else {
                        request.setAttribute("mensajeError", "El correo no es valido");
                        getServletContext().getRequestDispatcher("/recuperarClave.jsp").forward(request, response);
                    }

                } catch (Exception e) {

                    Logger.getLogger(MensajesControlador.class.getName()).log(Level.SEVERE, null, e);
                    request.setAttribute("mensajeError", "Algo salio mal");
                        getServletContext().getRequestDispatcher("/recuperarClave.jsp").forward(request, response);
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
}
