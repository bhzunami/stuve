package ch.fhnw.person.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import ch.fhnw.person.model.Address;
import ch.fhnw.person.model.Person;
import ch.fhnw.person.service.AddressService;
import ch.fhnw.person.service.PersonService;

@ManagedBean
public class PersonPage {
	private PersonService personService;
	private AddressService addressService;
	
	private Person person =  new Person();
	private Address address = new Address();
	private List<Person> persons = new ArrayList();
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * We need the personService that Spring instance for us.
	 */
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

//	public PersonPage() {
//		this.person = new Person();
//		this.person.setAdress(adress);
//	}
//	
	
	//this.person.setAdress(new Adress());
	//private Adress adress = person.getAddress();
	    
	/**
	 * Create a new person
	 * and return the String newPerson - this is the URL
	 * we gave back.
	 * 
	 * @return String
	 */
    public String newPerson(){
    	person = new Person();
    	return "newPerson";
    }
    
    /**
     * Save the person into the database
     * Returns the string "listOfPerson"
     * You return to the list
     * 
     * @return String
     */
    public String save(){
//    	System.out.println(person.getAddress().getCity());
    	//addressService.save(address);
//    	person.setAdress(address);
    	personService.save( person );
    	
    	person = new Person();
      return "listOfPerson";
    }

    /**
     * Get the person
     * @return person
     */
	public Person getPerson() {
		return person;
	}
	
	/**
	 * Get a list of all persons
	 * @return List<Person>
	 */
	public List<Person> getPersons() {
		return personService.getPersons();
	}

	/**
	 * Set a person
	 * @param student
	 */
	public void setPerson(Person person) {
		this.person = person;
	} 
	
	/**
	 * Delete a person and retrun to the personList
	 * @return String
	 */
	public void delPerson() {
		this.personService.delPerson(person);
		this.newPerson();
	} 
	
	/**
	 * Serach for e person with the name
	 * @param name
	 * @return List<Person>
	 */
	public List<Person> searchPerson(String name) {
		return this.personService.searchPerson(name);
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

}
