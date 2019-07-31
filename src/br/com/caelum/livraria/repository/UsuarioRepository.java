package br.com.caelum.livraria.repository;

import java.io.Serializable;
import java.util.Collection;

import br.com.caelum.livraria.model.Usuario;

public interface UsuarioRepository extends Serializable {

	void salvar(Usuario usuario);

	void editar(Usuario usuario);

	void excluir(Usuario usuario);

	Usuario buscarPorId(Long id);

	Collection<Usuario> buscarTodos();

	Usuario efetuaLogin(Usuario usuario);
}
