package com.spring.security.core.validate.code.sms;

/**
 * 类名称：DefaultSmsCodeSender<br>
 * 类描述：<br>
 * 创建时间：2019年03月18日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class DefaultSmsCodeSender implements SmsCodeSender{
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile + "发送短信验证码: " + code);
    }
}
