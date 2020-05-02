<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<style>

div.formularioEliminar{
	border: 1px solid !important;
	margin-top:10px;
	margin-right: 5px;
	background-color: #ffff;
}

input{
margin-top: 15px;
margin-left: 25px;
}

button{

margin-top: 5px;
padding: 5px;
margin-left: 25px;
margin-bottom: 15px;
}
</style>
<body>
<p><b>Eliminar anclaje<b></p>
<div class ="formularioEliminar">

<form action="FormEliminaAnclajeServlet">

<div><input type="text" name="anclajeID" placeholder="ID"></div>
	<div><input type="text" name="estacionId" value = "${estacion.id}"></div>
	<button type="submit">Eliminar anclaje</button>
</form>
</div>
</body>
</html>