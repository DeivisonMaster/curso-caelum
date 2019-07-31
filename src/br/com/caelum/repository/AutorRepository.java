package br.com.caelum.repository;

import java.io.Serializable;
import java.util.Collection;

import br.com.caelum.livraria.model.Autor;


public interface AutorRepository extends Serializable {
	
	void salvar(Autor autor);
	
	void editar(Autor autor);
	
	void excluir(Autor autor);
	
	Autor buscarPorId(Long id);
	
	Collection<Autor> buscarTodos();
}
