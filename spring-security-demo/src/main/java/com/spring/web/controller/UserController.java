package com.spring.web.controller;

import com.spring.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 类名称：UserController<br>
 * 类描述：<br>
 * 创建时间：2019年03月11日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user){
        return user;
    }


    @PostMapping("/create")
    public User create(@Valid @RequestBody User user, BindingResult erros){

        if (erros.hasErrors()){
            erros.getAllErrors().stream().forEach(error ->{
                    FieldError fieldError = (FieldError)error;
                    System.out.println(fieldError.getField() + error.getDefaultMessage());
                }
            );
        }

        String userName = user.getUserName();
        String password = user.getPassword();
        User u  = new User();
        u.setUserName(userName);
        u.setPassword(password);
        return u;
    }


    @GetMapping("/{id:\\d+}")
    public User getInfo(@PathVariable String id){
        /*System.out.println("调用getInfo服务");*/
        User u = new User();
        u.setUserName("tom");
        return u;
    }
}
