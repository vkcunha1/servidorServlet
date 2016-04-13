<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String contexto= request.getContextPath();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="js/bootstrap.js"type="text/javascript"></script>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
	<title>Menu</title>
</head>
<body>
	<nav class="navbar navbar-inverse" role="navigation">
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
	          <li><a href="#">Cadastro de Usuarios</a></li>
	          <li><a href="#">Cadastro de Fornecedores</a></li>
	          <li><a href="#">Cadastro de Produtos</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>