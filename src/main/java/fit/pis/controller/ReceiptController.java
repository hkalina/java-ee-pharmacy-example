package fit.pis.controller;

import fit.pis.domain.entity.Receipt;
import fit.pis.domain.mediator.ReceiptDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "receipts")
@ViewScoped
public class ReceiptController {

    private Receipt current;

    @EJB
    private ReceiptDao dao;

    public List<Receipt> getAll() {
        return dao.findAll();
    }

    public Receipt getCurrent() {
        if (current == null) {
            current = getTemplate();
        }
        return current;
    }

    public void setCurrent(Receipt current) {
        this.current = current;
    }

    public void removeCurrent() {
        dao.remove(current);
    }

    public void saveCurrent() {
        dao.save(current);
    }

    public Receipt getTemplate() {
        return new Receipt();
    }

}
