package fit.pis.controller;

import fit.pis.domain.entity.Doctor;
import fit.pis.domain.mediator.DoctorDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "doctors")
@ViewScoped
public class DoctorController {

    private Doctor current;

    @EJB
    private DoctorDao dao;

    public List<Doctor> getAll() {
        return dao.findAll();
    }

    public Doctor getCurrent() {
        if (current == null) {
            current = getTemplate();
        }
        return current;
    }

    public void setCurrent(Doctor current) {
        this.current = current;
    }

    public void removeCurrent() {
        dao.remove(current);
    }

    public void saveCurrent() {
        dao.save(current);
    }

    public Doctor getTemplate() {
        return new Doctor();
    }

}
