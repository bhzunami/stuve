package ch.fhnw.person.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ch.fhnw.person.dao.AddressDao;
import ch.fhnw.person.model.Address;

@Transactional
public class AddressServiceImpl implements AddressService {

	private AddressDao addressDao;

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public void save(Address address) {
		addressDao.save(address);
	}

	public Address getAddress(int plz) {
		return addressDao.getAddress(plz);
	}

	public List<Address> getAddresses() {
		return addressDao.getAddresses();
	}

	public void delAddress(Address address) {
		this.addressDao.delAddress(address);
	}

}
