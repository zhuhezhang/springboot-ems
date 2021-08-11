package pers.zhz.service;

import org.apache.ibatis.annotations.Param;
import pers.zhz.pojo.Department;

import java.util.List;

public interface DepartmentService {
    //获得所有部门信息
    List<Department> getAllDepartments();

    //通过ID的到部门名称
    String getNameById(@Param("id") int id);

}
