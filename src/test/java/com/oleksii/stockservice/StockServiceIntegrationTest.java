package com.oleksii.stockservice;

import com.oleksii.stockservice.domain.Stock;
import com.oleksii.stockservice.repository.StockRepository;
import org.apache.commons.collections4.IterableUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StockServiceIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StockRepository stockRepository;

    private UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromPath("/api/stocks");

    @Before
    public void setUp() throws Exception {
        //add test records to db
//        System.out.println("sleep");
//        Thread.sleep(99999999999999999L);
//        entityManager.persist(Stock.builder().name("test1").currentPrice(new BigDecimal(120)).build());
//        entityManager.persist(Stock.builder().name("test2").currentPrice(new BigDecimal(12)).build());
//        entityManager.persist(Stock.builder().name("test3").currentPrice(new BigDecimal(502.5)).build());
//        entityManager.persist(Stock.builder().name("test4").currentPrice(new BigDecimal(46.3)).build());
//        entityManager.persist(Stock.builder().name("test5").currentPrice(new BigDecimal(95.3)).build());
    }

    @Test
	public void testGetAllEntities() throws Exception {
        Iterable<Stock> all = stockRepository.findAll();

        System.out.println("sleep");
        Thread.sleep(99999999999999999L);

        Assert.assertEquals(5, IterableUtils.size(all));


    }

}
