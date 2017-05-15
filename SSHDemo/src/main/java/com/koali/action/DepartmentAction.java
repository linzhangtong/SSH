package com.koali.action;

import com.koali.pojo.Department;
import com.koali.pojo.PageBean;
import com.koali.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by Elric on 2017/5/12.
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
   //注入模型驱动
    private Department department = new Department();
    @Override
    public Department getModel() {
        return department;
    }
    //分页需要的当前页数
    private Integer currPage = 1;

    public Integer getCurrPage() {
        return currPage;
    }
    //注入Service
    private DepartmentService departmentService;
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }
    //查询数据

    public String findAll(){
        PageBean<Department> pageBean = departmentService.findByPage(currPage);
        // 将pageBean存入到值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    // 跳转到添加部门的页面
    public String saveUI() {
        return "saveUI";
    }
    //添加部门
    public String save(){
        departmentService.save(department);
        return "saveSuccess";
    }
    //编辑部门信息
    public String edit() {
        // 模型驱动默认在值栈中
        department = departmentService.findById(department.getDid());
        ActionContext.getContext().getValueStack().push(department);
        return "editSuccess";
    }
    // 修改部门
    public String update() {
        departmentService.update(department);
        return "updateSuccess";
    }
    // 删除部门
    public String delete() {
        // // 方法一 无法级联删除
        // departmentService.delete(department.getDid());
        // 方法二 先查询后删除
        department = departmentService.findById(department.getDid());
        departmentService.delete(department);
        return "deleteSuccess";
    }

}
