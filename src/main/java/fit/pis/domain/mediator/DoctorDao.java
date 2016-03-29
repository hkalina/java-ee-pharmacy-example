package fit.pis.domain.mediator;

import fit.pis.domain.entity.Doctor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class DoctorDao {

    @PersistenceContext
    private EntityManager em;

    public void save(Doctor doctor) {
        em.merge(doctor);
    }

    public void remove(Doctor doctor) {
        em.remove(em.merge(doctor));
    }

    public List<Doctor> findAll() {
        TypedQuery<Doctor> query = em.createQuery("SELECT d FROM Doctor d", Doctor.class);
        return query.getResultList();
    }

    public Doctor getById(long id) {
        try {
            TypedQuery<Doctor> query = em.createQuery("SELECT d FROM Doctor d WHERE id = :id", Doctor.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}