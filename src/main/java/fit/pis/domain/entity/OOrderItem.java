package fit.pis.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OOrderItem {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  private int amount;
  
  @ManyToOne
  private OOrder oorder;
  
  @ManyToOne
  private Medicament drug;
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public OOrder getOrder() {
    return oorder;
  }

  public void setOrder(OOrder oorder) {
    this.oorder = oorder;
  }

  public Medicament getMedicament() {
    return drug;
  }

  public void setMedicament(Medicament drug) {
    this.drug = drug;
  }
}
