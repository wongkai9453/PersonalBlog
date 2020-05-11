package com.system.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyConfig
 * @Description TODO
 * @Author wk
 * @Date 2020/5/8 0008 15:53
 * @Version 1.0
 */
@Configuration
public class MyConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource durid(){
        return new DruidDataSource();
    }

    /**
     * 功能描述:
     * @param: druid 监控后台servlet
     * @return: org.springframework.boot.web.servlet.ServletRegistrationBean
     * @auther: wk
     * @date: 2020/5/8 0008 15:58
     */
    @Bean
    public ServletRegistrationBean registrationBean(){
        ServletRegistrationBean registration = new ServletRegistrationBean();
        registration.setServlet(new StatViewServlet());
        registration.setUrlMappings(Arrays.asList("/druid/*"));
        Map<String,String> map = new HashMap<>();
        map.put("loginUsername","admin");//允许登陆后台时用的用户名
        map.put("loginPassword","123456");//允许登陆后台时用的密码
        map.put("allow","");//允许登陆不写则允许所有登陆
        map.put("deny","192.168.1.7");//不允许登陆
        registration.setInitParameters(map);
        return registration;
    }

        /**
     * 配置Web监控的Filter
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> map = new HashMap<>();
        //不拦截那些请求
        map.put("exclusions","*.js,*.css,*.ico,*.svg,/druid/*");
        bean.setInitParameters(map);
        //拦截规则
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
