package com.cy.store.config;

import com.cy.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        LoginInterceptor interceptor = new LoginInterceptor();


        ArrayList<String> list = new ArrayList<>();
        list.add("/bootstrap3/**");
        list.add("/css/**");
        list.add("/images/**");
        list.add("/js/**");
        list.add("/web/login.html");
        list.add("/web/index.html");
        list.add("/web/register.html");
        list.add("/users/reg");
        list.add("/users/login");
        list.add("/web/product.html");
        list.add("/districts/**");
        list.add("/products/**");

        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(list);
    }
}
