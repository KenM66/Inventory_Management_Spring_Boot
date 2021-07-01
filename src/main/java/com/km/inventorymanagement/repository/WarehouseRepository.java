package com.km.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.km.inventorymanagement.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    
}
