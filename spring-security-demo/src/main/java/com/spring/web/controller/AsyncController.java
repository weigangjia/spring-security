package com.spring.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * 类名称：AsyncController<br>
 * 类描述：<br>
 * 创建时间：2019年03月12日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@Slf4j
@RestController
public class AsyncController {

    @GetMapping("/order")
    public Callable<String> order() throws Exception {
       log.info("主线程开始");
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("副线程开始");
                Thread.sleep(1000);
                log.info("副线程结束");
                return "SUCCESS";
            }
        };
        log.info("主线程结束");
        return result;
    }

}
