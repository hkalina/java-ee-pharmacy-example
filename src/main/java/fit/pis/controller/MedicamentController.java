package fit.pis.controller;

import fit.pis.domain.entity.Medicament;
import fit.pis.domain.mediator.MedicamentDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import java.util.Date;
import java.util.List;

@ManagedBean(name = "medicaments")
@ViewScoped
public class MedicamentController implements Converter {

    private Medicament current;

    @EJB
    private MedicamentDao dao;

    public List<Medicament> getAll() {
        return dao.findAll();
    }

    public Medicament getCurrent() {
        if (current == null) {
            current = getTemplate();
        }
        return current;
    }

    public void setCurrent(Medicament current) {
        this.current = current;
    }

    public void removeCurrent() {
        dao.remove(current);
    }

    public void saveCurrent() {
        dao.save(current);
    }

    public Medicament getTemplate() {
    	Medicament medicament = new Medicament();
    	medicament.setValidFrom(new Date());
    	medicament.setValidTo(new Date());
        return new Medicament();
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value == null) return null;
        return dao.getById(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object medicament) {
        return Long.toString(((Medicament) medicament).getId());
    }

}
