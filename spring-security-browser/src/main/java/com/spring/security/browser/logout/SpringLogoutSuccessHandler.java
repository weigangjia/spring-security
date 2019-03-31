package com.spring.security.browser.logout;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.security.browser.support.SimpleResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类名称：SpringLogoutSuccessHandler<br>
 * 类描述：<br>
 * 创建时间：2019年03月31日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class SpringLogoutSuccessHandler implements LogoutSuccessHandler {

    private Logger loger = LoggerFactory.getLogger(getClass());

    private String signOutUrl;

    private ObjectMapper objectMapper = new ObjectMapper();

    public SpringLogoutSuccessHandler(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse,
                                 Authentication authentication) throws IOException, ServletException {

        loger.info("退出成功");

        if (StringUtils.isBlank(signOutUrl)){
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
        }else{
            httpServletResponse.sendRedirect(signOutUrl);
        }
    }
}
