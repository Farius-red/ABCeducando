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
                    <a href="index.html"><img src="assets/img/logo/loder.png" alt=""></a>
                </div>
                <h2>Login Here</h2>
                <div class="form-input">
                    <label for="name">usuarioLogin</label>
                    <input  type="text" name="textusuario" placeholder="escribe nombre de usuario">
                </div>
                <div class="form-input">
                    <label for="name">Password</label>
                    <input type="password" name="textclave" placeholder="Password">
                </div>
                <div class="form-input pt-30">
                    <input type="submit" name="submit" value="login">
                    <input type="hidden" value="1" name="opcion">
                    <input type="hidden" value="1" name="textid">
                </div>
                
                <!-- Forget Password -->
                <a href="#" class="forget">Forget Password</a>
                <!-- Forget Password -->
                <a href="register.jsp" class="registration">Registration</a>
            </div>
        </form>
        <!-- /end login form -->
    </main>


    <%@include file="Componentes/scripts.jsp" %>
    
    </body>
</html>