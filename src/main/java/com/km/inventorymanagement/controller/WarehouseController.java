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

import com.km.inventorymanagement.entity.Warehouse;
import com.km.inventorymanagement.service.WarehouseService;
@CrossOrigin(origins="*")
@RestController
public class WarehouseController {
	
	@Autowired WarehouseService service;
	
	@PostMapping("/api/addWarehouse")
	public Warehouse addWarehouse(@RequestBody Warehouse warehouse) {
		return service.saveWarehouse(warehouse);
	}
	
	@GetMapping("/api/warehouses")
	public List<Warehouse> findAllWarehouses(){
		return service.getWarehouses();
	}
	
	@PutMapping("/api/updateWarehouse/{id}")
	public Warehouse updateWarehouse(@RequestBody Warehouse warehouse) {
		return service.updateWarehouse(warehouse);
	}
	
	@DeleteMapping("/api/deleteWarehouse/{id}")
	public void deleteWarehouse(@PathVariable long id) {
		service.deleteById(id);
	}
	
	@GetMapping("/api/warehouseById/{id}")
	public Warehouse findWarehouseById(@PathVariable long id) {
		return service.getWarehouseById(id);
	}

}
