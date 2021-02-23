package weblojaspring;

import org.agenda.modelo.Usuario;
import org.agenda.repositorio.UsuarioRepositorio;

public class JPATeste {

	public static void main(String[] args) {
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		Usuario usuario = new Usuario();
		usuario.setEmail("admin@ifsp.edu.br");
		usuario.setSenha("pw3456");
		repositorio.cadastrar(usuario);

	}

}
