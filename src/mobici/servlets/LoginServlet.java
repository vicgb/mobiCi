package mobici.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mobici.dao.*;
import mobici.model.*;

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		System.out.println("hola");
		// TODO Auto-generated constructor stub
	}

	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		List<Usuario> usuarios = (List<Usuario>) UsuarioDAOImplementation.getInstancia().readAll();
		Usuario usuario = UsuarioDAOImplementation.getInstancia().login(email, password);
		
		if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
			req.getSession().setAttribute("admin", true);
			req.getSession().setAttribute("usuarios", usuarios);
			getServletContext().getRequestDispatcher("/InterfazAdmin.jsp").forward(req,resp);
		} else if ( null != usuario ) {
			List<Estacion> estaciones = (List<Estacion>) EstacionDAOImplementation.getInstancia().readAll();
			Reserva reserva = ReservaDAOImplementation.getInstancia().read(email);
			req.getSession().setAttribute("usuario", usuario);
			req.getSession().setAttribute("email", usuario);
			req.getSession().setAttribute("estaciones", estaciones);
			if (null != reserva) {
				req.getSession().setAttribute("reserva", reserva);
				req.getSession().setAttribute("reservado", true);
				Anclaje anclajeReservado = AnclajeDAOImplementation.getInstancia().read(reserva.getAnclaje());
				Estacion estacionReservada = anclajeReservado.getEstacion();
				req.getSession().setAttribute("anclaje", anclajeReservado);
				req.getSession().setAttribute("estacion", estacionReservada);
				req.getSession().setAttribute("vencimiento", reserva.getVencimiento().getTime());
			}
			else {
				req.getSession().setAttribute("reservado", false);
			}
			getServletContext().getRequestDispatcher("/InterfazUsuario.jsp").forward(req,resp);
		
		} else {
			getServletContext().getRequestDispatcher("/FormularioRegistro.jsp").forward(req,resp);
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