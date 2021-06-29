<%@page import="java.util.ArrayList"%>
<%@page import="modeloDAO.DatosPersonalesDAO"%>
<%@page import="modeloVO.DatosPersonalesVO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
       
        <title>Lista Estudiantes</title>
        <meta name="description" content="">
       
        <%@include  file="Componentes/head.jsp" %>
    </head>
    <body>
        <%@include file="Componentes/header.jsp" %>
        <section class="container-fluid">
            <div class="row">

                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Estudiantes</h1>
                    </div>
                </div>
                <div class="container">
                    <div class="col-xl-12">
                        <div class="tabladocente">
                            <form>
                                <table border="1">
                                    <tr>
                                        <th>Numero Documento</th>
                                        <th>Tipo Documento</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Telefono</th>
                                        <th>Email</th>                                        
                                    </tr>

                                    <%
                                        
                                        DatosPersonalesVO datosVO = new DatosPersonalesVO();
                                        DatosPersonalesDAO datosDAO = new DatosPersonalesDAO();
                                        ArrayList<DatosPersonalesVO> listadocentes = datosDAO.listarEstudiantes();
                                        for (int i = 0; i < listadocentes.size(); i++) {
                                            datosVO = listadocentes.get(i);
                                    %>
                                    <tr>
                                        <td><%=datosVO.getDatosnombres()%></td>
                                        <td><%=datosVO.getDatosapellidos()%></td>
                                        <td><%=datosVO.getDatostipoid()%></td>
                                        <td><%=datosVO.getIdDatos()%></td>
                                        <td><%=datosVO.getDatostelefono()%></td>
                                        <td><%=datosVO.getDatosemail()%></td>
                                    </tr>
                                    <% }%>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">

            </div>


        </section>
                                    <%@include file="Componentes/footer.jsp" %>
    </body>
</html>
