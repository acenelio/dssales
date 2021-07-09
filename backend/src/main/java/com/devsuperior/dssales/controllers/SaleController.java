package com.devsuperior.dssales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dssales.dto.SalesByCategoryDTO;
import com.devsuperior.dssales.dto.SalesByDateDTO;
import com.devsuperior.dssales.dto.SalesByPaymentMethodDTO;
import com.devsuperior.dssales.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/by-category")
	public ResponseEntity<List<SalesByCategoryDTO>> salesByCategory() {
		List<SalesByCategoryDTO> list = service.salesByCategory();
		return ResponseEntity.ok(list);
	}	
	
	@GetMapping(value = "/by-payment-method")
	public ResponseEntity<List<SalesByPaymentMethodDTO>> salesByPaymentMethod() {
		List<SalesByPaymentMethodDTO> list = service.salesByPaymentMethod();
		return ResponseEntity.ok(list);
	}	
	
	@GetMapping(value = "/by-date")
	public ResponseEntity<List<SalesByDateDTO>> salesByDate() {
		List<SalesByDateDTO> list = service.salesByDate();
		return ResponseEntity.ok(list);
	}	
}
