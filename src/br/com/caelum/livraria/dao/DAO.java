package br.com.caelum.livraria.dao;

import javax.persistence.EntityManager;

import br.com.caelum.livraria.util.JPAUtil;

public class DAO<T> {
	private EntityManager entityManager = null;
	private final Class<T> classe;
	
	public DAO(Class<T> classe) {
		this.classe = classe;
		this.entityManager = new JPAUtil().getEntityManager();
	}
	
	public void salvar(T classe) {
		entityManager.getTransaction();
		entityManager.persist(classe);
		entityManager.getTransaction();
		entityManager.close();
	}
}
