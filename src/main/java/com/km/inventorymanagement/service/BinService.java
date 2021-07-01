package com.km.inventorymanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.km.inventorymanagement.entity.Bin;
import com.km.inventorymanagement.entity.Item;
import com.km.inventorymanagement.repository.BinRepository;

@Service
public class BinService {
	
	@Autowired
	private BinRepository repository;
	
	@Autowired
	private ItemService itemService;
	
	public Bin saveBin(Bin bin) {
		Bin newBin= new Bin();
		newBin.setName(bin.getName());	
		newBin.setWarehouse(bin.getWarehouse());
		newBin.setWarehouseNum(bin.getWarehouseNum());
		newBin.getItems()
			.addAll(bin
					.getItems()
					.stream()
					.map(i ->{
						Item ii= itemService.getItemById(i.getId());
					    ii.getBins().add(newBin);
					    return ii;
					}).collect(Collectors.toList()));
		return repository.save(newBin);
		
	}
	public List<Bin> getBins(){
	   return repository.findAll();
	}
	
	public Bin updateBin(Bin bin) {
		
		Bin existingBin= repository.findById(bin.getId()).orElse(null);
		existingBin.setName(bin.getName());
		//existingBin.setWarehouse(bin.getWarehouse());
		//existingBin.setItems(bin.getItems());
		return repository.save(existingBin);
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public Bin getBinById(long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void addItemToBin(long binId, long itemId) {
		Bin bin= repository.getOne(binId);
		Item item= itemService.getItemById(itemId);
		bin.getItems().add(item);
		repository.save(bin);
	}
	public void deleteItemFromBin(long binId, long itemId) {
		Bin bin= repository.getOne(binId);
		Item item = itemService.getItemById(itemId);
		bin.getItems().remove(item);
		repository.save(bin);
	}
	
	

}
