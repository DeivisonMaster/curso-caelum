package br.com.caelum.livraria.controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.model.Livro;
import br.com.caelum.livraria.repository.Impl.AutorRepositoryImpl;
import br.com.caelum.livraria.repository.Impl.LivroRepositoryImpl;
import br.com.caelum.repository.AutorRepository;
import br.com.caelum.repository.LivroRepository;

@Named
@ViewScoped
public class LivroController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Livro livro;
	private LivroRepository livroRepository;
	private AutorRepository autorRepository;
	private Long autorId;

	public LivroController() {
		this.livro = new Livro();
		this.livroRepository = new LivroRepositoryImpl();
		this.autorRepository = new AutorRepositoryImpl();
	}
	
	public void salvar() {
		if(livro.getId() == null) {
			if(livro.getAutores().isEmpty()) {
				//throw new RuntimeException("Livro deve ter pelo menos um Autor");
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Livro deve ter pelo menos um Autor", "");
				context.addMessage(null, mensagem);
			}else {
				this.livroRepository.salvar(livro);
				this.livro = new Livro();
			}
			
		}else {
			editar(livro);
		}
	}
	
	private void editar(Livro livro) {
		this.livroRepository.editar(livro);
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage("Livro editado com sucesso!");
		context.addMessage(null, mensagem);
	}

	public void salvaAutor() {
		Autor autor = this.autorRepository.buscarPorId(this.autorId);
		this.livro.getAutores().add(autor);
	}
	
	public void removerAutorDoLivro(Autor autor) {
		this.livro.removeAutor(autor);
	}
	
	public void carregaDadosLivro(Livro livro) {
		this.livro = livro;
	}
	
	public void excluir(Livro livro) {
		this.livroRepository.excluir(livro);
		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage("Livro excluido com sucesso!");
		context.addMessage(null, mensagem);
	}
	
	public String formAutor() {
		return "CadastroAutor?faces-redirect=true";
	}
	
	
	// FacesContext = informações da view processada no momento, UIComponent = componente da view validado
	public void comecaComDigitoUm(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String valor = value.toString();
		
		if(!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("O campo ISBN deveria começar com digito 1"));
		}
	}
	
	public Collection<Livro> getListaLivros(){
		return this.livroRepository.buscarTodos();
	}

	public Collection<Autor> getListaAutores(){
		return this.autorRepository.buscarTodos();
	}
	
	public Collection<Autor> getAutoresSelecionados(){
		return this.livro.getAutores();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Long getAutorId() {
		return autorId;
	}
	
	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}
}
































