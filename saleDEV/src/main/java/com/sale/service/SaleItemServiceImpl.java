package com.sale.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sale.entity.SaleItem;
import com.sale.repo.SaleItemRepository;




@Service
public class SaleItemServiceImpl implements SaleItemService {

	@Autowired
	private SaleItemRepository saleItemRepo;
	
	@Override
	public String upsert(SaleItem sale) {
		saleItemRepo.save(sale); 
		
		return "success";
	}

	@Override
	public SaleItem getById(Integer cid) {
		Optional<SaleItem> findById = saleItemRepo.findById(cid);
		if(findById.isPresent())
		{
			return findById.get();
		}
			return null;
	}

	@Override
	public List<SaleItem> getAllSaleItems() {
		return saleItemRepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) {
		if(saleItemRepo.existsById(cid))
		{
			saleItemRepo.deleteById(cid);
			return "Delete Success";
		}
		else
		{
			return "No Record Found";
		}
	}

	@Override
	public String saveSaleItems(List<SaleItem> saleItemList) {
		saleItemRepo.saveAll(saleItemList);
		return "success";
	}


}
