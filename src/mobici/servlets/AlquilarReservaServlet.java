package mobici.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.AnclajeDAOImplementation;
import mobici.dao.BicicletaDAOImplementation;
import mobici.dao.ReservaDAOImplementation;
import mobici.dao.UsuarioDAOImplementation;
import mobici.dao.ViajeDAOImplementation;
import mobici.model.Anclaje;
import mobici.model.Bicicleta;
import mobici.model.EstadoAnclaje;
import mobici.model.EstadoBici;
import mobici.model.EstadoUsuario;
import mobici.model.Reserva;
import mobici.model.Usuario;
import mobici.model.Viaje;

/**
 * Servlet implementation class AlquilarReservaServlet
 */
@WebServlet("/AlquilarReservaServlet")
public class AlquilarReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlquilarReservaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Reserva reserva = ReservaDAOImplementation.getInstancia().read(req.getParameter("reserva"));
		if (null != reserva) {
			String email = req.getParameter("usuario");
			Usuario usuario = UsuarioDAOImplementation.getInstancia().read(email);
			Anclaje anclaje = AnclajeDAOImplementation.getInstancia().read(req.getParameter("anclaje"));
			Bicicleta bicicleta = BicicletaDAOImplementation.getInstancia().read(anclaje.getBicicleta());


			Viaje viaje = new Viaje(anclaje, email, bicicleta.getId());
			usuario.setEstadoUsuario(EstadoUsuario.VIAJANDO);
			anclaje.liberarAnclaje();
			bicicleta.setEstado(EstadoBici.VIAJANDO);

			UsuarioDAOImplementation.getInstancia().update(usuario);
			AnclajeDAOImplementation.getInstancia().update(anclaje);
			BicicletaDAOImplementation.getInstancia().update(bicicleta);
			ReservaDAOImplementation.getInstancia().delete(reserva);
			ViajeDAOImplementation.getInstancia().create(viaje);

			req.getSession().setAttribute("anclaje", anclaje);
			req.getSession().setAttribute("bicicleta", bicicleta);
			req.getSession().setAttribute("email", email);
			req.getSession().setAttribute("alquilado", true);
			req.getSession().setAttribute("reservado", false);
			req.getSession().setAttribute("viaje", viaje);
			req.getSession().setAttribute("viajeTerminado", null);
			getServletContext().getRequestDispatcher("/InterfazUsuario.jsp").forward(req,res);
		}
		else {
			req.getSession().setAttribute("reservado", false);
			req.getSession().setAttribute("alquilado", false);
			req.getSession().setAttribute("viajeTerminado", null);
			getServletContext().getRequestDispatcher("/InterfazUsuario.jsp").forward(req,res);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
