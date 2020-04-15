<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="FormCreaUsuarioServlet">
	<input type="text" name="email" placeholder="Email">
	<input type="text" name="nombre" placeholder="Nombre">
	<input type="text" name="apellido1" placeholder="Apellido">
	<input type="text" name="apellido2" placeholder="Apellido">
	<input type="password" name="password" placeholder="Password">
	<input type="password" name="repPassword" placeholder="Repita Password">
	<input type="text" name="telefono" placeholder="Teléfono">
	<input type="text" name="dni" placeholder="DNI">
	<input type="text" name="numTarjeta" placeholder="Tarjeta">
	<input type="text" name="fechaCadu" placeholder="Fecha Caducidad">
	<input type="text" name="cvv" placeholder="cvv">
	<button type="submit">Registrar usuario</button>
</form>	
</body>
</html>