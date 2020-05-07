<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file = "NavbarRegistro.jsp" %>
<style>

html{
background-color: #f4f5f7;
}

#formularioRegistro{
	margin-top: 150px;
	margin-left: 500px;
	border: 1px solid !important;
	float: left;
	padding: 30px;
	background-color: #ffff;
}
label{
	padding: 5px;
	margin: 5px;
}
input{
	margin: 5px;
}
</style>
<body>

	<form action ="FormRegistroServlet">
	<div id = "formularioRegistro">
	<label>Nombre</label>
	<br>
	<input type="text" name="nombre" placeholder = "Introduzca su nombre"/>

	<div>
	<label>Apellido1</label>
	<br>
	<input type="text" name="apellido1" placeholder = "Introduzca su primer apellido"/>
	</div>
	<div>
	<label>Apellido2</label>
	<br>
	<input type="text" name="apellido2" placeholder = "Introduzca su segundo apellido"/>
	</div>
	<div>
	<label>Email</label>
	<br>
	<input type="email" name="email" placeholder = "Introduzca su email"/>
	</div>
	<div>
	<label>Número de teléfono</label>
	<br>
	<input type="tel" name="telefono" placeholder = "Introduzca su número de teléfono"/>
	</div>
	<div>
	<label>DNI</label>
	<br>
	<input type="text" name="dni" placeholder = "Introduzca su DNI" />
	</div>
	<div>
	<label>Número de tarjeta</label>
	<br>
	<input type="text" name="numTarjeta" placeholder = "Introduzca su número de tarjeta"/>
	</div>
	<div>
	<label>Fecha de caducidad</label>
	<br>
	<input type="date" name="fechaCadu" placeholder = "Introduzca la fecha de caducidad de su tarjeta">
	</div>
	<div>
	<label>CVV</label>
	<br>
	<input  type="text" name="cvv" placeholder = "Introduzca el CVV de su tarjeta"/>
	</div>
	<div>
	<label>Contraseña</label>
	<br>
	<input type="password" name="password" placeholder = "Cree una contraseña para su cuenta"/>
	</div>
	<div>
	<label>Repita la contraseña</label>
	<br>
	<input type="password" name="repPassword" placeholder = "Introduzca de nuevo la contraseña"/>
	</div>
	<br>
	<button type ="submit" class = "btn btn-success">Registrarme</button>

	</div>
	</form>

</body>
</html>