package org.agenda.controle;

import org.agenda.modelo.Contato;
import org.agenda.repositorio.ContatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastroUsuarioControle {
	
	private ContatoRepositorio repositorio;
	
	@Autowired
	public CadastroUsuarioControle(ContatoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@RequestMapping("cadastro")
	public String cadastroForm() {
		return "cadastro";
	}
	
	@Transactional
	@RequestMapping(value = "cadastrarUsuario", method=RequestMethod.POST)
	public String cadastrar(Contato usuario) {
		repositorio.cadastrar(usuario);
		return "redirect:login";
	}

}
