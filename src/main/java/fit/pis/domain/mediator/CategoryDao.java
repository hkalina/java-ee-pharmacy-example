package fit.pis.domain.mediator;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fit.pis.domain.entity.Category;

@Stateless
public class CategoryDao {

	@PersistenceContext
    private EntityManager em;
	
	public void save(Category category) {
        em.merge(category);
    }
	
	public void remove(Category category) {
		em.remove(em.merge(category));
	}
	
	public List<Category> findAll() {
		TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c", Category.class);
		return query.getResultList();
	}

	public Category getById(long id) {
		try {
			TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c WHERE id = :id", Category.class);
			query.setParameter("id", id);
            return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
