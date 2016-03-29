package fit.pis.controller;

import fit.pis.domain.entity.Prescription;
import fit.pis.domain.mediator.PrescriptionDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "prescriptions")
@ViewScoped
public class PrescriptionController {

    private Prescription current;

    @EJB
    private PrescriptionDao dao;

    public List<Prescription> getAll() {
        return dao.findAll();
    }

    public Prescription getCurrent() {
        if (current == null) {
            current = getTemplate();
        }
        return current;
    }

    public void setCurrent(Prescription current) {
        this.current = current;
    }

    public void removeCurrent() {
        dao.remove(current);
    }

    public void saveCurrent() {
        dao.save(current);
    }

    public Prescription getTemplate() {
        return new Prescription();
    }

}
