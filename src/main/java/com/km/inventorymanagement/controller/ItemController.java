package com.km.inventorymanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.km.inventorymanagement.entity.Item;
import com.km.inventorymanagement.service.ItemService;

@RestController
@CrossOrigin(origins="*")
public class ItemController {
	
	@Autowired
	private ItemService service;

	@PostMapping("/api/addItem")
	public Item addItem(@RequestBody Item item) {
		return service.saveItem(item);
	}
	
	@GetMapping("/api/items")
	public List<Item> findAllItems(){
		return service.getItems();
	}
	
	@PutMapping("/api/updateItem/{id}")
	public Item updateItem(@PathVariable long id, @RequestBody Item item) {
		return service.updateItem(item);
	}
	
	@DeleteMapping("/api/deleteItem/{id}")
	public void deleteItem(@PathVariable long id) {
		  service.deleteById(id);
		}
	
	@GetMapping("/api/itemById/{id}")
	public Item findById(@PathVariable long id) {
		return service.getItemById(id);
	}
	@GetMapping("/api/itemByName/{name}")
	public List<Item> findItemByName(@PathVariable String name){
		return service.findItemByName(name);
	}
	@GetMapping("/api/itemsByCompanyNum/{companyNum}")
	public List<Item> findItemByCompanyNum(@PathVariable long companyNum){
		return service.findItemByCompanyNum(companyNum);
	}
}
