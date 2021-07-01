package com.km.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.km.inventorymanagement.entity.Warehouse;
import com.km.inventorymanagement.repository.WarehouseRepository;

@Service
public class WarehouseService {
	
	@Autowired
	private WarehouseRepository repository;
	
	public Warehouse saveWarehouse(Warehouse warehouse) {
		return repository.save(warehouse);
	}
	
	public List<Warehouse> getWarehouses(){
		return repository.findAll();
	}
	
	public Warehouse updateWarehouse(Warehouse warehouse) {
		Warehouse existingWarehouse= repository.findById(warehouse.getId()).orElse(null);
		existingWarehouse.setName(warehouse.getName());
		existingWarehouse.setAddress(warehouse.getAddress());
		return repository.save(existingWarehouse);
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public Warehouse getWarehouseById(long id) {
		return repository.findById(id).orElse(null);
	}

}
