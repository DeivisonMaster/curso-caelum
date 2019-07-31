package br.com.caelum.transacao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class GerenciadorDeTransacao {
	
	@Inject
	private EntityManager entityManager;
	
	
	public void executaTX() {
		entityManager.getTransaction().begin();
		
		
		
		entityManager.getTransaction().commit();
	}
}
