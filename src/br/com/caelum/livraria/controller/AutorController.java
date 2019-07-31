package br.com.caelum.livraria.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.repository.Impl.AutorRepositoryImpl;
import br.com.caelum.repository.AutorRepository;

@Named
@ViewScoped
public class AutorController implements Serializable{
	private static final long serialVersionUID = 1L;
	private Autor autor;
	
	@Inject
	private AutorRepository autorRepository;

	public AutorController() {
		this.autor = new Autor();
	}

	public void salvar() {
		if (this.autor.getId() == null) {
			this.autorRepository.salvar(autor);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor cadastrado com sucesso!", "");
			context.addMessage(null, mensagem);
			this.autor = new Autor();
		} else {
			this.editar(autor);
		}

	}

	public void buscaAutorPorId() {
		this.autorRepository.buscarPorId(autor.getId());
	}

	public Collection<Autor> getListaAutores() {
		return this.autorRepository.buscarTodos();
	}

	public void carregarDadosAutor(Autor autor) {
		this.autor = autor;
	}

	public void editar(Autor autor) {
		this.autorRepository.editar(autor);
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados do autor foram editados com sucesso!", "");
		context.addMessage(null, mensagem);
		this.autor = new Autor();
	}

	public void excluir(Autor autor) {
		this.autorRepository.excluir(autor);
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor excluído com sucesso!", "");
		context.addMessage(null, mensagem);
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
