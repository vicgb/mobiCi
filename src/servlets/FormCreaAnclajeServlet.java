package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnclajeDAOImplementation;
import dao.EstacionDAOImplementation;
import model.Anclaje;
import model.Estacion;
import model.EstadoAnclaje;

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

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id  = req.getParameter("id");
		String idEstacion = req.getParameter("idEstacion");
		Estacion estacion = EstacionDAOImplementation.getInstancia().read(idEstacion);
		
		if (null != estacion) {
			Anclaje anclaje = new Anclaje();
			anclaje.setId(id);
			anclaje.setIdEstacion(idEstacion);
			anclaje.setBicicleta(null);
			anclaje.setEstado(EstadoAnclaje.LIBRE);
			anclaje.setEstacion(estacion);

			AnclajeDAOImplementation.getInstancia().create(anclaje);
			List<Anclaje> la = new ArrayList<Anclaje>();
			la.addAll((List<Anclaje>)req.getSession().getAttribute("anclajes"));
			la.add (anclaje);
			req.getSession().setAttribute("anclajes", la);
		}
		
		getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
