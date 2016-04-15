<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add New Provider</title>
</head>
<body>
	<form action="providerController" method="post">
		<fieldset>
			<div>
				<label for="idFornec">Provider ID</label> <input type="text"
					name="idFornec" value="<c:out value="${fornecedor.idFornec}" />"
					readonly="readonly" placeholder="Provider ID" />
			</div>
			<div>
				<label for="nomeFornec">Name</label> <input type="text"
					name="nomeFornec" value="<c:out value="${fornecedor.nomeFornec}" />"
					placeholder="Name" />
			</div>
			<div>
				<label for="cnpjFornec">CNPJ</label> <input type="text"
					name="cnpjFornec" value="<c:out value="${fornecedor.cnpjFornec}" />"
					placeholder="CNPJ" />
			</div>
			<div>
				<label for="fornecUf">UF</label> <input type="text" name="fornecUf"
					value="<c:out value="${fornecedor.fornecUf}" />" placeholder="UF" />
			</div>
			<div>
				<label for="dsFornec">Description</label> <input type="text" name="dsFornec"
					value="<c:out value="${fornecedor.dsFornec}" />" placeholder="Description" />
			</div>
			<div>
				<label for="telFornec">Phone</label> <input type="text" name="telFornec"
					value="<c:out value="${fornecedor.telFornec}" />" placeholder="Phone" />
			</div>
			<div>
				<input type="submit" value="Submit" />
			</div>
		</fieldset>
	</form>
</body>
</html>