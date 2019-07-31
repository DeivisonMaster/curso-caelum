package br.com.caelum.livraria.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NavegacaoController {
	
	public String cadastrarLivro() {
		return "CadastroLivro.xhtml?faces-redirect=true";
	}
	
	public String cadastrarAutor() {
		return "CadastroAutor.xhtml?faces-redirect=true";
	}
	
	public String paginaInicial() {
		return "Vendas.xhtml?faces-redirect=true";
	}
}
