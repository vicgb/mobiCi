<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mobiCi</title>
<%@ include file="NavbarEstacionAdmin.jsp"%>
<style>

#derecha {
	float: right;
	margin-top: 150px;
	margin-right: 100px;
}
th {
	border: 1px solid !important;
	background-color: #A9A9A9;
}

td.td{
	border: 1px solid;
	
}

table{
	border: 1px solid !important;
}
iframe{
	margin-top: 150px;
	margin-left: 50px;
}

#alquiler{
	float: right;
	margin-right: -25px;
}
div.izquierda{
float: left;
}

</style>
</head>
<body>

	
	
	<div id = "derecha">
		
		
		<h2> Estas en la estación de ${estacion.direccion}</h2>
		<br>
		<br>
		<table>
				<tr>
					<th> Estacion id </th>
					<th> Direccion</th>
					<th> Capacidad </th>
					<th> Coordenadas </th>
					<th> Disponibles </th>
				</tr>
				<tr>
				<td class = "td"> ${estacion.id} </td>
				<td class = "td"> ${estacion.direccion}</td> 
				<td class = "td"> ${estacion.capacidad}</td> 
				<td class = "td">  (${estacion.latitud}, ${estacion.longitud})</td>
				<td class = "td"> ${disponibles}</td>
				</tr>
				

		</table>
		<div>
		<h2> Anclajes de la estacion : ${estacion.id}</h2>
		<table>
				<tr>
					<th>ID</th>
					<th>Bicicleta</th>
					<th>Estado</th>
					
				</tr>
				
				
					<tr>
						<td>${anclajesId}</td>
						<td>${anclajesBicicletas}</td>
						<td>${anclajesEstado}</td>
				</tr>
							
</table>
		</div>
		
		<br>
		<br>
		<br>
		
		
	
		<div class = "izquierda"><%@ include file="FormCreaAnclaje.jsp"%></div>
		<div class = "izquierda"><%@ include file="FormEliminaAnclaje.jsp"%></div>
		
		</div>
		<div>
		
		
		</div>
	
	<div class= "mapa">
	<c:choose>
	
		<c:when test = "${fn: substring(estacion.id, 0 ,7) == 'Plaza 7' }" >
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3037.509441857437!2d-3.6906446852569674!3d40.41971697936475!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zNDDCsDI1JzExLjAiTiAzwrA0MScxOC40Ilc!5e0!3m2!1ses!2ses!4v1587029654550!5m2!1ses!2ses" width="450" height="500" style="border:0;"  aria-hidden="false" tabindex="0"></iframe>
		</c:when>
		<c:when test="${fn: substring(estacion.id, 0 ,8) == 'Parque 1' }">
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3037.902576264694!2d-3.691084685257315!3d40.411008979365846!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zNDDCsDI0JzM5LjYiTiAzwrA0MScyMC4wIlc!5e0!3m2!1ses!2ses!4v1587030020824!5m2!1ses!2ses" width="450" height="500" style="border:0;"  aria-hidden="false" tabindex="0"></iframe>
		</c:when>
		<c:otherwise>
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3037.7680028970954!2d-3.6952886852572164!3d40.41398997936546!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zNDDCsDI0JzUwLjQiTiAzwrA0MSczNS4yIlc!5e0!3m2!1ses!2ses!4v1587030087981!5m2!1ses!2ses" width="450" height="500"  style="border:0;"  aria-hidden="false" tabindex="0"></iframe>
		</c:otherwise>
	</c:choose>
	
	</div>
</body>
</html>