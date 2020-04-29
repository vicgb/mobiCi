package mobici.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.EstacionDAOImplementation;
import mobici.dao.UsuarioDAOImplementation;
import mobici.model.Estacion;
import mobici.model.Usuario;




/**
 * Servlet implementation class FormPerfilServlet
 */
@WebServlet("/FormPerfilServlet")
public class FormPerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FormPerfilServlet() {
        super();
       
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Usuario usuario = UsuarioDAOImplementation.getInstancia().read("email");
		
		req.setAttribute("usuario", usuario);
		
		getServletContext().getRequestDispatcher("/Perfil.jsp").forward(req,res);
}

	
	

}