<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <style>
    body {
    margin: 10px;
    padding: 10px;
}
form {
    max-width: 480px;
    margin: auto;
}
.form-group >[class*="col-"] + .ws-errorbox {
    padding: 0 15px;
}
</style>
    <script>
    (function () {
        webshim.setOptions('forms', {
            lazyCustomMessages: true,
            iVal: {
                sel: '.ws-validate',
                handleBubble: 'hide', // hide error bubble

                //add bootstrap specific classes
                errorMessageClass: 'help-block',
                successWrapperClass: 'has-success',
                errorWrapperClass: 'has-error',

                //add config to find right wrapper
                fieldWrapper: '.form-group'
            }
        });

        //load forms polyfill + iVal feature
        webshim.polyfill('forms');
    })();
    </script>
<title>Add New User</title>
</head>
<body>
<form action="userController" class="form-horizontal ws-validate" method="post">
    <div class="form-group">
        <label for="idUsuario" class="control-label">User ID</label>
        <input name="idUsuario" readonly="readonly" value="<c:out value="${usuario.idUsuario}" />" type="text" class="form-control" id="idUsuario" placeholder="User ID"/>
    </div>
    		<div class="form-group">
				<label for="emailUsu" class="control-label">E-mail</label> <input type="text"
					name="emailUsu" value="<c:out value="${usuario.emailUsu}" />"
					class="form-control" placeholder="E-mail"  required  />
			</div>
			<div class="form-group">
				<label for="senhaUsu" class="control-label">Password</label> <input type="text"
					name="senhaUsu" value="<c:out value="${usuario.senhaUsu}" />"
					class="form-control" placeholder="Password"  required  />
			</div>
			<div class="form-group">
				<label for="telefoneUsu" class="control-label">Phone</label> <input type="text" name="telefoneUsu"
					value="<c:out value="${usuario.telefoneUsu}" />" placeholder="Phone"  class="form-control" required  />
			</div>
			<div class="form-group">
				<label for="nomeUsu" class="control-label">Name</label> <input type="text" name="nomeUsu"
					value="<c:out value="${usuario.nomeUsu}" />" placeholder="Name" class="form-control"  required  />
			</div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Accept</button>
        <a href="userController" class="btn btn-primary">Back</a>
    </div>
</form>
</body>
</html>