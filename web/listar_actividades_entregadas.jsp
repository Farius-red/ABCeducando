<%@page import="java.util.ArrayList"%>
<%@page import="modeloDAO.ActividadEntregadaDAO"%>
<%@page import="modeloVO.ActividadEntregadaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
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
                                                <a href="estudiante.jsp"><h1>Estudiante</h1></a>
                                                <li><a href="index.html"></a></li>
                                                <li><a href="#">Actividades</a>
                                                    <ul class="submenu">
                                                        <li><a href="entregar_actividad.jsp">Entregar actividades</a></li>
                                                        <li><a href="Actividades_pendientes_estudiante.jsp">Actividades pendientes</a></li>
                                                        <li><a href="listar_actividades_entregadas.jsp">Actividades entregadas</a></li>

                                                    </ul>
                                                </li>
                                                <li><a href="#">Notas</a>
                                                    <ul class="submenu">
                                                        <li><a href="#">Ver notas</a></li>
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
                        <h1>Actividades cargadas</h1>                                          
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-2">

                </div>
                <div class="col-xl-8">
                    <div class="datospersonales">
                        <!--<body>-->
                        <!--<center>
                            <h1></h1>
                        </center>-->

                        <%
                            ActividadEntregadaDAO emp = new ActividadEntregadaDAO();
                            ActividadEntregadaVO actividadentregadavo = new ActividadEntregadaVO();
                            ArrayList<ActividadEntregadaVO> listar = emp.Listar_ActividadEntregadaVO();
                        %>

                        <div class="datagrid">
                            <table class="actividadescargadas">
                                <thead>
                                    <tr> 
                                        <!--<th>Codigo</th>-->
                                        <th>Nombre</th>
                                        <th>Descripcion</th>
                                        <th>Archivo</th>
                                        <th>Estado</th>
                                        <th>Estudiante</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <td colspan="6">
                                            <div id="paging"><ul><li><a href="#"><span>Previous</span></a></li><li><a href="#" class="active"><span>1</span></a></li><li><a href="#"><span>2</span></a></li><li><a href="#"><span>3</span></a></li><li><a href="#"><span>4</span></a></li><li><a href="#"><span>5</span></a></li><li><a href="#"><span>Next</span></a></li></ul>
                                            </div>
                                    </tr>
                                </tfoot>
                                <!--<tbody>-->
                                    <%if (listar.size() > 0) {
                                            for (ActividadEntregadaVO listar2 : listar) {
                                                actividadentregadavo = listar2;
                                    %>
                                    <tr>
                                        <!--<td><%=actividadentregadavo.getActividadentregadaid()%></td>-->
                                        <td><%=actividadentregadavo.getActividadentregadanombre()%></td>
                                        <td><%=actividadentregadavo.getActividadentregadadescripcion()%></td>
                                        <td>
                                            <%
                                                if (actividadentregadavo.getActividadentregadaarchivo2()!= null) {
                                            %>
                                            <a href="actividadcargada?id=<%=actividadentregadavo.getActividadentregadaid()%>" target="_blank"><img src="img/actividad.png" title="pdf"/></a>
                                                <%
                                                    } else {
                                                        out.print("Vacio");
                                                    }
                                                %>
                                        </td>
                                        <td><%=actividadentregadavo.getActividadentregadaestado()%></td>
                                        <td><%=actividadentregadavo.getEstudianteid()%></td>
                                        <td>
                                            <a id="mostrar" href="ActividadEntregada?action=insert&id=<%=actividadentregadavo.getActividadentregadaid()%>"> <img src="img/nuevo1.png" title="Nuevo registro"/></a>
                                            <a href="ActividadEntregada?action=edit&id=<%=actividadentregadavo.getActividadentregadaid()%>"> <img src="img/editar1.png" title="Modificar"/></a>
                                            <a href="ActividadEntregada?action=delete&id=<%=actividadentregadavo.getActividadentregadaid()%>"> <img src="img/delete1.png" title="Eliminar"/></a>
                                        </td>
                                    </tr>
                                    <%}
                                        }%>
                                <!--</tbody>-->
                            </table>
                        </div>
                        <!--</body>-->

                    </div>
                </div>
                <div class="col-xl-2">

                </div>

            </div>


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
