<%@page import="modeloVO.ListarUsuarioVO"%>
<%@page import="modeloDAO.ListarUsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.RolVO"%>
<%@page import="modeloDAO.RolDAO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        
        <title>Registro Docente</title>
        <meta name="description" content="">
   

        <jsp:include page="Componentes/head.jsp"  flush="true"></jsp:include>
    </head>
    <body>
  <%@include file="Componentes/header.jsp"%>
        <section class="container-fluid">
            <div class="row">

                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Registro Nuevo usuario</h1>
                    </div>
                </div>

            </div>
            <div class="row">


                <div class="col-xl-4">

                </div>
                <div class="col-xl-4">
                    <div class="datospersonales">
                        <form  class="formulario" method="post" action="Usuario">
                            <h1>Datos Personales</h1><br>
                            <h2><label>Nombres</label><br></h2>
                            <input type="text" title="Nombre solo acepta letrad y espacios en blanco" pattern="^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$" placeholder="Escriba nombre aqui" name="textnombres" required=""><br><br>
                            <h2><label>Apellidos</label><br></h2>
                            <input type="text" placeholder="Escriba apellido aqui" name="textapellidos" title="" required=""><br><br>
                            
                            <h2><label>Tipo documento</label><br></h2>
                            <select required class="tipodoc" pattern=""  name="texttipoid">
                                    <option>Seleccione...</option>
                                    <option value="Registro civil">RC</option>
                                    <option value="Tarjeta de identidad">TI</option>
                                    <option value="Cedula de ciudadania">CC</option>
                                </select>
                               <h2><label>EPS</label><br></h2>
                               <select required class="tipodoc" name="eps">
                                    <option>Seleccione...Eps</option>
                                    <option value="sanitas">Sanitas</option>
                                    <option value="compensar">Compensar</option>
                                    <option value="Salud Total"> Salud Total</option>
                                </select>
                               
                            
                            <br><br>
                                
                               
                            <!--<input type="text" placeholder="" name="texttipoid"><br><br>-->
                            <h2><label>Numero documento</label><br></h2>
                            <input type="text" placeholder="" name="textnumeroid" title="" required="" ><br><br>
                            <h2><label>Teléfono</label><br></h2>
                            <input type="text" placeholder="" name="texttelefono" title="" required=""><br><br>
                            <h2><label>Email</label><br></h2>
                            <input type="email" placeholder="Escriba un email" name="textemail" title="Email incorrecto revise su formato" pattern="^[a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,15})$" required=""><br><br>
                            <h2><label>Fecha de nacimiento</label><br></h2>
                            <input type="date" placeholder="" name="textfechanacimiento" required><br><br>
                           
                            <input type="hidden" value="4" name="opcion">
                             <button class="btnregistrar">Registrar</button>
                        </form>
                    </div>
                    <%@include file="Componentes/mensajesRespuesta.jsp" %>
                </div>

                <div class="col-xl-4">

                </div>                
            </div>


        </section>
                        <%@include file="Componentes/footer.jsp" %>
    </body>
</html>
