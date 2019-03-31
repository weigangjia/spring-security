package com.spring.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * 类名称：QQProperties<br>
 * 类描述：<br>
 * 创建时间：2019年03月27日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class QQProperties extends SocialProperties {
    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
