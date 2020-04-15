<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<form action="estacionServlet" method="get">
		<input type="hidden" name="estacion" value="${estacioni.id}" />
		<button type="submit">Ver estacion</button>
	</form>
</body>
</html>