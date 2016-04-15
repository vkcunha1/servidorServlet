<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String contexto = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Sucesso</title>
</head>
<body>
	<section class="hero" id="hero">
		<div class="text-center">
			<h1 class="animated fadeInDown">BEM VINDO <span> ${usuarioLogado.nomeUsu}!</span></h1>
			<br/>
			<h1 class="animated fadeInDown delay-05s">Deseja Continuar?</h1>
			 <div class="row">
	          <div class="col-md-6 col-md-offset-3 text-center">
	           <a href="menuController" class="learn-more-btn">Sim</a>
	                </div>
	         </div>
			 <div class="row">
	          <div class="col-md-6 col-md-offset-3 text-center">
	           <a href="loginController.do?action=nao" class="learn-more-btn">Não</a>
	                </div>
	         </div>
		</div>
	</section>
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