package mobici.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.AnclajeDAOImplementation;
import mobici.dao.EstacionDAOImplementation;
import mobici.dao.ReservaDAOImplementation;
import mobici.dao.UsuarioDAOImplementation;
import mobici.model.Anclaje;
import mobici.model.Estacion;
import mobici.model.EstadoAnclaje;
import mobici.model.EstadoUsuario;
import mobici.model.Reserva;
import mobici.model.Usuario;

/**
 * Servlet implementation class ReservarServlet
 */
@WebServlet("/ReservarServlet")
public class ReservarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Creación del objeto Reserva con los datos de anclaje, usuario y hora/fecha de vencimiento
		Reserva reserva = new Reserva();
		reserva.setAnclaje(req.getParameter("anclaje"));
		reserva.setUsuario(req.getParameter("usuario"));
		Calendar vencimiento = Calendar.getInstance();
		vencimiento.add(Calendar.MINUTE, 15);
		reserva.setVencimiento(vencimiento);
		ReservaDAOImplementation.getInstancia().create(reserva);
		
		//Actualizamos los objetos involucrados
		Anclaje anclaje = AnclajeDAOImplementation.getInstancia().read(req.getParameter("anclaje"));
		Usuario usuario = UsuarioDAOImplementation.getInstancia().read(req.getParameter("usuario"));
		Estacion estacion = EstacionDAOImplementation.getInstancia().read(req.getParameter("estacion"));
		
		int disponibles = Integer.parseInt(req.getParameter("disponibles"));
		anclaje.setEstado(EstadoAnclaje.RESERVADO);
		AnclajeDAOImplementation.getInstancia().update(anclaje);
		usuario.setEstadoUsuario(EstadoUsuario.RESERVADO);
		UsuarioDAOImplementation.getInstancia().update(usuario);
		
		disponibles--;
		req.getSession().setAttribute("estacion", estacion);
		req.getSession().setAttribute("anclaje", anclaje);
		req.getSession().setAttribute("disponibles", disponibles);
		req.getSession().setAttribute("reserva", reserva);
		req.getSession().setAttribute("reservado", true);
		req.getSession().setAttribute("estacionReservada", estacion.getId());
		req.getSession().setAttribute("vencimiento", reserva.getVencimiento().getTime());
		req.getSession().setAttribute("viajeTerminado", null);
		req.getSession().setAttribute("viaje", null);
		getServletContext().getRequestDispatcher("/InterfazUsuario.jsp").forward(req,res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
