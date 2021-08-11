package pers.zhz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.zhz.pojo.Admin;
import pers.zhz.service.AdminServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final AdminServiceImpl adminServiceImpl;

    public LoginController(AdminServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }

    // 处理登录请求
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession httpSession) {
        //如果用户名和密码正确
        Admin admin = new Admin(username, password);
        if (adminServiceImpl.queryAdmin(admin) != null) {
            httpSession.setAttribute("LoginUser", username);
            return "redirect:/main.html";//跳转到主页面
        } else {
            model.addAttribute("msg", "用户名或者密码错误");//显示错误信息
            return "index";//跳转到首页
        }
    }
}

