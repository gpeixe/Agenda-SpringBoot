package org.agenda.controle.eventos;

import javax.servlet.http.HttpSession;

import org.agenda.modelo.Compromisso;

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
public class AlterarCompromissoControle {
	
private CompromissoRepositorio compromissoRepositorio;
	
	@Autowired
	public AlterarCompromissoControle(CompromissoRepositorio compromisso) {
		this.compromissoRepositorio = compromisso;
	}
	
	
	@RequestMapping(value = "alterarCompromisso", method=RequestMethod.GET)
	public String alterarCompromisso(@RequestParam int id, Model model) {
		Compromisso compromisso = compromissoRepositorio.listar(id);
		model.addAttribute("compromisso", compromisso);
		return "alterarCompromisso";
	}
	
	@Transactional
	@RequestMapping(value = "atualizarCompromisso", method=RequestMethod.POST)
	public String atualizarCompromisso(Compromisso compromisso, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		compromisso.setContato(usuario);
		compromissoRepositorio.atualizar(compromisso);
		return "redirect:listarCompromissosUsuario";
	}
	
}
