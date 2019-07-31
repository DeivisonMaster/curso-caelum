package br.com.caelum.livraria.insere;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.model.Livro;
import br.com.caelum.livraria.util.JPAUtil;

public class InsereDados {

	public static void main(String[] args) {
		EntityManager entity = new JPAUtil().getEntityManager();
		
		entity.getTransaction().begin();
		Autor assis = new Autor();
		assis.setNome("Gracindo jr");
		entity.persist(assis);
		entity.getTransaction().commit();
		
		
//		List<Autor> autores = null;
//		TypedQuery<Autor> consulta = entity.createQuery("SELECT a FROM Autor AS a", Autor.class);
//		autores = consulta.getResultList();
//		
//		entity.getTransaction().begin();
//		Livro memorias = new Livro();
//		memorias.setIsbn("598-8-52-504464-3");
//		memorias.setTitulo("Memória");
//		memorias.setDataLancamento(Calendar.getInstance());
//		memorias.setPreco(24.90);
//		memorias.setAutores(autores);
//		entity.persist(memorias);
//		entity.getTransaction().commit();
		
	}
}
