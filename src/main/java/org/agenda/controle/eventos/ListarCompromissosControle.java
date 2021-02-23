package org.agenda.controle.eventos;

import javax.servlet.http.HttpSession;
import org.agenda.modelo.Usuario;
import org.agenda.repositorio.CompromissoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ListarCompromissosControle {
	
	private CompromissoRepositorio compromissoRepositorio;
	
	@Autowired
	public ListarCompromissosControle(CompromissoRepositorio compromisso) {
		this.compromissoRepositorio = compromisso;
	}
	
	@Transactional
	@RequestMapping(value = "removerCompromisso", method=RequestMethod.GET)
	public String removerCompromisso(@RequestParam int id, HttpSession sessao) {
		compromissoRepositorio.remover(compromissoRepositorio.listar(id));
		return "redirect:listarCompromissosUsuario";
	}
	
	
	@RequestMapping(value = "listarCompromissosUsuario", method=RequestMethod.GET)
	public String listarCompromissos(HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		model.addAttribute("compromissos", compromissoRepositorio.listarTodosDoUsuario(usuario.getId()));
		return "listarCompromissosUsuario";
	}
	
	
	
	

}
