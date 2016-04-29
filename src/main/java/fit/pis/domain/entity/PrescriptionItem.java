package fit.pis.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/** Položka receptu */
@Entity
public class PrescriptionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Prescription prescription;

    @ManyToOne
    private Medicament medicament;

    private double amount;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "prescriptionItem", cascade = CascadeType.ALL)
    List<ReceiptItem> receiptItems;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<ReceiptItem> getReceiptItems() {
        return receiptItems;
    }

    public void setReceiptItems(List<ReceiptItem> receiptItems) {
        this.receiptItems = receiptItems;
    }

    public double getIssuedAmount() {
        double issued = 0;
        if (receiptItems != null) {
            for (ReceiptItem receiptItem : receiptItems) {
                issued += receiptItem.getAmount();
            }
        } else {
            System.err.println("PrescriptionItem: receiptItems is null!");
        }
        return issued;
    }

}
