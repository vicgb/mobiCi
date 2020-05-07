package mobici.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.UsuarioDAOImplementation;
import mobici.dao.ViajeDAOImplementation;
import mobici.model.Anclaje;
import mobici.model.EstadoAnclaje;
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

		String email = req.getParameter("email");
		Usuario usuario = UsuarioDAOImplementation.getInstancia().read(email);
		
		
		req.setAttribute("usuario", usuario);
		
		List<Viaje> viajes = (List<Viaje>) ViajeDAOImplementation.getInstancia().readAll();
		List<Viaje> viajesUsuario = new ArrayList<Viaje>();
		int i=0;
		while(i< viajes.size()) {
			Viaje viaje= viajes.get(i);
			if(viaje.getIdUsuario().equals(usuario.getEmail())) {
				viajesUsuario.add(viaje);
			}
			i++;
		}

		req.getSession().setAttribute("viajes", viajesUsuario);

	getServletContext().getRequestDispatcher("/Perfil.jsp").forward(req,res);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	  


}