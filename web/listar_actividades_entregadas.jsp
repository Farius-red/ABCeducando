<%@page import="modeloDAO.DocenteDAO"%>

<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeloVO.ActividadCargadaVO"%>
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
                                        <th>Estudiante</th>
                                        <th>Acción</th>
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
                                        ArrayList< ActividadEntregadaVO> listaActividad = datosDAO.listarActivadesEntregadas(idDocente);
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
                                        <td><%=datosVO.getActividadEntregadaEstado() %></td>
                                        <td><%=datosVO.getEstudianteId()%></td>
                                        <td>
                                            <form id="crudForm"  action="Docente" method="post">
                                                <input type="hidden" name="idAcrividad" value="<%=datosVO.getActividadEntregadaId()%>"/>
                                                <input type="hidden" name="estado" value="calificado"/>
                                                <select name="calificacion" id="cars">
                                                    <option>seleccione Calificacion</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                </select>
                                                <input id="metodo" name="opcion" value="calificar" type="hidden"/>
                                                <button type="submit" class="btn btn-primary"> Calificar </button>

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
