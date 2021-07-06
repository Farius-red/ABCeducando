

<%@page contentType="text/html" pageEncoding="UTF-8"%>
     <%
                                    UsuarioVO usu = new UsuarioVO();
                                    UsuarioDAO usudao = new UsuarioDAO();
                                    miSesion.getAttribute("datosUsuario");
                                    ArrayList<UsuarioVO> datosU = (ArrayList<UsuarioVO>)  miSesion.getAttribute("datosUsuario");
                                    
                                      for (int i = 0; i < datosU.size(); i++) {
                                              usu = datosU.get(i);
                                              
                                          
                                  %>
                                  
                                  <input type="hidden" name="idUsuario" value="<%=usu.getUsuarioid()%>"/> 
                                  
                                  <input type="hidden" name="nombre" value="<%=usu.getNombre()%>"
                                <%}%>  
