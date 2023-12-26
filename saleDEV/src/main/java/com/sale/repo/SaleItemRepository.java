package com.sale.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.sale.entity.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Integer>  {

	 
}
