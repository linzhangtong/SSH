package com.koali.service.Impl;

import com.koali.dao.EmployeeDao;
import com.koali.pojo.Employee;
import com.koali.pojo.PageBean;
import com.koali.service.EmployeeService;

import java.util.List;

/**
 * Created by Elric on 2017/5/11.
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee login(Employee employee) {
        Employee existEmployee =employeeDao.findByUserNameAndPassword(employee);
        return existEmployee;
    }

    @Override
    public PageBean<Employee> findByPage(Integer currPage) {
        PageBean<Employee> pageBean = new PageBean<Employee>();
        // 设置当前页数
        pageBean.setCurrPage(currPage);
        // 设置每页显示记录数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        // 设置总记录数
        int totalCount = employeeDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 设置每页显示的数据
        int begin = (currPage - 1) * pageSize;
        List<Employee> list = employeeDao.findByPage(begin, pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public Employee findById(Integer eid) {
        return employeeDao.findById(eid);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }
}
