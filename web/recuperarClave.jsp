<!doctype html>
<html class="no-js" lang="zxx">
<head>
    
    <title> Recuperar Clave</title>
    <meta name="description" content="">
    <%@include file="Componentes/head.jsp" %>
  
</head>
<body>
    <!-- ? Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="assets/img/logo/loder.png" alt="">
                </div>
            </div>
        </div>
    </div>
    <!-- Preloader Start-->


    <main class="login-body" data-vide-bg="assets/img/login-bg.mp4">
        <!-- Login Admin -->
        
       
        <form class="formulario form-default" action="Mensajes" method="POST">
            
            <div class="login-form">
                <!-- logo-login -->
                <div class="logo-login">
                    <a href="index.html"><img src="assets/img/logo/loder.png" alt=""></a>
                </div>
                <h2>Recuperar clave </h2>
                <div class="form-input">
                    <label for="name">Correo</label>
                    <input  type="text" name="receptor" placeholder="escriba su correo"  title="Email incorrecto revise su formato" pattern="^[a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,15})$"  required>
                </div>
                
                <div class="form-input pt-30">
                    <input type="submit" name="submit" value="Recuperar Clave">
                    <input type="hidden" value="3" name="opcion">
                    
                </div>
                
                <!-- Forget Password -->
                <a href="login.jsp" class="forget">login</a>
               <div class="container">
            <h1> <%@include file="Componentes/mensajesRespuesta.jsp"%></h1>
        </div>
            </div>
        </form>
        
        <!-- /end login form -->
    </main>


    <%@include file="Componentes/scripts.jsp" %>
    
    </body>
</html>