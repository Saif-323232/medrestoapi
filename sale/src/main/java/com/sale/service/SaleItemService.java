package com.sale.service;

import java.util.List;

import com.sale.entity.Sale;
import com.sale.entity.SaleItem;


public interface SaleItemService {
	
public String upsert(SaleItem sale);
	
	public SaleItem getById(Integer cid);
	
	public List<SaleItem> getAllSaleItems();
	
	public String deleteById(Integer cid);
	
	public String saveSaleItems(List<SaleItem> saleItemList);


}
