package pers.zhz.service;

import org.springframework.stereotype.Service;
import pers.zhz.mapper.AdminMapper;
import pers.zhz.pojo.Admin;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin queryAdmin(Admin admin) {
        return adminMapper.queryAdmin(admin);
    }
}
