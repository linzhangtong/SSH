package com.koali.service;

import com.koali.pojo.Employee;
import com.koali.pojo.PageBean;

/**
 * Created by Elric on 2017/5/11.
 */
public interface EmployeeService {
    Employee login(Employee employee);

    PageBean<Employee> findByPage(Integer currPage);

    void save(Employee employee);

    Employee findById(Integer eid);

    void update(Employee employee);

    void delete(Employee employee);
}
