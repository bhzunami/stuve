package ch.fhnw.person.service;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import ch.fhnw.person.dao.AddressDao;
import ch.fhnw.person.dao.FunctionDao;
import ch.fhnw.person.dao.PersonDao;
import ch.fhnw.person.model.Address;
import ch.fhnw.person.model.Function;
import ch.fhnw.person.model.Person;

@Transactional
public class PersonServiceImpl implements PersonService {
	
	PersonDao personDao;
	FunctionDao functionDao;
	AddressDao addressDao;
	
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public FunctionDao getFunctionDao() {
		return functionDao;
	}

	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}

	public void save(Person person) {
		personDao.save(person);
	}
	
	public Person getPerson(Long id) {
		return personDao.getPerson(id);
	}

	public List<Person> getPersons() {
		return personDao.getPersons();
	}

	public void delPerson(Person person) {
		this.personDao.delPerson(person);
		
	}

	public List<Person> searchPerson(String name) {
		return personDao.searchPerson(name);
	}
	
	public void addFunction(Function function) {
		
		
	}
	
	public void addFunctions(Set<Function> functions) {
		
		
	}
}
