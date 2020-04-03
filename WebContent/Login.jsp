<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>

form{
	border: 1px solid !important;
	margin: 0px;
}


</style>
<body>


	<form action ="LoginServlet">
	<label>Usuario</label>
	<br>
	<input placeholder = "Introduzca el usuario">

	<div>
	<label>Contraseña</label>
	<br>
	<input placeholder = "Introduzca su contraseña">
	</div>
	<br>
	<button type ="submit" class = "btn btn-success">Iniciar Sesión</button>

	</form>

</body>
</html>