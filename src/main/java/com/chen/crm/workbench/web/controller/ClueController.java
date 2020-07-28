package com.chen.crm.workbench.web.controller;

import com.chen.crm.settings.domain.User;
import com.chen.crm.settings.service.UserService;
import com.chen.crm.settings.service.impl.UserServiceImpl;
import com.chen.crm.utils.DateTimeUtil;
import com.chen.crm.utils.PrintJson;
import com.chen.crm.utils.ServiceFactory;
import com.chen.crm.utils.UUIDUtil;
import com.chen.crm.vo.PaginationVO;
import com.chen.crm.workbench.domain.Activity;
import com.chen.crm.workbench.domain.ActivityRemark;
import com.chen.crm.workbench.service.ActivityService;
import com.chen.crm.workbench.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 86176
 * @Date: 2020/7/25 21:52
 * @Description:
 */
public class ClueController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入线索控制器");

        String path = req.getServletPath();
        /*if("/workbench/clue/xxx.do".equals(path)){
            xxx(req,resp);
        }else if("/workbench/clue/xxx.do".equals(path)) {
            xxx(req,resp);
        }*/
    }


}
