package com.otodosov.stockservice;

import com.otodosov.stockservice.domain.Stock;
import com.otodosov.stockservice.repository.StockRepository;
import org.assertj.core.util.IterableUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StockRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StockRepository stockRepository;

    private Long testId;

    @Before
    public void setUp() throws Exception {
        //add test records to db
        testId = entityManager
                .persistAndGetId(Stock.builder().name("test1").currentPrice(new BigDecimal(120)).build(),
                        Long.class);
        entityManager.persist(Stock.builder().name("test2").currentPrice(new BigDecimal(12)).build());
        entityManager.persist(Stock.builder().name("test3").currentPrice(new BigDecimal(502.5)).build());
        entityManager.persist(Stock.builder().name("test4").currentPrice(new BigDecimal(46.3)).build());
        entityManager.persist(Stock.builder().name("test5").currentPrice(new BigDecimal(95.3)).build());
    }

    @Test
    public void testGetAllEntities() throws Exception {
        Iterable<Stock> all = stockRepository.findAll();

        assertEquals(5, IterableUtil.toCollection(all).size());
    }

    @Test
    public void testGetById() throws Exception {
        Optional<Stock> result = stockRepository.findById(testId);

        assertEquals("test1", result.get().getName());
    }

    @Test
    @Ignore
    public void testSetLastUpdateOnInsert() throws Exception {
        Stock stock = stockRepository.findById(testId).get();
        Date previousUpdate = stock.getLastUpdate();
        stock.setName("1111");
        stockRepository.save(stock);
        Date lastUpdate = stockRepository.findById(testId).get().getLastUpdate();

        assertTrue(lastUpdate.after(previousUpdate));
    }

    @Test
    public void testUpdateById() throws Exception {
        Stock stock = stockRepository.findById(testId).get();
        stock.setName("updated name");
        stockRepository.save(stock);

        assertEquals("updated name", stockRepository.findById(testId).get().getName());
    }

    @Test
    public void testDeleteById() throws Exception {
        stockRepository.deleteById(testId);

        assertFalse(stockRepository.findById(testId).isPresent());
    }
}
