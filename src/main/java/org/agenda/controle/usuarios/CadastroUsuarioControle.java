package org.agenda.controle.usuarios;

import org.agenda.modelo.Usuario;
import org.agenda.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastroUsuarioControle {
	
	private UsuarioRepositorio repositorio;
	
	@Autowired
	public CadastroUsuarioControle(UsuarioRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@RequestMapping("cadastro")
	public String cadastroForm() {
		return "cadastro";
	}
	
	@Transactional
	@RequestMapping(value = "cadastrarUsuario", method=RequestMethod.POST)
	public String cadastrar(Usuario usuario) {
		repositorio.cadastrar(usuario);
		return "redirect:login";
	}

}
