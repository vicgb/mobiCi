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

table{
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

html{
background-color: #f4f5f7;
}
</style>

</head>
<body>



	<div id="derecha">

	<h2>Bienvenido: ${usuario.nombre}</h2>

			<table border="1">
				<tr>
					<th>Estacion con ID</th>
					<th>Dirección</th>
					<th>Ir a </th>
				</tr>
				<c:forEach items="${estaciones}" var="estacioni">
					<tr>
						<td>${estacioni.id}</td>
						<td>${estacioni.direccion}</td>
						<td><%@ include file="FormEstacion.jsp"%>
						</td>
					</tr>
				</c:forEach>
			
				
</table>
	</div>
	<div class="mapa">
		<iframe
			src="https://www.google.com/maps/d/u/0/embed?mid=1rMDFcbZ1U-fNw5k36MjqkNnu6u8mUvGK"
			width="600" height="350" style="border: 0;" aria-hidden="false"
			tabindex="0"></iframe>
	</div>
</body>
</html>