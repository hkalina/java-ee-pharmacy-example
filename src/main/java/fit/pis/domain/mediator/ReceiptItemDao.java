package fit.pis.domain.mediator;

import javax.annotation.security.PermitAll;
import fit.pis.domain.entity.ReceiptItem;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ReceiptItemDao {

    @PersistenceContext
    private EntityManager em;

    @RolesAllowed({"PHARMACIST", "MANAGER"})
    public void save(ReceiptItem receiptItem) {
        em.merge(receiptItem);
    }

    @RolesAllowed({"PHARMACIST", "MANAGER"})
    public void remove(ReceiptItem receiptItem) {
        em.remove(em.merge(receiptItem));
    }

    @PermitAll
    public List<ReceiptItem> findAll() {
        TypedQuery<ReceiptItem> query = em.createQuery("SELECT ri FROM ReceiptItem ri", ReceiptItem.class);
        return query.getResultList();
    }

}
