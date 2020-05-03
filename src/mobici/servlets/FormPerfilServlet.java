package mobici.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.UsuarioDAOImplementation;
import mobici.dao.ViajeDAOImplementation;
import mobici.model.Usuario;
import mobici.model.Viaje;




/**
 * Servlet implementation class FormPerfilServlet
 */
@WebServlet("/FormPerfilServlet")
public class FormPerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public FormPerfilServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		List<Viaje> viajes = (List<Viaje>) ViajeDAOImplementation.getInstancia().readAll();
		String id = req.getParameter("id");
		Usuario usuario = UsuarioDAOImplementation.getInstancia().read("email");
		

		req.getSession().setAttribute("id", viajes);
		
		req.setAttribute("usuario", usuario);

		req.getSession().setAttribute("idUsuario", viajes);
		


	getServletContext().getRequestDispatcher("/Perfil.jsp").forward(req,res);
}


}