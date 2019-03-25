package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：DemoApplication<br>
 * 类描述：<br>
 * 创建时间：2019年03月07日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello spring-security!";
    }
}
