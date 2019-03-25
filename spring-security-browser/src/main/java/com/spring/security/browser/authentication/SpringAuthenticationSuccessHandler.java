package com.spring.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.security.browser.support.SimpleResponse;
import com.spring.security.core.enums.LoginTypeEnum;
import com.spring.security.core.properties.BrowserProperties;
import com.spring.security.core.properties.LoginResponseType;
import com.spring.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类名称：SpringAuthenticationSuccessHandler<br>
 * 类描述：成功的处理器<br>
 * 创建时间：2019年03月14日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@Component("springAuthenticationSuccessHandler")
public class SpringAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功");

        if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
        }


    }
}
