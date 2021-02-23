package org.agenda.controle.eventos;

import javax.servlet.http.HttpSession;

import org.agenda.modelo.Compromisso;
import org.agenda.modelo.Usuario;
import org.agenda.repositorio.CompromissoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NovoCompromissoControle {
	private CompromissoRepositorio compromissoRepositorio;
	
	@Autowired
	public NovoCompromissoControle(CompromissoRepositorio repo) {
		this.compromissoRepositorio = repo;
	}
	
	@RequestMapping(value = "novoCompromisso", method=RequestMethod.GET)
	public String novoCompromisso() {
		return "novoCompromisso";
	}
	
	@Transactional
	@RequestMapping(value = "adicionarCompromisso", method=RequestMethod.POST)
	public String adicionarCompromisso(Compromisso compromisso, HttpSession sessao) {
		Usuario usuario = ((Usuario) sessao.getAttribute("usuario"));
		compromisso.setContato(usuario);
		compromissoRepositorio.criar(compromisso);
		return "redirect:listarCompromissosUsuario";
	}
}
