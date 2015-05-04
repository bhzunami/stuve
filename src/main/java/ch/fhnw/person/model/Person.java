package ch.fhnw.person.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String streetName;
	private Long phoneNumber;
	private Long mobilePhoneNumber;
	@Lob
	private byte[] image;

	@ManyToOne
	@JoinColumn(name = "id_plz")
	private Address adress;
	
	@ManyToMany(mappedBy = "persons")
	private Set<Function> functions = new HashSet<Function>();
	
	/**
	 * Default constructor for Person
	 */
	public Person() {}
	
	/**
	 * Constructor for Person
	 * 
	 * @param firstName		firstname of the person
	 * @param lastName 		lastname of the person
	 * @param Address 		adress of the person
	 */
	public Person(String firstName, String lastName, Address address) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.adress = address;
	}

	/**
	 * Add a new function to the exist function list
	 * 
	 * @param function
	 */
	@Transient
	public void addFunction(Function function) {
		this.getFunctions().add(function);
	}
	
	/**
	 * Delete a function in the exist function list
	 * 
	 * @param function
	 */
	@Transient
	public void delFunction(Function function) {
		this.getFunctions().remove(function);
	}
	
//************************************
// Getter and Setter
//************************************
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(Long mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public Address getAddress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public Set<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}
}
