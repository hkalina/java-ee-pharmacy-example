package fit.pis.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import fit.pis.domain.entity.Insurance;
import fit.pis.domain.mediator.InsuranceDao;

@ManagedBean(name = "insurances")
@ViewScoped
public class InsuranceController implements Converter {
	
	private Insurance current;
	
	@EJB
	private InsuranceDao dao;
	
	public List<Insurance> getAll() {
		return dao.findAll();
	}

	public Insurance getCurrent() {
		if(current == null) {
			current = getTemplate();
		}
		return current;
	}

	public void setCurrent(Insurance current) {
		this.current = current;
	}
	
	public void removeCurrent() {
		dao.remove(current);
	}
	
	public void saveCurrent() {
		dao.save(current);
	}
	
	public Insurance getTemplate() {
		return new Insurance();
	}
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if(value == null) {
			return null;
		}
		return dao.getById(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object insurance) {
		return Long.toString(((Insurance) insurance).getId());
	}
}
