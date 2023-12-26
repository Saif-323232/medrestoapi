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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sale.entity.Sale;
import com.sale.service.SaleService;



@RestController
@RequestMapping("/api")
public class SaleRestController {

	@Autowired
	private SaleService saleService;
	
	
	@PostMapping("/sale")
	public ResponseEntity<String> createSale(@RequestBody Sale sale)
	{
		String status = saleService.upsert(sale);
		return new ResponseEntity<> (status, HttpStatus.CREATED);
	}
	
	@PostMapping("/sales")
	public ResponseEntity<String> createSales(@RequestBody List<Sale> saleList)
	{
		String status = saleService.saveSales(saleList);
		return new ResponseEntity<> (status, HttpStatus.CREATED);
	}
	
	@GetMapping("/sale/{cid}")
	public ResponseEntity<Sale> getSale(@PathVariable Integer cid)
	{
		Sale sale = saleService.getById(cid);
		return new ResponseEntity<>(sale,HttpStatus.OK);
	}
	
	
	@GetMapping("/sales")
	public ResponseEntity<List<Sale>> getAllSales()
	{
		List<Sale> allsales = saleService.getAllSales();
		return new ResponseEntity<>(allsales,HttpStatus.OK);
	}
	
	@PutMapping("/sale")
	public ResponseEntity<String> updateSale(@RequestBody Sale sale)
	{
		String status = saleService.upsert(sale);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@DeleteMapping("/sale/{cid}")
	public ResponseEntity<String> deleteSale(@PathVariable Integer cid)
	{
		String status = saleService.deleteById(cid);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	
}
