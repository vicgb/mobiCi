package mobici.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import mobici.dao.UsuarioDAO;
import mobici.dao.UsuarioDAOImplementation;
import mobici.model.Usuario;



@WebServlet("/FormModificaContraseñaServlet")
public class FormModificaContraseñaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FormModificaContraseñaServlet() {
        super();
       
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String emailUsuario = (String) req.getSession().getAttribute("email");
		UsuarioDAO dao = UsuarioDAOImplementation.getInstancia();
		
		Usuario usuario = dao.read(emailUsuario);
		

		String password = req.getParameter("password");
		String repPassword = req.getParameter("repPassword");
		
		
		if(((!password.isEmpty())&(!repPassword.isEmpty()))&(repPassword.equals(password))) {
			usuario.setPassword(password);
			usuario.setRepPassword(repPassword);
			JOptionPane.showMessageDialog(null, "La contraseña se ha modificado correctamente");
			req.getSession().setAttribute("usuario", usuario);
			dao.update(usuario);
			res.sendRedirect(req.getContextPath() + "/InterfazUsuario.jsp");
			
		} else {
			
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
			res.sendRedirect(req.getContextPath() + "/FormModificarContrasena.jsp");
		}
	
	
	}

}
