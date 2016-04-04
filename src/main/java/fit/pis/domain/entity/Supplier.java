package fit.pis.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  private String name;
  
  private String citty;
  
  private String street;
  
  private int houseNumber;
  
  private int postcode;
  
  private int ico;
  
  private int acountNumber;
  
  private int phoneNumber;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCitty() {
    return citty;
  }

  public void setCitty(String citty) {
    this.citty = citty;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public int getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(int houseNumber) {
    this.houseNumber = houseNumber;
  }

  public int getPostcode() {
    return postcode;
  }

  public void setPostcode(int postcode) {
    this.postcode = postcode;
  }

  public int getIco() {
    return ico;
  }

  public void setIco(int ico) {
    this.ico = ico;
  }

  public int getAcountNumber() {
    return acountNumber;
  }

  public void setAcountNumber(int acountNumber) {
    this.acountNumber = acountNumber;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
