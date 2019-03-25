package com.spring.security.core.properties;

import lombok.Data;

/**
 * 类名称：ImageCodeProperties<br>
 * 类描述：<br>
 * 创建时间：2019年03月15日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@Data
public class SmsCodeProperties {

    private int length = 6;
    private int expireIn = 60;
    private String url;


}
