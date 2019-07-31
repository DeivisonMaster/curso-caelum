package br.com.caelum.livraria.controller;

import java.io.Serializable;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.model.Usuario;
import br.com.caelum.livraria.repository.UsuarioRepository;
import br.com.caelum.livraria.repository.Impl.UsuarioRepositoryImpl;

@Named
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	public LoginController() {
		this.usuario = new Usuario();
	}
	
	public String efetuaLogin() {
		Usuario verificaUsuario = this.usuarioRepository.efetuaLogin(this.usuario);
		String pagina = "";
		
		if(verificaUsuario != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Map<String, Object> sessaoHttp = context.getExternalContext().getSessionMap();
			sessaoHttp.put("usuarioLogado", this.usuario);
			
			return "CadastroLivro?faces-redirect=true";
		}
		
		return pagina;
	}
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		
		return "Login.xhtml?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
