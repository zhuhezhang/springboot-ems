package pers.zhz.service;

import org.apache.ibatis.annotations.Param;
import pers.zhz.pojo.Employee;
import java.util.List;

public interface EmployeeService {

    //查询全部的员工信息
    List<Employee> getAllEmployees();

    //通过ID查询员工
    Employee getEmployeeById(@Param("id") int id);

    //通过ID删除员工
    int deleteEmployee(@Param("id") int id);

    //增加一个员工
    int addEmployee(Employee employee);

    //修改员工
    int updateEmpById(Employee employee);
}
