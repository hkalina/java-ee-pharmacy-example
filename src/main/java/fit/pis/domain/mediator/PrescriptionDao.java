package fit.pis.domain.mediator;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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

    @RolesAllowed({"PHARMACIST", "MANAGER"})
    public void save(Prescription prescription) {
        em.merge(prescription);
    }

    @RolesAllowed({"PHARMACIST", "MANAGER"})
    public void remove(Prescription prescription) {
        em.remove(em.merge(prescription));
    }

    @PermitAll
    public List<Prescription> findAll() {
        TypedQuery<Prescription> query = em.createQuery("SELECT p FROM Prescription p", Prescription.class);
        return query.getResultList();
    }

}
