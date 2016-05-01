package fit.pis.domain.mediator;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import fit.pis.domain.entity.Receipt;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ReceiptDao {

    @PersistenceContext
    private EntityManager em;

    @RolesAllowed({"PHARMACIST", "MANAGER"})
    public void save(Receipt receipt) {
        em.merge(receipt);
    }

    @RolesAllowed({"PHARMACIST", "MANAGER"})
    public void remove(Receipt receipt) {
        em.remove(em.merge(receipt));
    }

    @PermitAll
    public List<Receipt> findAll() {
        TypedQuery<Receipt> query = em.createQuery("SELECT r FROM Receipt r", Receipt.class);
        return query.getResultList();
    }

}
