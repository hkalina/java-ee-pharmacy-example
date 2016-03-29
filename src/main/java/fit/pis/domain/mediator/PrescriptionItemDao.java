package fit.pis.domain.mediator;

import fit.pis.domain.entity.PrescriptionItem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PrescriptionItemDao {

    @PersistenceContext
    private EntityManager em;

    public void save(PrescriptionItem prescriptionItem) {
        em.merge(prescriptionItem);
    }

    public void remove(PrescriptionItem prescriptionItem) {
        em.remove(em.merge(prescriptionItem));
    }

    public List<PrescriptionItem> findAll() {
        TypedQuery<PrescriptionItem> query = em.createQuery("SELECT pi FROM PrescriptionItem pi", PrescriptionItem.class);
        return query.getResultList();
    }

}
