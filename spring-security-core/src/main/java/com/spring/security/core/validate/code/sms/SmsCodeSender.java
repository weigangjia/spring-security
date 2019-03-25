package com.spring.security.core.validate.code.sms;

/**
 * 类名称：SmsCodeSender<br>
 * 类描述：<br>
 * 创建时间：2019年03月18日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public interface SmsCodeSender {
    void send(String mobile, String code);
}
