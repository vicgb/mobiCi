package mobici.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.BicicletaDAOImplementation;
import mobici.model.Bicicleta;
import mobici.model.EstadoBici;

/**
 * Servlet implementation class FormCreaBicicletaServlet
 */
@WebServlet("/FormCreaBicicletaServlet")
public class FormCreaBicicletaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormCreaBicicletaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		Bicicleta bicicleta= new Bicicleta();
		bicicleta.setId(id);
		bicicleta.setEstado(EstadoBici.ANCLADA);

		BicicletaDAOImplementation.getInstancia().create(bicicleta);
		List<Bicicleta> lb = new ArrayList<Bicicleta>();
		lb.addAll((List<Bicicleta>)req.getSession().getAttribute("bicicletas"));
		lb.add (bicicleta);
		req.getSession().setAttribute("bicicletas", lb);
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