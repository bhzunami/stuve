package ch.fhnw.person.service;

import java.util.List;

import ch.fhnw.person.model.Address;

public interface AddressService {
	
	/**
	 * Save a new address into the database
	 * 
	 * @param address
	 */
	void save( Address address );
	
	/**
	 * Get an existing address from the database with 
	 * the given plz as id
	 * 
	 * @param plz is the id for address
	 * @return Address
	 */
	Address getAddress( int plz );
	
	/**
	 * Get all all addresses that are stored in
	 * the database 
	 * 
	 * @return List<Address>
	 */
	List<Address> getAddresses();
	
	/**
	 * Delete an existing address from the database
	 * with the object address
	 * 
	 * @param address
	 */
	void delAddress(Address address);

}
