<%-- 
    Document   : actualizarU
    Created on : 19/08/2021, 11:36:26 AM
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
        <title>Actualizar Datos</title>
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
                        <h1>Actualizar Usuario</h1>                                          
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
                                            <select class="tipodoc" name="texttipoid">
                                    <option>Seleccione...</option>
                                    <option value="Registro civil">RC</option>
                                    <option value="Tarjeta de identidad">TI</option>
                                    <option value="Cedula de ciudadania">CC</option>
                                </select><br><br>
                                              
                                                    <label >Nombres *</label>
                                                    <input type="text"  name="textnombres" value="<%=usu.getNombre()%>" required>
                                              
                                                    <br><br>
                                          
                                             
                                                    <label for="apellidos">Apellidos *</label>
                                                    <input type="text"  name="textapellidos" value="<%=usu.getApellidos()%>" required>
                                               <br>
                                          
                                                 <br>
                                          
                                                      <label >Telefono *</label>
                                                      <input type="text"  name="texttelefono" value="<%=usu.getTelefono()%>" required>
                                                      <input type="hidden"  name="rol" value="<%=usu.getNombrerol()%>" required>
                                                <br>
                                                   <label> Email *</label>
                                                   <input type="email"  name="textemail"  value="<%=usu.getEmail()%>" required>
                                                   <br><br>
                                                    <label> clave *</label>
                                                    <input type="password"  name="clave"  value="" required>
                                                   
          
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
