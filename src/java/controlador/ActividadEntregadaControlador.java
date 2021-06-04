package controlador;

import util.sql;
import modeloDAO.ActividadEntregadaDAO;
import modeloVO.ActividadEntregadaVO;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "ActividadEntregada", urlPatterns = {"/ActividadEntregada"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB

public class ActividadEntregadaControlador extends HttpServlet {

    public static final String lIST_STUDENT = "/listar_actividades_entregada.jsp";
    public static final String INSERT_OR_EDIT = "/entregar_actividad.jsp";

    String estado = null;
    ActividadEntregadaDAO actividadentregadadao;
    int id_pdf = -1;

    public ActividadEntregadaControlador() {
        actividadentregadadao = new ActividadEntregadaDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            forward = lIST_STUDENT;
            int studentId = Integer.parseInt(request.getParameter("id"));
            actividadentregadadao.Eliminar_ActividadEntregadaVO(studentId);
        }
        if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int studentIdM = Integer.parseInt(request.getParameter("id"));
            id_pdf = studentIdM;
            ActividadEntregadaVO actividadcargadavo = actividadentregadadao.getPdfVOById(studentIdM);
            request.setAttribute("row", actividadcargadavo);
            boolean boo = false;
            if (actividadcargadavo.getActividadentregadaarchivo2()!= null) {
                boo = true;
            }
            request.setAttribute("row2", boo);
            estado = "edit";
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
            estado = "insert";
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ActividadEntregadaVO actividadentregadavo = new ActividadEntregadaVO();
        sql auto = new sql();
        int nuevoid = auto.auto_increm("SELECT MAX(actividadentregadaid) FROM actividadentregada;");
        
        try{
            String name = request.getParameter("txtname");
            actividadentregadavo.setActividadentregadanombre(name);
        }catch(Exception ex){
            System.out.println("nombre: "+ex.getMessage());
        }
        
        try{
            String descripcion = request.getParameter("textdescripcion");
            actividadentregadavo.setActividadentregadadescripcion(descripcion);
        }catch(Exception ex){
            System.out.println("nombre: "+ex.getMessage());
        }

        InputStream inputStream = null;
        try {
            Part filePart = request.getPart("fichero");
            if (filePart.getSize() > 0) {
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
                inputStream = filePart.getInputStream();
            }
        } catch (Exception ex) {
            System.out.println("fichero: "+ex.getMessage());
        }
        
        try{
            String descripcion = request.getParameter("textestado");
            actividadentregadavo.setActividadentregadaestado(descripcion);
        }catch(Exception ex){
            System.out.println("nombre: "+ex.getMessage());
        }
        
        try{
            int Docente = Integer.parseInt(request.getParameter("textestudianteid")); 
            actividadentregadavo.setEstudianteid(Docente);
        }catch(Exception ex){
            System.out.println("nombre: "+ex.getMessage());
        }

        try {
            
            if (estado.equalsIgnoreCase("insert")) {
                actividadentregadavo.setActividadentregadaid(nuevoid);
                if (inputStream != null) {
                    actividadentregadavo.setActividadentregadaarchivo(inputStream);
                }
                actividadentregadadao.Agregar_ActividadEntregadaVO(actividadentregadavo);
            } else {
                actividadentregadavo.setActividadentregadaid(id_pdf);
                if (inputStream != null) {
                    actividadentregadavo.setActividadentregadaarchivo(inputStream);
                    actividadentregadadao.Modificar_ActividadEntregadaVO(actividadentregadavo);
                } else {
                    actividadentregadadao.Modificar_ActividadEntregadaVO2(actividadentregadavo);
                }
            }
        } catch (Exception ex) {
            System.out.println("textos: "+ex.getMessage());
        }

        RequestDispatcher view = request.getRequestDispatcher("listar_actividades_entregadas.jsp");
        view.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
