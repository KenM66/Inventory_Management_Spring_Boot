package com.km.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.km.inventorymanagement.entity.Bin;

public interface BinRepository extends JpaRepository<Bin, Long> {

}
