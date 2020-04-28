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
}
</style>
<body>
<p>Eliminar</p>
<div class ="formularioEliminar">

<form action="EliminarEstacionServlet">

<input type="text" name="estacionID" placeholder="introduce el ID  a eliminar">
<div><button type="submit" class="btn btn-success" id="btnSubmit">Eliminar<span class="glyphicon glyphicon-arrow-right"></span></button></div>

</form>
</div>
</body>
</html>