package pers.zhz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.zhz.pojo.Admin;
import pers.zhz.pojo.Employee;

@Mapper
@Repository
public interface AdminMapper {

    //通过ID查询员工
    Admin queryAdmin(Admin admin);

}
