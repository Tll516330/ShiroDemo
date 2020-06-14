package com.example.shiortwodemo.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tll
 * @create 2020/6/10 16:56
 * shiro配置文件  需要编写三个类
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /**
         * Shiro内置过滤器  实现权限相关的访问
         *  常用的过滤器
         *      anon: 无需认证，可直接访问进入(通常用于一些登录界面)
         *      authc:必须认证后，才能访问到
         *      user:使用remeberMe功能 可直接访问
         *      perms:改资源必须得到资源权限才可以访问到
         *      role:该资源必须得到角色权限才可以访问到
         *
         */
        //有序
        Map<String,String> filterMap = new LinkedHashMap<String, String>();
        //登录界面不需要认证
        filterMap.put("/login","anon");
        filterMap.put("/user","anon");

        //添加授权过滤器
        filterMap.put("/add","perms[user:add]");
        filterMap.put("/update","perms[user:update]");

        //所有资源都需要认证
        filterMap.put("/*","authc");

        //修改跳转的登录界面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //添加为授权跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultSecurityManager
     * 需要关联Realm
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     * @Bean  将方法交给spring管理  主要用于Configuration注解类里
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    /**
     * 配置ShiroDialect ,用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
