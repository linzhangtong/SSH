package com.koali.dao;

import com.koali.pojo.Department;

import java.util.List;

/**
 * Created by Elric on 2017/5/12.
 */
public interface DepartmentDao {
    int findCount();

    List<Department> findByPage(int begin, int pageSize);
    void save(Department department);

    Department findById(Integer did);

    void update(Department department);

    void delete(Department department);

    List<Department> findAll();
}
