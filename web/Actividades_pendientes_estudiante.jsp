<%@page import="modeloDAO.EstudianteDAO"%>
<%@page import="modeloDAO.DocenteDAO"%>
<%@page import="modeloVO.ActividadCargadaVO"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="java.util.ArrayList"%>

<%@page import="modeloVO.ActividadEntregadaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Componentes/Sessiones.jsp" %>
<%@include file="Componentes/datosUsuarioSesion.jsp" %>


<html lang="en">
    <head>
     
        <title>Lista actividades Pendientes</title>
        <meta name="description" content="">
        
        <%@include file="Componentes/head.jsp" %>
     
    </head>
    <body>
        <%@include file="Componentes/Estudiante/headEstudiante.jsp" %>
      
                      <section class="container-fluid">
            <div class="row">
                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Actividades Pendientes</h1>                                          
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
                                <thead class="text-white" style="background: #ED078B!important;">
                                    <tr> 
                                        <th>idActividad</th>
                                        <th>Nombre Actividad</th>
                                        <th>Descripcion</th>
                                        <th>Archivo</th>
                                        <th>Docente ID</th>
                                        <th>Accion</th>
                                    </tr>
                                </thead>

                                <tbody>
                                         <%
                                        String idEstudiante = "";
                                        UsuarioVO usu = new UsuarioVO();
                                    UsuarioDAO usudao = new UsuarioDAO();
                                    miSesion.getAttribute("datosUsuario");
                                    ArrayList<UsuarioVO> datosU = (ArrayList<UsuarioVO>)  miSesion.getAttribute("datosUsuario");
                                    
                                      for (int i = 0; i < datosU.size(); i++) {
                                              usu = datosU.get(i);
                                              idEstudiante = usu.getNombre();
                                      }
                                        
                                        ActividadCargadaVO datosVO = new  ActividadCargadaVO();
                                       EstudianteDAO datosDAO = new EstudianteDAO();
                                        ArrayList< ActividadCargadaVO> listaActividad = datosDAO.listarActivadesPendientes(idEstudiante);
                                        if(listaActividad.size() != 0){
                                        
                                        for (int i = 0; i < listaActividad.size(); i++) {
                                            datosVO = listaActividad.get(i);
                                        
                                        
                                    %>
                                 
                                    <tr>
                                        <td><%=datosVO.getActividadCargadaId()%></td>
                                        <td><%=datosVO.getActividadCargadaNombre()%></td>
                                        <td><%=datosVO.getActividadCargadaDescripcion()%></td>
                                        <td>

                                            <a href="<%=datosVO.getRutaArchivo()%>" target="_blank"><img src="img/actividad.png" title="pdf"/></a>

                                        </td>
                                        <td><%=datosVO.getDocenteId()%></td>
                                        <td>
                                            
                                            <form  method="post" action="Estudiante">
                                                <input  type="hidden" name="idActividad" value="<%=datosVO.getActividadCargadaId()%>">
                                                <input  type="hidden" name="opcion" value="idActividad">
                                                <button type="submit" class="btn">Enviar Actividad</button>
                                            </form>
                                        </td>
                                        
                                    </tr>
                                    
                                       <% }}else{%>
                                       
                                <h1>No tiene actividades Pendientes</h1>
                                <%}%>
                                
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
        
        <%@include file="Componentes/footer.jsp"%>
    </body>
</html>
