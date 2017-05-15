package com.koali.action;

import com.koali.pojo.Department;
import com.koali.pojo.Employee;
import com.koali.pojo.PageBean;
import com.koali.service.DepartmentService;
import com.koali.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.logging.Log;

import java.util.List;

import static com.opensymphony.xwork2.Action.NONE;

/**
 * Created by Elric on 2017/5/11.
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
    private Employee employee = new Employee();
    @Override
    public Employee getModel() {
        return employee;
    }
    private Integer currPage = 1;
    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }
    //注入EmployService
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String login(){
        //调用Service层
        Employee existEmployee = employeeService.login(employee);
        if(existEmployee==null){
            this.addActionError("用户名或者密码错误");

            return INPUT;
        }else
        {
            ActionContext.getContext().getSession().put("existEmployee",existEmployee);
            return SUCCESS;
        }
    }

    public String findAll() {
        PageBean<Employee> pageBean = employeeService.findByPage(currPage);
        // 将pageBean存入到值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }
    public String saveUI() {
        System.out.println("SaveUI被执行了!");
        List<Department> list = departmentService.findAll();
        System.out.println("SaveUI被执行了list也被执行了!");
        System.out.println("添加员工"+list.size());
        ActionContext.getContext().getValueStack().set("list", list);
        return "saveUI";
    }
    public String save() {
        employeeService.save(employee);
        return "saveSuccess";
    }

    public String edit() {
        employee=employeeService.findById(employee.getEid());
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list", list);
        return "editSuccess";
    }

    public String update() {
        employeeService.update(employee);
        return "updateSuccess";
    }

    public String delete() {
        employee=employeeService.findById(employee.getEid());
        employeeService.delete(employee);
        return "deleteSuccess";
    }
}
