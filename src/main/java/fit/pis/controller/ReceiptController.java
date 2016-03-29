package fit.pis.controller;

import fit.pis.domain.entity.Receipt;
import fit.pis.domain.entity.ReceiptItem;
import fit.pis.domain.mediator.ReceiptDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "receipts")
@ViewScoped
public class ReceiptController {

    private Receipt current;
    private ReceiptItem currentItem;

    @EJB
    private ReceiptDao dao;

    public List<Receipt> getAll() {
        return dao.findAll();
    }

    public Receipt getCurrent() {
        if (current == null) {
            current = getTemplate();
        }
        return current;
    }

    public void setCurrent(Receipt current) {
        this.current = current;
    }

    public ReceiptItem getCurrentItem() {
        if (currentItem == null) {
            currentItem = getItemTemplate();
        }
        return currentItem;
    }

    public void setCurrentItem(ReceiptItem currentItem) {
        this.currentItem = currentItem;
    }

    public void saveCurrentItem() {
        System.out.println("saveCurrentItem "+current.getItems().size());
        if (!current.getItems().contains(currentItem)) {
            System.out.println("saveCurrentItem ADD");
            current.getItems().add(currentItem);
        }
        System.out.println("saveCurrentItem "+current.getItems().size());
    }

    public void removeCurrentItem() {
        current.getItems().remove(currentItem);
    }

    public void saveCurrent() {
        System.out.println("save receipt....");
        System.out.println("items: "+current.getItems().size());
        System.out.println("first item parent: "+current.getItems().get(0).getReceipt().getDate());
        dao.save(current);
    }

    public void removeCurrent() {
        dao.remove(current);
    }

    public Receipt getTemplate() {
        Receipt receipt = new Receipt();
        receipt.setItems(new LinkedList<>());
        return receipt;
    }

    public ReceiptItem getItemTemplate() {
        ReceiptItem item = new ReceiptItem();
        item.setReceipt(current);
        return item;
    }

}
