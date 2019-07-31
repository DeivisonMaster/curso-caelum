package br.com.caelum.livraria.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.caelum.livraria.model.Usuario;

public class Autorizador implements PhaseListener{
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		// recuperar a arvore de elementos para obter o nome da pagina
		FacesContext context = event.getFacesContext();
		
		// recupera a raiz da view exibida no momento e obtem o nome da página
		String nomePagina = context.getViewRoot().getViewId();
		
		System.out.println(nomePagina);
		
		// caso a pagina acessada seja a de Login
		if("/Login.xhtml".equals(nomePagina)) {
			return;
		}
		
		Usuario usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		if(usuarioLogado != null) {
			return;
		}
		
		// redireciona para o login caso o usuario não esteja logado
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/Login.xhtml?faces-redirect=true");
		
		// renderiza a resposta
		context.renderResponse();
		
	}

	// antes de uma fase
	@Override
	public void beforePhase(PhaseEvent event) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
