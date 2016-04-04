package fit.pis.domain.mediator;

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
	
	public void save(OOrder oorder) {
		em.merge(oorder);
	}
	
	public void remove(OOrder oorder) {
		em.remove(em.merge(oorder));
	}
	
	public List<OOrder> findAll() {
		TypedQuery<OOrder> query = em.createQuery("SELECT o FROM OOrder o", OOrder.class);
		return query.getResultList();
	}

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
