package finalproject.demo.controller;


import finalproject.demo.entity.UserInfo;
import finalproject.demo.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class LoginController {

    @Autowired
    private UserDao userRepository;


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/first")
    public String first() {
        return "register";
    }

    @RequestMapping("/ensure")
    public String ensure(String username, String password, HttpServletResponse response) throws IOException {
        System.out.println(username + password);
        UserInfo userInfo = userRepository.findByUsername(username);
        if (password.equals(userInfo.getPassword())) {
            return "redirect:/query";
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript'>alert('密码错误或改用户不存在!');</script>");
            return "login";
        }
    }

    @RequestMapping("/register")
    public String register(String username, String password, HttpServletResponse response) throws IOException {
        UserInfo userInfo = new UserInfo(username, password);
        userRepository.save(userInfo);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<script type='text/javascript'>alert('注册成功!');</script>");
        return "login";
    }

    @RequestMapping("/query")
    public String query(Model model) {
        model.addAttribute("dayMoney", 10000);
        return "index";
    }
}
