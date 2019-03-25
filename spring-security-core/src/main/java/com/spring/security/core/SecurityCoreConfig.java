package com.spring.security.core;

import com.spring.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 类名称：SecurityCoreConfig<br>
 * 类描述：<br>
 * 创建时间：2019年03月13日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
