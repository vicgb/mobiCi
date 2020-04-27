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
import mobici.dao.BicicletaDAOImplementation;
import mobici.dao.EstacionDAOImplementation;
import mobici.dao.ViajeDAOImplementation;
import mobici.model.Anclaje;
import mobici.model.Bicicleta;
import mobici.model.Estacion;
import mobici.model.EstadoAnclaje;
import mobici.model.EstadoBici;
import mobici.model.Viaje;

/**
 * Servlet implementation class TerminarViaje
 */
@WebServlet("/TerminarViajeServlet")
public class TerminarViajeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TerminarViajeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Estacion estacionFin = EstacionDAOImplementation.getInstancia().read(req.getParameter("estacionFin"));
		Viaje viaje= ViajeDAOImplementation.getInstancia().read(Integer.parseInt(req.getParameter("viaje")));
		List<Anclaje> anclajes =(List<Anclaje>) AnclajeDAOImplementation.getInstancia().readAll();
		List<Anclaje> anclajesDisponibles = new ArrayList<Anclaje>();
		int i=0;
		while(i< anclajes.size()) {
			Anclaje anclaje = anclajes.get(i);
			if(anclaje.getIdEstacion().equals(estacionFin.getId()) && anclaje.getEstado().equals(EstadoAnclaje.LIBRE)) {
				//Hay anclajes disponibles en la estacion seleccionada
				System.out.println("HAY ANCLAJES DISPONIBLES");
				anclajesDisponibles.add(anclaje);
			}
			i++;
		}
		
		if(anclajesDisponibles.size() > 0) {
			Anclaje anclajeFin = anclajesDisponibles.get(0);
			
			viaje.terminarViaje(anclajeFin);
			Bicicleta bicicleta = BicicletaDAOImplementation.getInstancia().read(viaje.getIdBicileta());
			anclajeFin.setEstado(EstadoAnclaje.OCUPADO);
			anclajeFin.setBicicleta(bicicleta.getId());
			bicicleta.setEstado(EstadoBici.ANCLADA);
			
			BicicletaDAOImplementation.getInstancia().update(bicicleta);
			AnclajeDAOImplementation.getInstancia().update(anclajeFin);
			ViajeDAOImplementation.getInstancia().update(viaje);
			
			req.getSession().setAttribute("viajeTerminado", viaje);
		} else {			
			req.getSession().setAttribute("error", "LA ESTACIÓN SELECCIONADA NO TIENE ANCLAJES DISPONIBLES!!! POR FAVOR, SELECCIONE OTRA ESTACIÓN PARA TERMINAR EL VIAJE");
		}
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
