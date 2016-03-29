package fit.pis.domain.mediator;

import fit.pis.domain.entity.ReceiptItem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ReceiptItemDao {

    @PersistenceContext
    private EntityManager em;

    public void save(ReceiptItem receiptItem) {
        em.merge(receiptItem);
    }

    public void remove(ReceiptItem receiptItem) {
        em.remove(em.merge(receiptItem));
    }

    public List<ReceiptItem> findAll() {
        TypedQuery<ReceiptItem> query = em.createQuery("SELECT ri FROM ReceiptItem ri", ReceiptItem.class);
        return query.getResultList();
    }

}
