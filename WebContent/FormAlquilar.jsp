<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AlquilarServlet">
		<input type="hidden" name="anclaje" value="${anclajeDisponible.id}" />
		<input type="hidden" name="estacion" value="${estacion.id}" />
		<button type="submit">Alquilar bicicleta</button>
	</form>

</body>
</html>