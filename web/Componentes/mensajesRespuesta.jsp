

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div style="color: #007180;">
                        <%
                            if (request.getAttribute("mensajeError") != null) {
                        %>
                        ${mensajeError}
                        <%} else {%>
                        ${mensajeExito}
                        <%}%>
                    </div>
