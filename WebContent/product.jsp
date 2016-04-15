<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add New Product</title>
</head>
<body>
	<form action="productController" method="post">
		<fieldset>
			<div>
				<label for="codProd">Product COD</label> <input type="text"
					name="codProd" value="<c:out value="${produto.codProd}" />"
					readonly="readonly" placeholder="Product COD" />
			</div>
			<div>
				<label for="nomeProd">Name</label> <input type="text"
					name="nomeProd" value="<c:out value="${produto.nomeProd}" />"
					placeholder="Name" />
			</div>
			<div>
				<label for="tipoProd">Type</label> <input type="text"
					name="tipoProd" value="<c:out value="${produto.tipoProd}" />"
					placeholder="Type" />
			</div>
			<div>
				<label for="tamanhoProd">Size</label> <input type="text" name="tamanhoProd"
					value="<c:out value="${produto.tamanhoProd}" />" placeholder="Size" />
			</div>
			<!-- <div>
				<label for="prodFornec">Provider</label> <input type="text" name="prodFornec"
					value="<c:out value="${produto.prodFornec.nomeFornec}" />" placeholder="Provider" />
			</div>  -->
				<div>
					  <label class="control-label">Provider</label>
						    <select id="provider"  name="idFornec" class="input-xlarge">
					     	 <c:forEach items="${fornecedores}" var="fornecedor" >
									<option><c:out value="${fornecedor.idFornec} - ${fornecedor.nomeFornec}"/></option>
	 						</c:forEach>
						    </select>
				</div>
			<div>
				<input type="submit" value="Submit" />
			</div>
		</fieldset>
	</form>
</body>
</html>