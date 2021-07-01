package com.km.inventorymanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.km.inventorymanagement.entity.Item;
import com.km.inventorymanagement.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repository;
	
	private ArrayList<Item> items= new ArrayList<>();
	
	public Item saveItem(Item item) {
		return repository.save(item);
	}
	
	public List<Item> getItems(){
		return repository.findAll();
	}
	
	public Item updateItem(Item item) {
		
		Item existingItem= repository.findById(item.getId()).orElse(null);
		existingItem.setName(item.getName());
		existingItem.setDescription(item.getDescription());
		existingItem.setQuantity(item.getQuantity());
		return repository.save(existingItem);
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public Item getItemById(long id) {
		return repository.findById(id).orElse(null);
	}
	
    public List<Item> findItemByName(String keyword){
		return repository.findItemByNameContaining(keyword);
	}
	
    public List<Item> findItemByCompanyNum(long companyNum){
	    return repository.findItemByCompanyNum(companyNum);
 }
	
}
