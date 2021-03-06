package com.gushiyu.springbootwebcrud.config;

import com.gushiyu.springbootwebcrud.component.MyInterceptor;
import com.gushiyu.springbootwebcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    private static Logger logger = LoggerFactory.getLogger(MyMvcConfig.class);
    @Bean
    public WebMvcConfigurer aa(){

        WebMvcConfigurer success = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/login").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
                registry.addViewController("/").setViewName("index");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/user/login","/","/index.html","/webjars/**","/asserts/**");
            }
        };
        return success;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
