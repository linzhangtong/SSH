package com.koali.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 部门实体类
 * Created by Elric on 2017/5/11.
 */
@Entity
@Table(name = "department")
public class Department {
    private Integer did;
    private String dname;
    private String ddesc;
    private Set<Employee> emplyoees = new HashSet<Employee>();

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDdesc() {
        return ddesc;
    }

    public void setDdesc(String ddesc) {
        this.ddesc = ddesc;
    }

    public Set<Employee> getEmplyoees() {
        return emplyoees;
    }

    public void setEmplyoees(Set<Employee> emplyoees) {
        this.emplyoees = emplyoees;
    }

    @Override
    public String toString() {
        return "Department [did=" + did + ", dname=" + dname + ", ddesc="
                + ddesc + ", emplyoees=" + emplyoees + "]";
    }
}
