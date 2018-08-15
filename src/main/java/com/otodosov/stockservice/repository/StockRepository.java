package com.otodosov.stockservice.repository;

import com.otodosov.stockservice.domain.Stock;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends PagingAndSortingRepository<Stock, Long> {
}
