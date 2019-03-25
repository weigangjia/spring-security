package com.spring.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 类名称：SecurityProperties<br>
 * 类描述：这个类会读取以 prefix开头的配置<br>
 * 创建时间：2019年03月13日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "mydemo.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
