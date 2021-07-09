package com.devsuperior.dssales.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dssales.dto.SalesByCategoryDTO;
import com.devsuperior.dssales.dto.SalesByDateDTO;
import com.devsuperior.dssales.dto.SalesByPaymentMethodDTO;
import com.devsuperior.dssales.dto.SalesDTO;
import com.devsuperior.dssales.dto.SalesSummaryDTO;
import com.devsuperior.dssales.entities.Gender;
import com.devsuperior.dssales.entities.Sale;
import com.devsuperior.dssales.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Transactional(readOnly = true)
	public Page<SalesDTO> sales(Pageable pageable) {
		Page<Sale> page = repository.findAll(pageable);
		repository.salesWithOtherEntities(page.getContent());
		return page.map(x -> new SalesDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SalesByCategoryDTO> salesByCategory(String minDate, String maxDate, String gender) {
		LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
		LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
		Gender genderEnum = "".equals(gender) ? null : Gender.valueOf(gender);
		return repository.salesByCategory(min, max, genderEnum);
	}

	@Transactional(readOnly = true)
	public List<SalesByPaymentMethodDTO> salesByPaymentMethod(String minDate, String maxDate, String gender) {
		LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
		LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
		Gender genderEnum = "".equals(gender) ? null : Gender.valueOf(gender);
		return repository.salesByPaymentMethod(min, max, genderEnum);
	}
	
	@Transactional(readOnly = true)
	public List<SalesByDateDTO> salesByDate(String minDate, String maxDate, String gender) {
		LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
		LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
		Gender genderEnum = "".equals(gender) ? null : Gender.valueOf(gender);
		return repository.salesByDate(min, max, genderEnum);
	}
	
	@Transactional(readOnly = true)
	public SalesSummaryDTO salesSummary(String minDate, String maxDate, String gender) {
		LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
		LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
		Gender genderEnum = "".equals(gender) ? null : Gender.valueOf(gender);
		return repository.salesSummary(min, max, genderEnum);		
	}
}
