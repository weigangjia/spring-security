package com.spring.security.core.properties;

/**
 * 类名称：SocialProperties<br>
 * 类描述：<br>
 * 创建时间：2019年03月27日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class SocialProperties {

    private QQProperties qq = new QQProperties();
    private String filterProcessesUrl = "/auth";

    private WeixinProperties weixin = new WeixinProperties();

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }

    public String getFilterProcessesUrl() {
        return filterProcessesUrl;
    }

    public void setFilterProcessesUrl(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    public WeixinProperties getWeixin() {
        return weixin;
    }

    public void setWeixin(WeixinProperties weixin) {
        this.weixin = weixin;
    }
}
