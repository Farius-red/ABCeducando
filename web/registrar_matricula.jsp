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
        <script src="assets/cargaArchivos/carga.js" type="text/javascript"></script>

    </head>
    <body>
        <%@include file="Componentes/header.jsp" %>
        <section class="container">
        



            <div class="row">

                <div class="col-sm-12">

                    <div class="card  shadow-lg mb-5 bg-light rounded">
                    

                        <div class="card-header  text-center">

                        <h1>Carga De matriculas </h1>
                        </div>
                        <div class="card-body"> 
                            
                            <form method="post"  name="formularioCargaMatricula" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="col-md-12 text-center">
                                <label> Cargar cvs Matricula</label>
                                <input type="file" onchange="cargarArchivo(this)" name="urlArchivo" accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12 text-center">
                                <input value="" name="nombreArchivo" type="hidden" />
                                <input value="3" name="opcion" type="hidden" />
                               
                            </div>
                        </div>



                    </form>
        </div>
                        
                        
                    </div>
                </div>                                       
            </div>



            <div  class="row" style="color: #007180;">
                <%
                    if (request.getAttribute("mensajeError") != null) {
                %>
                ${mensajeError}
                <%} else {%>
                ${mensajeExito}
                <%}%>
            </div>
        </div>




        <iframe name="null" style="display: none;"></iframe>

    </section>
    <%@include file="Componentes/footer.jsp" %>
</body>
</html>
