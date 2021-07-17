<%-- 
    Document   : actualizarUsuarios
    Created on : 15/07/2021, 12:43:42 AM
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
<html lang="en">
    <head>
      
        <title>Actualiza Usuario</title>
        <meta name="description" content="">
        
        <%@include file="Componentes/head.jsp" %>
        
    </head>
    <body>
        <%@include file="Componentes/header.jsp" %>
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


                      

                        <form class="container" action="Usuario" method="post" >       
                                
                            
                            <% 
                               int idDatos = 0;
                               String datosnombres="", datosapellidos="",datostelefono="", datosemail="";
            
            
             
                                    if(request.getAttribute("idDatos")!= null){
                                    idDatos =(int) request.getAttribute("idDatos");
                                       
                                    }
                                    
                                    if(request.getAttribute("datosnombres")!= null){
                                         datosnombres =(String) request.getAttribute("datosnombres");
                                    }
                                    
                                     if(request.getAttribute("datosapellidos")!= null){
                                         datosapellidos =(String) request.getAttribute("datosapellidos");
                                    }
                                    
                                      if(request.getAttribute("datostelefono")!= null){
                                         datostelefono =(String) request.getAttribute("datostelefono");
                                    }
                                      if(request.getAttribute("datosemail")!= null){
                                         datosemail =(String) request.getAttribute("datosemail");
                                    }
                                    ;%>
                              

                              
 
                                    
                           
                                               <label for="numeroDocumento">Numero Documento *</label>
                                               <input type="text"  name="textnumeroid" value="<%=idDatos%>">
                                            <br></br>
                                            <select class="tipodoc" name="texttipoid">
                                    <option>Seleccione...</option>
                                    <option value="Registro civil">RC</option>
                                    <option value="Tarjeta de identidad">TI</option>
                                    <option value="Cedula de ciudadania">CC</option>
                                </select><br><br>
                                              
                                                    <label >Nombres *</label>
                                                    <input type="text"  name="textnombres" value="<%=datosnombres%>">
                                              
                                                <br></br>
                                          
                                             
                                                    <label for="apellidos">Apellidos *</label>
                                                <input type="text"  name="textapellidos" value="<%=datosapellidos%>">
                                               <br></br>
                                          
                                                 <br></br>
                                          
                                                      <label >Telefono *</label>
                                                <input type="text"  name="texttelefono" value="<%=datostelefono%>">
                                                 <br></br
                                                   <label >Email *</label>
                                                <input type="email"  name="textemail" value="<%=datosemail%>">
                                                 
                                           <br></br>
                                    <input value="7" name="opcion" type="hidden">
                                 
                                <input type="submit" value="Actualizar Usuario"  id="btn" class="btn"/>
                              
                            
                            
                                     
                                  
                             
                          
                        </form>
                
                                <%@include file="Componentes/mensajesRespuesta.jsp" %>
                    </div>
                </div>
               

            </div>


        </section>
          <%@include file="Componentes/footer.jsp"%>
    </body>
</html>
