
<%@page import="modeloVO.UsuarioVO"%>


<%@include  file="Componentes/Sessiones.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
     
        
        <title>Adminsitrador</title>
        <meta name="description" content="">
       


        <!-- CSS here -->
           <jsp:include page="Componentes/head.jsp"  flush="true"></jsp:include>

    </head>
    <body>
    <%@include file="Componentes/header.jsp"%>
        <section class="container-fluid">
            <div class="row">

                <div class="col-xl-12">
                    <div class="registrodocente">
                        <%@include file="Componentes/mensajesRespuesta.jsp" %>
                    </div>
                </div>

            </div>
            

        </section>
        <jsp:include page="Componentes/footer.jsp" flush="true"></jsp:include>
    </body>
</html>
