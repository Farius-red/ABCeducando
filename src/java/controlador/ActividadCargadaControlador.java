package controlador;

import util.sql;
import modeloDAO.ActividadCargadaDAO;
import modeloVO.ActividadCargadaVO;
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

@WebServlet(name = "ActividadCargada", urlPatterns = {"/ActividadCargada"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB

public class ActividadCargadaControlador extends HttpServlet {

    public static final String lIST_STUDENT = "/listar_actividad.jsp";
    public static final String INSERT_OR_EDIT = "/cargar_actividad.jsp";

    String estado = null;
    ActividadCargadaDAO actividadcargadadao;
    int id_pdf = -1;

    public ActividadCargadaControlador() {
        actividadcargadadao = new ActividadCargadaDAO();
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
            actividadcargadadao.Eliminar_ActividadCargadaVO(studentId);
        }
        if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int studentIdM = Integer.parseInt(request.getParameter("id"));
            id_pdf = studentIdM;
            ActividadCargadaVO actividadcargadavo = actividadcargadadao.getPdfVOById(studentIdM);
            request.setAttribute("row", actividadcargadavo);
            boolean boo = false;
            if (actividadcargadavo.getActcararchivo2()!= null) {
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

        ActividadCargadaVO actividadcargadavo = new ActividadCargadaVO();
        sql auto = new sql();
        int nuevoid = auto.auto_increm("SELECT MAX(actividadcargadaid) FROM actividadcargada;");
        
        try{
            String name = request.getParameter("txtname");
            actividadcargadavo.setActividadcargadanombre(name);
        }catch(Exception ex){
            System.out.println("nombre: "+ex.getMessage());
        }
        
        try{
            String descripcion = request.getParameter("textdescripcion");
            actividadcargadavo.setActividadcargadadescripcion(descripcion);
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
            int Docente = Integer.parseInt(request.getParameter("textdocenteid")); 
            actividadcargadavo.setDocenteid(Docente);
        }catch(Exception ex){
            System.out.println("nombre: "+ex.getMessage());
        }

        try {
            
            if (estado.equalsIgnoreCase("insert")) {
                actividadcargadavo.setActividadcargadaid(nuevoid);
                if (inputStream != null) {
                    actividadcargadavo.setActcararchivo(inputStream);
                }
                actividadcargadadao.Agregar_ActividadCargadaVO(actividadcargadavo);
            } else {
                actividadcargadavo.setActividadcargadaid(id_pdf);
                if (inputStream != null) {
                    actividadcargadavo.setActcararchivo(inputStream);
                    actividadcargadadao.Modificar_ActividadCargadaVO(actividadcargadavo);
                } else {
                    actividadcargadadao.Modificar_ActividadCargadaVO2(actividadcargadavo);
                }
            }
        } catch (Exception ex) {
            System.out.println("textos: "+ex.getMessage());
        }

        RequestDispatcher view = request.getRequestDispatcher("listar_actividad.jsp");
        view.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
