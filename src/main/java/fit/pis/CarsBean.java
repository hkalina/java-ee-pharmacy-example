package fit.pis;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

//import org.richfaces.JsfVersion;

@ManagedBean(name = "carsBean")
@ViewScoped
public class CarsBean implements Serializable {
    private static final long serialVersionUID = -3832235132261771583L;
    private static final int DECIMALS = 1;
    private static final int CLIENT_ROWS_IN_AJAX_MODE = 15;
    private static final int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;
    private List<InventoryItem> allInventoryItems = null;
    private List<InventoryItem> shortInventoryList = null;
    private List<InventoryVendorList> inventoryVendorLists = null;
    private List<InventoryVendorList> shortInventoryVendorLists = null;
    private List<String> allVendors = Arrays.asList("Chevrolet", "Ford", "Nissan", "Toyota", "GMC", "Infiniti");
    private int currentCarIndex;
    private InventoryItem editedCar;
    private int page = 1;

    private int clientRows;

    public void switchAjaxLoading(ValueChangeEvent event) {
        this.clientRows = (Boolean) event.getNewValue() ? CLIENT_ROWS_IN_AJAX_MODE : 0;
    }

    public void remove() {
        allInventoryItems.remove(allInventoryItems.get(currentCarIndex));
    }

    public void store() {
        allInventoryItems.set(currentCarIndex, editedCar);
    }

    public List<SelectItem> getVendorOptions() {
        List<SelectItem> result = new ArrayList<SelectItem>();
        result.add(new SelectItem("", ""));

        for (String vendor : allVendors) {
            result.add(new SelectItem(vendor));
        }
        return result;
    }

    public List<String> getAllVendors() {
        return allVendors;
    }

    public List<InventoryVendorList> getInventoryVendorLists() {
        synchronized (this) {
            if (inventoryVendorLists == null) {
                inventoryVendorLists = new ArrayList<InventoryVendorList>();

                int counter = 0;
                InventoryVendorList vendorList = new InventoryVendorList();
                try {
                    String vendor = allVendors.get(counter++);

                    vendorList.setVendor(vendor);
                    vendorList.getVendorItems().addAll(createCar(vendor, "Corvette", 5));
                    vendorList.getVendorItems().addAll(createCar(vendor, "Malibu", 8));
                    vendorList.getVendorItems().addAll(createCar(vendor, "Tahoe", 6));
                    inventoryVendorLists.add(vendorList);

                    vendor = allVendors.get(counter++);
                    vendorList = new InventoryVendorList();
                    vendorList.setVendor(vendor);
                    vendorList.getVendorItems().addAll(createCar(vendor, "Taurus", 12));
                    vendorList.getVendorItems().addAll(createCar(vendor, "Explorer", 11));
                    inventoryVendorLists.add(vendorList);

                    vendor = allVendors.get(counter++);
                    vendorList = new InventoryVendorList();
                    vendorList.setVendor(vendor);
                    vendorList.getVendorItems().addAll(createCar(vendor, "Maxima", 9));
                    vendorList.getVendorItems().addAll(createCar(vendor, "Frontier", 6));
                    inventoryVendorLists.add(vendorList);

                    vendor = allVendors.get(counter++);
                    vendorList = new InventoryVendorList();
                    vendorList.setVendor(vendor);
                    vendorList.getVendorItems().addAll(createCar(vendor, "4-Runner", 7));
                    vendorList.getVendorItems().addAll(createCar(vendor, "Camry", 15));
                    vendorList.getVendorItems().addAll(createCar(vendor, "Avalon", 13));
                    inventoryVendorLists.add(vendorList);

                    vendor = allVendors.get(counter++);
                    vendorList = new InventoryVendorList();
                    vendorList.setVendor(vendor);
                    vendorList.getVendorItems().addAll(createCar(vendor, "Sierra", 8));
                    vendorList.getVendorItems().addAll(createCar(vendor, "Yukon", 10));
                    inventoryVendorLists.add(vendorList);

                    vendor = allVendors.get(counter++);
                    vendorList = new InventoryVendorList();
                    vendorList.setVendor(vendor);

                    vendorList.getVendorItems().addAll(createCar(vendor, "G35", 6));
                    vendorList.getVendorItems().addAll(createCar(vendor, "EX35", 5));
                    inventoryVendorLists.add(vendorList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return inventoryVendorLists;
    }

    public List<InventoryItem> getAllInventoryItems() {
        synchronized (this) {
            if (allInventoryItems == null) {
                allInventoryItems = new ArrayList<InventoryItem>();

                for (InventoryVendorList list : getInventoryVendorLists()) {
                    allInventoryItems.addAll(list.getVendorItems());
                }
            }
        }
        return allInventoryItems;
    }

    public List<InventoryVendorList> getShortInventoryVendorLists() {
        synchronized (this) {
            if (shortInventoryVendorLists == null) {
                shortInventoryVendorLists = new ArrayList<InventoryVendorList>();

                int counter = 0;
                InventoryVendorList vendorList = new InventoryVendorList();
                try {
                    String vendor = allVendors.get(counter++);

                    vendorList.setVendor(vendor);
                    vendorList.getVendorItems().addAll(createCar(vendor, "Corvette", 2));
                    vendorList.getVendorItems().addAll(createCar(vendor, "Malibu", 4));
                    vendorList.getVendorItems().addAll(createCar(vendor, "Tahoe", 1));
                    shortInventoryVendorLists.add(vendorList);

                    vendor = allVendors.get(counter++);
                    vendorList = new InventoryVendorList();
                    vendorList.setVendor(vendor);
                    vendorList.getVendorItems().addAll(createCar(vendor, "Taurus", 5));
                    vendorList.getVendorItems().addAll(createCar(vendor, "Explorer", 3));
                    shortInventoryVendorLists.add(vendorList);

                    vendor = allVendors.get(counter++);
                    vendorList = new InventoryVendorList();
                    vendorList.setVendor(vendor);
                    vendorList.getVendorItems().addAll(createCar(vendor, "Maxima", 3));
                    vendorList.getVendorItems().addAll(createCar(vendor, "Frontier", 4));
                    shortInventoryVendorLists.add(vendorList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return shortInventoryVendorLists;
    }

    public List<InventoryItem> getShortInventoryList() {
        synchronized (this) {
            if (shortInventoryList == null) {
                shortInventoryList = new ArrayList<InventoryItem>();

                for (InventoryVendorList list : getShortInventoryVendorLists()) {
                    shortInventoryList.addAll(list.getVendorItems());
                }
            }
        }
        return shortInventoryList;
    }

    public List<InventoryItem> createCar(String vendor, String model, int count) {
        ArrayList<InventoryItem> iiList = null;

        try {
            int arrayCount = count;
            InventoryItem[] demoInventoryItemArrays = new InventoryItem[arrayCount];

            for (int j = 0; j < demoInventoryItemArrays.length; j++) {
                InventoryItem ii = new InventoryItem();

                ii.setVendor(vendor);
                ii.setModel(model);
                ii.setStock(RandomHelper.randomstring(6, 7));
                ii.setVin(RandomHelper.randomstring(17, 17));
                ii.setMileage(new BigDecimal(RandomHelper.rand(5000, 80000)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setMileageMarket(new BigDecimal(RandomHelper.rand(25000, 45000)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setPrice(new Integer(RandomHelper.rand(15000, 55000)));
                ii.setPriceMarket(new BigDecimal(RandomHelper.rand(15000, 55000)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setDaysLive(RandomHelper.rand(1, 90));
                ii.setChangeSearches(new BigDecimal(RandomHelper.rand(0, 5)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setChangePrice(new BigDecimal(RandomHelper.rand(0, 5)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setExposure(new BigDecimal(RandomHelper.rand(0, 5)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setActivity(new BigDecimal(RandomHelper.rand(0, 5)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setPrinted(new BigDecimal(RandomHelper.rand(0, 5)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setInquiries(new BigDecimal(RandomHelper.rand(0, 5)).setScale(DECIMALS, ROUNDING_MODE));
                demoInventoryItemArrays[j] = ii;
            }

            iiList = new ArrayList<InventoryItem>(Arrays.asList(demoInventoryItemArrays));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return iiList;
    }

    public int getCurrentCarIndex() {
        return currentCarIndex;
    }

    public void setCurrentCarIndex(int currentCarIndex) {
        this.currentCarIndex = currentCarIndex;
    }

    public InventoryItem getEditedCar() {
        return editedCar;
    }

    public void setEditedCar(InventoryItem editedCar) {
        this.editedCar = editedCar;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getClientRows() {
        return clientRows;
    }

    public void setClientRows(int clientRows) {
        this.clientRows = clientRows;
    }

    public void resetValues() {
        // reset input fields to prevent stuck values after a validation failure
        // not necessary in JSF 2.2+ (@resetValues on a4j:commandButton)
        //if (!JsfVersion.getCurrent().isCompliantWith(JsfVersion.JSF_2_2)) {
            FacesContext fc = FacesContext.getCurrentInstance();
            UIComponent comp = fc.getViewRoot().findComponent("form:editGrid");

            ((EditableValueHolder) comp.findComponent("form:price")).resetValue();
            ((EditableValueHolder) comp.findComponent("form:mage")).resetValue();
            ((EditableValueHolder) comp.findComponent("form:vin")).resetValue();
        //}
    }

    public class InventoryItem implements Serializable {

        private static final long serialVersionUID = 2052446469750935597L;
        private String vendor;
        BigDecimal activity;
        BigDecimal changePrice;
        BigDecimal changeSearches;
        int daysLive;
        BigDecimal exposure;
        BigDecimal inquiries;
        BigDecimal mileage;
        BigDecimal mileageMarket;
        String model;
        Integer price;
        BigDecimal priceMarket;
        BigDecimal printed;
        String stock;
        String vin;

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }

        public String getVin() {
            return vin;
        }

        public void setVin(String vin) {
            this.vin = vin;
        }

        public BigDecimal getMileage() {
            return mileage;
        }

        public void setMileage(BigDecimal mileage) {
            this.mileage = mileage;
        }

        public BigDecimal getMileageMarket() {
            return mileageMarket;
        }

        public void setMileageMarket(BigDecimal mileageMarket) {
            this.mileageMarket = mileageMarket;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public BigDecimal getPriceMarket() {
            return priceMarket;
        }

        public void setPriceMarket(BigDecimal priceMarket) {
            this.priceMarket = priceMarket;
        }

        public int getDaysLive() {
            return daysLive;
        }

        public void setDaysLive(int daysLive) {
            this.daysLive = daysLive;
        }

        public BigDecimal getChangeSearches() {
            return changeSearches;
        }

        public void setChangeSearches(BigDecimal changeSearches) {
            this.changeSearches = changeSearches;
        }

        public BigDecimal getChangePrice() {
            return changePrice;
        }

        public void setChangePrice(BigDecimal changePrice) {
            this.changePrice = changePrice;
        }

        public BigDecimal getExposure() {
            return exposure;
        }

        public void setExposure(BigDecimal exposure) {
            this.exposure = exposure;
        }

        public BigDecimal getActivity() {
            return activity;
        }

        public void setActivity(BigDecimal activity) {
            this.activity = activity;
        }

        public BigDecimal getPrinted() {
            return printed;
        }

        public void setPrinted(BigDecimal printed) {
            this.printed = printed;
        }

        public BigDecimal getInquiries() {
            return inquiries;
        }

        public void setInquiries(BigDecimal inquiries) {
            this.inquiries = inquiries;
        }
    }

    public class InventoryVendorList implements Serializable {
        private static final long serialVersionUID = -6547391197128734913L;
        private String vendor;
        private List<InventoryItem> vendorItems;

        public InventoryVendorList() {
            vendorItems = new ArrayList<InventoryItem>();
        }

        public long getCount() {
            if (vendorItems != null) {
                return vendorItems.size();
            } else {
                return 0;
            }
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public List<InventoryItem> getVendorItems() {
            return vendorItems;
        }

        public void setVendorItems(List<InventoryItem> vendorItems) {
            this.vendorItems = vendorItems;
        }
    }

    public static final class RandomHelper {
        private RandomHelper() {

        }

        public static int genRand() {
            return rand(1, 10000);
        }

        public static int rand(int lo, int hi) {
            Random rn2 = new Random();
            int n = hi - lo + 1;
            int i = rn2.nextInt() % n;

            if (i < 0) {
                i = -i;
            }

            return lo + i;
        }

        public static String randomstring(int lo, int hi) {
            int n = rand(lo, hi);
            byte[] b = new byte[n];

            for (int i = 0; i < n; i++) {
                b[i] = (byte) rand('A', 'Z');
            }

            return new String(b);
        }
    }
}