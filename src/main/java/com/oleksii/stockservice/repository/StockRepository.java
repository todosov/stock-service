package com.oleksii.stockservice.repository;

import com.oleksii.stockservice.domain.Stock;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends PagingAndSortingRepository<Stock, Integer> {
}
