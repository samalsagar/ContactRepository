package in.nit.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.dto.Contact;
import in.nit.entity.ContactDetails;
import in.nit.repository.ContactDetailsRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDetailsRepository contactRepo;

	@Override
	public boolean saveData(Contact con) {
		ContactDetails entity =  new ContactDetails();
		BeanUtils.copyProperties(con, entity);
		ContactDetails savedEntity = contactRepo.save(entity);
		return savedEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactDetails> entities = contactRepo.findAll();
		
		
		//Leagcy approach for copying 
		/*
		 * List<Contact> contacts = new ArrayList<Contact>(); 
		 * for(ContactDetails entity:entities) { 
		 * Contact contact = new Contact();
		 * BeanUtils.copyProperties(entity, contact); 
		 * contacts.add(contact); 
		 * }
		 */
		
		//JAVA 8 Streams
		
		 List<Contact> contacts = entities.stream().map(entity->{
			 Contact contact = new Contact();
			 BeanUtils.copyProperties(entity, contact);
			 return contact;
		 }).collect(Collectors.toList());
		
		
		return contacts;
	}
	
	@Override
	public Contact contactfindbyId(Integer id) {
		
		System.out.println("3");
		Optional<ContactDetails> findById = contactRepo.findById(id);
		if(findById.isPresent()) {
			ContactDetails res =findById.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(res, c);
			return c;
		} else {
			return null;
		}
		
	}
	
	@Override
	public boolean deletConatctById(Integer id) {
		contactRepo.deleteById(id);
		return true;
	}

}
