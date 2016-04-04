package fit.pis.controller;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import fit.pis.domain.entity.OOrder;
import fit.pis.domain.entity.OOrderItem;
import fit.pis.domain.mediator.OOrderDao;

@ManagedBean(name = "orders")
@ViewScoped
public class OOrderController implements Converter {

	private OOrder current;
	private OOrderItem currentItem;
	
	@EJB
    private OOrderDao dao;
	
	public List<OOrder> getAll() {
		return dao.findAll();
	}
	
	public OOrder getCurrent() {
		if(current == null) {
			current = getTemplate();
		}
		return current;
	}
	
	public void setCurrent(OOrder current) {
		this.current = current;
	}
	
	public void saveCurrent() {
		System.out.println("save order...");
		System.out.println("items: "+current.getOorderItems().size());
		dao.save(current);
	}
	
	public void removeCurrent() {
		dao.remove(current);
	}
	
	public OOrderItem getCurrentItem() {
		if(currentItem == null) {
			currentItem = getItemTemplate();
		}
		return currentItem;
	}
	
	public void setCurrentItem(OOrderItem currentItem) {
		this.currentItem = currentItem;
	}
	
	public void saveCurrentItem() {
		System.out.println("saveCurrentItem "+current.getOorderItems().size());
		if(!current.getOorderItems().contains(currentItem)) {
			System.out.println("saveCurrentItem ADD");
			current.getOorderItems().add(currentItem);
		}
		System.out.println("saveCurrentItem "+current.getOorderItems().size());
	}
	
	public void removeCurrentItem() {
		current.getOorderItems().remove(currentItem);
	}
	
	public OOrder getTemplate() {
		OOrder order = new OOrder();
		order.setOrderItems(new LinkedList<>());
		return order;
	}
	
	public OOrderItem getItemTemplate() {
		OOrderItem item = new OOrderItem();
		item.setOrder(current);
		return item;
	}
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if(value == null) {
			return null;
		}
		return dao.getById(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object oorder) {
		return Long.toString(((OOrder) oorder).getId());
	}

}
