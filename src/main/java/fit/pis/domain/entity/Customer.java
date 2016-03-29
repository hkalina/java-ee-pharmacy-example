package fit.pis.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** Zákazník */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // TODO


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean equals(Object object) {
        if (object == null) return false;
        if ( ! (object instanceof Customer)) return false;
        return this.id == ((Customer) object).id;
    }

}
