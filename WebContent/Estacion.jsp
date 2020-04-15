<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>moBici</title>
<%@ include file = "NavbarRegistrado.jsp" %>
<style>

table.tabla{
border: 1px solid !important;
margin-top: 55px;

margin-right: 55px;
}

#derecha{
	float: right;
}
		
th, td{
border: 1px solid !important;
}	


button{

margin-top: 15px;

}

iframe{
margin-top: 15px;
float: left;
}

	</style>
</head>
<body>

<div id = "derecha">
<table class = "tabla">
  <thead>
  
   <p>Estacion con id ${estacion.id}</p>
   <p>Capacidad total: ${estacion.capacidad}</p>
   <p>Coordenadas: (${estacion.latitud}, ${estacion.longitud})</p>
   <p></p>

    
    </tr> 
  </tbody>
</table>

<button type = "submit" class = "btn btn-success"> Alquilar</button>
</div>
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3036.2185179375506!2d-3.7299398852106176!3d40.44830026164382!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd42283487cc4deb%3A0xe7a4244a657905e9!2sAv.%20Complutense%2C%2028040%20Madrid!5e0!3m2!1ses!2ses!4v1586684352389!5m2!1ses!2ses" width="600" height="350" style="border:0;" aria-hidden="false" tabindex="0"></iframe>

</body>
</html>