package mobici.servlets;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobici.dao.UsuarioDAOImplementation;
import mobici.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Usuario usuario = UsuarioDAOImplementation.getInstance().loginUsuario(email, password);
		if (ADMIN_EMAIL.equals("root") && ADMIN_PASSWORD.equals("root") ) {
			//req.getSession().setAttribute("adminLogged", true);
			//req.getSession().setAttribute("usuario_list", UsuarioDAOImplementation.getInstance().readAllUsuarios());
			resp.sendRedirect(req.getContextPath() + "/InterfazUsuario.jsp");
		} else if (null != usuario) {
			req.getSession().setAttribute("usuario", usuario);
			req.getSession().setAttribute("email", email);
			//Pongo lo del usuario porque aun no hay hecho nada
			resp.sendRedirect(req.getContextPath() + "/Usuario.jsp");
		} else {
			//Volvemos al Login
			resp.sendRedirect(req.getContextPath() + "/Login.jsp");
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
