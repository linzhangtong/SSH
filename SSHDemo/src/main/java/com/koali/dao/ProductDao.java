package com.koali.dao;

import com.koali.pojo.Product;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Elric on 2017/5/6.
 */
//Spring给Hiber自带了一个注入模板HibernateDaoSupport
@Transactional
public class ProductDao extends HibernateDaoSupport{

    public void save(Product product) {
        this.getHibernateTemplate().save(product);
        //this.getSessionFactory().getCurrentSession().save(product);
    }
}
