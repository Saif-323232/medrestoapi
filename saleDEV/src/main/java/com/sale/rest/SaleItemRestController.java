package com.sale.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sale.entity.SaleItem;
import com.sale.service.SaleItemService;




@RestController
@RequestMapping("/api")
public class SaleItemRestController {

	@Autowired
	private SaleItemService saleItemService;
	
	
	@PostMapping("/saleItem")
	public ResponseEntity<String> createSaleItem(@RequestBody SaleItem saleItem)
	{
		String status = saleItemService.upsert(saleItem);
		return new ResponseEntity<> (status, HttpStatus.CREATED);
	}
	
	@PostMapping("/saleItems")
	public ResponseEntity<String> createSaleItems(@RequestBody List<SaleItem> saleItemList)
	{
		String status = saleItemService.saveSaleItems(saleItemList);
		return new ResponseEntity<> (status, HttpStatus.CREATED);
	}
	
	@GetMapping("/saleItem/{cid}")
	public ResponseEntity<SaleItem> getSaleItem(@PathVariable Integer cid)
	{
		SaleItem saleItem = saleItemService.getById(cid);
		return new ResponseEntity<>(saleItem,HttpStatus.OK);
	}
	
	
	@GetMapping("/saleItems")
	public ResponseEntity<List<SaleItem>> getAllSaleItems()
	{
		List<SaleItem> allsaleItems = saleItemService.getAllSaleItems();
		return new ResponseEntity<>(allsaleItems,HttpStatus.OK);
	}
	
	@PutMapping("/saleItem")
	public ResponseEntity<String> updateSaleItem(@RequestBody SaleItem saleItem)
	{
		String status = saleItemService.upsert(saleItem);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@DeleteMapping("/saleItem/{cid}")
	public ResponseEntity<String> deleteSaleItem(@PathVariable Integer cid)
	{
		String status = saleItemService.deleteById(cid);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	
}
