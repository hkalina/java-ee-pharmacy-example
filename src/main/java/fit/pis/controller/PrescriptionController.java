package fit.pis.controller;

import fit.pis.domain.entity.Prescription;
import fit.pis.domain.entity.PrescriptionItem;
import fit.pis.domain.mediator.PrescriptionDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "prescriptions")
@ViewScoped
public class PrescriptionController {

    private Prescription current;
    private PrescriptionItem currentItem;

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

    public PrescriptionItem getCurrentItem() {
        if (currentItem == null) {
            currentItem = getItemTemplate();
        }
        return currentItem;
    }

    public void setCurrentItem(PrescriptionItem currentItem) {
        this.currentItem = currentItem;
    }

    public void saveCurrentItem() {
        if (!current.getItems().contains(currentItem)) {
            current.getItems().add(currentItem);
        }
    }

    public void removeCurrentItem() {
        current.getItems().remove(currentItem);
    }

    public void saveCurrent() {
        dao.save(current);
    }

    public void removeCurrent() {
        dao.remove(current);
    }

    public Prescription getTemplate() {
        Prescription prescription = new Prescription();
        prescription.setItems(new LinkedList<>());
        return prescription;
    }

    public PrescriptionItem getItemTemplate() {
        PrescriptionItem item = new PrescriptionItem();
        item.setPrescription(current);
        return item;
    }

}
