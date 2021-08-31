<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<header>
            <div class="header-area">
                <div class="main-header ">
                    <div class="header-top d-none d-sm-block">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xl-12">
                                    <div class="d-flex justify-content-between flex-wrap align-items-center">
                                        <div class="header-info-left">
                                            <ul>     
                                                <li><i class="fas fa-map-marker-alt"></i> Bogota Colombia</li>
                                                <li><i class="fas fa-phone-alt"></i> 315 367 3692</li>
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
                                                   <ul class="submenu">
                                                       <li><p></p>
                                                       <li>
                                                           <jsp:include page="Componentes/cerrarSesion.jsp" flush="true"/>
                                                       </li>
                                             
                                                    </ul>
                                                <a href="administrativo.jsp"><h1>Administrativo</h1></a>
                                                <li><a href="#">Matriculas</a>
                                                    <ul class="submenu">
                                                        <li><a href="registrar_matricula.jsp">Registrar matricula</a></li>
                                                        
                                                    </ul>
                                                </li>
                                                <li><a href="#">Docente</a>
                                                    <ul class="submenu">
                                                        <li><a href="registrarDocente.jsp">Registrar docente</a></li>
                                                        <li><a href="listardocentes.jsp">Ver docentes</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Estudiante</a>
                                                    <ul class="submenu">
                                                        <li><a href="registrarDocente.jsp">Registrar estudiantes</a></li>
                                                        <li><a href="listarEstudiantes.jsp">Ver estudiantes</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Mensajes</a>
                                                    <ul class="submenu">
                                                        <li><a href="crearmensaje.jsp">Crear y listar mensajes</a></li>
                                                        
                                                    </ul>
                                                </li>    
                                                
                                                 <li><a href="#">Cerrar Sesion</a>
                                                    <ul class="submenu">
                                                        <li><a href="login.jsp">Cerrar Sesion</a></li>
                                                       
                                                    </ul>
                                                </li>
                                                
                                                <li>
                                                    <a href="../actualizarU.jsp">Actualizar Datos</a>
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
                                                       
                                                       
                                                       
                                                       