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
public class ImageCodeProperties extends SmsCodeProperties{

    private int width = 67;
    private int height = 23;

    public ImageCodeProperties(){
        setLength(4);
    }


}
