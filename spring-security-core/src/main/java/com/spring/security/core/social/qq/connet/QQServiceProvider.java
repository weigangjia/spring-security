package com.spring.security.core.social.qq.connet;

import com.spring.security.core.social.qq.api.QQ;
import com.spring.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * 类名称：QQServiceProvider<br>
 * 类描述：<br>
 * 创建时间：2019年03月26日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    public static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    public static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    public QQServiceProvider(String appId, String appSecret){
        super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;
    }


    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }

}
