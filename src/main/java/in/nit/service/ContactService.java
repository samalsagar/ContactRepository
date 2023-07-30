package in.nit.service;

import java.util.List;

import in.nit.dto.Contact;

public interface ContactService {
	
	public boolean saveData(Contact con);
	
	public List<Contact> getAllContacts();
	
	public Contact contactfindbyId(Integer id);
	
	public boolean deletConatctById(Integer id);

}
