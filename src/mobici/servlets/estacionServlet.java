package mobici.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.EstacionDAOImplementation;
import mobici.model.Estacion;

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
		
		
		req.getSession().setAttribute("estacion", estacion);
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
