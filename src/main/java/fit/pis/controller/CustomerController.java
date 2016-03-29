package fit.pis.controller;

import fit.pis.domain.entity.Customer;
import fit.pis.domain.mediator.CustomerDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.List;

@ManagedBean(name = "customers")
@ViewScoped
public class CustomerController implements Converter {

    private Customer current;

    @EJB
    private CustomerDao dao;

    public List<Customer> getAll() {
        return dao.findAll();
    }

    public Customer getCurrent() {
        if (current == null) {
            current = getTemplate();
        }
        return current;
    }

    public void setCurrent(Customer current) {
        this.current = current;
    }

    public void removeCurrent() {
        dao.remove(current);
    }

    public void saveCurrent() {
        dao.save(current);
    }

    public Customer getTemplate() {
        return new Customer();
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value == null) return null;
        return dao.getById(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        return Long.toString(((Customer) object).getId());
    }
}
