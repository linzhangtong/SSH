package com.koali.pojo;


import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Elric on 2017/5/6.
 */
@Entity
@Table(name = "product")
public class Product {
    private Integer pid;
    private String pname;
    private Double price;
    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}