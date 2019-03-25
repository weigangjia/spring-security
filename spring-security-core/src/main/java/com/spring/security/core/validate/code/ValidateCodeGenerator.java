package com.spring.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 类名称：ValidateCodeGenerator<br>
 * 类描述：<br>
 * 创建时间：2019年03月15日<br>
 *
 * @author jwg
 * @version 1.0.0
 */

public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}
