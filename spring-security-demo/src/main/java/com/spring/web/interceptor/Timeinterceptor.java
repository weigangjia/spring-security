package com.spring.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类名称：Timeinterceptor<br>
 * 类描述：<br>
 * 创建时间：2019年03月12日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
/*@Component*/
public class Timeinterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        System.out.println(((HandlerMethod)o).getBean().getClass().getName());
        System.out.println(((HandlerMethod)o).getMethod().getName());
        httpServletRequest.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        Long startTime  = (Long)httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时:" + (System.currentTimeMillis() - startTime));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterHandle");
        Long startTime  = (Long)httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时:" + (System.currentTimeMillis() - startTime));
        System.out.println("e is : " + e);
    }
}
