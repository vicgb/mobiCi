package mobici.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.AnclajeDAOImplementation;
import mobici.dao.BicicletaDAOImplementation;
import mobici.dao.EstacionDAOImplementation;
import mobici.dao.UsuarioDAOImplementation;
import mobici.dao.ViajeDAOImplementation;
import mobici.model.Anclaje;
import mobici.model.Bicicleta;
import mobici.model.Estacion;
import mobici.model.EstadoAnclaje;
import mobici.model.EstadoBici;
import mobici.model.EstadoUsuario;
import mobici.model.Usuario;
import mobici.model.Viaje;

/**
 * Servlet implementation class AlquilarServlet
 */
@WebServlet("/AlquilarServlet")
public class AlquilarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlquilarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("email");
		System.out.println(req.getParameter("email"));
		Anclaje anclaje = AnclajeDAOImplementation.getInstancia().read(req.getParameter("anclaje"));
		Estacion estacion = EstacionDAOImplementation.getInstancia().read(req.getParameter("estacion"));
		Usuario usuario = UsuarioDAOImplementation.getInstancia().read(req.getParameter("email"));
		Bicicleta bicicleta= BicicletaDAOImplementation.getInstancia().read(anclaje.getBicicleta());

		Viaje viaje = new Viaje(anclaje, usuario.getEmail(), bicicleta.getId());
		ViajeDAOImplementation.getInstancia().create(viaje);
		anclaje.liberarAnclaje();
		bicicleta.setEstado(EstadoBici.VIAJANDO);
		AnclajeDAOImplementation.getInstancia().update(anclaje);
		BicicletaDAOImplementation.getInstancia().update(bicicleta);
		int disponibles = Integer.parseInt(req.getParameter("disponibles"));
		disponibles--;
		req.getSession().setAttribute("estacion", estacion);
		req.getSession().setAttribute("anclaje", anclaje);
		req.getSession().setAttribute("bicicleta", bicicleta);
		req.getSession().setAttribute("disponibles", disponibles);
		req.getSession().setAttribute("alquilado", true);
		getServletContext().getRequestDispatcher("/Estacion.jsp").forward(req,res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}