package mobici.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import mobici.dao.AnclajeDAOImplementation;
import mobici.dao.EstacionDAOImplementation;
import mobici.model.Anclaje;
import mobici.model.Bicicleta;
import mobici.model.Estacion;
import mobici.model.EstadoAnclaje;

/**
 * Servlet implementation class FormCreaAnclajeServlet
 */
@WebServlet("/FormCreaAnclajeServlet")
public class FormCreaAnclajeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreaAnclajeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	Estacion estacion = EstacionDAOImplementation.getInstancia().read(req.getParameter("estacionId"));
		
    	
		String id = req.getParameter("id");
		String bicicleta = req.getParameter("bicicleta");
		String estacionId = req.getParameter("estacionId");
		
		Anclaje anclaje = new Anclaje();
		anclaje.setId(id);
		anclaje.setBicicleta(bicicleta);
		anclaje.setEstado(EstadoAnclaje.LIBRE);
		anclaje.setIdEstacion(estacionId);
		
		
		
		AnclajeDAOImplementation.getInstancia().create(anclaje);
    	
		
		
		
		List<String> anclajesId = new ArrayList<String>();
		List<String> anclajesBicicletas = new ArrayList<String>();
		List<Anclaje> anclajes =(List<Anclaje>) AnclajeDAOImplementation.getInstancia().readAll();
		
		int j=0;
		while(j<anclajes.size()) {
			Anclaje anclaje2 = anclajes.get(j);
			if(estacion.getId().equals(anclaje2.getIdEstacion())){
				anclajesId.add(anclaje2.getId());
				anclajesBicicletas.add(anclaje2.getBicicleta());
				//anclajesEstado.add(anclaje2.getEstado());
			}
				j++;
			
		}
		
		req.getSession().setAttribute("estacion", estacion);
		req.setAttribute("anclajesId", anclajesId);
		req.setAttribute("anclajesBicicletas", anclajesBicicletas);
		//req.setAttribute("anclajesEstado", anclajesEstado);
		
		
    
    	JOptionPane.showMessageDialog(null, "Se ha creado correctamente el anclaje");
    	getServletContext().getRequestDispatcher("/EstacionAdmin.jsp").forward(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}