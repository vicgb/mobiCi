<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar datos del perfil</title>
<style>
#derecha {
	float: right;
	margin-top: 50px;
	margin-right: 450px;
}

#formularioCambioPerfil {
	margin-top: 150px;
	margin-left: 500px;
	border: 2px solid !important;
	float: left;
	padding: 40px;
}

label {
	padding: 0px;
	margin: 0px;
}

table {
	margin-top: 150px;
	background-color: #ffff;
}

th {
	border: 1px solid !important;
	background-color: #A9A9A9;
}

td.td {
	border: 1px solid !important;
}

html {
	background-color: #f4f5f7;
}
</style>
<body>
	<%@ include file="NavbarPerfilModificado.jsp"%>
	<form action="FormModificaPerfilServlet">
	
    <div id="formularioCambioPerfil">
    <div>
	<label><b>Introduzca el nuevo nombre<b></label>
	<br>
	<input type="text" name="nombre">
	</div>
	<br>
    <div>
	<label><b>Introduzca el nuevo primer apellido<b></label>
	<br>
	<input type="text" name="apellido1">
	</div>
	<br>
	<div>
	<label><b>Introduzca el nuevo segundo apellido<b></label>
	<br>
	<input type="text" name="apellido2">
	</div>
	<br>
	<div>
	<label><b>Introduzca el nuevo número de teléfono<b></label>
	<br>
	<input type="tel" name="telefono">
	</div>
	<br>
	<div>
	<label><b>Introduzca el nuevo dni<b></label>
	<br>
	<input type="text" name="dni">
	</div>
	<br>
	<div>
	<label><b>Introduzca el nuevo número de tarjeta<b></label>
	<br>
	<input type="text" name="numTarjeta">
	</div>
	<br>
	<div>
	<label><b>Introduzca la nueva fecha de caducidad<b></label>
	<br>
	<input type="date" name="fechaCadu">
	</div>
	<br>
	<div>
	<label><b>Introduzca el nuevo CVV<b></label>
	<br>
	<input  type="text" name="cvv">
	</div>
	<br>
	<div>
	<button type ="submit" class = "btn btn-success">Guardar cambios</button>
	</div>
	</form>
</body>
</html>