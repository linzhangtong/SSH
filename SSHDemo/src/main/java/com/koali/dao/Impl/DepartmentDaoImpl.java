package com.koali.dao.Impl;

import com.koali.dao.DepartmentDao;
import com.koali.pojo.Department;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Elric on 2017/5/12.
 */
@Transactional
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
    @Override
    public List<Department> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
        List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(
                criteria, begin, pageSize);
        return list;
    }

    @Override
    public int findCount() {
        String hql = "select count(*) from Department";
        List<?> list = this.getHibernateTemplate().find(hql);
        if (list.size() > 0) {
            return Integer.parseInt(list.get(0).toString());
        } else {
            return 0;
        }
    }

    @Override
    public void save(Department department) {
        this.getHibernateTemplate().save(department);
    }

    @Override
    public Department findById(Integer did) {
        Department department = this.getHibernateTemplate().get(Department.class, did);
        return department;
    }

    @Override
    public void update(Department department) {
        HibernateTemplate template = this.getHibernateTemplate();
        System.out.println("DepartmentDaoImp:Update"+template);
        this.getHibernateTemplate().update(department);
    }

    @Override
    public void delete(Department department) {
        this.getHibernateTemplate().delete(department);
    }

    @Override
    public List<Department> findAll() {
       //String hql = "select * from Department";
        System.out.println("Dao层findAll被执行了！");
        String hql = "from Department";
        List<?> list = this.getHibernateTemplate().find(hql);
        System.out.println("Dao层findAll中的getHibernateTemple被执行了！");
        if (list.size()>0){
            System.out.print(list.get(0).toString());
        }
        return (List<Department>) this.getHibernateTemplate().find(hql);
    }
}
