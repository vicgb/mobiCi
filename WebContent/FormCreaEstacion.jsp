<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
<form action="FormCreaEstacionServlet">
	<input type="text" name="id" placeholder="ID">
	<input type="text" name="longitud" placeholder="Longitud">
	<input type="text" name="latitud" placeholder="Latitud">
	<input type="number" name="capacidad" placeholder="capacidad">
	<button type="submit">Registrar estacion</button>
</form>
</body>
</html>