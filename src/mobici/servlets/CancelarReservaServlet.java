package mobici.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.AnclajeDAOImplementation;
import mobici.dao.ReservaDAOImplementation;
import mobici.dao.UsuarioDAOImplementation;
import mobici.model.Anclaje;
import mobici.model.EstadoAnclaje;
import mobici.model.EstadoUsuario;
import mobici.model.Reserva;
import mobici.model.Usuario;

/**
 * Servlet implementation class CancelarReservaServlet
 */
@WebServlet("/CancelarReservaServlet")
public class CancelarReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarReservaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Recogemos los datos necesarios
		Reserva reserva = ReservaDAOImplementation.getInstancia().read(req.getParameter("reserva"));
		if (null != reserva) {
			Usuario usuario = UsuarioDAOImplementation.getInstancia().read(reserva.getUsuario());
			Anclaje anclaje = AnclajeDAOImplementation.getInstancia().read(reserva.getAnclaje());

			//Actualizamos valores
			usuario.setEstadoUsuario(EstadoUsuario.NADA);
			anclaje.setEstado(EstadoAnclaje.OCUPADO);

			UsuarioDAOImplementation.getInstancia().update(usuario);
			AnclajeDAOImplementation.getInstancia().update(anclaje);
			ReservaDAOImplementation.getInstancia().delete(reserva);

			//Actualizamos los parámetros
			req.getSession().setAttribute("reservado", false);
			req.getSession().setAttribute("reserva", null);
			req.getSession().setAttribute("estacionReservada", null);
			req.getSession().setAttribute("vencimiento", null);

			getServletContext().getRequestDispatcher("/InterfazUsuario.jsp").forward(req,res);
		}
		else {
			req.getSession().setAttribute("reservado", false);
			req.getSession().setAttribute("reserva", null);
			req.getSession().setAttribute("estacionReservada", null);
			req.getSession().setAttribute("vencimiento", null);

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
