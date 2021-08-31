
<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.Conexion"%>
<%@page import="util.Conexion"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generar boletin </title>
    </head>
    <body>
         <% 
                                              String estudiante ="";              
                                           File  reporte = new File(application.getRealPath("notas.jasper"));
                                           Map<String,Object> parametros = new HashMap<String, Object>();
                                           
                                           estudiante = request.getParameter("estudiante");
                                           parametros.put("nombre", new String(estudiante));
                                           
                                           Conexion conex = new  Conexion();
                                           Connection conexion = conex.obtenerConexion();
                                           
                                           byte[] reportesBytes = JasperRunManager.runReportToPdf(reporte.getPath(), parametros, conexion);
                                            response.setContentType("application/pdf");
                                            response.setContentLength(reportesBytes.length);
                                            
                                            ServletOutputStream salida = response.getOutputStream();
                                            salida.write(reportesBytes,0,reportesBytes.length);
                                            
                                            salida.flush();
                                            salida.close();
                                      
                                           %>
    </body>
</html>
