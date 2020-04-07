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
    		//log(email);
    		String contraseña = req.getParameter("contraseña");
    		Usuario usuario = UsuarioDAOImplementation.getInstancia().login(email, contraseña);
    		
    		if (ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(contraseña) && req.getSession().getAttribute("usuario")==null ) {
    			//req.getSession().setAttribute("adminLogged", true);
    			//Se supone que ira al interfaz del Administrador. 
    			resp.sendRedirect(req.getContextPath() + "/InterfazAdmin.jsp");
    		}else if (null != usuario && req.getSession().getAttribute("usuario")==null) {
    			//log("estoy aqui");
    			//log(email);
    			req.getSession().setAttribute("usuario", usuario);
    			req.getSession().setAttribute("email", email);
    			resp.sendRedirect(req.getContextPath() + "/InterfazUsuario.jsp");
    		} else if(req.getSession().getAttribute("usuario")!= null && usuario != null){
    			//log("ahora estoy aqui");
    			req.getSession().setAttribute("usuario", null);
    			req.getSession().setAttribute("usuario", usuario);
    			req.getSession().setAttribute("email", null);
    			req.getSession().setAttribute("email", email);
    		
    			resp.sendRedirect(req.getContextPath() + "/InterfazUsuario.jsp");
    		}else{
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
