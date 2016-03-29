package fit.pis.controller;

import fit.pis.domain.entity.Medicament;
import fit.pis.domain.mediator.MedicamentDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "medicaments")
@ViewScoped
public class MedicamentController {

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
        return new Medicament();
    }

}
