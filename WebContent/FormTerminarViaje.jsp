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
<form action="TerminarViajeServlet">
		<input type="hidden" name="viaje" value="${viaje.id}" />
		<input type="hidden" name="estacionFin" value="${estacioni.id}" />
	<button type="submit">Terminar viaje</button>
</form>
</body>
</html>