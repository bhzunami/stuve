package ch.fhnw.person.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
//@Embeddable
public class Address {
	  @Id
	  private Integer plz;
	  private String city;
	  
	  /**
	   * Default constructor address
	   */
	  public Address() {}

	  /**
	   * constructor for address
	   * 
	   * @param city
	   * @param plz
	   */
	  public Address(String city, int plz) {
		  this.city = city;
		  this.plz = plz;
	  }
	  
//************************************
// Getter and Setter
//************************************
	public Integer getPlz() {
		return plz;
	}
	
	public void setPlz(Integer plz) {
		this.plz = plz;
	}
		
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String toString() {
		return plz +" " +city;
	}
}
