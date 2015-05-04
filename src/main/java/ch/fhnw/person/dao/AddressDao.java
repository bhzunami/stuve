package ch.fhnw.person.dao;

import java.util.List;

import ch.fhnw.person.model.Address;

public interface AddressDao {
	
	/**
	 * Save a new address into the database
	 * 
	 * @param address
	 */
	public void save(Address address);
	  
	/**
	 * Get an existing address from the database with 
	 * the given plz as id
	 * 
	 * @param plz is the id for address
	 * @return Address
	 */
	public Address getAddress(int plz);
	  
	/**
	 * Get all all addresses that are stored in
	 * the database 
	 * 
	 * @return List<Address>
	 */
	public List<Address> getAddresses();
	  
	/**
	 * Delete an existing address from the database
	 * with the object address
	 * 
	 * @param address
	 */
	public void delAddress(Address address);

}
