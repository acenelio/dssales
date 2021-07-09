package com.devsuperior.dssales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dssales.dto.SalesByCategoryDTO;
import com.devsuperior.dssales.dto.SalesByDateDTO;
import com.devsuperior.dssales.dto.SalesByPaymentMethodDTO;
import com.devsuperior.dssales.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Transactional(readOnly = true)
	public List<SalesByCategoryDTO> salesByCategory() {
		return repository.salesByCategory();
	}

	@Transactional(readOnly = true)
	public List<SalesByPaymentMethodDTO> salesByPaymentMethod() {
		return repository.salesByPaymentMethod();
	}
	
	@Transactional(readOnly = true)
	public List<SalesByDateDTO> salesByDate() {
		return repository.salesByDate();
	}
}
