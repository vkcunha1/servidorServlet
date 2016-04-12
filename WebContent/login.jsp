<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1"/>
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<script src="js/bootstrap.min.js"></script>
	<style>
		.navbar-header button {
		color: #fff;
		}
	</style>
<title>Login</title>
</head>
<body>
	<header>
		<nav role="navigation" class="navbar navbar-inverse">
			<div class="navbar-header">
				<button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
					<span class="sr-only">Navegação Responsiva</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			<a class="navbar-brand" style="color:#fff;">Meu site</a>
			</div>
		</nav>
	</header>
	<div class="text-center">
	<div class="thumbnail">
	<h1 class="text-center">Faça o seu login!</h1>
	<br/>
	<form class="form-inline" action="loginController.do?action=logar" method="post">
	  <div class="form-group">
	    <label class="sr-only" for="exampleInputEmail3">Email address</label>
	    <input type="email" class="form-control" id="exampleInputEmail3" name="email" placeholder="Email">
	  </div>
	 	 <br/>
	 	 <br/>
	  <div class="form-group">
	    <label class="sr-only" for="exampleInputPassword3">Password</label>
	    <input type="password" class="form-control" id="exampleInputPassword3" name="senha" placeholder="Password">
	  </div>
		  <br/>
		  <br/>
	  <div class="checkbox">
	    <label>
	      <input type="checkbox"> Me Lembre
	    </label>
	  </div>
	  <br/>
	  <br/>
	  <button type="submit" class="btn btn-warning">Sign in</button>
	</form>
	</div>
	</div>
</body>
</html>