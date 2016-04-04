package fit.pis.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import fit.pis.domain.entity.Supplier;
import fit.pis.domain.mediator.SupplierDao;

@ManagedBean(name = "suppliers")
@ViewScoped
public class SupplierController implements Converter {

	private Supplier current;
	
	@EJB
    private SupplierDao dao;
	
	public List<Supplier> getAll() {
		return dao.findAll();
	}
	
	public Supplier getCurrent() {
		if(current == null) {
			current = getTemplate();
		}
		return current;
	}
	
	public void setCurrent(Supplier current) {
		this.current = current;
	}
	
	public void removeCurrent() {
		dao.remove(current);
	}
	
	public void saveCurrent() {
		dao.save(current);
	}
	
	public Supplier getTemplate() {
		return new Supplier();
	}
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if(value == null) {
			return null;
		}
		return dao.getById(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object supplier) {
		return Long.toString(((Supplier) supplier).getId());
	}

}
