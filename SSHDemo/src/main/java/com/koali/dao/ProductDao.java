package com.koali.dao;

import com.koali.pojo.Product;

/**
 * Created by Elric on 2017/5/6.
 */
public class ProductDao {
    public void save(Product product) {
        System.out.println("Dao中的save被执行了");
    }
}
