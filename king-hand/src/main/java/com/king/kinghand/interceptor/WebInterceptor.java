package com.king.kinghand.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: king-hand
 * @description: 自定义全局拦截器
 * @author: mianhuatang
 * @create: 2018-04-01 14:05
 **/
public class WebInterceptor implements HandlerInterceptor{

    private static final String[] IGORE_URL = {"/login","/logout"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        //请求之前调用
        String servletPath = request.getServletPath();
        String user = (String)request.getSession().getAttribute("user");
        //返回true向下执行，否则取消当前请求
//        if(user == null){
//            //response.sendRedirect("/login");
//            flag = false;
//        }else{
//
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //请求之后调用
        System.out.println("《请求之后调用》");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("《在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）》");
    }
}
