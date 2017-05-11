package com.koali.dao;

import com.koali.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Elric on 2017/5/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ProductDaoTest {
    @Autowired
    private ProductDao productDao;
    @Test
    public void save() throws Exception {
        Product product = new Product();
        product.setPname("电视机");
        product.setPrice(2300.0);
        productDao.save(product);
    }
}