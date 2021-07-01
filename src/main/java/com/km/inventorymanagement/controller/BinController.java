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

import com.km.inventorymanagement.entity.Bin;
import com.km.inventorymanagement.service.BinService;

@CrossOrigin(origins="*")
@RestController
public class BinController {
	
	@Autowired
	private BinService service;
	
	@PostMapping("/api/addBin")
	public Bin addBin(@RequestBody Bin bin) {
		return service.saveBin(bin);
	}
	
	@GetMapping("/api/bins")
	public List<Bin> findAllBins(){
		return service.getBins();
	}
	
	@PutMapping("/api/updateBin/{id}")
	public Bin updateBin(@RequestBody Bin bin) {
		System.out.println(bin.getId());
		return service.updateBin(bin);
	}
	
	@DeleteMapping("/api/deleteBin/{id}")
	public void deleteBin(@PathVariable long id) {
		service.deleteById(id);
	}
	
	@GetMapping("/api/binById/{id}")
	public Bin findByById(@PathVariable long id) {
		return service.getBinById(id);
	}
	@PutMapping("/api/addToBin/{id}/{itemId}")
	public void addToBin(@PathVariable long id,@PathVariable long itemId) {
		 service.addItemToBin(id, itemId);
	}
	@PutMapping("/api/removeFromBin/{id}/{itemId}")
	public void removeFromBin(@PathVariable long id, @PathVariable long itemId) {
		service.deleteItemFromBin(id, itemId);
	}
	

}
