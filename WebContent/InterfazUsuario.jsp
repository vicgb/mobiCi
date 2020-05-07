<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>mobiCi</title>
<%@ include file="NavbarRegistrado.jsp"%>

<style>
#derecha {
	float: right;
	margin-top: 150px;
	margin-right: 50px;
}

table {
	margin-top: 50px;
	background-color: #ffff;
}

th {
	border: 1px solid !important;
	background-color: #A9A9A9;
}

td.td {
	border: 1px solid !important;
}

iframe {
	float: left;
	margin-top: 150px;
	margin-left: 00px;;
}

html {
	background-color: #f4f5f7;
}
</style>

</head>
<body>


	<h2>Bienvenido: ${usuario.nombre}</h2>

	<div id="derecha">
		<table border="1">
			<tr>
				<th>Estacion con ID</th>
				<th>Dirección</th>
				<th>Ir a</th>
				<c:choose>
					<c:when test="${not empty viaje and empty viajeTerminado}">
						<th>Acabar viaje</th>
					</c:when>
				</c:choose>
			</tr>

			<c:forEach items="${estaciones}" var="estacioni">
				<tr>
					<td>${estacioni.id}</td>
					<td>${estacioni.direccion}</td>
					<td><%@ include file="FormEstacion.jsp"%></td>
					<c:choose>
						<c:when test="${not empty viaje and empty viajeTerminado}">
							<td><%@ include file="FormTerminarViaje.jsp"%></td>
						</c:when>
					</c:choose>
				</tr>
			</c:forEach>
		</table>

		<c:choose>
			<c:when test="${not empty viajeTerminado}">
				Usted ha terminado el viaje <br>
				 desde el anclaje ${viajeTerminado.anclajeInicio.id} <br>
				 hasta el anclaje ${viajeTerminado.anclajeFin.id} <br>
				 comenzado a las ${viajeTerminado.inicioDate} <br>
				 terminado a las ${viajeTerminado.finDate} <br>
				 Coste del viaje: ${viajeTerminado.coste} <br>
			</c:when>
			<c:when test="${not empty viaje}">
				   Usted esta realizando un viaje comenzado a las ${viaje.inicioDate} <br>
				<c:if test="${not empty error}">
						${error} <br>
				</c:if>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
		<c:if test="${reservado == true}">
			<%@ include file="FormReservaActual.jsp"%>
		</c:if>

	</div>
	<%@ include file="FormMapa.jsp"%>
</body>
</html>