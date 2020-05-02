<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<form action="estacionServlet" method="get">
		<input type="hidden" name="estacion" value="${estacioni.id}" />
		<input type="hidden" name="email" value="${email}" />
		<button type="submit">Ver estacion</button>
	</form>
</body>
</html>