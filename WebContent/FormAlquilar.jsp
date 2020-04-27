<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario para alquilar una bicicleta</title>
</head>
<body>
	<form action="AlquilarServlet">
		<input type="hidden" name="anclaje" value="${anclajeDisponible.id}" />
		<input type="hidden" name="estacion" value="${estacion.id}" />
		<input type="hidden" name="disponibles" value="${disponibles}" />
		<input type="hidden" name=email value="${email}" />
		<button type="submit">Alquilar bicicleta</button>
	</form>

</body>
</html>