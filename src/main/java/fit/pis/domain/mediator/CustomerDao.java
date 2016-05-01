package fit.pis.domain.mediator;

import fit.pis.domain.entity.Customer;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CustomerDao {

    @PersistenceContext
    private EntityManager em;

    @RolesAllowed({"PHARMACIST", "MANAGER"})
    public void save(Customer customer) {
        em.merge(customer);
    }

	@RolesAllowed({"PHARMACIST", "MANAGER"})
    public void remove(Customer customer) {
        em.remove(em.merge(customer));
    }

	@PermitAll
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }

	@PermitAll
    public Customer getById(long id) {
        try {
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE id = :id", Customer.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
