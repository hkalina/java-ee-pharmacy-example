package fit.pis.domain.mediator;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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
	
	@RolesAllowed({"MANAGER"})
	public void save(OOrderItem oorderItem) {
		em.merge(oorderItem);
	}
	
	@RolesAllowed({"MANAGER"})
	public void remove(OOrderItem oorderItem) {
		em.remove(em.merge(oorderItem));
	}
	
	@PermitAll
	public List<OOrderItem> findAll() {
		TypedQuery<OOrderItem> query = em.createQuery("SELECT o FROM OOrderItem o", OOrderItem.class);
		return query.getResultList();
	}
}
