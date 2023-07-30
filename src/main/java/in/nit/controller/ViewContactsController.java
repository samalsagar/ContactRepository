package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.dto.Contact;
import in.nit.service.ContactService;

@Controller
public class ViewContactsController {
	
	
	@Autowired
	private ContactService contactService;

	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer id,Model model) {
		
		System.out.println("2");
		Contact contact = contactService.contactfindbyId(id);
			model.addAttribute("contact", contact);
		return "index";
	}
	
	@GetMapping("/deleteContact")
	public String delteContact(@RequestParam("cid") Integer id) {
		
		boolean deletConatctById = contactService.deletConatctById(id);
		
		if(deletConatctById) {
			return "redirect:/viewContact";
		}else {
			return null;
		}
		
	}
}
