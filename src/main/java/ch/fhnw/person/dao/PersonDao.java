package ch.fhnw.person.dao;

import java.util.List;

import ch.fhnw.person.model.Address;
import ch.fhnw.person.model.Person;

public interface PersonDao {
	
	/**
	 * Save a new Person into the database and 
	 * return the saved person
	 * 
	 * @param person
	 * @return Person
	 */
	public Person save(Person person);
  
	/**
	 * Get a person from the database with the correct id
	 * 
	 * @param id
	 * @return Person
	 */
	public Person getPerson(Long id);
	
	/**
	 * Get a person from the database with the correct 
	 * first name
	 * 
	 * @param name
	 * @return Person
	 */
	public Person getPersonByFirstName(String name);
  
	/**
	 * Get all person from the database
	 * 
	 * @return List<Person>
	 */
	public List<Person> getPersons();
  
	/**
	 * Delete the person from the database
	 * 
	 * @param person
	 */
	public void delPerson(Person person);
	
	/**
	 * Get all person with the name
	 * 
	 * @param name
	 * @return List<Person>
	 */
	public List<Person> searchPerson(String name);
	
}
