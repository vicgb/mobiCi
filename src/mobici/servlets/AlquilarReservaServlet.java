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
import mobici.model.Anclaje;
import mobici.model.Bicicleta;
import mobici.model.EstadoAnclaje;
import mobici.model.EstadoBici;
import mobici.model.EstadoUsuario;
import mobici.model.Reserva;
import mobici.model.Usuario;

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
			Usuario usuario = UsuarioDAOImplementation.getInstancia().read(req.getParameter("usuario"));
			Anclaje anclaje = AnclajeDAOImplementation.getInstancia().read(req.getParameter("anclaje"));
			Bicicleta bicicleta = BicicletaDAOImplementation.getInstancia().read(anclaje.getBicicleta());

			usuario.setEstadoUsuario(EstadoUsuario.VIAJANDO);
			anclaje.setEstado(EstadoAnclaje.LIBRE);
			anclaje.setBicicleta(null);
			bicicleta.setEstado(EstadoBici.VIAJANDO);

			UsuarioDAOImplementation.getInstancia().update(usuario);
			AnclajeDAOImplementation.getInstancia().update(anclaje);
			BicicletaDAOImplementation.getInstancia().update(bicicleta);
			ReservaDAOImplementation.getInstancia().delete(reserva);

			req.getSession().setAttribute("reservado", false);
			req.getSession().setAttribute("anclaje", anclaje);
			req.getSession().setAttribute("bicicleta", bicicleta);
			req.getSession().setAttribute("alquilado", true);
			getServletContext().getRequestDispatcher("/InterfazUsuario.jsp").forward(req,res);
		}
		else {
			req.getSession().setAttribute("reservado", false);
			req.getSession().setAttribute("alquilado", false);
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
