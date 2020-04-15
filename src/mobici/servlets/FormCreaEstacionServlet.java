package mobici.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.EstacionDAOImplementation;
import mobici.model.Estacion;

/**
 * Servlet implementation class FormCreaEstacion
 */
@WebServlet("/FormCreaEstacionServlet")
public class FormCreaEstacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormCreaEstacionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id  = req.getParameter("id");
		String latitud = req.getParameter("latitud");
		String longitud = req.getParameter("longitud");
		String c = req.getParameter("capacidad");
		int capacidad = Integer.parseInt(c);

		Estacion estacion= new Estacion();
		estacion.setId(id);
		estacion.setLatitud(latitud);
		estacion.setLongitud(longitud);
		estacion.setCapacidad(capacidad);
		estacion.setAnclajes(null);

		EstacionDAOImplementation.getInstancia().create(estacion);
		List<Estacion> le = new ArrayList<Estacion>();
		le.addAll((List<Estacion>)         
				req.getSession().getAttribute("estaciones"));
		le.add (estacion);
		req.getSession().setAttribute("estaciones", le);
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