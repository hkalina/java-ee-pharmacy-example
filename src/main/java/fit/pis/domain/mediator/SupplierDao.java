package fit.pis.domain.mediator;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fit.pis.domain.entity.Supplier;

@Stateless
public class SupplierDao {

    @PersistenceContext
    private EntityManager em;
    
    @RolesAllowed({"MANAGER"})
    public void save(Supplier supplier) {
    	em.merge(supplier);
    }
    
    @RolesAllowed({"MANAGER"})
    public void remove(Supplier supplier) {
    	em.remove(em.merge(supplier));
    }
    
    @RolesAllowed({"MANAGER"})
    public List<Supplier> findAll() {
    	TypedQuery<Supplier> query = em.createQuery("SELECT s FROM Supplier s", Supplier.class);
    	return query.getResultList();
    }

    @PermitAll
	public Supplier getById(long id) {
		try {
			TypedQuery<Supplier> query = em.createQuery("SELECT s FROM Supplier s WHERE id = :id", Supplier.class);
			query.setParameter("id", id);
			return query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}
