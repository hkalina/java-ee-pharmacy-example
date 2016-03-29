package fit.pis.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** Léčivo */
@Entity
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // TODO Léčivo


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean equals(Object object) {
        if (object == null) return false;
        if ( ! (object instanceof Medicament)) return false;
        return this.id == ((Medicament) object).id;
    }
}
