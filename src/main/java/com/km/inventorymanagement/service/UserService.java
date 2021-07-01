package com.km.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.km.inventorymanagement.entity.User;
import com.km.inventorymanagement.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	public User updateUser(User user) {
		User existingUser= repository.findById(user.getId()).orElse(null);
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		existingUser.setAdmin(user.isAdmin());
		existingUser.setEmail(user.getEmail());
		return repository.save(user);
		
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public User getUserById(long id) {
		return repository.findById(id).orElse(null);
	}
	
	public User getUserByUsername(String username) {
		return repository.getByUsername(username);
	}
	
	public User getUserByEmail(String email) {
		return repository.getByEmail(email);
	}
	
	public List<User> getUsersByCompanyNum(long companyNum){
		return repository.getByCompanyNum(companyNum);
	}
}
