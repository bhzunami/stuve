package ch.fhnw.person.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import ch.fhnw.person.model.Address;
import ch.fhnw.person.model.Person;

public class PersonDaoImpl implements PersonDao {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Person save(Person person) {
		sessionFactory.getCurrentSession().saveOrUpdate(person);
		return (Person) sessionFactory.getCurrentSession().load(Person.class,
				person.getId());
	}

	public Person getPerson(Long id) {
		return (Person) sessionFactory.getCurrentSession().load(Person.class,
				id);
	}

	public List<Person> getPersons() {
		Query q = sessionFactory.getCurrentSession().createQuery("from Person");
		return q.list();
	}

	public void delPerson(Person person) {
		this.sessionFactory.getCurrentSession().delete(person);
	}
	
	public Person getPersonByFirstName(String name) {
		return (Person) sessionFactory.getCurrentSession().createQuery(
				"from Person where firstName like '%" +name +"%'");
	}

	public List<Person> searchPerson(String name) {
		return  sessionFactory.getCurrentSession().find(
				"from Person where firstName ='"+name+"'");
	}
	
}
