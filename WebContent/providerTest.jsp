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
<title>Add New Provider</title>
</head>
<body>
<form action="providerController" class="form-horizontal ws-validate" method="post">
    		<div class="form-group">
				<label for="idFornec" class="control-label">Provider ID</label> <input type="text"
					class="form-control"
					name="idFornec" value="<c:out value="${fornecedor.idFornec}" />"
					readonly="readonly" placeholder="Provider ID" />
			</div>
			<div class="form-group">
				<label for="nomeFornec" class="control-label">Name*</label> <input type="text"
					class="form-control" name="nomeFornec" value="<c:out value="${fornecedor.nomeFornec}" />"
					placeholder="Name" />
			</div>
			<div class="form-group">
				<label for="cnpjFornec" class="control-label">CNPJ*</label> <input type="text"
					class="form-control" name="cnpjFornec" value="<c:out value="${fornecedor.cnpjFornec}" />"
					placeholder="CNPJ" />
			</div>
			<div class="form-group">
				<label for="fornecUf" class="control-label">UF*</label> <input type="text" name="fornecUf"
					class="form-control" value="<c:out value="${fornecedor.fornecUf}" />" placeholder="UF" />
			</div>
			<div class="form-group">
				<label for="dsFornec" class="control-label">Description*</label> <input type="text" name="dsFornec"
					class="form-control" value="<c:out value="${fornecedor.dsFornec}" />" placeholder="Description" />
			</div>
			<div class="form-group">
				<label for="telFornec" class="control-label">Phone*</label> <input type="text" name="telFornec"
					class="form-control" value="<c:out value="${fornecedor.telFornec}" />" placeholder="Phone" />
			</div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Accept</button>
        <a href="providerController" class="btn btn-primary">Back</a>
    </div>
</form>
</body>
</html>