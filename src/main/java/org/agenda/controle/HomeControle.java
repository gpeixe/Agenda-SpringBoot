package org.agenda.controle;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeControle {
	
	
	@RequestMapping(value = "home", method=RequestMethod.GET)
	public String homePage(HttpSession sessao) {
		return "home";
	}
	
	
}
