package com.sale.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.sale.entity.Sale;



public interface SaleRepository extends JpaRepository<Sale, Integer>  {

	 
}
