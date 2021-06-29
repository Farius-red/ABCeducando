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
        

        <!-- CSS here -->
        <jsp:include page="Componentes/head.jsp"  flush="true"></jsp:include>
    </head>
    <body>
    <%@include file="Componentes/header.jsp" %>
        <section class="container-fluid">
            <div class="row">

                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Crear usuario</h1>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-xl-4">

                </div>

                <div class="col-xl-4">
                    <div class="datospersonales">
                        <form method="POST" action="Usuario">
                            <h1></h1><br>
                            <h2><label>Email</label><br></h2>
                            <input type="text" placeholder="ejemplo@gmail.com" name="textusuario" required><br><br>
                            <h2><label>Contraseña</label><br></h2>
                            <input type="password" placeholder="Escriba su contraseña aqui" name="textclave" required=""><br><br><br>

                        <h2><label>numero Documento</label><br></h2>
                        <input type="text" placeholder="Escriba numero de documento aqui" name="textid" required><br><br>
                           
                            <input type="hidden" value="2" name="opcion">
                             <button class="btnregistrar">Registrar</button>
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
                        <jsp:include page="Componentes/footer.jsp"  flush="true"></jsp:include>
    </body>
</html>
