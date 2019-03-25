package com.spring.web.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * 类名称：TimeFilter<br>
 * 类描述：<br>
 * 创建时间：2019年03月12日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start!");
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long finishTime = System.currentTimeMillis();
        System.out.println("time filter 耗时:" + (finishTime - startTime));
        System.out.println("time filter finish!");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy !");
    }
}
