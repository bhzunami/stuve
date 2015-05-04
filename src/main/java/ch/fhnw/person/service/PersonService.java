package ch.fhnw.person.service;

import java.util.List;
import java.util.Set;

import ch.fhnw.person.model.Address;
import ch.fhnw.person.model.Function;
import ch.fhnw.person.model.Person;

public interface PersonService {
	
	/**
	 * Save a new Person into the database and 
	 * return the saved person
	 * 
	 * @param person
	 * @return Person
	 */
	void save( Person person );
	
	/**
	 * Get a person from the database with the correct id
	 * 
	 * @param id
	 * @return Person
	 */
	Person getPerson( Long id );
	
	/**
	 * Get all person from the database
	 * 
	 * @return List<Person>
	 */
	List<Person> getPersons();
	
	/**
	 * Delete the person from the database
	 * 
	 * @param person
	 */
	void delPerson(Person person);
	
	/**
	 * Get all person with the name
	 * 
	 * @param name
	 * @return List<Person>
	 */
	List<Person> searchPerson(String name);
	
	/**
	 * Add a function to the person
	 * 
	 * @param function
	 */
	void addFunction(Function function);
	
	/**
	 * Delete a function from the person
	 * 
	 * @param functions
	 */
	void addFunctions(Set<Function> functions );
		
}
