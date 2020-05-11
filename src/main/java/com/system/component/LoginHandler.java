package com.system.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginHandler
 * @Description TODO
 * @Author wk
 * @Date 2020/5/9 0009 17:23
 * @Version 1.0
 */
public class LoginHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginName");
        if (user == null) {
            //未登录，返回登录页面
            request.setAttribute("msg","没有登录权限");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }else {
            return true;
        }

    }
}
