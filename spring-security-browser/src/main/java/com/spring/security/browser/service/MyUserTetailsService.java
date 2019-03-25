package com.spring.security.browser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 类名称：MyUserTetailsService<br>
 * 类描述：<br>
 * 创建时间：2019年03月13日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@Component
public class MyUserTetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登录用户名：" + username);
        String password = passwordEncoder.encode("123456");
        logger.info("数据库密码是：" + password);
        return new User(username, password,true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
