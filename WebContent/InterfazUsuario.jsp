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
	<h2>Acciones del usuario</h2>
	<p>Aqui deberia ir la navbar</p>
	<p>Salir de la aplicacion</p>
	<form action="FormLogoutServlet">
		<button type="submit">Salir</button>
	</form>
	<table>
		<tr>
			<td>
				<iframe src="https://www.google.com/maps/d/u/0/embed?mid=1rMDFcbZ1U-fNw5k36MjqkNnu6u8mUvGK" width="640" height="480"></iframe>
			</td>
			<td>
				<table>
					<tr>
						<p>Bienvenido, usuario</p>
						<p>Su nombre es ${usuario.nombre}</p>
					</tr>
					<tr>
						<p>Reserva Actual</p>
						<p>Aqui ira la reserva actual del cliente</p>
					</tr>
					<tr>
						<table>
							<tr>
								<td>Estacion</td>
								<td>Ir a</td>
							</tr>
							<c:forEach items="${estaciones}" var="estacioni">
							<tr>
								<td>${estacioni.id}</td>
								<td>
									<td><%@ include file="FormEstacion.jsp"%></td>
								</td>
							</c:forEach>
						</table>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>