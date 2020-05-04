package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Sale;
import com.example.repository.SaleRepository;

@Service
@Transactional
public class SaleSetService {

	@Autowired
	private SaleRepository saleRepository;
	
	public Sale save(Sale sale){
		sale = saleRepository.save(sale);
		return sale;
	}
}
