package com.otodosov.stockservice.repository;

import com.otodosov.stockservice.domain.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
}
