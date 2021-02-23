package org.agenda.controle.contatos;

import javax.servlet.http.HttpSession;

import org.agenda.modelo.Contato;
import org.agenda.modelo.Usuario;
import org.agenda.repositorio.ContatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlterarContatoControle {
	
private ContatoRepositorio contatoRepositorio;
	
	@Autowired
	public AlterarContatoControle(ContatoRepositorio contato) {
		this.contatoRepositorio = contato;
	}
	
	
	@RequestMapping(value = "alterarContato", method=RequestMethod.GET)
	public String alterarContato(@RequestParam int id, Model model) {
		Contato contato = contatoRepositorio.listar(id);
		model.addAttribute("contato", contato);
		return "alterarContato";
	}
	
	@Transactional
	@RequestMapping(value = "atualizarContato", method=RequestMethod.POST)
	public String atualizarContato(Contato contato, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		contato.setUsuario(usuario);
		contatoRepositorio.atualizar(contato);
		return "redirect:listarContatosUsuario";
	}
	
}
