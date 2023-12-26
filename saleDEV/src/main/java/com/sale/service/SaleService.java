package com.sale.service;

import java.util.List;

import com.sale.entity.Sale;


public interface SaleService {
	
public String upsert(Sale sale);
	
	public Sale getById(Integer cid);
	
	public List<Sale> getAllSales();
	
	public String deleteById(Integer cid);
	
	public String saveSales(List<Sale> saleList);
	


}
