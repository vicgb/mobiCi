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
	border: 1px solid !important;
	margin-bottom: 10px;
	background-color: #ffff;
}

input{
margin: 15px;

}

button{

margin-top: 5px;
padding: 5px;
margin-left: 15px;
margin-bottom: 5px;
}

</style>
<body>
<p>Crear estación </p>
  <div  class = "formularioCrear">
  
<form action="FormCreaEstacionServlet">
	<div><input type="text" name="id" placeholder="ID"></div>
	<div><input type="text" name="direccion" placeholder="Direccion"></div>
	<div><input type="text" name="longitud" placeholder="Longitud"></div>
	<div><input type="text" name="latitud" placeholder="Latitud"></div>
	<div><input type="number" name="capacidad" placeholder="capacidad"></div>
	<div><button type="submit">Crear</button></div>
</form>
</div>
</body>
</html>