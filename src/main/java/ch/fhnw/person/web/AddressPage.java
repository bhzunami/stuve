package ch.fhnw.person.web;

import java.util.List;

import javax.faces.bean.ManagedBean;

import ch.fhnw.person.model.Address;
import ch.fhnw.person.service.AddressService;

@ManagedBean
public class AddressPage {
	
	private AddressService addressService;
	private Address address = new Address();
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	private List<Address> addresses;
	
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	public String newAddress() {
		Address adress = new Address();
		return "newAddress";
	}
	
	public void saveAddress(Address address) {
		addressService.save(address);
	}
	
	public List<Address> getAddresses() {
		return addressService.getAddresses();
	}

}
