package com.spring.web.config;

import com.spring.web.filter.TimeFilter;
import com.spring.web.interceptor.Timeinterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：Webconfig<br>
 * 类描述：<br>
 * 创建时间：2019年03月12日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
/*@Configuration*/
public class Webconfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Timeinterceptor timeinterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(timeinterceptor);
    }

    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter  = new TimeFilter();
        registrationBean.setFilter(timeFilter);
        List<String> url = new ArrayList<>();
        url.add("/*");
        registrationBean.setUrlPatterns(url);
        return registrationBean;
    }

}
