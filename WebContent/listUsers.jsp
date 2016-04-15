<!DOCTYPE html>
<html lang="pt-br">
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>System User</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/style.css" rel="stylesheet">
</head>
<body> 
<nav class="navbar navbar-inverse navbar-fixed-top">
 <div class="container-fluid">
  <div class="navbar-header">
   <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
   </button>
   <a class="navbar-brand" href="#">User Navigation:</a>
   <a class="navbar-brand" style="color:#00CC00;" href="#">${usuarioLogado.nomeUsu}</a>
  </div>
  <div id="navbar" class="navbar-collapse collapse">
   <ul class="nav navbar-nav navbar-right">
    <li><a href="menuController">Welcome</a></li>
    <li><a href="#">Options</a></li>
    <li><a href="#">Settings</a></li>
    <li><a href="#">Help</a></li>
    <li><a href="loginController?action=nao">Logout</a></li>
   </ul>
  </div>
 </div>
</nav>
<div id="main" class="container-fluid">
     <div id="top" class="row">
 
     </div> <!-- /#top -->
 
     <hr />
     <div id="list" class="row">
     
     </div> <!-- /#list -->
 
     <div id="bottom" class="row">
     
     </div> <!-- /#bottom -->
 </div>  <!-- /#main -->
 <div id="top" class="row">
    <div class="col-md-3">
        <h2>Search user for name:</h2>
    </div>
 
    <div class="col-md-3" >
        <div class="input-group h2">
        <form action="userController">
            <input name="search" id="search" type="text" placeholder="Search" style="font-size: 20px">
                <button class="btn btn-primary" type="submit">
                    <span class="glyphicon glyphicon-search"></span>
                    </button>
         </form>
        </div>	
    </div>
 
 	<div class="col-md-4">
    	 <a href="userController" class="btn btn-primary pull-right h2">Refresh</a>
    </div>
 
    <div class="col-md-2">
        <a href="userController?action=insert" class="btn btn-primary pull-right h2">New User</a>
    </div>
</div> <!-- /#top -->
<div id="list" class="row">
    <div class="table-responsive col-md-12">
        <table class="table table-striped" cellspacing="0" cellpadding="0">
            <thead>
                <tr>
                    <th>User ID</th>
					<th>Email</th>
					<th>Password</th>
					<th>Phone</th>
					<th>Name</th>
                    <th class="actions">Actions</th>
                 </tr>
            </thead>
            <tbody>
 				<c:forEach items="${usuarios}" var="user" >
                <tr>
                    <td><c:out value="${user.idUsuario}" /></td>
					<td><c:out value="${user.emailUsu}" /></td>
					<td><c:out value="${user.senhaUsu}" /></td>
					<td><c:out value="${user.telefoneUsu}" /></td>
					<td><c:out value="${user.nomeUsu}" /></td>
                    <td class="actions">
                        <a class="btn btn-success btn-xs" href="view.html">View</a>
                        <a class="btn btn-warning btn-xs" href="userController?action=edit&idUsuario=<c:out value="${user.idUsuario}"/>">Edit</a>
                        <a class="btn btn-danger btn-xs"  href="userController?action=delete&idUsuario=<c:out value="${user.idUsuario}"/>" data-toggle="modal" data-target="#delete-modal">Delete</a>
                    </td>
                </tr>
 				</c:forEach>
            </tbody>
         </table>
 
     </div>
 </div> 
 <script src="js/jquery.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
</body>
</html>