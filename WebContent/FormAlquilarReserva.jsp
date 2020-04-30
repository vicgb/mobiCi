<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AlquilarReservaServlet">
		<input type="hidden" name="reserva" value="${reserva.usuario}" />
		<input type="hidden" name="usuario" value="${usuario.email}" />
		<input type="hidden" name="anclaje" value="${anclaje.id}" />
		<button type="submit">Alquilar</button>
	</form>
</body>
</html>