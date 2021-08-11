package pers.zhz.service;

import pers.zhz.mapper.DepartmentMapper;
import pers.zhz.pojo.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments();
    }

    @Override
    public String getNameById(int id) {
        return departmentMapper.getNameById(id);
    }

}
