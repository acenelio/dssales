package com.devsuperior.dssales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<List<SalesByCategoryDTO>> salesByCategory(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
		List<SalesByCategoryDTO> list = service.salesByCategory(minDate, maxDate);
		return ResponseEntity.ok(list);
	}	
	
	@GetMapping(value = "/by-payment-method")
	public ResponseEntity<List<SalesByPaymentMethodDTO>> salesByPaymentMethod(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
		List<SalesByPaymentMethodDTO> list = service.salesByPaymentMethod(minDate, maxDate);
		return ResponseEntity.ok(list);
	}	
	
	@GetMapping(value = "/by-date")
	public ResponseEntity<List<SalesByDateDTO>> salesByDate(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
		List<SalesByDateDTO> list = service.salesByDate(minDate, maxDate);
		return ResponseEntity.ok(list);
	}	
}
