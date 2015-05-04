package ch.fhnw.person.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Function {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinTable(name = "Function_Persons")
	private Set<Person> persons = new HashSet<Person>();
	
	/**
	 * Default constructor for Function
	 */
	public Function() {}
	
	/**
	 * Constructor for Function
	 * 
	 * @param name
	 */
	public Function(String name) {
		this.name = name;
	}
	
	/**
	 * Add a new Person to the exist person list
	 * 
	 * @param person
	 */
	@Transient
	public void addPerson(Person person) {
		this.getPersons().add(person);
	}
	
	/**
	 * Delete a person from the exist person list
	 * 
	 * @param person
	 */
	@Transient
	public void delPerson(Person person) {
		this.getPersons().remove(person);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	
}
