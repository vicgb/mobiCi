package mobici.servlets;

import java.io.IOException;

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
@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		List<Admin> administradores = (List<Admin>) AdminDAOImplementation.getInstancia().readAll();
		Admin admin = AdminDAOImplementation.getInstancia().login(email, password);
		
		 if( null != admin ) {
			List<Estacion> estaciones = (List<Estacion>) EstacionDAOImplementation.getInstancia().readAll();
			List<Anclaje> anclajes = (List<Anclaje>) AnclajeDAOImplementation.getInstancia().readAll();
			
			req.getSession().setAttribute("emailAdmin", admin); //o email
			req.getSession().setAttribute("estaciones", estaciones);
			req.getSession().setAttribute("anclajes", anclajes);
			
			getServletContext().getRequestDispatcher("/InterfazAdmin.jsp").forward(req,resp);
		
		} else {
			JOptionPane.showMessageDialog(null, "El login o la contraseña son incorrectos");
			getServletContext().getRequestDispatcher("/LoginAdmin.jsp").forward(req,resp);
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