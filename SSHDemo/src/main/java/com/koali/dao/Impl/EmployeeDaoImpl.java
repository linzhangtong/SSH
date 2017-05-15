package com.koali.dao.Impl;

import com.koali.dao.EmployeeDao;
import com.koali.pojo.Employee;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Elric on 2017/5/11.
 */
@Transactional
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
    @Override
    public Employee findByUserNameAndPassword(Employee employee) {
        String hql = "from Employee where username = ? and password= ?";
        List<?> list =  this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
        if(list.size()>0){
            return (Employee) list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public int findCount() {
        String hql = "select count(*) from Employee";
        List<?> list = this.getHibernateTemplate().find(hql);
        if (list.size() > 0) {
            return Integer.parseInt(list.get(0).toString());
        }else {
            return 0;
        }
    }
    @Override
    public List<Employee> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
        List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(
                criteria, begin, pageSize);
        return list;
    }

    @Override
    public void save(Employee employee) {
        this.getHibernateTemplate().save(employee);
    }

    @Override
    public Employee findById(Integer eid) {
        return this.getHibernateTemplate().get(Employee.class, eid);
    }

    @Override
    public void update(Employee employee) {
        this.getHibernateTemplate().update(employee);
    }

    @Override
    public void delete(Employee employee) {
        this.getHibernateTemplate().delete(employee);
    }
}
