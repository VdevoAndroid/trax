package com.trax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trax.entities.Contacts;
import com.trax.entities.Lead;
import com.trax.services.ContactService;
import com.trax.services.LeadService;

@Controller
public class ContactController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	

	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id,ModelMap model) {
		
		
		Lead lead=leadService.findLeadById(id);
		
		Contacts contacts=new Contacts();
		contacts.setFirstName(lead.getFirstName());
		contacts.setLastName(lead.getLastName());
		contacts.setLeadSource(lead.getLeadSource());
		contacts.setEmail(lead.getEmail());
		contacts.setMobile(lead.getMobile());
		
		contactService.saveContact(contacts);
		
		leadService.deleteLeadById(id);
		
		List<Contacts> contact = contactService.getAllContacts();
		model.addAttribute("contact", contact);
		return "contact_search_result";
		
	}
	
	@RequestMapping("/contactInfo")
	public String contactInfo(@RequestParam("id") long id,ModelMap model) {
		Contacts contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		
		return "contact_info";
	}
	
	@RequestMapping("listallcontact")
	public String listAllContacts(ModelMap model) {
		List<Contacts> contact = contactService.getAllContacts();
		model.addAttribute("contact", contact);
		return "contact_search_result";
	}
	
	
}
