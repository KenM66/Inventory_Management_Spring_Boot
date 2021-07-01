package com.km.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.km.inventorymanagement.entity.User;
import com.km.inventorymanagement.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/api/addUser")
	public User addUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@GetMapping("/api/users")
	public List<User> getAllUsers(){
		return service.getUsers();
	}
	
	@PutMapping("/api/updateUser/{id}")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	
	@DeleteMapping("/api/deleteUser/{id}")
	public void deleteUser(@PathVariable long id) {
		service.deleteById(id);
	}
	
	@GetMapping("/api/userByUsername/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return service.getUserByUsername(username);
	}
	
	@GetMapping("/api/userByEmail/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return service.getUserByEmail(email);
	}
	@GetMapping("/api/usersByCompanyNum/{companyNum}")
	public List<User> getUsersByCompanyNum(@PathVariable long companyNum) {
		return service.getUsersByCompanyNum(companyNum);
	}
	}


