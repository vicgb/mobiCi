<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="NavbarModificarPerfil.jsp"%>
<style>
#derecha {
	float: right;
	margin-top: 120px;
	margin-right: 70px;
}

#viaje {
	float: right;
	margin-top: 90px;
	margin-right: 520px;
}

#formularioPerfil {
	margin-top: 120px;
	margin-left: 60px;
	border: 2px solid !important;
	float: left;
	padding: 30px;
	font-size: large;
}

label {
	padding: 0px;
	margin: 0px;
}

table {
	margin-top: -100px;
	background-color: #ffff;
	font-size:medium;
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
	<div id="formularioPerfil">
	<h1>Datos del perfil</h1>
		<br>
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
		<br> <br>
		<label><b>Número de teléfono:</b> ${usuario.telefono}</label>
		<br>
		<br> 
		<label><b>DNI:</b> ${usuario.dni}</label>
		<br> <br>
		<label><b>Número de tarjeta:</b> ${usuario.numTarjeta}</label>
	    <br>
		<br>
	    <label><b>Fecha de caducidad:</b>${usuario.fechaCadu}</label>
	    <br> <br> 
	    <label><b>CVV:</b>${usuario.cvv}</label>
	    <br>
	</div>

    <div id="viaje">
    <h1>Últimos viajes</h1>
    </div>>

	<div id="derecha">
	
		<table border="1">
			<tr>
				<th>Fecha y hora de inicio</th>
				<th>Fecha final</th>
				<th>Estación Inicio</th>
				<th>Estación Destino</th>
				<th>Bicicleta</th>
				<th>Coste</th>
			</tr>

			<c:forEach items="${viajes}" var="viajei"  end="9">
				<tr>
					<td>${viajei.inicioDate}</td>
					<td>${viajei.finDate}</td>
					<td>${viajei.anclajeInicio.idEstacion}</td>
					<td>${viajei.anclajeFin.idEstacion}</td>
					<td>${viajei.idBicileta}</td>
					<td>${viajei.coste} €</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>