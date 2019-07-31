package br.com.caelum.repository;

import java.util.Collection;

import br.com.caelum.livraria.model.Livro;

public interface LivroRepository{
	
	void salvar(Livro livro);
	
	void editar(Livro livro);
	
	void excluir(Livro livro);
	
	Livro buscarPorId(Long id);
	
	Collection<Livro> buscarTodos();
}
