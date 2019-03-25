package com.spring.security.core.validate.code.sms;

import com.spring.security.core.properties.SecurityProperties;
import com.spring.security.core.validate.code.ValidateCode;
import com.spring.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 类名称：ImageCodeGenerator<br>
 * 类描述：<br>
 * 创建时间：2019年03月15日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }


    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }
}
