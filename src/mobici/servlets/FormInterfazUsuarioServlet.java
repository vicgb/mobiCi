package mobici.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.*;
import mobici.model.*;



@WebServlet("/FormInterfazUsuarioServlet")
public class FormInterfazUsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
    public FormInterfazUsuarioServlet() {
        super();
       
    }


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Estacion> estaciones = (List<Estacion>) EstacionDAOImplementation.getInstancia().readAll();
		String id = req.getParameter("id");
		
		req.getSession().removeAttribute("admin");
		req.getSession().invalidate();
		req.getSession().setAttribute("id", estaciones);
		getServletContext().getRequestDispatcher("/Estacion.jsp").forward(req,resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
