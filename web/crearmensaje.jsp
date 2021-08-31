
<%@page import="java.util.ArrayList"%>
<%@page import="modeloDAO.MensajesDAO"%>
<%@page import="modeloVO.MensajesVO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include  file="Componentes/head.jsp" %>
    </head>
    <body>
        <%@include file="Componentes/header.jsp" %>
        
<!-- ? Preloader Start -->
<%@include file="Componentes/preloadaer.jsp" %>
    <!-- Preloader Start-->

        
  <div class="container  mt-4 d-flex justify-content-around">
      
      
    <div class="row">
        <div class="col-12">
        <div style="color: #007180;">
                        <%
                            if (request.getAttribute("mensaje") != null) {
                        %>
                        ${mensaje}
                        <%} else {%>
                        ${mensaje}
                        <%}%>
                    </div>
                    </div>
        <div class="col-md-6 col-lg-8">
            <%
                    String clave ="",datosemail ="";
                    String mensaje ="";
                 if(request.getAttribute("clave")!= null){
                                  clave =(String) request.getAttribute("clave");
                                       mensaje= "Su clave de acceso es\n"+ clave;
                                    }
                 
if(request.getAttribute("datosemail")!= null){
                                         datosemail =(String) request.getAttribute("datosemail");
                                    }
            %>

            <form  class="needs-validation formulario" method="post" action="Mensajes">
                <div class="card " style=" width: 100%; height: 60%">
                    <div class="card-header bg-dark">
                        <h4 class="text-center text-bold text-white">Crear nuevo
                            mensaje
                        </h4>
                    </div>
                    <div class="card-body">
                        
                        <div class="form-group form-row ">
                            
                            <div class="col-md-6">
                            <label class="text-bold font-italic">Destino</label>
                            <input 
                                type="email"  placeholder="Escriba correo destino" class="form-control " style="font-size: 15px;" name="receptor"
                                title="Email incorrecto revise su formato" pattern="^[a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,15})$" required value="<%=datosemail%>" />
                            </div>
                             <input id="metodo" type="hidden" name="opcion" value="1" >
                
                              
                             
                             <div class="col-md-6">
                                 <label class="text-bold font-italic">Asunto</label>
                            <input 
                                type="text"   class="form-control" style="font-size: 15px;" placeholder="Escriba un asunto" name="asunto"
                                placeholder="Escriba Aqui su asunto" pattern="^.{1,25}$" title="El asunto es requerido y no puede pasar los 25 caracteres" required />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="text-bold font-italic">mensaje</label>
                            <textarea 
                                class="form-control" placeholder="Escriba su mensaje aqui" name="contenido"
                                rows="3"  data-pattern="^.{2,255}$" title="Tu comentario no debe pasar los 255 caracteres" required ><%=mensaje %> </textarea>
                        </div>
                    </div>
                    <div class="card-footer align-content-center">
                        <button 
                            type="submit" class="btn btn-group-sm align-center">Crear
                            mensaje</button>
                    </div>
                </div>
            </form>





        </div>
        <div class="col-md-6 col-lg-4 mt-4">
            <table class="table table-light table-hover shadow-lg p-3 mb-5
                bg-white rounded">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">mensaje</th>
                         <th scope="col">destinatario</th>
                         <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody class="">
                    <%
                                        
                                        MensajesVO mensVO = new MensajesVO();
                                        MensajesDAO mensajesDAO = new MensajesDAO();
                                        ArrayList<MensajesVO> listaMensajes = mensajesDAO.listaMensajes();
                                        for (int i = 0; i < listaMensajes.size(); i++) {
                                            mensVO = listaMensajes.get(i);
                           %>
                    <tr >
                        <th><%=mensVO.getId_mensaje()%></th>
                        <th class="font-weight-normal"><%=mensVO.getMensaje()%></th>
                        <th class="font-weight-normal"><%=mensVO.getDestinatario()%></th>
                        <td>
                                            <form id="crudForm"  action="Mensajes" method="post">
                                                
                                                <input id="metodo" type="hidden" name="opcion" value="2" >
                                             
                                                <input type="hidden"  name="idMensaje" value="<%=mensVO.getId_mensaje()%>">
                                                
                                                <button type="submit" class="btn-danger"><i class="fas fa-trash-alt"></i></button>
                                                
                                            </form>
                                        </td>
                    </tr>
                      <% }%>
                </tbody>
            </table>
        </div>
    </div>
</div>
        <script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>
        <%@include file="Componentes/footer.jsp" %>
        <%@include file="Componentes/scripts.jsp" %>
    </body>
</html>
