<%@page import="modeloVO.ListarUsuarioVO"%>
<%@page import="modeloDAO.ListarUsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.RolVO"%>
<%@page import="modeloDAO.RolDAO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        
        <title>Registrar  matricula</title>
        <meta name="description" content="">
        <%@include file="Componentes/head.jsp" %>
       
    </head>
    <body>
        <%@include file="Componentes/header.jsp" %>
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
                                                <form class="form-horizontal" method="post" action="RegistroMatricula">
                                                    <fieldset>
                                                        <legend class="text-center header"></legend>
                                                        
                                                        <h1>Datos del niño</h1>
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

                                <h1>Datos del niño</h1>
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
                                <%@include file="Componentes/footer.jsp" %>
    </body>
</html>
