	package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.dto.Contact;
import in.nit.service.ContactService;

@Controller
public class ContactDetailsInfo {
	
	@Autowired
	private ContactService contactService;

	@GetMapping("/load")
	public String loadForm(Model model) {
		Contact con = new Contact();
		model.addAttribute("contact", con);
		return "index";
	}

	
	@PostMapping("/saveContact")
	public String handleSubmit(@ModelAttribute  Contact con,Model model) {
			boolean isSave = contactService.saveData(con);
			if(isSave) {
				if(con.getContactId()!=null) {
					model.addAttribute("updtateMsg", "Conact Updated Successfully!!!!");
				}else {
					model.addAttribute("sucMsg", "Conact Saved Successfully!!!!");
				}
				
			} else {
				model.addAttribute("errMsg", "Failed to save Contact!!!!");
			}
			
			return "index";	
	}
	
	@GetMapping("/viewContact")
	public String showData(Model model) {
		List<Contact> contactsList =contactService.getAllContacts();
		model.addAttribute("contact", contactsList);
		return "viewContact";
	}
	
	
}
