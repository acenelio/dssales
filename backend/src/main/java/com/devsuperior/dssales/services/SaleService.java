package com.devsuperior.dssales.services;

import java.time.LocalDate;
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
	public List<SalesByCategoryDTO> salesByCategory(String minDate, String maxDate) {
		LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
		LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
		return repository.salesByCategory(min, max);
	}

	@Transactional(readOnly = true)
	public List<SalesByPaymentMethodDTO> salesByPaymentMethod(String minDate, String maxDate) {
		LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
		LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
		return repository.salesByPaymentMethod(min, max);
	}
	
	@Transactional(readOnly = true)
	public List<SalesByDateDTO> salesByDate(String minDate, String maxDate) {
		LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
		LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
		return repository.salesByDate(min, max);
	}
}
