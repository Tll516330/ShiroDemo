package com.example.shiortwodemo.web;

import com.example.shiortwodemo.pojo.User;
import com.example.shiortwodemo.service.UserService;
import com.example.shiortwodemo.utils.LogUtils;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tll
 * @create 2020/6/10 15:46
 */
@Controller
public class TestController {

    @Autowired
    private UserService userService;

    /**
     * 测试
     * @return
     */
    @RequestMapping("/lo")
    @ResponseBody
    public String testString(){
        System.out.println("访问成功");
        return "你好";
    }

    /**
     * 进入首页
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name","海阔天空");
        System.out.println("hahah");
        return "test";
    }

    /**
     * 进入登录页面
     * @param model
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        return "toLogin";
    }

    /**
     * 用户添加功能
     * @param model
     * @return
     */
    @RequestMapping("add")
    public String add(Model model){
        return "user/add";
    }

    /**
     * 更新用户功能
     * @param model
     * @return
     */
    @RequestMapping("update")
    public String update(Model model){
        return "user/update";
    }

    /**
     * 无授权访问页面
     * @param model
     * @return
     */
    @RequestMapping("noAuth")
    public String noAuth(Model model){
        return "/noAuth";
    }


    /**
     * 登录判断
     * @param name
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("login")
    public String login(String name,String password,Model model){

        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        //3.执行登录方法
        try {
            subject.login(token);
            model.addAttribute("name","欢迎进入Shiro");
            //登录成功 跳转到test页面
            //重定向不能携带参数

            return "test";
        }catch (UnknownAccountException e){
            //登录失败，用户名 不存在
            model.addAttribute("name","用户名不存在");

            return "toLogin";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("name","密码错误");

            return "toLogin";
        }

    }

    /**
     * 测试
     * @return
     */
    @RequestMapping("/user")
    @ResponseBody
    public User findByName(){
        User tll = userService.findByName("tll");
        return tll;
    }
}
