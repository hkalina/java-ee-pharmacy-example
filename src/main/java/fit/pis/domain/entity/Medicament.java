package fit.pis.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/** Léčivo */
@Entity
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    
    private Boolean prescription;
    
    private int deliveryPrice;
    
    private int margin;
    
    private Date validFrom;
    
    private Date validTo;
    
    @ManyToOne
    private Category category;


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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getPrescription() {
		return prescription;
	}

	public void setPrescription(Boolean prescription) {
		this.prescription = prescription;
	}

	public int getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(int deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
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
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
}
