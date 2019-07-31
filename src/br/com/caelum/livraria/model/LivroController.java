package br.com.caelum.livraria.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LivroController {
	
	private Livro livro;
	
	public LivroController() {
		this.livro = new Livro();
	}
	
	public void gravar() {
		System.out.println("Gravando livro: " + this.livro.getTitulo());
	}

	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
