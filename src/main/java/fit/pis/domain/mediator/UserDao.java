package fit.pis.domain.mediator;

import fit.pis.domain.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    // one method in EJB = one transaction

    public void save(User user) {
        em.merge(user);
    }

    public void remove(User user) {
        em.remove(em.merge(user));
    }

    public List<User> findAll() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

}
