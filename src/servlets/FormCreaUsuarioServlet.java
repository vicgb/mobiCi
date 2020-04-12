package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAOImplementation;
import model.EstadoUsuario;
import model.Usuario;

/**
 * Servlet implementation class FormCreaUsuarioServlet
 */
@WebServlet("/FormCreaUsuarioServlet")
public class FormCreaUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormCreaUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String nombre = req.getParameter("nombre");
		String repPassword = req.getParameter("repPassword");
		String apellido1 = req.getParameter("apellido1");
		String apellido2 = req.getParameter("apellido2");
		String telefono= req.getParameter("telefono");
		String dni = req.getParameter("dni");
		String numTarjeta = req.getParameter("numTarjeta");
		String fechaCadu = req.getParameter("fechaCadu");
		String cvv = req.getParameter("cvv");

		if (password.contentEquals(repPassword)) {
			Usuario usuario= new Usuario();
			usuario.setEmail(email);
			usuario.setPassword(password);
			usuario.setNombre(nombre);
			usuario.setApellido1(apellido1);
			usuario.setApellido2(apellido2);
			usuario.setTelefono(telefono);
			usuario.setDni(dni);
			usuario.setNumTarjeta(numTarjeta);
			usuario.setFechaCadu(fechaCadu);
			usuario.setCvv(cvv);
			usuario.setEstadoUsuario(EstadoUsuario.NADA);

			UsuarioDAOImplementation.getInstancia().create(usuario);
			List<Usuario> lu = new ArrayList<Usuario>();
			lu.addAll((List<Usuario>)         
					req.getSession().getAttribute("usuarios"));
			lu.add (usuario);
			req.getSession().setAttribute("usuarios", lu);
			getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
		} else {
			getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
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
