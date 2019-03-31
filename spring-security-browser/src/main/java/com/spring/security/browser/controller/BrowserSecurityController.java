package com.spring.security.browser.controller;

import com.spring.security.browser.support.SimpleResponse;
import com.spring.security.browser.support.SocialUserInfo;
import com.spring.security.core.properties.SecurityConstants;
import com.spring.security.core.properties.SecurityProperties;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类名称：BrowserSecurityController<br>
 * 类描述：<br>
 * 创建时间：2019年03月13日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@RestController
public class BrowserSecurityController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;




    /**
     * 当需要身份认证时跳转到这里
     * @author 贾伟岗
     * @date 2019/3/13
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception{

        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if (savedRequest != null){
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是：" + targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl ,"html")){
                String loginPage = securityProperties.getBrowser().getLoginPage();
                redirectStrategy.sendRedirect(request, response, loginPage);
            }
        }
        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
    }

    @GetMapping("/session/invalid")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse sessionInvalid(){
        String message = "session失效";
        return new SimpleResponse(message);
    }

}
