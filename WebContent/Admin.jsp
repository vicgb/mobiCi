<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista de Admin</title>
</head>
<body>

<h2>Admin</h2>
<p><b>Numero de usuarios activos: </b>${fn:length(usuarios)}</p>

<h2>Usuarios</h2>
<table border="1">
<tr>
<td>Nombre</td>
<td>Email</td>
<td>Password</td>
<td>Apellido1</td>
<td>Apellido2</td>
<td>Telefono</td>
<td>DNI</td>
<td>Numero Tarjeta</td>
<td>Fecha Caducidad</td>
<td>CVV</td>
</tr>
<c:forEach items="${usuarios}" var="usuarioi">
<tr>
<td>${usuarioi.nombre}</td>
<td>${usuarioi.email}</td>
<td>${usuarioi.password}</td>
<td>${usuarioi.apellido1}</td>
<td>${usuarioi.apellido2}</td>
<td>${usuarioi.telefono}</td>
<td>${usuarioi.dni}</td>
<td>${usuarioi.numTarjeta}</td>
<td>${usuarioi.fechaCadu}</td>
<td>${usuarioi.cvv}</td>
</tr>
</c:forEach>
</table>

<h2>Registrar un nuevo Usuario</h2>
<%@ include file = "FormCreaUsuario.jsp" %>

<h2>Estaciones</h2>
<table border="1">
<tr>
<td>Id</td>
<td>Longitud</td>
<td>Latitud</td>
<td>Capacidad</td>
<td>Numero de Anclajes</td>
</tr>
<c:forEach items="${estaciones}" var="estacioni">
<tr>
<td>${estacioni.id}</td>
<td>${estacioni.longitud}</td>
<td>${estacioni.latitud}</td>
<td>${estacioni.capacidad}</td>
<td>${fn:length(estacioni.anclajes)}</td>
</tr>
</c:forEach>
</table>

<h2>Registrar una nueva Estaci�n</h2>
<%@ include file = "FormCreaEstacion.jsp" %>

<h2>Anclajes</h2>
<table border="1">
<tr>
<td>Id</td>
<td>Id Estacion</td>
<td>Estado</td>
<td>Bicicleta</td>
</tr>
<c:forEach items="${anclajes}" var="anclajei">
<tr>
<td>${anclajei.id}</td>
<td>${anclajei.idEstacion}</td>
<td>${anclajei.estado}</td>
<td>${anclajei.bicicleta.id}</td>
</tr>
</c:forEach>
</table>

<h2>Registrar un nuevo anclaje</h2>
<%@ include file = "FormCreaAnclaje.jsp" %>

<h2>Bicicletas</h2>
<table border="1">
<tr>
<td>Id</td>
<td>Estado</td>
</tr>
<c:forEach items="${bicicletas}" var="bicicletai">
<tr>
<td>${bicicletai.id}</td>
<td>${bicicletai.estado}</td>
</tr>
</c:forEach>
</table>

<h2>Registrar una nueva bicicleta</h2>
<%@ include file = "FormCreaBicicleta.jsp" %>


</body>
</html>