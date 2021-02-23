package org.agenda.controle;

import javax.servlet.http.HttpSession;
import org.agenda.modelo.Contato;
import org.agenda.repositorio.ContatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AutenticadorControle {
	
	private ContatoRepositorio repositorio;
	
	@Autowired
	public AutenticadorControle(ContatoRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	@RequestMapping("login")
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value="autentica", method=RequestMethod.POST)
	public String autenticar(@RequestParam String login, @RequestParam String senha, HttpSession session) {
		if(repositorio.autenticar(login, senha)) {
			Contato usuario = repositorio.listarPeloEmail(login);
			session.setAttribute("usuario", usuario);
			return "redirect:listarContatosUsuario";
			
		}
		return "redirect:login";
		
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession sessao) {
		sessao.removeAttribute("usuario");
		sessao.invalidate();
		return "redirect:login";
	}

}
