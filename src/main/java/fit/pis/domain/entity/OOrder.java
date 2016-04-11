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
public class OOrder {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  private Date date;
  
  @ManyToOne
  private Supplier supplier;
  
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "oorder", cascade = CascadeType.ALL)
  private List<OOrderItem> oorderItems;
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public List<OOrderItem> getOorderItems() {
    return oorderItems;
  }

  public void setOrderItems(List<OOrderItem> oorderItems) {
    this.oorderItems = oorderItems;
  }

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}
}
