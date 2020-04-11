<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

form.formularioLogin{
	margin-top: 50px;
	margin-left: 500px;
	border: 1px solid !important;
	float:left;
	padding: 30px;
}

button{
	margin-top: 10px;
}

label{
	margin-top: 10px;
}
</style>
<body>

<form action ="LoginServlet" class = "formularioLogin">
	<div>
	<label>Usuario</label>
	<br>
	<input type="email" name="email" placeholder = "Introduzca su email">
	<div>
	<label>Contraseña</label>
	<br>
	<input type="password" name="password" placeholder = "Introduzca su contraseña">
	</div>
	
	<button type ="submit" class = "btn btn-success">Acceder</button>

	</div>
	</form>
</body>
</html>