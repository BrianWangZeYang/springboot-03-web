package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author xxx
 * @version 1.0
 * @Description
 * @date 2022/8/10 0:03
 */
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, Model model, HttpSession session ){
        //具体的业务（用户名不为空的情况下即可，密码为123）
        if(!StringUtils.isEmpty(username) &&"123".equals(password)){
            //登录成功，重定向到"dashboard"
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //登录失败，告诉用户你登录失败了,返回首页
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }
    @RequestMapping("/user/logout")
    public String loginout(HttpSession session){
        System.out.println("进入了注销方法");
        //需要注销掉之前登录的session凭证
        session.invalidate();
        return "redirect:/index.html";
    }
}
