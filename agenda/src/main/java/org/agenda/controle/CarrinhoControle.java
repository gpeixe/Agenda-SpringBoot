/*package org.agenda.controle;

import org.agenda.modelo.Carrinho;
import org.agenda.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoControle {
	
	private ContatoRepositorio repositorio;
	private Carrinho carrinho;
	
	@Autowired
	public CarrinhoControle(ProdutoRepositorio repositorio, Carrinho carrinho) {
		this.repositorio = repositorio;
		this.carrinho = carrinho;
	}
	
	@RequestMapping("listarProdutosCliente")
	public String getProdutosLoja(Model model) {
		//model.addAttribute("carrinho", carrinho.getProdutos());
		model.addAttribute("produtos", repositorio.buscaTodos());
		
		return "listarProdutosCliente";
	}
	
	@RequestMapping("listarProdutosCarrinho")
	public String getProdutosCarrinho(Model model) {
		model.addAttribute("carrinho", carrinho.getProdutos());
		//model.addAttribute("produtos", repositorio.buscaTodos());
		
		return "carrinho";
	}
	
	@RequestMapping(value = "adicionarProdutoCarrinho", method = RequestMethod.GET)
	public String adicionar(int id) {
		carrinho.adicionar(repositorio.busca(id));
		
		return "redirect:listarProdutosCarrinho";
	}
	
	@RequestMapping("removerProdutoCarrinho")
	public String remover(int id) {
		carrinho.removerProduto(id);
		
		return "redirect:listarProdutosCarrinho";
	}

}*/
