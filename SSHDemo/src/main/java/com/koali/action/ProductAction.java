package com.koali.action;

import com.koali.pojo.Product;
import com.koali.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 商品管理的Action
 * Created by Elric on 2017/5/6.
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product> {
    private ProductService productService;
    public void setProductService(ProductService productService){
        this.productService = productService;
    }
    private Product product = new Product();
    public Product getModel() {
        return product;
    }
    public void save(){
        System.out.println("save被执行了");
        productService.save(product);
    }
}
