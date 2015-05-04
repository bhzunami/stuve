package ch.fhnw.person.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import ch.fhnw.person.model.Address;

public class AddressDaoImpl implements AddressDao {
	
	  SessionFactory sessionFactory;
	  
	  public void setSessionFactory( SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	  }

	public void save(Address address) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(address);
	}

	
	public Address getAddress(int plz) {
		return (Address)sessionFactory.getCurrentSession().load(Address.class, plz);
	}

	public List<Address> getAddresses() {
		Query q = sessionFactory.getCurrentSession().createQuery("from Address");
		return q.list();
	}

	public void delAddress(Address address) {
		this.sessionFactory.getCurrentSession().delete(address);
	}

}
