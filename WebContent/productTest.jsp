<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Add New Product</title>
</head>
<body>
		<form action="productController" class="form-horizontal ws-validate" method="post">
					<div class="form-group">
				<label for="codProd">Product COD</label> <input type="text"
					class="form-control" name="codProd" value="<c:out value="${produto.codProd}" />"
					readonly="readonly" placeholder="Product COD" />
			</div>
			<div class="form-group">
				<label for="nomeProd">Name</label> <input type="text"
					class="form-control" name="nomeProd" value="<c:out value="${produto.nomeProd}" />"
					placeholder="Name" />
			</div>
			<div class="form-group">
				<label for="tipoProd">Type</label> <input type="text"
					class="form-control" name="tipoProd" value="<c:out value="${produto.tipoProd}" />"
					placeholder="Type" />
			</div>
			<div class="form-group">
				<label for="tamanhoProd">Size</label> <input type="text" name="tamanhoProd"
					class="form-control" value="<c:out value="${produto.tamanhoProd}" />" placeholder="Size" />
			</div>
			<!-- <div>
				<label for="prodFornec">Provider</label> <input type="text" name="prodFornec"
					value="<c:out value="${produto.prodFornec.nomeFornec}" />" placeholder="Provider" />
			</div>  -->
				<div class="form-group">
					  <label class="control-label">Provider</label>
						    <select class="form-control" id="provider"  name="idFornec" class="input-xlarge">
					     	 <c:forEach items="${fornecedores}" var="fornecedor" >
									<option><c:out value="${fornecedor.idFornec} - ${fornecedor.nomeFornec}"/></option>
	 						</c:forEach>
						    </select>
				</div>
		    <div class="form-group">
		        <button type="submit" class="btn btn-primary">Accept</button>
		        <a href="productController" class="btn btn-primary">Back</a>
		    </div>
	</form>
</body>
</html>