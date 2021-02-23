package org.agenda.controle.contatos;

import javax.servlet.http.HttpSession;

import org.agenda.modelo.Contato;
import org.agenda.modelo.Usuario;
import org.agenda.repositorio.ContatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdicionarContatoControle {

private ContatoRepositorio contatoRepositorio;
	
	@Autowired
	public AdicionarContatoControle(ContatoRepositorio contato) {
		this.contatoRepositorio = contato;
	}
	
	@Transactional
	@RequestMapping(value = "adicionarContato", method=RequestMethod.POST)
	public String adicionarContato(Contato contato, HttpSession sessao) {
		Usuario usuario = ((Usuario) sessao.getAttribute("usuario"));
		contato.setUsuario(usuario);
		contatoRepositorio.cadastrar(contato);
		return "redirect:listarContatosUsuario";
	}
	
	@RequestMapping(value = "novoContato", method=RequestMethod.GET)
	public String novoContato() {
		return "novoContato";
	}
	
}
