package com.koali.dao;

import com.koali.pojo.Employee;

import java.util.List;

/**
 * Created by Elric on 2017/5/11.
 */
public interface EmployeeDao {
    Employee findByUserNameAndPassword(Employee employee);

    int findCount();

    List<Employee> findByPage(int begin, int pageSize);

    void save(Employee employee);

    Employee findById(Integer eid);

    void update(Employee employee);

    void delete(Employee employee);
}
