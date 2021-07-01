package com.km.inventorymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.km.inventorymanagement.entity.Company;
import com.km.inventorymanagement.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	public Company saveCompany(Company company) {
		return repository.save(company);
	}
	
	public Company updateCompany(Company company) {
		Company existingCompany= repository.findById(company.getId()).orElse(null);
		existingCompany.setCompanyName(company.getCompanyName());
		existingCompany.setAddress(company.getAddress());
		return repository.save(company);
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public Company getById(long id) {
		return repository.findById(id).orElse(null);
	}
}
