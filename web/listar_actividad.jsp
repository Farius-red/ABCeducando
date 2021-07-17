<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="modeloDAO.DocenteDAO"%>
<%@page import="java.util.ArrayList"%>

<%@page import="modeloVO.ActividadCargadaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="Componentes/Sessiones.jsp" %>
<%@include file="Componentes/datosUsuarioSesion.jsp" %>
<html lang="en">
    <head>
      
        <title>Lista Actividades</title>
        <meta name="description" content="">
        <%@include file="Componentes/head.jsp" %>
    </head>
    <body>
        
        <%@include file="Componentes/docente/headDocente.jsp" %>
        <section class="container-fluid">
            <div class="row">
                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Actividades cargadas</h1>                                          
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
                                <thead  class="text-white" style="background: #ED078B;">
                                    <tr> 
                                       <th>idActividad</th>
                                        <th>Nombre</th>
                                        <th>Descripcion</th>
                                        <th>Archivo</th>
                                        
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
                                        
                                        ActividadCargadaVO datosVO = new ActividadCargadaVO();
                                       DocenteDAO datosDAO = new DocenteDAO();
                                        ArrayList<ActividadCargadaVO> listaActividad = datosDAO.listarActivades(idDocente);
                                        for (int i = 0; i < listaActividad.size(); i++) {
                                            datosVO = listaActividad.get(i);
                                    %>
                                    <tr>
                                        <td><%=datosVO.getActividadCargadaId()%></td>
                                        </td>
                                        <td><%=datosVO.getActividadCargadaNombre()%></td>
                                        <td><%=datosVO.getActividadCargadaDescripcion()%></td>
                                        <td>
                                            
                                            <a href="<%=datosVO.getRutaArchivo()%>" target="_blank"><img src="img/actividad.png" title="pdf"/></a>
                              
                                        </td>
                                        
                                        <td>
                                            <form id="crudForm"  action="Docente" method="post">
                                                <input type="hidden" name="idAcrividad" value="<%=datosVO.getActividadCargadaId()%>"/>
                                                <input type="hidden" name="urlArchivo" value="<%=datosVO.getRutaArchivo()%>"/>
                                                <input id="metodo" name="opcion" type="hidden" value="eliminar"/>
                                                
                                            <button type="submit"> <img src="img/delete1.png" title="Eliminar"/></button>
                                            </form>
                                        </td>
                                    </tr>
                                   <% }%>
                                </tbody>
                                
                                
                            </table>
                        </div>
                  

                    </div>
                </div>
                <div class="col-xl-2">
                    <%@include file="Componentes/mensajesRespuesta.jsp" %>
                </div>

            </div>


        </section>
                                        <%@include file="Componentes/footer.jsp" %>
    </body>
    
</html>
