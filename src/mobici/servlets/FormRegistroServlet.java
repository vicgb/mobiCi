package mobici.servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.swing.JOptionPane;

import mobici.dao.UsuarioDAOImplementation;
import mobici.model.EstadoUsuario;
import mobici.model.Usuario;
import javax.swing.JOptionPane;

@WebServlet("/FormRegistroServlet")
public class FormRegistroServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public FormRegistroServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String apellido1 = req.getParameter("apellido1");
		String apellido2 = req.getParameter("apellido2");
		String email = req.getParameter("email");
		String telefono = req.getParameter("telefono");
		String dni = req.getParameter("dni");
		String numTarjeta = req.getParameter("numTarjeta");
		String fechaCadu = req.getParameter("fechaCadu");
		String cvv = req.getParameter("cvv");
		String password = req.getParameter("password");
		String repPassword = req.getParameter("repPassword");

		
		
		

		if(repPassword.equals(password)) {
			
			
			
			MessageDigest digest = null;
			try {
				digest = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			
			String passwordHash = new String(hash);
			
			
			
			
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setApellido1(apellido1);
			usuario.setApellido2(apellido2);
			usuario.setEmail(email);
			usuario.setTelefono(telefono);
			usuario.setDni(dni);
			usuario.setNumTarjeta(numTarjeta);
			usuario.setFechaCadu(fechaCadu);
			usuario.setCvv(cvv);
			usuario.setPassword(passwordHash);
			usuario.setEstadoUsuario(EstadoUsuario.NADA);
			UsuarioDAOImplementation.getInstancia().create(usuario);
			JOptionPane.showMessageDialog(null, "El usuario se ha registrado correctamente");
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		
		}else {
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
			resp.sendRedirect(req.getContextPath() + "/FormularioRegistro.jsp");
	
}
}
	
}