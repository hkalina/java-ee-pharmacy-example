package fit.pis.domain.mediator;

import fit.pis.domain.entity.Medicament;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class MedicamentDao {

    @PersistenceContext
    private EntityManager em;

    @RolesAllowed({"ADMIN", "MANAGER"})
    public void save(Medicament medicament) {
        em.merge(medicament);
    }

    @RolesAllowed({"ADMIN", "MANAGER"})
    public void remove(Medicament medicament) {
        em.remove(em.merge(medicament));
    }

    @PermitAll
    public List<Medicament> findAll() {
        TypedQuery<Medicament> query = em.createQuery("SELECT m FROM Medicament m", Medicament.class);
        return query.getResultList();
    }

    @PermitAll
    public Medicament getById(long id) {
        try {
            TypedQuery<Medicament> query = em.createQuery("SELECT m FROM Medicament m WHERE id = :id", Medicament.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
