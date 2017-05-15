package com.koali.service;

import com.koali.pojo.Department;
import com.koali.pojo.PageBean;

import java.util.List;

/**
 * Created by Elric on 2017/5/12.
 */
public interface DepartmentService {
    PageBean<Department> findByPage(Integer currPage);
    void save(Department department);

    Department findById(Integer did);

    void update(Department department);

    void delete(Department department);

    List<Department> findAll();
}
