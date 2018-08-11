package com.oleksii.stockservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Stock {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private BigDecimal currentPrice;

    private Date lastUpdate;
}
