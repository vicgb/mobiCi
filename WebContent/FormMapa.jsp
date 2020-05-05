<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
#map {
	height: 400px; /* The height is 400 pixels */
	width: 50%; /* The width is the width of the web page */
}
</style>
</head>
<body>
	<div id="map"></div>
	<script>
		window.markers = [];
		function initMap() {
			var map = new google.maps.Map(document.getElementById('map'), {
				center: {lat: 40.419717, lng: -3.688456	},
				zoom: 15
			});
			window.markers.forEach(function (marker) {
				var marker = new google.maps.Marker(Object.assign({map: map}, marker))
			})
		}
	</script>
	<c:forEach items="${estaciones}" var="estacioni">
		<script>
			( function () {
				var latitud = ${estacioni.latitud};
				var longitud = ${estacioni.longitud};
				var titulo = "${estacioni.id}";
				var myPos = {lat : latitud, lng : longitud};
				window.markers.push({position: myPos, title: titulo});
			} )()
		</script>
	</c:forEach>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDJGteAywUskIEdmQ2RoaiYKyREz-06Caw&callback=initMap">
	</script>
</body>
</html>