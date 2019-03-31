package com.spring.security.core.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * 类名称：QQImpl<br>
 * 类描述：<br>
 * 创建时间：2019年03月26日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ{

    public static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    public static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private String appId;

    private String openId;

    private ObjectMapper objectMapper = new ObjectMapper();

    public QQImpl(String accessToken, String appId){
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;
        String url = String.format(URL_GET_OPENID, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);

        this.openId = StringUtils.substringBetween(result, "\"openId\":\"", "\"}");
    }

    @Override
    public QQUserInfo getUserInfo(){
        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);
        QQUserInfo userInfo = null;
        try {
            userInfo = objectMapper.readValue(result, QQUserInfo.class);
            userInfo.setOpenId(openId);
            return userInfo;
        } catch (Exception e) {
           throw new RuntimeException("获取用户信息失败", e);
        }
    }
}
