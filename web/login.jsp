<!doctype html>
<html class="no-js" lang="zxx">
<head>
    
    <title> Login</title>
    <meta name="description" content="">
    <%@include file="Componentes/head.jsp" %>
  
</head>
<body>
    <!-- ? Preloader Start -->
    <%@include file="Componentes/preloadaer.jsp" %>
    <!-- Preloader Start-->


    <main class="login-body" data-vide-bg="assets/img/login-bg.mp4">
        <!-- Login Admin -->
        
       
        <form class=" formulario " action="Usuario" method="POST">
            
            <div class="login-form">
                <!-- logo-login -->
                <div class="logo-login">
                    <a href="index.jsp"><img src="assets/img/logo/loder.png" alt=""></a>
                </div>
                <h2>Iniciar Sesión </h2>
                <div class="form-input">
                    <label for="name">Correo</label>
                    <input  type="text" name="textusuario" placeholder="escribe nombre de usuario"  title="Email incorrecto revise su formato" pattern="^[a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,15})$" required>
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
                <a href="recuperarClave.jsp" class="forget">¿olvido su clave?</a>
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