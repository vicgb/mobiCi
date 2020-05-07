package mobici.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.AnclajeDAOImplementation;
import mobici.dao.EstacionDAOImplementation;
import mobici.dao.UsuarioDAOImplementation;
import mobici.dao.ViajeDAOImplementation;
import mobici.model.Anclaje;
import mobici.model.Estacion;
import mobici.model.EstadoAnclaje;
import mobici.model.EstadoUsuario;
import mobici.model.Usuario;

/**
 * Servlet implementation class estacionServlet
 */
@WebServlet("/estacionServlet")
public class estacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public estacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Estacion estacion = EstacionDAOImplementation.getInstancia().read(req.getParameter("estacion"));
		Usuario usuario= UsuarioDAOImplementation.getInstancia().read(req.getParameter("email"));
		List<Anclaje> anclajes =(List<Anclaje>) AnclajeDAOImplementation.getInstancia().readAll();
		List<Anclaje> anclajesDisponibles = new ArrayList<Anclaje>();
		int i=0;
		while(i< anclajes.size()) {
			Anclaje anclaje = anclajes.get(i);
			if(estacion.getId().equals(anclaje.getIdEstacion()) && anclaje.getEstado().equals(EstadoAnclaje.OCUPADO)) {
				anclajesDisponibles.add(anclaje);
			}
			i++;
		}
		req.getSession().setAttribute("estacion", estacion);
		req.getSession().setAttribute("email", req.getParameter("email"));
		int disponibles = anclajesDisponibles.size();
		req.getSession().setAttribute("disponibles", disponibles);
		if(disponibles > 0) {
			req.getSession().setAttribute("anclajeDisponible", anclajesDisponibles.get(0));
		}
		
		if(usuario.getEstadoUsuario().equals(EstadoUsuario.VIAJANDO)) {
			req.getSession().setAttribute("alquilado", true);
		} else {
			req.getSession().setAttribute("alquilado", false);
			
		}
		
		if(usuario.getEstadoUsuario().equals(EstadoUsuario.NADA) || usuario.getEstadoUsuario().equals(null) ) {
			req.getSession().setAttribute("puedeAlquilar", true);
		} else {
			req.getSession().setAttribute("puedeAlquilar", false);
		}
		
		getServletContext().getRequestDispatcher("/Estacion.jsp").forward(req,res);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}