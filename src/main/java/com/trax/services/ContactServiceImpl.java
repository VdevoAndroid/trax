package com.trax.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.entities.Contacts;
import com.trax.entities.Lead;
import com.trax.repositories.ContactRepositories;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepositories contactRepo;
	
	@Override
	public void saveContact(Contacts contacts) {
		contactRepo.save(contacts);
		
	}

	@Override
	public List<Contacts> getAllContacts() {
		List<Contacts> contacts = contactRepo.findAll();
		return  contacts;
	}

	@Override
	public Contacts findContactById(long id) {
		Optional<Contacts> findById = contactRepo.findById(id);
		Contacts contacts = findById.get();
		return contacts;
	}

	

}
