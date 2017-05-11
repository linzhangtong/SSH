package com.koali.service;

import com.koali.dao.ProductDao;
import com.koali.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Elric on 2017/5/6.
 */

public class ProductService {
    private ProductDao productDao;
    public void setProductDao(ProductDao productDao){
        this.productDao = productDao;
    }

    public void save(Product product){
        productDao.save(product);
    }
}
