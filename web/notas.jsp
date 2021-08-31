<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.Conexion"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="modeloDAO.DocenteDAO"%>
<%@page import="modeloVO.ActividadCargadaVO"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="java.util.ArrayList"%>

<%@page import="modeloVO.ActividadEntregadaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Componentes/Sessiones.jsp" %>
<%@include file="Componentes/datosUsuarioSesion.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>

        <title>Listar Actividades</title>
        <meta name="description" content="">
        <%@include file="Componentes/head.jsp" %>

    </head>
    <body>
        <%@include file="Componentes/docente/headDocente.jsp" %>
        <section class="container-fluid">
            <div class="row">
                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Notas Estudiantes</h1>                                          
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-2">

                </div>
                <div class="col-xl-8">
                    <div class="datospersonales">




                        <div class="datagrid">
                            <table class="actividadescargadas table-hover container">
                                <thead class="text-white" style="background: #ED078B;">
                                    <tr> 
                                        
                                       
                                        <th>Estudiante</th>
                                        <th>Acciones</th>
                                    
                                    </tr>
                                </thead>

                                <tbody>
                                         <%
                                        int idDocente = 0;
                                        UsuarioVO usu = new UsuarioVO();
                                    UsuarioDAO usudao = new UsuarioDAO();
                                    miSesion.getAttribute("datosUsuario");
                                    ArrayList<UsuarioVO> datosU = (ArrayList<UsuarioVO>)  miSesion.getAttribute("datosUsuario");
                                    
                                      for (int i = 0; i < datosU.size(); i++) {
                                              usu = datosU.get(i);
                                              idDocente = usu.getUsuarioid();
                                      }
                                        
                                        ActividadEntregadaVO datosVO = new  ActividadEntregadaVO();
                                       DocenteDAO datosDAO = new DocenteDAO();
                                        ArrayList< ActividadEntregadaVO> listaActividad = datosDAO.listarnotas(idDocente);
                                        for (int i = 0; i < listaActividad.size(); i++) {
                                            datosVO = listaActividad.get(i);
                                    %>
                                    
                                    
                                    <tr>
                                   
                                       
                                       <td><%=datosVO.getEstudianteId()%></td>
                                       <td>
                                           
                                           <form method="post" action="generarBoletin.jsp" target="_blank">
                                               <input  type="hidden" name="estudiante" value="<%=datosVO.getEstudianteId()%>" />
                                               
                                               <input  class="btn-primary" type="submit" value="Generar Reporte">
                                               
                                           </form>
                                       </td>
                                    </tr>
                                    
                                       <% }%>
                                </tbody>


                            </table>

                            <div class="col-sm-12">
                                <%@include file="Componentes/mensajesRespuesta.jsp" %>
                            </div>
                        </div>

                    </div>
                </div>


            </div>


        </section>
        <%@include file="Componentes/footer.jsp" %>
    </body>
</html>
