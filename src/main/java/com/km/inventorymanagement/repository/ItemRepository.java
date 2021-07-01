package com.km.inventorymanagement.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.km.inventorymanagement.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	
	List<Item> findItemByNameContaining(String name);
	
	List<Item> findItemByCompanyNum(long companyNum);
}
