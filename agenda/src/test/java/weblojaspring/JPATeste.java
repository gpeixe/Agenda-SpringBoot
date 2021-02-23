package weblojaspring;

import org.agenda.modelo.Contato;
import org.agenda.repositorio.ContatoRepositorio;

public class JPATeste {

	public static void main(String[] args) {
		ContatoRepositorio repositorio = new ContatoRepositorio();
		Contato usuario = new Contato();
		usuario.setEmail("admin@ifsp.edu.br");
		usuario.setSenha("pw3456");
		repositorio.cadastrar(usuario);

	}

}
