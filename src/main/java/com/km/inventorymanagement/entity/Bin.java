package com.km.inventorymanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bin {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private long warehouseNum;
    
	@JsonBackReference
    @ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="warehouse_id", referencedColumnName="id", nullable=false)
	private Warehouse warehouse;
	
	@ManyToMany(targetEntity= Item.class, cascade=CascadeType.ALL)
	List<Item> items= new ArrayList<>();
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public long getWarehouseNum() {
		return warehouseNum;
	}

	public void setWarehouseNum(long warehouseNum) {
		this.warehouseNum= warehouseNum;
	}
	
	
	
	

}
