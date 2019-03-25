package com.spring.security.core.validate.code;


import org.springframework.security.core.AuthenticationException;

/**
 * 类名称：ValidateCodeException<br>
 * 类描述：<br>
 * 创建时间：2019年03月15日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class ValidateCodeException extends AuthenticationException {


    public ValidateCodeException(String msg){
        super(msg);
    }
}
