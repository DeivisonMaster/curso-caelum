package br.com.caelum.livraria.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.repository.Impl.AutorRepositoryImpl;

@FacesConverter(forClass = Autor.class)
public class AutorConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		AutorRepositoryImpl autorRepositoryImpl = new AutorRepositoryImpl();
		Autor autor = null;

		if (value != null) {
			autor = autorRepositoryImpl.buscarPorId(new Long(value));
			return autor;
		}

		return autor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			return ((Autor) value).getId().toString();
		}
		return null;
	}

}
