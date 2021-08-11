package pers.zhz.controller;

import org.springframework.web.bind.annotation.*;
import pers.zhz.pojo.Department;
import pers.zhz.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import pers.zhz.service.DepartmentServiceImpl;
import pers.zhz.service.EmployeeServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;
    private final DepartmentServiceImpl departmentServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl, DepartmentServiceImpl departmentServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
        this.departmentServiceImpl = departmentServiceImpl;
    }

    //处理查询员工请求
    @RequestMapping("/emp/list.html")
    public String list(Model model) {
        List<Department> deptsList = departmentServiceImpl.getAllDepartments();//以部门id为键.名称为值转化为map
        Map<Integer, String> deptsMap = new HashMap<>();
        for (Department dept : deptsList) {
            deptsMap.put(dept.getId(), dept.getName());
        }

        List<Employee> emps = employeeServiceImpl.getAllEmployees();//依次找出每个员工部门id对应的部门名称返回
        List<String> deptNames = new ArrayList<>();
        for (Employee emp : emps) {
            deptNames.add(deptsMap.get(emp.getDepartment()));
        }

        model.addAttribute("emps", emps);
        model.addAttribute("deptNames", deptNames);
        return "emp/list";//返回到list页面
    }

    //处理新增员工请求
    @GetMapping("/emp/add.html")
    public String add(Model model) {
        //查出所有的部门信息,添加到departments中,用于前端接收
        Collection<Department> departments = departmentServiceImpl.getAllDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";//返回到添加员工页面
    }

    //确认提交新增员工请求
    @PostMapping("/add")
    public String addEmp(Employee employee) {
        employeeServiceImpl.addEmployee(employee);//添加一个员工
        return "redirect:/emp/list.html";//重定向到/emps,刷新列表,返回到list页面
    }

    //处理编辑员工请求
    @RequestMapping("/edit/{id}")//restful风格接收参数
    public String edit(@PathVariable("id") int id, Model model) {
        //查询指定id的员工,添加到employee中,用于前端接收
        Employee employee = employeeServiceImpl.getEmployeeById(id);
        model.addAttribute("employee", employee);
        //查出所有的部门信息,添加到departments中,用于前端接收
        Collection<Department> departments = departmentServiceImpl.getAllDepartments();
        model.addAttribute("departments", departments);
        return "/emp/edit";//返回到编辑员工页面
    }

    // 提交编辑员工数据
    @PostMapping("/edit")
    public String EditEmp(Employee employee) {
        employeeServiceImpl.updateEmpById(employee);//添加一个员工
        return "redirect:/emp/list.html";//添加完成重定向到/emps,刷新列表
    }

    // 删除员工
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeServiceImpl.deleteEmployee(id);
        return "redirect:/emp/list.html";
    }

    //注销
    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }

}


