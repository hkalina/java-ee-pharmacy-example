package fit.pis.domain.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  private String title;
  
  private int paidPrice;
  
  private Date validFrom;
  
  private Date validTo;
  
  @ManyToOne
  private Insurance insurance;
  
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
  private List<Medicament> medicaments;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPaidPrice() {
    return paidPrice;
  }

  public void setPaidPrice(int paidPrice) {
    this.paidPrice = paidPrice;
  }

  public Date getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(Date validFrom) {
    this.validFrom = validFrom;
  }

  public Date getValidTo() {
    return validTo;
  }

  public void setValidTo(Date validTo) {
    this.validTo = validTo;
  }

  public List<Medicament> getMedicaments() {
    return medicaments;
  }

  public void setMedicaments(List<Medicament> medicaments) {
    this.medicaments = medicaments;
  }

  public String toString() {
    return title;
  }

  public boolean equals(Object object) {
    if (object == null) return false;
    if (!(object instanceof Category)) return false;
    return ((Category)object).getId() == this.getId();
  }

  public Insurance getInsurance() {
	return insurance;
  }

  public void setInsurance(Insurance insurance) {
	this.insurance = insurance;
  }
}
