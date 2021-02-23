package org.agenda.controle.contatos;

import javax.servlet.http.HttpSession;
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
public class ListarContatosControle {
	
	private ContatoRepositorio contatoRepositorio;
	
	@Autowired
	public ListarContatosControle(ContatoRepositorio contato) {
		this.contatoRepositorio = contato;
	}
	
	@Transactional
	@RequestMapping(value = "removerContato", method=RequestMethod.GET)
	public String removerContato(@RequestParam int id, HttpSession sessao) {
		contatoRepositorio.remover(contatoRepositorio.listar(id));
		return "redirect:listarContatosUsuario";
	}
	
	
	@RequestMapping(value = "listarContatosUsuario", method=RequestMethod.GET)
	public String listarContatos(HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		model.addAttribute("contatos", contatoRepositorio.listarTodosDoUsuario(usuario.getId()));
		return "listarContatosUsuario";
	}
	
	@RequestMapping(value = "buscarNome", method=RequestMethod.POST)
	public String buscarNome(@RequestParam String nome,HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		System.out.println("aowwww:");
		model.addAttribute("contatos", contatoRepositorio.listarPeloNome(usuario.getId(), nome));
		System.out.println("AQUIIIII: " +contatoRepositorio.listarPeloNome(usuario.getId(), nome));
		return "listarContatosUsuario";
	}
	

}
