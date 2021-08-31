<%@page import="java.util.ArrayList"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="modeloVO.ActividadCargadaVO"%>

 <%@include file="Componentes/Sessiones.jsp"%>
<%@include file="Componentes/datosUsuarioSesion.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        
        <title>Estudiante</title>
        <meta name="description" content="Adminsitracion de estudiantes">
        <jsp:include page="Componentes/head.jsp"  flush="true"></jsp:include>
        
    </head>
    <body>
    <%@include file="Componentes/Estudiante/headEstudiante.jsp" %>
        <section class="container-fluid">
            <div class="row">

                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1></h1>
                    </div>
                </div>

            </div>
            <div class="row container d-flex align-center">
                <div>
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
                                      
                                      <h1>Bienvenido: <%=usu.getNombre()%></h1>
                                      <%}%>
                                      
                                      <%@include file="Componentes/mensajesRespuesta.jsp" %>
            </div>


        </section>
        <jsp:include page="Componentes/footer.jsp" flush="true"></jsp:include>
    </body>
</html>
