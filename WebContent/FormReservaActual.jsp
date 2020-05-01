
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Reserva Actual</td>
			<td>Vencimiento</td>
			<td>Alquilar</td>
			<td>Cancelar</td>
		</tr>
		<tr>
			<td>${estacion.id}</td>
			<td>${vencimiento}</td>
			<td><%@ include file="FormAlquilarReserva.jsp"%></td>
			<td><%@ include file="FormCancelaReserva.jsp"%></td>
		</tr>
	</table>
</body>
</html>