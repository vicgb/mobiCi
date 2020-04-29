<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file = "NavbarEstacion.jsp" %>
<style>
#formularioPerfil{
	margin-top: 150px;
	margin-left: 80px;
	border: 2px solid !important;
	float: left;
	padding: 30px;
}
label{
	padding: 0px;
	margin: 0px;
}
</style>
<body>

	<div id = "formularioPerfil">
	<label><b>Nombre:</b> ${usuario.nombre}</label>
	<br>
	<br>
	


	<label><b>Apellido1:</b> ${usuario.apellido1}</label>
	<br>
	<br>
	
	

	<label><b>Apellido2:</b> ${usuario.apellido2}</label>
	<br>
	<br>
	
	
	<label><b>Email:</b> ${usuario.email}</label>
	<br>
	<br>
	
	
	<label><b>Número de teléfono:</b> ${usuario.telefono}</label>
	<br>
	<br>
	

	<label><b>DNI:</b> ${usuario.dni}</label>
	<br>
	<br>
	

	<label><b>Número de tarjeta:</b> ${usuario.numTarjeta}</label>
	<br>
	<br>
	

	<label><b>Fecha de caducidad:</b> ${usuario.fechaCadu}</label>
	<br>
	<br>
	
	
	<label><b>CVV:</b> ${usuario.cvv}</label>
	<br>
	<br>
	
	
	<br>
	<button type ="submit" class = "btn btn-success">Modificar mi perfil</button>

	</div>
	

</body>
</html>