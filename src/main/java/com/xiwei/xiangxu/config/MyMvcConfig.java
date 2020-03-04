package com.xiwei.xiangxu.config;

import com.xiwei.xiangxu.component.LoginHandlerInterceptor;
import com.xiwei.xiangxu.component.MyLocaleResolver;
import com.xiwei.xiangxu.utils.StaticResourceUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.context.WebContext;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/18 14:18
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }*/
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter=new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("frontView");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                        .addPathPatterns("/**")
                .excludePathPatterns("/","/index.html","/login","/resources/css/**","/resources/img/**");
            }

        };
        return adapter;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
                 registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
                 registry.addResourceHandler("/static/resources/**").addResourceLocations("classpath:/static/resources/");
                registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
                registry.addResourceHandler("/static/img/**").addResourceLocations("file:" + StaticResourceUtils.getImgDirFile().getAbsolutePath() + "/");  //添加这一行
    }
}
