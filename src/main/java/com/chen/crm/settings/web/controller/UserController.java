package com.chen.crm.settings.web.controller;

import com.chen.crm.settings.domain.User;
import com.chen.crm.settings.service.UserService;
import com.chen.crm.settings.service.impl.UserServiceImpl;
import com.chen.crm.utils.MD5Util;
import com.chen.crm.utils.PrintJson;
import com.chen.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 86176
 * @Date: 2020/7/25 21:52
 * @Description:
 */
public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入用户控制器");

        String path = req.getServletPath();
        if("/settings/user/login.do".equals(path)){
            login(req,resp);
        }else if("/settings/user/xxx.do".equals(path)) {
            /*xxx(req, resp);*/
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入到验证登录操作");

        String loginAct = req.getParameter("loginAct");
        String loginPwd = req.getParameter("loginPwd");
        //将密码的明文形式转换为MD5的密文形式
        loginPwd = MD5Util.getMD5(loginPwd);
        //接收ip地址
        String ip = req.getRemoteAddr();
        System.out.println("ip地址:"+ ip);

        //未来业务层开发，统一使用代理类形态的接口对象
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        System.out.println("================================");

        try{
            User user = us.login(loginAct,loginPwd,ip);
            req.getSession().setAttribute("user", user);

            //如果程序执行到此，说明业务层没有为controller抛出任何异常
            //表示登录成功
            /*
            * {"success":true}
            * */
            PrintJson.printJsonFlag(resp, true);
        }catch (Exception e){
            e.printStackTrace();
            //一旦程序执行了catch语句块的信息，说明业务层为我们验证登录失败，为controller抛出异常
            //表示登录失败
            /*
                {"success":false,"msg":?}
            * */
            String msg = e.getMessage();

            Map<String,Object> map = new HashMap<>();
            map.put("success", false);
            map.put("msg", msg);
            PrintJson.printJsonObj(resp, map);
        }
    }
}
