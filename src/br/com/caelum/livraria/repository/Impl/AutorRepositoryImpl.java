package br.com.caelum.livraria.repository.Impl;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.model.Livro;
import br.com.caelum.livraria.util.JPAUtil;
import br.com.caelum.repository.AutorRepository;

@Dependent
public class AutorRepositoryImpl implements AutorRepository{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;


	@Override
	public void salvar(Autor autor) {
		entityManager.persist(autor);
	}

	@Override
	public void editar(Autor autor) {
		entityManager.merge(autor);
	}

	@Override
	public void excluir(Autor autor) {
		entityManager.remove(autor);
	}

	@Override
	public Autor buscarPorId(Long id) {
		Autor autor = this.entityManager.find(Autor.class, id);
		return autor;
	}

	@Override
	public List<Autor> buscarTodos() {
		TypedQuery<Autor> consulta = entityManager.createQuery("SELECT a FROM Autor AS a", Autor.class);
		List<Autor> autores = consulta.getResultList();
		
		return autores;
	}

	
}
