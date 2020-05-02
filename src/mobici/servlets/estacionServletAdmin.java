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
import mobici.model.Anclaje;
import mobici.model.Estacion;
import mobici.model.EstadoAnclaje;
import mobici.model.Usuario;

/**
 * Servlet implementation class estacionServlet
 */
@WebServlet("/estacionServletAdmin")
public class estacionServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public estacionServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Estacion estacion = EstacionDAOImplementation.getInstancia().read(req.getParameter("estacion"));
		
		
		
		List<Anclaje> anclajes =(List<Anclaje>) AnclajeDAOImplementation.getInstancia().readAll();
		
		List<Anclaje> anclajesDisponibles = new ArrayList<Anclaje>();
		
		
		List<String> anclajesId = new ArrayList<String>();
		List<String> anclajesBicicletas = new ArrayList<String>();
		List<EstadoAnclaje> anclajesEstado = new ArrayList<EstadoAnclaje>();
	
		
		
		
		
		int i=0;
		while(i< anclajes.size()) {
			Anclaje anclaje = anclajes.get(i);
			if(estacion.getId().equals(anclaje.getIdEstacion()) && anclaje.getEstado().equals(EstadoAnclaje.OCUPADO)) {
				anclajesDisponibles.add(anclaje);
			}
			
			i++;
		}
		
		int j=0;
		while(j<anclajes.size()) {
			Anclaje anclaje2 = anclajes.get(j);
			if(estacion.getId().equals(anclaje2.getIdEstacion())){
				anclajesId.add(anclaje2.getId());
				anclajesBicicletas.add(anclaje2.getBicicleta());
				anclajesEstado.add(anclaje2.getEstado());
			}
			j++;
		}
		
		
		
	
		req.getSession().setAttribute("estacion", estacion);
		
		
		req.getSession().setAttribute("anclajesId", anclajesId);
		req.getSession().setAttribute("anclajesBicicletas", anclajesBicicletas);
		req.getSession().setAttribute("anclajesEstado", anclajesEstado);
		
	
		
		
		int disponibles = anclajesDisponibles.size();
		
		//Se le pasa el tamaño de la lista anclajesDisponibles al parametro disponibles
		req.getSession().setAttribute("disponibles", disponibles);
		if(disponibles > 0) {			
			req.getSession().setAttribute("anclajeDisponible", anclajesDisponibles.get(0));
		}
		getServletContext().getRequestDispatcher("/EstacionAdmin.jsp").forward(req,res);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}