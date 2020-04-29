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
	margin-right: 300px;
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
</style>

</head>
<body>



	<div id="derecha">
		<tr>
			<table border="1">
				<tr>
					<th>Estacion</th>
					<th>Ir a</th>
				<c:choose><c:when test="${not empty viaje and empty viajeTerminado}"><th>Acabar viaje</th></c:when></c:choose>
				</tr>
				<c:forEach items="${estaciones}" var="estacioni">
					<tr>
						<td>${estacioni.id}</td>
						<td><%@ include file="FormEstacion.jsp"%></td>	
			   			<c:choose><c:when test="${not empty viaje and empty viajeTerminado}"> <td><%@ include file="FormTerminarViaje.jsp"%></td>  </c:when></c:choose>
						<!-- <if test="${not empty viaje}"><td><%@ include file="FormTerminarViaje.jsp"%></td></if> -->
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
				   Usted esta realizando un viaje desde el anclaje ${viaje.anclajeInicio.id} comenzado a las ${viaje.inicioDate} <br>
				   <c:if test="${not empty error}">
						${error} <br>
					</c:if>
			   </c:when>
			   <c:otherwise></c:otherwise> 
			</c:choose>
		</tr>

	</div>
	<div class="mapa">
		<iframe
			src="https://www.google.com/maps/d/u/0/embed?mid=1rMDFcbZ1U-fNw5k36MjqkNnu6u8mUvGK"
			width="600" height="350" style="border: 0;" aria-hidden="false"
			tabindex="0"></iframe>
	</div>
</body>
</html>