package com.spring.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 类名称：ValidateCodeProcessor<br>
 * 类描述：校验码处理器，封装不同的校验码处理逻辑<br>
 * 创建时间：2019年03月18日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public interface ValidateCodeProcessor {


    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    void validate(ServletWebRequest servletWebRequest);
}
