package fit.pis.domain.mediator;

import fit.pis.domain.entity.Medicament;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class MedicamentDao {

    @PersistenceContext
    private EntityManager em;

    public void save(Medicament medicament) {
        em.merge(medicament);
    }

    public void remove(Medicament medicament) {
        em.remove(em.merge(medicament));
    }

    public List<Medicament> findAll() {
        TypedQuery<Medicament> query = em.createQuery("SELECT m FROM Medicament m", Medicament.class);
        return query.getResultList();
    }

}
