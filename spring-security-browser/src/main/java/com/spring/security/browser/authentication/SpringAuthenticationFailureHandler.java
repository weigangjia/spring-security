package com.spring.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.security.browser.support.SimpleResponse;
import com.spring.security.core.enums.LoginTypeEnum;
import com.spring.security.core.properties.LoginResponseType;
import com.spring.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类名称：SpringAuthenticationFailureHandler<br>
 * 类描述：失败的处理器<br>
 * 创建时间：2019年03月14日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@Component("springAuthenticationFailureHandler")
public class SpringAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("登录失败");

        if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(e.getMessage())));
        }else{
            super.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
        }

    }
}
