
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String rol = "";
    Integer idusu = null;
    HttpSession miSesion = (HttpSession) request.getSession();
    
    
    if(miSesion.getAttribute("datosUsuario") == null ){
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }else{
    
       
       
        
    }
%>
