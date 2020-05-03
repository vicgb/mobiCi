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

#formularioCambioContraseña {
	margin-top: 150px;
	margin-left: 550px;
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
	<form action="FormModificaContraseñaServlet">
    <div id="formularioCambioContraseña">
	<div>
	<label><b>Introduzca la nueva contraseña<b></label>
	<br>
	<input type="password" name="password">
	</div>
	<br>
	<div>
	<label><b>Repita la nueva contraseña<b></label>
	<br>
	<input type="password" name="repPassword">
	</div>
	<br>
	<div>
	<button type ="submit" class = "btn btn-success">Guardar cambios</button>
	</div>
	</div>>
	</form>
</body>
</html>