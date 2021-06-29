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
        <jsp:include page="Componentes/head.jsp" flush="true"></jsp:include>
    </head>
    <body>
        <header>
            <!-- Header Start -->
            <div class="header-area">
                <div class="main-header ">
                    <div class="header-top d-none d-sm-block">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xl-12">
                                    <div class="d-flex justify-content-between flex-wrap align-items-center">
                                        <div class="header-info-left">
                                            <ul>     
                                                <li><i class="fas fa-map-marker-alt"></i> 57/A, Green Lane, NYC</li>
                                                <li><i class="fas fa-phone-alt"></i> +10 (78) 367 3692</li>
                                            </ul>
                                        </div>
                                        <div class="header-info-right">
                                            <ul class="header-social">    
                                                <li><a href="#"><i class="fab fa-facebook"></i></a></li>
                                                <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                                                <li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                                                <li> <a href="#"><i class="fab fa-instagram"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="header-bottom  header-sticky">
                        <div class="container-fluid">
                            <div class="row align-items-center">
                                <!-- Logo -->
                                <div class="col-xl-2 col-lg-2">
                                    <div class="logo">
                                        <a href="index.jsp"><img src="assets/img/logo/logo.png" alt=""></a>
                                    </div>
                                </div>
                                <div class="col-xl-10 col-lg-10">
                                    <!-- Main-menu -->
                                    <div class="main-menu f-right d-none d-lg-block">
                                        <nav> 
                                            <ul id="navigation">    
                                                <a href="administrativo.jsp"><h1>Administrativo</h1></a>
                                                <li><a href="index.html">Matriculas</a></li>
                                                <li><a href="blog.html">Docente</a>
                                                    <ul class="submenu">
                                                        <li><a href="blog.html">Registrar Docente</a></li>
                                                        <li><a href="blog_details.html">Lista Docentes</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="blog.html">Estudiante</a>
                                                    <ul class="submenu">
                                                        <li><a href="blog.html">Registrar Estudiantes</a></li>
                                                        <li><a href="blog_details.html">Lista Estudiantes</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="blog.html">Mensajes</a>
                                                    <ul class="submenu">
                                                        <li><a href="blog.html">Redactar mensaje</a></li>
                                                        <li><a href="blog.html">Bandeja de entrada</a></li>
                                                        <li><a href="blog_details.html">Bandeja de salida</a></li>
                                                    </ul>
                                                </li>    
                                            </ul>
                                        </nav>
                                    </div>
                                </div> 
                                <!-- Mobile Menu -->
                                <div class="col-12">
                                    <div class="mobile_menu d-block d-lg-none"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Header End -->
        </header>
        <section class="container-fluid">
            <div class="row">

                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Registro de Docente</h1>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-xl-4">

                </div>
                <div class="col-xl-4">
                    <div class="datospersonales">
                        <form method="post" action="UsuarioRol">
                            <h1>Asignar Rol</h1><br>
                            <h2><label>Email</label><br></h2>
                            <select name="textusuarioid">
                                <option>Seleccione...</option>
                                <%
                                    ListarUsuarioDAO listarusuarioDAO = new ListarUsuarioDAO();
                                    for (ListarUsuarioVO listarusuarioVO : listarusuarioDAO.listarusuario()) {
                                %>

                                <option value="<%=listarusuarioVO.getUsuarioid()%>"><%=listarusuarioVO.getUsuariologin()%></option>

                                <%}%>
                            </select><br><br>
                            <h2><label>Rol</label><br></h2>
                            <select name="textrolid">
                                <option>Seleccione...</option>
                                <%
                                    RolDAO rolDAO = new RolDAO();
                                    for (RolVO rolVO : rolDAO.listar()) {
                                %>

                                <option value="<%=rolVO.getRolid()%>"><%=rolVO.getRoltipo()%></option>

                                <%}%>
                            </select><br><br>                           
                            <button class="btnregistrar">Asignar</button>
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
                        <jsp:include page="Componentes/footer.jsp" flush="true" ></jsp:include>
    </body>
</html>
