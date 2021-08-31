<%-- 
    Document   : actualizarContra.jsp
    Created on : 19/08/2021, 10:39:51 PM
    Author     : Hector
--%>

<%@page import="modeloVO.DatosPersonalesVO"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeloVO.ActividadCargadaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Componentes/Sessiones.jsp" %>
<%@include file="Componentes/datosUsuarioSesion.jsp"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Clave</title>
        <%@include file="Componentes/head.jsp" %>
             
    </head>
    <body>
        
         <%
                                        int idEstudiante = 0;
                                        UsuarioVO usu = new UsuarioVO();
                                    UsuarioDAO usudao = new UsuarioDAO();
                                    miSesion.getAttribute("datosUsuario");
                                    ArrayList<UsuarioVO> datosU = (ArrayList<UsuarioVO>)  miSesion.getAttribute("datosUsuario");
                                    
                                      for (int i = 0; i < datosU.size(); i++) {
                                              usu = datosU.get(i);
                                              idEstudiante= usu.getUsuarioid();
                                  
                                     
                                      %>
                                      <% if(usu.getNombrerol().equals("estudiante")){
                                      %>
                                      <%@include file="Componentes/Estudiante/headEstudiante.jsp" %>
                                      
                                      <%}else{%>
                                      <%@include file="Componentes/header.jsp" %>
                                      
                                      <%}%>
                                      
                                      <h1>Bienvenido: <%=usu.getNombre()%></h1>
                                     <section class="container-fluid">
            <div class="row">
                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Actualizar Clave</h1>                                          
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-4">

                </div>
                <div class="col-xl-4">

                    <div class="datospersonales">


                      

                        <form class="container  align-content-center" action="Usuario" method="post">       
                        
                                               <label for="numeroDocumento">Numero Documento *</label>
                                               <input type="text"  name="textnumeroid" value="<%=usu.getUsuarioid()%>">
                                               <br>
                                         
                                                   <br><br>
                                                    <label> clave *</label>
                                                    <input type="password"  name="clave"  value="" required>
                                                 
                                           <br>
                                    <input value="9" name="opcion" type="hidden">
                                    <br>
                                 
                                <input type="submit" value="Actualizar Usuario"  id="btn" class="btn"/>
                              
                            
                            
                                     
                                  
                             
                          
                        </form>
                
                                <%@include file="Componentes/mensajesRespuesta.jsp" %>
                    </div>
                </div>
               

            </div>


        </section>
                             
                                      <%}%>
                                      
        <%@include file="Componentes/footer.jsp"%>
    </body>
</html>