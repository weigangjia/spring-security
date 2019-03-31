package com.spring.security.core.social.qq.connet;

import com.spring.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * 类名称：QQConnectionFactory<br>
 * 类描述：<br>
 * 创建时间：2019年03月27日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class QQConnectionFactory  extends OAuth2ConnectionFactory<QQ>{

    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }
}
