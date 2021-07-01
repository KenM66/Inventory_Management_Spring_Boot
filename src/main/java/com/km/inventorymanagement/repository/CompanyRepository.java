package com.km.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.km.inventorymanagement.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
