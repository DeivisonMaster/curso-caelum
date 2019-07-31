package br.com.caelum.livraria.repository.Impl;

import java.util.Collection;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.livraria.model.Livro;
import br.com.caelum.livraria.util.JPAUtil;
import br.com.caelum.repository.LivroRepository;

@Dependent
public class LivroRepositoryImpl implements LivroRepository {

	@Inject
	private EntityManager entityManager;

	@Override
	public void salvar(Livro livro) {
		entityManager.persist(livro);
	}

	@Override
	public void editar(Livro livro) {
		entityManager.merge(livro);
	}

	@Override
	public void excluir(Livro livro) {
		entityManager.remove(livro);
	}

	@Override
	public Livro buscarPorId(Long id) {
		Livro livro = null;
		try {
			livro = entityManager.find(Livro.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//entityManager.close();
		}
		return livro;
	}

	@Override
	public Collection<Livro> buscarTodos() {
		Query query = this.entityManager.createQuery("SELECT liv FROM Livro liv ORDER BY liv.titulo");
		
		return query.getResultList();
	}

}
