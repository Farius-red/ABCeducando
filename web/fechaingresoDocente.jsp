<%@page import="modeloVO.ListarUsuarioVO"%>
<%@page import="modeloDAO.ListarUsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.RolVO"%>
<%@page import="modeloDAO.RolDAO"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <title>Document</title>
        <meta name="description" content="">
        <%@include file="Componentes/head.jsp" %>
        
    </head>
    <body>
        <%@include file="Componentes/header.jsp" %>
        <section class="container-fluid">
            <div class="row">

                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Fecha de ingreso</h1>
                    </div>
                </div>

            </div>
            <div class="row">


                <div class="col-xl-4">
                    <%
                    int idDatos = 0;
                        
                    if(request.getAttribute("idDatos")!= null){
                                    idDatos =(int) request.getAttribute("idDatos");
                                       
                                    }
                    %>
                </div>
                <div class="col-xl-4">
                    <div class="datospersonales">
                        <form method="post" action="Fechaingreso">
                            <h1>Datos Personales</h1><br>
                            <h2><label>Fecha ingreso</label><br></h2>
                            <input type="date" placeholder="" name="textfechaingreso"><br><br>
                            <h2><label>Fecha salida</label><br></h2>
                            <input type="date" placeholder="" name="textfechasalida"><br><br>                            
                            
                            <input type="hidden" value="<%=idDatos%>" placeholder="" name="textdocumentoid"><br><br>   
                             <select class="tipodoc" name="textrol">
                                    <option>Seleccione...</option>
                                    <option value="1">administrador</option>
                                    <option value="2">estudiante</option>
                                    <option value="3">docente</option>
                                     <option value="4">acudiente</option>
                                </select><br><br>
                            <button class="btnregistrar">Registrar</button>
                            <input type="hidden" value="1" name="opcion">
                        </form>
                    </div>
                    <div style="color: #007180;">
                        <%
                            if (request.getAttribute("mensajeError") != null) {
                        %>
                        ${mensajeError}
                        <%} else {%>
                        ${mensajeExito}
                        <%}%>
                    </div>
                </div>

                <div class="col-xl-4">

                </div>                
            </div>


        </section>
                        <%@include file="Componentes/footer.jsp" %>
    </body>
</html>
