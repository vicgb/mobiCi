<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido, Usuario</title>
</head>
<body>

<h2>Aquí irá un include para el mapa</h2>

<h2>Bienvenido, usuario</h2>
<p>Su nombre es ${usuario.nombre}</p>

<h2>Reserva Actual</h2>
<p>Aquí irá la reserva actual del cliente</p>

<h2>Salir de la aplicacion</h2>
<%@ include file = "FormLogout.jsp" %>

</body>
</html>