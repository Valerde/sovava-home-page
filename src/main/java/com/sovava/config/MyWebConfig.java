package com.sovava.config;

import com.sovava.interceptor.LoginUserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        LoginUserInterceptor loginUserInterceptor = new LoginUserInterceptor();
        registry.addInterceptor(loginUserInterceptor).addPathPatterns("/**");
    }
}
