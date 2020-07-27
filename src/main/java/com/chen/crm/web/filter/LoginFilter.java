package com.chen.crm.web.filter;

import com.chen.crm.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: 86176
 * @Date: 2020/7/26 17:33
 * @Description:
 */
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入登录过滤器");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String path = request.getServletPath();

        //不应该拦截的资源，自动放行请求
        if ("/login.jsp".equals(path)||"/settings/user/login.do".equals(path)){
            chain.doFilter(req, resp);

        //其他资源必须验证是否登录过
        }else {

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            //如果user不为空，说明登录过，将请求放行
            if (user != null){
                chain.doFilter(req, resp);

            }else {
                //重定向到登录页
            /*
                重定向路径
                在实际开发，一律使用绝对路径
                    转发：
                        使用的是一种特殊的绝对路径的使用方式，这种绝对路径前面不加 /项目名，这种路径也称为内部路径
                        /login.jsp
                    重定向：
                        使用传统绝对路径，前面必须使用 /项目名，后面跟资源路径
                        /crm/login.jsp
            */
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }

    }

    @Override
    public void destroy() {

    }
}
