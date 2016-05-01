package fit.pis.domain.mediator;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import fit.pis.domain.entity.OOrder;

@Stateless
public class OOrderDao {

	@PersistenceContext
    private EntityManager em;
	
	@RolesAllowed({"MANAGER"})
	public void save(OOrder oorder) {
		em.merge(oorder);
	}
	
	@RolesAllowed({"MANAGER"})
	public void remove(OOrder oorder) {
		em.remove(em.merge(oorder));
	}
	
	@PermitAll
	public List<OOrder> findAll() {
		TypedQuery<OOrder> query = em.createQuery("SELECT o FROM OOrder o", OOrder.class);
		return query.getResultList();
	}

	@PermitAll
	public OOrder getById(long id) {
		try {
			TypedQuery<OOrder> query = em.createQuery("SELECT o FROM OOrder o WHERE id = :id", OOrder.class);
			query.setParameter("id", id);
			return query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}
