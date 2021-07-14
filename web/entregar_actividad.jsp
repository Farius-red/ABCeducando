




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
      
        <title>Entregar Actividad</title>
        <meta name="description" content="">
        
        <%@include file="Componentes/head.jsp" %>
        
    </head>
    <body>
        <%@include file="Componentes/Estudiante/headEstudiante.jsp" %>
         <section class="container-fluid">
            <div class="row">
                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Entregar Actividad</h1>                                          
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-4">

                </div>
                <div class="col-xl-4">

                    <div class="datospersonales">


                      

                        <form name="formpdf" action="Estudiante" method="post" enctype="multipart/form-data">       
                                <%@include file="Componentes/java/inputIdUsuario.jsp" %>     
                            
                            <% 
                                int id = 0;
                                    if(request.getAttribute("idActividad")!= null){
                                    
                                         id =(int)request.getAttribute("idActividad");
                                    }
                                    ;%>
                              

                              

                                
                                <label for="id">Descripcion: </label><br>
                                                                             
                                                                          
                                            
                                                                         <label for="id">id Actividad *</label>  
                                                                         <input type="text" name="idActividad" value="<%=id%>" required>
                                               <label for="id">Seleccionar PDF: *</label>                                     
                                <input type="file" name="urlArchivo"  accept="application/pdf" class="btn1" required/><br><br>
                                    <input value="registrar" name="opcion" type="hidden">
                                 
                                <input type="submit" value="Enviar Archivo"  id="btn" class="btn"/>
                              
                                         
                            
                                     
                                  
                             
                          
                        </form>
                
                                <%@include file="Componentes/mensajesRespuesta.jsp" %>
                    </div>
                </div>
               

            </div>


        </section>
          <%@include file="Componentes/footer.jsp"%>
    </body>
</html>
