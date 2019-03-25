package com.spring.security.core.validate.code.sms;

import com.spring.security.core.validate.code.ValidateCode;
import com.spring.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 类名称：SmsCodeProcessor<br>
 * 类描述：短信验证码处理器<br>
 * 创建时间：2019年03月18日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {
    /**
     * 短信验证码发送器
     */
    @Autowired
    private SmsCodeSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), "mobile");
        smsCodeSender.send(mobile, validateCode.getCode());
    }
}
