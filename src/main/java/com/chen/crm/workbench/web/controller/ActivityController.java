package com.chen.crm.workbench.web.controller;

import com.chen.crm.settings.domain.User;
import com.chen.crm.settings.service.UserService;
import com.chen.crm.settings.service.impl.UserServiceImpl;
import com.chen.crm.utils.*;
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
public class ActivityController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入市场活动控制器");

        String path = req.getServletPath();
        if("/workbench/activity/getUserList.do".equals(path)){
            getUserLIst(req,resp);
        }else if("/workbench/activity/save.do".equals(path)) {
            save(req,resp);
        }else if("/workbench/activity/pageList.do".equals(path)) {
            pageList(req,resp);
        }else if("/workbench/activity/delete.do".equals(path)) {
            delete(req, resp);
        }else if("/workbench/activity/getUerListAndActivity.do".equals(path)) {
            getUerListAndActivity(req, resp);
        }else if("/workbench/activity/update.do".equals(path)) {
            update(req, resp);
        }else if("/workbench/activity/detail.do".equals(path)) {
            detail(req, resp);
        }else if("/workbench/activity/getRemarkListByAid.do".equals(path)) {
            getRemarkListByAid(req,resp);
        }else if("/workbench/activity/deleteRemark.do".equals(path)) {
            deleteRemark(req,resp);
        }else if("/workbench/activity/saveRemark.do".equals(path)) {
            saveRemark(req,resp);
        }else if("/workbench/activity/updateRemark.do".equals(path)) {
            updateRemark(req,resp);
        }
    }

    private void updateRemark(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("执行修改备注操作");

        String id = req.getParameter("id");
        String noteContent = req.getParameter("noteContent");
        //修改时间：当前系统时间
        String editTime = DateTimeUtil.getSysTime();
        //修改人：当前登录用户
        String editBy = ((User) req.getSession().getAttribute("user")).getName();
        String editFlag = "1";

        ActivityRemark ar = new ActivityRemark();
        ar.setId(id);
        ar.setNoteContent(noteContent);
        ar.setEditTime(editTime);
        ar.setEditBy(editBy);
        ar.setEditFlag(editFlag);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        boolean success = as.updateRemark(ar);

        Map<String,Object> map = new HashMap<>();
        map.put("success", success);
        map.put("ar", ar);

        PrintJson.printJsonObj(resp, map);

    }

    private void saveRemark(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入保存备注操作");

        String noteContent = req.getParameter("noteContent");
        String activityId = req.getParameter("activityId");
        String id = UUIDUtil.getUUID();
        //创建时间：当前系统时间
        String createTime = DateTimeUtil.getSysTime();
        //创建人：当前登录用户
        String createBy = ((User) req.getSession().getAttribute("user")).getName();
        String editFlag = "0";

        ActivityRemark ar = new ActivityRemark();
        ar.setId(id);
        ar.setActivityId(activityId);
        ar.setCreateBy(createBy);
        ar.setCreateTime(createTime);
        ar.setNoteContent(noteContent);
        ar.setEditFlag(editFlag);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        boolean flag = as.saveRemark(ar);

        Map<String,Object> map = new HashMap<>();
        map.put("success", flag);
        map.put("ar", ar);

        PrintJson.printJsonObj(resp, map);

    }

    private void deleteRemark(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入备注删除操作");

        String id = req.getParameter("id");

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        boolean flag = as.deleteRemark(id);

        PrintJson.printJsonFlag(resp, flag);
    }

    private void getRemarkListByAid(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("根据市场活动的id，取得备注信息列表");

        String activityId = req.getParameter("activityId");

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        List<ActivityRemark> arList = as.getRemarkListByAid(activityId);

        PrintJson.printJsonObj(resp, arList);
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入到跳转详细信息页的操作");

        String id = req.getParameter("id");

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        Activity a = as.detail(id);

        req.setAttribute("a", a);

        req.getRequestDispatcher("/workbench/activity/detail.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {

        System.out.println("执行市场活动修改操作");

        String id = req.getParameter("id");
        System.out.println(id);
        String owner = req.getParameter("owner");
        System.out.println(owner);
        String name = req.getParameter("name");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String cost = req.getParameter("cost");
        String description = req.getParameter("description");
        //修改时间：当前系统时间
        String editTime = DateTimeUtil.getSysTime();
        System.out.println(editTime);
        //修改人：当前登录用户
        String editBy = ((User)req.getSession().getAttribute("user")).getName();

        Activity a = new Activity();
        a.setId(id);
        a.setCost(cost);
        a.setStartDate(startDate);
        a.setOwner(owner);
        a.setName(name);
        a.setEndDate(endDate);
        a.setDescription(description);
        a.setEditBy(editBy);
        a.setEditTime(editTime);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        System.out.println("============");

        boolean flag = as.update(a);


        PrintJson.printJsonFlag(resp, flag);

    }

    private void getUerListAndActivity(HttpServletRequest req, HttpServletResponse resp) {

        System.out.println("进入到查询用户信息列表和根据市场活动查询单条记录的操作");

        String id = req.getParameter("id");

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        /**
         * 前端需要：
         *      {"uList":{用户1},{2},{3},"a":{市场活动}}
         */
        Map<String,Object> map = as.getUerListAndActivity(id);

        PrintJson.printJsonObj(resp, map);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {

        System.out.println("执行市场活动删除操作");

        String ids[] = req.getParameterValues("id");

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        boolean flag = as.delete(ids);

        PrintJson.printJsonFlag(resp, flag);
    }

    private void pageList(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入查询市场活动信息列表的操作（结合条件查询+分页查询）");

        String name = req.getParameter("name");
        String owner = req.getParameter("owner");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        System.out.println(endDate.toString());
        String pageNoStr = req.getParameter("pageNo");
        int pageNo = Integer.parseInt(pageNoStr);
        //每页展现的记录数
        String pageSizeStr = req.getParameter("pageSize");
        int pageSize = Integer.parseInt(pageSizeStr);

        //limit a,b  a表示略过的记录数，b表示展示的记录数
        //计算出略过的记录数
        int skipCount = (pageNo-1)*pageSize;

        Map<String,Object> map = new HashMap<>();
        map.put("name", name);
        map.put("owner", owner);
        map.put("startDate",startDate );
        map.put("endDate", endDate);
        map.put("skipCount", skipCount);
        map.put("pageSize", pageSize);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        /**
         * 前端需要：市场活动信息列表
         *          查询的总条数
         *
         *          业务层拿到以上两条信息之后，返回
         *          map
         *          map.put("dataList":dataList)
         *          map.put("total":total)
         *          PrintJSON map-->json
         *          {"total":100,"dataList":[{市场活动1},{市场活动2}...]}
         *
         *          vo
         *          PaginationVo<T>
         *              private int total;
         *              private List<T> dataList;
         *
         *          PaginationVO<Activity> vo = new PaginationVO<>();
         *          vo.setTotal(total);
         *          vo.setDataList(dataList);
         *          PrintJSON vo --> json
         *          {"total":100,"dataList":[{市场活动1},{市场活动2}...]}
         *
         *          将来分页查询，每个模块都有，选择使用一个通用vo，操作方便
         */
        PaginationVO<Activity> vo = as.pageList(map);

        //将vo转换为json对象
        PrintJson.printJsonObj(resp, vo);

    }


    private void save(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("执行市场活动添加操作");

        String id = UUIDUtil.getUUID();
        String owner = req.getParameter("owner");
        String name = req.getParameter("name");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String cost = req.getParameter("cost");
        String description = req.getParameter("description");
        //创建时间：当前系统时间
        String createTime = DateTimeUtil.getSysTime();
        //创建人：当前登录用户
        String createBy = ((User) req.getSession().getAttribute("user")).getName();

        Activity activity = new Activity();
        activity.setId(id);
        activity.setOwner(owner);
        activity.setName(name);
        activity.setStartDate(startDate);
        activity.setEndDate(endDate);
        activity.setCost(cost);
        activity.setDescription(description);
        activity.setCreateTime(createTime);
        activity.setCreateBy(createBy);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        boolean flag = as.save(activity);

        PrintJson.printJsonFlag(resp, flag);

    }

    private void getUserLIst(HttpServletRequest req, HttpServletResponse resp) {

        System.out.println("取得用户信息列表");

        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        List<User> uList = us.getUserList();

        PrintJson.printJsonObj(resp, uList);
    }


}
