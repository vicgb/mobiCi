package mobici.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import mobici.dao.EstacionDAOImplementation;
import mobici.model.Estacion;

/**
 * Servlet implementation class EliminarEstacionServlet
 */
@WebServlet("/EliminarEstacionServlet")
public class EliminarEstacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarEstacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String estacionID = req.getParameter("estacionID");
    	Estacion estacion = EstacionDAOImplementation.getInstancia().read(estacionID);
	
    		
    	EstacionDAOImplementation.getInstancia().delete(estacion);
    	
    	List<Estacion> estaciones = (List<Estacion>) EstacionDAOImplementation.getInstancia().readAll();
    	req.getSession().setAttribute("estaciones", estaciones);
    	
    	
    	JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
    	getServletContext().getRequestDispatcher("/InterfazAdmin.jsp").forward(req,resp);
	}
    
     
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
