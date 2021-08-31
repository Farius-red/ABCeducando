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
                                        <li><i class="fas fa-map-marker-alt"></i>Bogota Colombia</li>
                                        <li><i class="fas fa-phone-alt"></i> +031 367 3692</li>
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
                                        <h1>Estudiante</h1>
                                        <h1></h1>
                                        <li><a href="index.html"></a></li>
                                        <li><a href="#">Actividades</a>
                                            <ul class="submenu">
                                                <li><a href="entregar_actividad.jsp">Entregar actividades</a></li>
                                                <li><a href="Actividades_pendientes_estudiante.jsp">Actividades pendientes</a></li>
                                                <li><a href="activi_entregadas_estudiante.jsp">Actividades entregadas</a></li>

                                            </ul>
                                        </li>
                                        <li><a href="#">Notas</a>
                                            <ul class="submenu">
                                                <li><a href="notasEstudiante.jsp">Ver notas</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Cerrar Sesión</a>
                                            <ul class="submenu">
                                                <%@include file="../cerrarSesion.jsp" %>

                                            </ul>

                                        </li>  
                                        <li>
                                            <a href="../../actualizarU.jsp">Actualizar Datos</a>
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
