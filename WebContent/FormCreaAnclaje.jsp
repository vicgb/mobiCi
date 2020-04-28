<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>mobiCi</title>
</head>
<style>

div.formularioCrear{
	margin-bottom: 10px;
	border:1px solid !important;
	margin-right:25px;
}

input{
margin-top: 15px;
margin-left: 15px;
margin-right:25px;
}

button{

margin-top: 5px;
padding: 5px;
margin-left: 25px;
margin-bottom:15px;
}

</style>
<body>
<p>Crear anclaje </p>
  <div  class = "formularioCrear">
  
<form action="FormCreaAnclajeServlet">
	<div><input type="text" name="id" placeholder="ID"></div>
	<div><input type="text" name="bicicleta" placeholder="Bicicleta"></div>
	<div><input type="text" name="estado" placeholder="Estado"></div>
	<div><input type="text" name="estacionId" value = "${estacion.id}"></div>
	
	<div><button type="submit">Crear</button></div>
</form>
</div>
</body>
</html>