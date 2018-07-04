package com.king.kinghand.config;

import com.king.kinghand.interceptor.WebInterceptor;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @program: king-hand
 * @description: 自定义注解拦截器
 * @author: mianhuatang
 * @create: 2018-04-01 14:24
 **/
//@Configuration
//public class WebInterceptorConfigurer extends WebMvcConfigurationSupport{
//
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        //添加拦截器
//        registry.addInterceptor(new WebInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/swagger/*");
//        super.addInterceptors(registry);
//    }
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/static/");
//        super.addResourceHandlers(registry);
//    }
//}
