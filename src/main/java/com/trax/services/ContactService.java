package com.trax.services;

import java.util.List;

import com.trax.entities.Contacts;
import com.trax.entities.Lead;

public interface ContactService {

	public void saveContact(Contacts contacts);
	public List<Contacts> getAllContacts();
	public Contacts findContactById(long id);
}
