package org.agenda.controle;

import javax.servlet.http.HttpSession;
import org.agenda.modelo.Contato;
import org.agenda.repositorio.ContatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class ListarContatosControle {
	
	private ContatoRepositorio repositorio;
	
	@Autowired
	public ListarContatosControle(ContatoRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	@Transactional
	@RequestMapping(value = "removerContato", method=RequestMethod.GET)
	public String removerContato(@RequestParam int contatoId, HttpSession sessao) {
		Contato contato = repositorio.listar(contatoId);
		repositorio.remover(contato);
		Contato usuario = (Contato) sessao.getAttribute("usuario");
		usuario.getContatos().remove(contato);
		return "redirect:listarContatosUsuario";
	}
	
	
	@RequestMapping(value = "listarContatosUsuario", method=RequestMethod.GET)
	public String listarContatos(Model model, HttpSession session) {
		Contato contato = (Contato) session.getAttribute("usuario");
		model.addAttribute("contato", contato);
		
		return "listarContatosUsuario";
	}
	
	

}
