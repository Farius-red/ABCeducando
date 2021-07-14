
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloDAO.EstudianteDAO"%>
<%@page import="modeloVO.ActividadEntregadaVO"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="java.util.ArrayList"%>

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
        <%@include file="Componentes/Estudiante/headEstudiante.jsp" %>
        <section class="container-fluid">
            <div class="row">
                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Actividades Entregadas</h1>                                          
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
                                        <th>idActividadEntregada</th>
                                        <th>idActividad</th>
                                        <th>calificacion</th>
                                        <th>Archivo</th>
                                        <th>Estado</th>
                                       
                                    </tr>
                                </thead>

                                <tbody>
                                         <%
                                        String idEstudiante = "";
                                        UsuarioVO usu = new UsuarioVO();
                                    UsuarioDAO usudao = new UsuarioDAO();
                                    miSesion.getAttribute("datosUsuario");
                                    ArrayList<UsuarioVO> datosU = (ArrayList<UsuarioVO>)  miSesion.getAttribute("datosUsuario");
                                     if(datosU.size() != 0){
                                      for (int i = 0; i < datosU.size(); i++) {
                                              usu = datosU.get(i);
                                              idEstudiante = usu.getNombre();
                                      }
                                     }
                                        ActividadEntregadaVO datosVO = new  ActividadEntregadaVO();
                                      EstudianteDAO datosDAO = new EstudianteDAO();
                                        ArrayList<ActividadEntregadaVO> listaActividad = datosDAO.listarActivadesEntregadas(idEstudiante);
                                         if(listaActividad.size() != 0){
                                        for (int i = 0; i < listaActividad.size(); i++) {
                                            datosVO = listaActividad.get(i);
                                    %>
                                    <tr>
                                        <td><%=datosVO.getActividadEntregadaId()%></td>
                                        <td><%=datosVO.getIdActividadCargada()%></td>
                                        <td><%=datosVO.getCalificacion()%></td>
                                        <td>

                                            <a href="<%=datosVO.getActividadEntregadaRuta()%>" target="_blank"><img src="img/actividad.png" title="pdf"/></a>

                                        </td>
                                        <td><%=datosVO.getActividadEntregadaEstado()%></td>
                                   
                                    
                                    </tr>
                                    
                                       <% }}%>
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
