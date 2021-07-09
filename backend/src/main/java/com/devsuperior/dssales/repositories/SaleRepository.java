package com.devsuperior.dssales.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dssales.dto.SalesByCategoryDTO;
import com.devsuperior.dssales.dto.SalesByDateDTO;
import com.devsuperior.dssales.dto.SalesByPaymentMethodDTO;
import com.devsuperior.dssales.entities.Gender;
import com.devsuperior.dssales.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.devsuperior.dssales.dto.SalesByCategoryDTO(obj.category, SUM(obj.total)) "
			+ "FROM Sale AS obj "
			+ "WHERE (:min IS NULL OR obj.date >= :min) "
			+ "AND (:max IS NULL OR obj.date <= :max) "
			+ "AND (:genderEnum IS NULL OR obj.gender = :genderEnum) "
			+ "GROUP BY obj.category")
	List<SalesByCategoryDTO> salesByCategory(LocalDate min, LocalDate max, Gender genderEnum);

	@Query("SELECT new com.devsuperior.dssales.dto.SalesByPaymentMethodDTO(obj.paymentMethod, SUM(obj.total)) "
			+ "FROM Sale AS obj "
			+ "WHERE (:min IS NULL OR obj.date >= :min) "
			+ "AND (:max IS NULL OR obj.date <= :max) "
			+ "AND (:genderEnum IS NULL OR obj.gender = :genderEnum) "
			+ "GROUP BY obj.paymentMethod")
	List<SalesByPaymentMethodDTO> salesByPaymentMethod(LocalDate min, LocalDate max, Gender genderEnum);
	
	@Query("SELECT new com.devsuperior.dssales.dto.SalesByDateDTO(obj.date, SUM(obj.total)) "
			+ "FROM Sale AS obj "
			+ "WHERE (:min IS NULL OR obj.date >= :min) "
			+ "AND (:max IS NULL OR obj.date <= :max) "
			+ "AND (:genderEnum IS NULL OR obj.gender = :genderEnum) "
			+ "GROUP BY obj.date")
	List<SalesByDateDTO> salesByDate(LocalDate min, LocalDate max, Gender genderEnum);
	
	@Query("SELECT obj FROM Sale obj "
			+ "JOIN FETCH obj.category "
			+ "JOIN FETCH obj.paymentMethod "
			+ "JOIN FETCH obj.store "
			+ "WHERE obj in :sales")
	List<Sale> salesWithOtherEntities(List<Sale> sales);
}
