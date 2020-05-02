<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mobiCi</title>
<%@ include file = "NavbarRegistro.jsp" %>
</head>
<style>
form.formularioLogin{
	margin-top: 150px;
	margin-left: 500px;
	border: 1px solid !important;
	float:left;
	padding: 30px;
	background-color: #ffff;
}
button{
	margin-top: 10px;
}
input{
	margin-top: 10px;
	margin-bottom: 10px;
}
html{
background-color: #f4f5f7;
}
</style>
<body>

<form action ="LoginAdminServlet" class = "formularioLogin">

	<div>
	<h2>Administradores</h2>
	</div>
	<div></div>
	<label>Usuario</label>
	<br>
	<input type="text" name="email" placeholder = "Introduzca su email de admin">
	<div>
	<label>Contraseña</label>
	<br>
	<input type="password" name="password" placeholder = "Introduzca su contraseña">
	</div>
	
	<button type ="submit" class = "btn btn-success">Acceder</button>

	
	</form>
</body>
</html>