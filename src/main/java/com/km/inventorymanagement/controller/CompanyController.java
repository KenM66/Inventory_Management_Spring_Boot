package com.km.inventorymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.km.inventorymanagement.entity.Company;
import com.km.inventorymanagement.service.CompanyService;

@RestController
@CrossOrigin(origins="*")
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	@PostMapping("/api/addCompany")
	public Company addCompany(@RequestBody Company company) {
		return service.saveCompany(company);
	}
	@PutMapping("/api/updateCompany/{id}")
	public Company updateCompany(@RequestBody Company company) {
		return service.updateCompany(company);
	}
	
	@DeleteMapping("/api/deleteCompany/{id}")
	public void deleteCompany(@PathVariable long id) {
		service.deleteById(id);
		}
	
	@GetMapping("/api/getCompanyById/{id}")
	public Company getCompanyById(@PathVariable long id) {
		return service.getById(id);
	}

}
