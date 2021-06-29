
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
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
    private String receptor ;
    private String asunto;
    private  String contenido ;
    private String mensaje;
    public void init(){
    
        ServletContext  contexto = getServletContext();
        host = contexto.getInitParameter("host");
        puerto = contexto.getInitParameter("puerto");
        usuario= contexto.getInitParameter("usuario");
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
       
        receptor =request.getParameter("receptor");
       asunto = request.getParameter("asunto");
        contenido = request.getParameter("contenido");
        
        
        MensajesVO mensVO = new MensajesVO(null,contenido,receptor);
        MensajesDAO mensDAO = new MensajesDAO(mensVO);
        
        try {
            Mensajes.envioMensajes(host,puerto,usuario,clave,receptor,asunto,contenido);
            
          
            
           
            
            
             if(mensDAO.agregarl(contenido,receptor)){
              mensaje = "El mensae se almaceno correactamente";
              
              
               
        }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            mensaje = "error el mensaje no fue enviado";
            System.out.println("erro" + e.toString());
        }finally{
         request.setAttribute("mensaje", mensaje);
         getServletContext().getRequestDispatcher("/crearmensaje.jsp").forward(request, response);
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
