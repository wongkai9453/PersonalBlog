package com.system.config;

import com.system.component.LoginHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyConfigYs
 * @Description TODO
 * @Author wk
 * @Date 2020/5/8 0008 16:21
 * @Version 1.0
 */
@Configuration
public class MyConfigYs implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("index");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginHandler handler = new LoginHandler();
        InterceptorRegistration registration =   registry.addInterceptor(handler);
        registration.addPathPatterns("/**");//拦截登录所有请求
        registration.excludePathPatterns("/login","/","/user/login","/assets/**"); //排除登录请求
    }

}
