<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add New User</title>
</head>
<body>
	<form action="userController" method="post">
		<fieldset>
			<div>
				<label for="idUsuario">User ID</label> <input type="text"
					name="idUsuario" value="<c:out value="${usuario.idUsuario}" />"
					readonly="readonly" placeholder="User ID" />
			</div>
			<div>
				<label for="emailUsu">E-mail</label> <input type="text"
					name="emailUsu" value="<c:out value="${usuario.emailUsu}" />"
					placeholder="E-mail" />
			</div>
			<div>
				<label for="senhaUsu">Password</label> <input type="text"
					name="senhaUsu" value="<c:out value="${usuario.senhaUsu}" />"
					placeholder="Password" />
			</div>
			<div>
				<label for="telefoneUsu">Phone</label> <input type="text" name="telefoneUsu"
					value="<c:out value="${usuario.telefoneUsu}" />" placeholder="Phone" />
			</div>
			<div>
				<label for="nomeUsu">Name</label> <input type="text" name="nomeUsu"
					value="<c:out value="${usuario.nomeUsu}" />" placeholder="Name" />
			</div>
			<div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</fieldset>
	</form>
</body>
</html>