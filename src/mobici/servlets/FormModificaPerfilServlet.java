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



@WebServlet("/FormModificaPerfilServlet")
public class FormModificaPerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public FormModificaPerfilServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


		String emailUsuario = (String) req.getSession().getAttribute("email");
		UsuarioDAO dao = UsuarioDAOImplementation.getInstancia();

		Usuario usuario = dao.read(emailUsuario);

		String nombre = req.getParameter("nombre");
		String apellido1 = req.getParameter("apellido1");
		String apellido2 = req.getParameter("apellido2");
		String telefono = req.getParameter("telefono");
		String dni = req.getParameter("dni");
		String numTarjeta = req.getParameter("numTarjeta");
		String fechaCadu = req.getParameter("fechaCadu");
		String cvv = req.getParameter("cvv");

		if(!nombre.isEmpty()) {
			usuario.setNombre(nombre);
		}
		if(!apellido1.isEmpty()) {
			usuario.setApellido1(apellido1);
		}
		if(!apellido2.isEmpty()) {
			usuario.setApellido2(apellido2);
		}
		if(!telefono.isEmpty()) {
			usuario.setTelefono(telefono);
		}
		if(!dni.isEmpty()) {
			usuario.setDni(dni);
		}
		if(!numTarjeta.isEmpty()) {	
			usuario.setNumTarjeta(numTarjeta);
		}
		if(!fechaCadu.isEmpty()) {
			usuario.setFechaCadu(fechaCadu);
		}
		if(!cvv.isEmpty()) {
			usuario.setCvv(cvv);
		}

		JOptionPane.showMessageDialog(null, "Los datos se han modificado correctamente");
		req.getSession().setAttribute("usuario", usuario);
		dao.update(usuario);
		res.sendRedirect(req.getContextPath() + "/InterfazUsuario.jsp");


	}

}
