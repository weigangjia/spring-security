package com.spring.security.core.social.qq;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 类名称：SpringSpringSocialConfigurer<br>
 * 类描述：<br>
 * 创建时间：2019年03月27日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class SpringSpringSocialConfigurer  extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public SpringSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter= (SocialAuthenticationFilter)super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T)filter;
    }
}
