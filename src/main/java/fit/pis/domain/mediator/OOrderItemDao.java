package fit.pis.domain.mediator;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import fit.pis.domain.entity.OOrderItem;

@Stateless
public class OOrderItemDao {

	@PersistenceContext
    private EntityManager em;
	
	public void save(OOrderItem oorderItem) {
		em.merge(oorderItem);
	}
	
	public void remove(OOrderItem oorderItem) {
		em.remove(em.merge(oorderItem));
	}
	
	public List<OOrderItem> findAll() {
		TypedQuery<OOrderItem> query = em.createQuery("SELECT o FROM OOrderItem o", OOrderItem.class);
		return query.getResultList();
	}
}
