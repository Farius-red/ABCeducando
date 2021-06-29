<%@page import="java.util.ArrayList"%>
<%@page import="modeloDAO.ActividadEntregadaDAO"%>
<%@page import="modeloVO.ActividadEntregadaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        
        <title>Listar Actividades</title>
        <meta name="description" content="">
        <%@include file="Componentes/head.jsp" %>
       
    </head>
    <body>
        <%@include file="Componentes/docente/headDocente.jsp" %>
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
                                        <%@include file="Componentes/footer.jsp" %>
    </body>
</html>
