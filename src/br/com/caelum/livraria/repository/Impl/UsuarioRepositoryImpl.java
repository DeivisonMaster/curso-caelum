package br.com.caelum.livraria.repository.Impl;

import java.util.Collection;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.model.Usuario;
import br.com.caelum.livraria.repository.UsuarioRepository;

@Dependent
public class UsuarioRepositoryImpl implements UsuarioRepository {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;

	
	@Override
	public void salvar(Usuario usuario) {
		
	}

	@Override
	public void editar(Usuario usuario) {

	}

	@Override
	public void excluir(Usuario usuario) {

	}

	@Override
	public Usuario buscarPorId(Long id) {
		return null;
	}

	@Override
	public Collection<Usuario> buscarTodos() {
		return null;
	}

	@Override
	public Usuario efetuaLogin(Usuario usuario) {
		TypedQuery<Usuario> consulta = this.entityManager
				.createQuery("SELECT u FROM Usuario u WHERE u.email = :pEmail AND u.senha = :pSenha", Usuario.class);
		consulta.setParameter("pEmail", usuario.getEmail());
		consulta.setParameter("pSenha", usuario.getSenha());

		try {
			return consulta.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
