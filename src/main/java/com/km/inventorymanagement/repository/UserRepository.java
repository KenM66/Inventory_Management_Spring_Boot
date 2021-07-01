package com.km.inventorymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.km.inventorymanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User getByUsername(String username);
	public User getByEmail(String email);
	public List<User> getByCompanyNum(long companyNum);

}
