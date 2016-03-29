package fit.pis.controller;

import fit.pis.domain.entity.Customer;
import fit.pis.domain.mediator.CustomerDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "customers")
@ViewScoped
public class CustomerController {

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

}
