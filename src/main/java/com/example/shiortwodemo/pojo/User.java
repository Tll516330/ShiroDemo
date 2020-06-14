package com.example.shiortwodemo.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author tll
 * @create 2020/6/11 16:44
 */
@Data
@Table(name = "t_user")
public class User {
    /**
     * id为主键
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private int id;
    private String name;
    private String password;
    private String perms;
}
