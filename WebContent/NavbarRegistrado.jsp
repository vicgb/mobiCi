<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<style>
header{
	background: rgba(0,0,0,.32) ;
	width: 100%;
	position: fixed;
	z-index: 100;
}
nav{
	float: right;
}

nav ul{
	list-style: none;
	overflwow: hidden;
}

nav ul li {
	float: right;
	font-family: Arial, sans-serif;
	font-size: 16px;
}
nav ul li a {
	display: block;
	padding: 20px;
	color: black;
	text-decoration: none;
}

nav ul li:hover{
	background: #ffff;
}

h2{
	float: left;
	margin-left: 15px;
	margin-top: 15px;
	margin-bottom: 5px;
	font-family: Arial;
}

</style>

<header>
<h2>mobiCi</h2>
	<nav>
	
	<ul>
		<li><a href = "FormLogoutServlet">Salir</a></li>
		 <li><a href = "FormPerfilServlet">Perfil</a></li>

	</ul>
	</nav>
</header>

<body>
</body>
</html>