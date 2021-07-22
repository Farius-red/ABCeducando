<%@page import="java.util.ArrayList"%>
<%@page import="modeloDAO.DatosPersonalesDAO"%>
<%@page import="modeloVO.DatosPersonalesVO"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <title>Document</title>
        <meta name="description" content="">

        <%@include  file="Componentes/head.jsp" %>
    </head>
    <body>
        <%@include file="Componentes/header.jsp" %>
        <section class="container-fluid">
            <div class="row">

                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Docentes</h1>
                    </div>
                </div>
                <div class="container">
                    <div class="col-xl-12">
                        <div class="tabladocente">

                            <table  class="table-hover" border="1">
                                <thead class="text-white" style="background: #ED078B;">
                                    <tr>
                                        <th>Numero Documento</th>
                                        <th>Tipo Documento</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Telefono</th>
                                        <th>Email</th> 
                                        <th>EPS</th> 
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                            <tbody>
                                    <%

                                        DatosPersonalesVO datosVO = new DatosPersonalesVO();
                                        DatosPersonalesDAO datosDAO = new DatosPersonalesDAO();
                                        ArrayList<DatosPersonalesVO> listadocentes = datosDAO.listardocentes();
                                        for (int i = 0; i < listadocentes.size(); i++) {
                                            datosVO = listadocentes.get(i);
                                    %>
                                    
                                    <tr>
                                        <td> <%=datosVO.getIdDatos()%></td>
                                        <td> <%=datosVO.getDatostipoid()%></td>
                                        <td> <%=datosVO.getDatosnombres()%></td>
                                        <td><%=datosVO.getDatosapellidos()%></td>
                                        <td><%=datosVO.getDatostelefono()%></td>
                                        <td><%=datosVO.getDatosemail()%></td>
                                        <td><%=datosVO.getEps()%></td>
                                        <td>
                                            <form id="crudForm"  action="Usuario" method="post">
                                                
                                                <input id="metodo" type="hidden" name="opcion" value="5">
                                             
                                                <input type="hidden"  name="textnumeroid" value="<%=datosVO.getIdDatos()%>">
                                                <input type="hidden"  name="textnombres" value="<%=datosVO.getDatosnombres()%>">
                                                <input type="hidden"  name="textapellidos" value="<%=datosVO.getDatosapellidos()%>">
                                                <input type="hidden"  name="texttelefono" value="<%=datosVO.getDatostelefono()%>">
                                                <input type="hidden"  name="textemail" value="<%=datosVO.getDatosemail()%>">
                                                <button type="submit" class="btn-danger"><i class="fas fa-trash-alt"></i></button>
                                                <button onclick="crud('6')" class="btn-warning"><i class="fas fa-user-edit"></i></button>
                                            </form>
                                        </td>
                                    </tr>
                                    <% }%>
                            </tbody>
                                </table>
                            
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">

            </div>


        </section>
        <%@include file="Componentes/footer.jsp" %>
         <script src="assets/js/crud/crud.js" type="text/javascript"></script>
    </body>
</html>
