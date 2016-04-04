package fit.pis.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import fit.pis.domain.entity.Category;
import fit.pis.domain.mediator.CategoryDao;

@ManagedBean(name = "categories")
@ViewScoped
public class CategoryController implements Converter {
	private Category current;
	
	@EJB
	private CategoryDao dao;
	
	public List<Category> getAll() {
		return dao.findAll();
	}
	
	public Category getCurrent() {
		if(current == null) {
			current = getTemplate();
		}
		return current;
	}
	
	public void setCurrent(Category current) {
		this.current = current;
	}
	
	public void saveCurrent() {
		System.out.println("save category...");
		dao.save(current);
	}
	
	public void removeCurrent() {
		dao.remove(current);
	}
	
	public Category getTemplate() {
		return new Category();
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if(value == null) return null;
		return dao.getById(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent iuComponent, Object category) {
		return Long.toString(((Category) category).getId());
	}
}
