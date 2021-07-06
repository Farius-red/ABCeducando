

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                                                <li><i class="fas fa-map-marker-alt"></i> Bogota</li>
                                                <li><i class="fas fa-phone-alt"></i> 318-929-333</li>
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
                                                <a href="docente.jsp"><h1>Docente</h1></a>
                                                <li><a href="#"></a></li>
                                                <li><a href="#">Actividades</a>
                                                    <ul class="submenu">
                                                        <li><a href="cargar_actividad.jsp">Cargar actividad</a></li> 
                                                        <li><a href="listar_actividad.jsp">Actividades cargadas</a></li>    
                                                        <li><a href="listar_actividades_entregadas.jsp">Calificar actividades</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Notas</a>
                                                    <ul class="submenu">
                                                        <li><a href="notas.jsp">Ver notas</a></li>
                                                        
                                                    </ul>
                                                </li>
                                                  
                                                
                                                  <li><a href="#">Cerrar Sesion</a>
                                                                                                        <ul class="submenu">
                                                                                                            <li><%@include file="../cerrarSesion.jsp" %></li>
                                                        
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