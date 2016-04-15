<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String contexto= request.getContextPath();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/flexslider.css" rel="stylesheet" >
    <link href="css/styles.css" rel="stylesheet">
    <link href="css/queries.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<title>Menu</title>
</head>
<body id="top">
	<header id="home">
		<nav>
		<div class="container-fluid">
              <div class="row">
                <div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2">
                  <nav class="pull">
                    <ul class="top-nav">
                      <li><a href="userController">Cadastro de Usuários <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                      <li><a href="providerController">Cadastro de Fornecedores<span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                      <li><a href="productController">Cadastro de Produtos<span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                      <li><a href="loginController?action=nao">Logout<span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                    </ul>
                  </nav>
                </div>
           	  </div>
         </div>
         </nav>
        
         <section class="hero" id="hero">
            <div class="container">
              <div class="row">
                <div class="col-md-12 text-right navicon">
                  <a id="nav-toggle" class="nav_slide_button" href="#"><span></span></a>
                </div>
              </div>
              <div class="row">
                <div class="col-md-8 col-md-offset-2 text-center inner">
                  <h1 class="animated fadeInDown">CRUD<span> PROJECT</span></h1>
                  <p class="animated fadeInUp delay-05s">by <em>Vinícius Kreusch da Cunha</em></p>
                </div>
              </div>
            </div>
          </section>
          <section class="portfolio text-center section-padding" id="portfolio">
          <div class="container">
            <div class="row">
              <div id="portfolioSlider">
                <ul class="slides">
                  <li>
                    <div class="col-md-4 wp4">
                      <div class="overlay-effect effects clearfix">
                        <div class="img">
                          <img src="img/QUF9mL84o.jpg" alt="Portfolio Item">
                          <div class="overlay">
                            <a href="userController" class="expand"><i class="fa fa-search"></i><br>View More</a>
                            <a class="close-overlay hidden">x</a>
                          </div>
                        </div>
                      </div>
                      <h2>Create an Users</h2>
                      <p>Administration the system for permission the users execute controller</p>
                    </div>
                    <div class="col-md-4 wp4 delay-05s">
                      <div class="overlay-effect effects clearfix">
                        <div class="img">
                          <img src="img/portfolio-02.jpg" alt="Portfolio Item">
                          <div class="overlay">
                            <a href="productController" class="expand"><i class="fa fa-search"></i><br>View More</a>
                            <a class="close-overlay hidden">x</a>
                          </div>
                        </div>
                      </div>
                      <h2>Create a Products</h2>
                      <p>Controller your store with the system.</p>
                    </div>
                    <div class="col-md-4 wp4 delay-1s">
                      <div class="overlay-effect effects clearfix">
                        <div class="img">
                          <img src="img/portfolio-03.jpg" alt="Portfolio Item">
                          <div class="overlay">
                            <a href="providerController" class="expand"><i class="fa fa-search"></i><br>View More</a>
                            <a class="close-overlay hidden">x</a>
                          </div>
                        </div>
                      </div>
                      <h2>Edit the Providers</h2>
                      <p>Create a control of you providers.</p>
                    </div>
                  </li>
                  <li>
                    <div class="col-md-4 wp4">
                      <div class="overlay-effect effects clearfix">
                        <div class="img">
                          <img src="img/QUF9mL84o.jpg" alt="Portfolio Item">
                          <div class="overlay">
                            <a href="userController" class="expand"><i class="fa fa-search"></i><br>View More</a>
                            <a class="close-overlay hidden">x</a>
                          </div>
                        </div>
                      </div>
                      <h2>Create an Users</h2>
                      <p>Administration the system for permission the users execute controller.</p>
                    </div>
                    <div class="col-md-4 wp4 delay-05s">
                      <div class="overlay-effect effects clearfix">
                        <div class="img">
                          <img src="img/portfolio-02.jpg" alt="Portfolio Item">
                          <div class="overlay">
                            <a href="productController" class="expand"><i class="fa fa-search"></i><br>View More</a>
                            <a class="close-overlay hidden">x</a>
                          </div>
                        </div>
                      </div>
                      <h2>Create a Products</h2>
                      <p>Controller your store with the system.</p>
                    </div>
                    <div class="col-md-4 wp4 delay-1s">
                      <div class="overlay-effect effects clearfix">
                        <div class="img">
                          <img src="img/portfolio-03.jpg" alt="Portfolio Item">
                          <div class="overlay">
                            <a href="providerController" class="expand"><i class="fa fa-search"></i><br>View More</a>
                            <a class="close-overlay hidden">x</a>
                          </div>
                        </div>
                      </div>
                      <h2>Edit the Providers</h2>
                      <p>Create a control of you providers.</p>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </section>
	<!-- <nav class="navbar navbar-inverse" role="navigation">
			<div class="navbar-header">
		    	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bar1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		    	</button>
		    	<a class="navbar-brand" style="color:#fff; href="#">Menu</a>
			</div>
			<div class="collapse navbar-collapse" id="bar1">
				<ul class="nav navbar-nav">
		          <li><a href="menuController?action">Cadastro de Usuarios</a></li>
		          <li><a href="#">Cadastro de Fornecedores</a></li>
		          <li><a href="#">Cadastro de Produtos</a></li>
				</ul>
			</div>
		</nav>  -->
	</header>
	        <footer>
          <div class="container">
            <div class="row">
              <div class="col-md-6">
                <ul class="legals">
                  <li><a href="#">Terms &amp; Conditions</a></li>
                  <li><a href="#">Legals</a></li>
                </ul>
              </div>
              <div class="col-md-6 credit">
                <p>Designed &amp; Developed by Vinícius Kreusch exclusively;</a></p>
              </div>
            </div>
          </div>
        </footer>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/waypoints.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <script src="js/jquery.flexslider.js"></script>
    <script src="js/modernizr.js"></script>
</body>
</html>