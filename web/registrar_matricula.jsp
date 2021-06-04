<%@page import="modeloVO.ListarUsuarioVO"%>
<%@page import="modeloDAO.ListarUsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.RolVO"%>
<%@page import="modeloDAO.RolDAO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <meta name="description" content="">
        <link rel="manifest" href="site.webmanifest">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">


        <!-- CSS here -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/slicknav.css">
        <link rel="stylesheet" href="assets/css/progressbar_barfiller.css">
        <link rel="stylesheet" href="assets/css/gijgo.css">
        <link rel="stylesheet" href="assets/css/animate.min.css">
        <link rel="stylesheet" href="assets/css/animated-headline.css">
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/slick.css">
        <link rel="stylesheet" href="assets/css/nice-select.css">
        <link rel="stylesheet" href="assets/css/style.css">
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
                                                <li><a href="#">Matriculas</a>
                                                    <ul class="submenu">
                                                        <li><a href="registrar_matricula.jsp">Registrar matricula</a></li>
                                                        <li><a href="#">Ver matriculas</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Docente</a>
                                                    <ul class="submenu">
                                                        <li><a href="registrarDocente.jsp">Registrar Docente</a></li>
                                                        <li><a href="listardocentes.jsp">Lista Docentes</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Estudiante</a>
                                                    <ul class="submenu">
                                                        <li><a href="#">Registrar Estudiantes</a></li>
                                                        <li><a href="#">Lista Estudiantes</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Mensajes</a>
                                                    <ul class="submenu">
                                                        <li><a href="#">Redactar mensaje</a></li>
                                                        <li><a href="#">Bandeja de entrada</a></li>
                                                        <li><a href="#">Bandeja de salida</a></li>
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
                        <h1>Registro de Matricula</h1>
                    </div>
                </div>

            </div>
            <form method="post" action="Docente">
                <div id="">
                    <div>
                        <div class="row">
                            
                            <div class="col-xl-4">
                                <div class="container">                                    
                                            <div class="well well-sm">
                                                <form class="form-horizontal" method="post">
                                                    <fieldset>
                                                        <legend class="text-center header"></legend>
                                                        
                                                        <h1>Datos del ni�o</h1>
                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="fname" name="name" type="text" placeholder="Nombres" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="lname" name="name" type="text" placeholder="Apellidos" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="email" name="email" type="text" placeholder="Tipo de documento" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="email" name="email" type="text" placeholder="Numero de documento" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="phone" name="phone" type="text" placeholder="Telefono" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="phone" name="phone" type="text" placeholder="Email" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="phone" name="phone" type="text" placeholder="Fecha de nacimiento" class="form-control">
                                                            </div>
                                                        </div>
                                                        </div>
                                                        <h1>Datos del acudiente</h1>
                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="fname" name="name" type="text" placeholder="Nombres" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="lname" name="name" type="text" placeholder="Apellidos" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="email" name="email" type="text" placeholder="Tipo de documento" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="email" name="email" type="text" placeholder="Numero de documento" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="phone" name="phone" type="text" placeholder="Telefono" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="phone" name="phone" type="text" placeholder="Email" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <span class="col-md-1 col-md-offset-2 text-center"><i class=""></i></span>
                                                            <div class="col-md-8">
                                                                <input id="phone" name="phone" type="text" placeholder="Fecha de nacimiento" class="form-control">
                                                            </div>
                                                        </div>
                                                        
                                                        



                                                        <div class="form-group">
                                                            <div class="col-md-12 text-center">
                                                                <button type="submit" class="btn btn-primary btn-lg">Registrar</button>
                                                            </div>
                                                        </div>
                                                    </fieldset>
                                                </form>
                                            </div>                                       
                                </div>
                            </div>
                            <div class="col-xl-3">
                                
                            </div>
                            <!--<div class="col-xl-6">

                                <h1>Datos del ni�o</h1>
                                <labe>Nombres:</labe>
                                <input type="text">
                                <labe>Apellidos:</labe>
                                <input type="text">
                                <labe>Tipo de documento:</labe>
                                <input type="text">
                                <labe>Numero de documento:</labe>
                                <input type="text">
                                <labe>Telefono:</labe>
                                <input type="text">
                                <labe>Email:</labe>
                                <input type="text">
                                <labe>Fecha de nacimiento:</labe>
                                <input type="text">
                            </div>
                            <div class="col-xl-6">

                            </div>-->
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
                    </div>
                </div>
                </div>

            </form>


        </section>
        <footer>
            <div class="footer-wrappper footer-bg">
                <!-- Footer Start-->
                <div class="footer-area footer-padding">
                    <div class="container">
                        <div class="row justify-content-between">
                            <div class="col-xl-5 col-lg-6 col-md-6 col-sm-8">
                                <div class="single-footer-caption mb-50">
                                    <div class="single-footer-caption mb-30">
                                        <!-- logo -->
                                        <div class="footer-logo mb-25">
                                            <a href="index.html"><img src="assets/img/logo/logo2_footer.png" alt=""></a>
                                        </div>
                                        <div class="footer-tittle">
                                            <div class="footer-pera">
                                                <p>Users and submit their own items. You can create different packages and by connecting with your PayPal or Stripe account charge users for registration.</p>
                                            </div>
                                        </div>
                                        <!-- social -->
                                        <div class="footer-social">
                                            <a href="#"><i class="fab fa-twitter"></i></a>
                                            <a href="https://bit.ly/sai4ull"><i class="fab fa-facebook-f"></i></a>
                                            <a href="#"><i class="fab fa-pinterest-p"></i></a>
                                            <a href="#"><i class="fab fa-linkedin-in"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-2 col-lg-3 col-md-3 col-sm-4">
                                <div class="single-footer-caption mb-50">
                                    <div class="footer-tittle">
                                        <h4>Quick Links </h4>
                                        <ul>
                                            <li><a href="#">Classes</a></li>
                                            <li><a href="#">Join with us</a></li>
                                            <li><a href="#">About</a></li>
                                            <li><a href="#">Blog</a></li>
                                            <li><a href="#">Events</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-2 col-lg-3 col-md-3 col-sm-6">
                                <div class="single-footer-caption mb-50">
                                    <div class="footer-tittle">
                                        <h4>About Us</h4>
                                        <ul>
                                            <li><a href="#">Our Team</a></li>
                                            <li><a href="#">Privacy Policy</a></li>
                                            <li><a href="#">Testimonial</a></li>
                                            <li><a href="#">Programing</a></li>
                                            <li><a href="#">User Stories</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- footer-bottom area -->
                <div class="footer-bottom-area">
                    <div class="container">
                        <div class="footer-border">
                            <div class="row d-flex align-items-center">
                                <div class="col-xl-12 ">
                                    <div class="footer-copy-right text-center">
                                        <p>Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart color-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" rel="nofollow noopener">Colorlib</a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Footer End-->
            </div>
        </footer>
    </body>
</html>