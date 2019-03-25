package com.spring.security.core.properties;

import lombok.Data;

/**
 * 类名称：ValidateCodeProperties<br>
 * 类描述：<br>
 * 创建时间：2019年03月15日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();
    private SmsCodeProperties sms = new SmsCodeProperties();
}
