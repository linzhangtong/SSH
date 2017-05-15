package com.koali.dao;

import com.koali.pojo.Department;
import org.junit.Test;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Elric on 2017/5/14.
 */
public class DepartmentDaoTest extends HibernateDaoSupport{
    @Test
    public void findCount() throws Exception {
    }

    @Test
    public void findByPage() throws Exception {
    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void findById() throws Exception {
        Department department = this.getHibernateTemplate().get(Department.class, 1);
        System.out.println(department.getDname());
    }

}