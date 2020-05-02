<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<form action="estacionServletAdmin" method="get">
		<input type="hidden" name="estacion" value="${estacioni.id}" />
		
		<button type="submit">Ver estacion</button>
	</form>
</body>
</html>