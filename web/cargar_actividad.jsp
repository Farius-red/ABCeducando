<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeloVO.ActividadCargadaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<%@include file="Componentes/Sessiones.jsp" %>
<%@include file="Componentes/datosUsuarioSesion.jsp" %>

<html lang="en">
    <head>




        <title>Carga de actividades</title>
        <meta name="description" content=" carga actividades de alumnos">
        <jsp:include page="Componentes/head.jsp" ></jsp:include>
        </head>
        <body>
        <%@include file="Componentes/docente/headDocente.jsp" %>
        <section class="container-fluid">
            <div class="row">
                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Cargar actividad</h1>                                          
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-4">

                </div>
                <div class="col-xl-4">

                    <div class="datospersonales">


                      

                        <form name="formpdf" action="Docente" method="post" enctype="multipart/form-data">                                
                            

                              

                              

                                
                                <label for="id">Descripcion: </label><br>
                                                                             
                                                                          
                                <input type="text" name="descripcion" /><br><br>
                                                                                 <label for="id">Seleccionar PDF: *</label>
                               
                                                                            
                                <input type="file" name="urlArchivo"  accept="application/pdf" class="btn1"/><br><br>
                                
                                  <input value="registrar" name="opcion" type="hidden"/>
                         <input type="submit" value="Enviar Archivo"  id="btn" class="btn"/>
                                <%@include file="Componentes/java/inputIdUsuario.jsp" %>       
                                         
                                
                                     
                                    
                             
                          
                        </form>
                
                                <%@include file="Componentes/mensajesRespuesta.jsp" %>
                    </div>
                </div>
               

            </div>


        </section>
        <jsp:include page="Componentes/footer.jsp" flush="true"></jsp:include>
    </body>
</html>
