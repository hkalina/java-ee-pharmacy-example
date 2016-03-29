package fit.pis.domain.mediator;

import fit.pis.domain.entity.Prescription;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PrescriptionDao {

    @PersistenceContext
    private EntityManager em;

    public void save(Prescription prescription) {
        em.merge(prescription);
    }

    public void remove(Prescription prescription) {
        em.remove(em.merge(prescription));
    }

    public List<Prescription> findAll() {
        TypedQuery<Prescription> query = em.createQuery("SELECT p FROM Prescription p", Prescription.class);
        return query.getResultList();
    }

}
