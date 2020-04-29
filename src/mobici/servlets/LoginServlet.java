package mobici.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
			
			List<Viaje> viajes = (List<Viaje>)  ViajeDAOImplementation.getInstancia().readAll();
			Viaje viajeActual = null;
			int i=0;
			while(i< viajes.size()) {
				Viaje viaje= viajes.get(i);
				if(viaje.getIdUsuario().equals(email) && viaje.getFinDate() == null) {
					//El usuario est� en un viaje y no ha acabado
					viajeActual = viaje;
					req.getSession().setAttribute("viaje", viajeActual);
					break;
				}
				i++;
			}
			
			req.getSession().setAttribute("email", email);
			req.getSession().setAttribute("estaciones", estaciones);
			//req.getSession().setAttribute("usuarios", usuarios);
			req.getSession().setAttribute("usuario", usuario);
			getServletContext().getRequestDispatcher("/InterfazUsuario.jsp").forward(req,resp);
		
		} else {
			JOptionPane.showMessageDialog(null, "El login o la contraseña son incorrectos");
			getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
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