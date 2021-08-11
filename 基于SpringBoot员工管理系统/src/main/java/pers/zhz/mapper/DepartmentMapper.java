package pers.zhz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.zhz.pojo.Department;

import java.util.List;

@Mapper
@Repository // dao层的注解
public interface DepartmentMapper {

    //获得所有部门信息
    List<Department> getAllDepartments();

    //通过ID的到部门名称
    String getNameById(@Param("id") int id);

}
