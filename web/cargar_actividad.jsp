<%@page import="modeloVO.ActividadCargadaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html lang="en">
    <head>
   
      
      
        
        <title>Carga de actividades</title>
        <meta name="description" content="">
        <jsp:include page="Componentes/head.jsp"  flush="true"></jsp:include>
    </head>
    <body>
    <%@include file="Componentes/docente/headDocente.jsp" %>
        <section class="container-fluid">
            <div class="row">
                <div class="col-xl-12">
                    <div class="registrodocente">
                        <h1>Cargar actividad</h1>                                          
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-4">

                </div>
                <div class="col-xl-4">

                    <div class="datospersonales">


                        <%
                            Integer dato = 0;
                            try {
                                ActividadCargadaVO actividadcargada = (ActividadCargadaVO) request.getAttribute("row");
                                dato = actividadcargada.getActividadcargadaid();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            boolean icono = false;
                            try {
                                icono = (Boolean) request.getAttribute("row2");
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                        %>

                        <form name="formpdf" action="ActividadCargada" method="post" enctype="multipart/form-data">                                
                            <div class="">
                                <!--<table class="tbcargaractividad">-->
                                <thead>
                                    <tr>
                                        <!--<th>Nombre</th>
                                        <th>Campo</th-->
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <td colspan="2">
                                        </td>
                                    </tr>
                                </tfoot>

                                <!--                                            <tr>
                                                                                <td>-->
                                <label for="id">Nombre del archivo: </label><br>
                                <!--                                                </td>  
                                                                                <td>-->
                                <input type="text" name="txtname" value="<c:out value="${row.actividadcargadanombre}" />" /><br><br>
                                <!--                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>-->
                                <label for="id">Descripcion: </label><br>
                                <!--                                                </td>  
                                                                                <td>-->
                                <input type="text" name="textdescripcion" value="<c:out value="${row.actividadcargadadescripcion}" />" /><br><br>
                                <!--                                                </td>
                                                                            </tr>-->
                                <!--                                            <tr class="alt">-->
                                <!--                                                <td>-->
                                <!--                                                    <label for="id">Seleccionar PDF: *</label>-->
                                <%
                                    if (icono) {
                                %>
                                <a href="actividadcargada?id=<%out.print(dato); %>" target="_blank"> Ver Pdf</a><br><br>
                                <%
                                    } else {
//                                                            out.print("No hay Pdf");
                                    }
                                %>
                                <!--                                                </td>  
                                                                                <td>-->
                                <input type="file" name="fichero" value="" class="btn1"/><br><br>
                                <!--                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>-->
                                <label for="id">Docente:</label><br>
                                <!--                                                </td>  
                                                                                <td>-->
                                <input type="text" name="textdocenteid" value="<c:out value="${row.docenteid}" />" /><br><br>
                                <!--                                                </td>
                                                                            </tr>
                                                                            <tr>-->
                                <td colspan="2" style="text-align: center"><input type="submit" value="Enviar Archivo" name="submit" id="btn" class="btn"/></td>
                                <!--                                            </tr>-->

                                <!--</table>-->
                            </div>
                        </form>
                        <a href="Pagina1.jsp">Regresar</a>

                    </div>
                </div>
                <div class="col-xl-4">

                </div>

            </div>


        </section>
     <jsp:include page="Componentes/footer.jsp" flush="true"></jsp:include>
    </body>
</html>
