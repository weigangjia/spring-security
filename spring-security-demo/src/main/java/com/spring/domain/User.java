package com.spring.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 类名称：User<br>
 * 类描述：<br>
 * 创建时间：2019年03月11日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@Data
public class User implements Serializable {

    private String id;

    private String userName;

    @NotBlank
    private String password;
}
