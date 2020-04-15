package mobici.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.AnclajeDAOImplementation;
import mobici.dao.BicicletaDAOImplementation;
import mobici.dao.EstacionDAOImplementation;
import mobici.dao.UsuarioDAOImplementation;
import mobici.model.Anclaje;
import mobici.model.Bicicleta;
import mobici.model.Estacion;
import mobici.model.Usuario;


@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";

	public FormLoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		List<Usuario> usuarios = (List<Usuario>) UsuarioDAOImplementation.getInstancia().readAll();
		List<Estacion> estaciones = (List<Estacion>) EstacionDAOImplementation.getInstancia().readAll();
		List<Anclaje> anclajes = (List<Anclaje>) AnclajeDAOImplementation.getInstancia().readAll();
		List<Bicicleta> bicicletas = (List<Bicicleta>) BicicletaDAOImplementation.getInstancia().readAll();
		
		if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
			req.getSession().setAttribute("admin", true);
			req.getSession().setAttribute("usuarios", usuarios);
			req.getSession().setAttribute("estaciones", estaciones);
			req.getSession().setAttribute("anclajes", anclajes);
			req.getSession().setAttribute("bicicletas", bicicletas);
			getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
		} else {
			getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
