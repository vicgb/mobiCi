# mobiCi

Versión definitiva del proyecto mobiCi, para la asignatura de Ingeniería de Sistemas y Servicios Telemáticos de 4º en el itinerario de Telemática, en la ETSIT.

Objetos creados en el Model y sus acciones definidas y desarrolladas en DAO y DAOImplementation, respectivamente. La lógica de la aplicación y la comunicación con la BBDD queda a cargo de los Servlets.

El proyecto en JEE consiste en un usuario que alquila-reserva una bicicleta (asociada a un determinado anclaje y una determinada estación), realiza un viaje y la deja en otro anclaje de otra estación, bajo un coste determinado por minuto. El usuario puede acceder a su perfil para modificar sus datos y para ver los viajes realizados, con sus respectivos costes. Necesario registro y logueo del usuario.

El administrador podrá crear-eliminar una nueva estación, con una determinada capacidad (que será igual al número de anclajes que habrá en la estación) y, una vez dentro del .jsp de administración de esa estación, añadir-eliminar anclajes. 

Las vistas (WebContent) están compuestas por el acceso al login o registro, un interfaz de usuario donde podremos ver las estaciones disponibles (mediante configuración de la API de Google Maps) y, accediendo a una de ellas en concreto, entraremos en otra vista de la propia estación donde veremos una tabla con el número de bicicletas disponibles, la localización de la estación, etc. Si hay bicicletas disponibles, podrá reservar o alquilar una bicicleta.

Por otra parte, el administrador tiene las mismas vistas pero siempre con la capacidad de crear-eliminar estaciones y anclajes, dicha anteriormente.

