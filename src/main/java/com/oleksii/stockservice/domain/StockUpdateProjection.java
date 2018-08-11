package com.oleksii.stockservice.domain;

import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(name = "update", types = Stock.class)
public interface StockUpdateProjection {

    String getName();

    BigDecimal getCurrentPrice();
}
