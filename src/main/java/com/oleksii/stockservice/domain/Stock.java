package com.oleksii.stockservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Stock {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private BigDecimal currentPrice;

    private Date lastUpdate;

    @PrePersist
    @PreUpdate
    public void updateDate() {
        lastUpdate = new Date();
    }
}
