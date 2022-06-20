package com.trax.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.entities.Billing;
import com.trax.entities.Contacts;
import com.trax.repositories.BillingRepositories;

@Service
public class BillingServiceImpl implements BillingService {
	
	@Autowired
	private BillingRepositories billingRepo;

	@Override
	public void saveBill(Billing bill) {
		billingRepo.save(bill);
	}

	@Override
	public List<Billing> getAllBills() {
		List<Billing> bill = billingRepo.findAll();
		return  bill;
	}

}
