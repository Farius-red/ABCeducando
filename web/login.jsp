<!doctype html>
<html class="no-js" lang="zxx">
<head>
    
    <title> Login</title>
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
        
       
        <form class="form-default" action="Usuario" method="POST">
            
            <div class="login-form">
                <!-- logo-login -->
                <div class="logo-login">
                    <a href="index.jsp"><img src="assets/img/logo/loder.png" alt=""></a>
                </div>
                <h2>Iniciar Sesi�n </h2>
                <div class="form-input">
                    <label for="name">Correo</label>
                    <input  type="text" name="textusuario" placeholder="escribe nombre de usuario" required>
                </div>
                <div class="form-input">
                    <label for="name">Clave</label>
                    <input type="password" name="textclave" placeholder="Password" required="">
                </div>
                <div class="form-input pt-30">
                    <input type="submit" name="submit" value="login">
                    <input type="hidden" value="1" name="opcion">
                    
                </div>
                
                <!-- Forget Password -->
                <a href="recuperarClave.jsp" class="forget">�olvido su clave?</a>
                <!-- Forget Password -->
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