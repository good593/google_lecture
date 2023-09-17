package com.example.basic.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    // TODO Auto-generated method stub
    MustacheViewResolver resolver = new MustacheViewResolver();
    resolver.setCharset("UTF-8");
    resolver.setContentType("text/html;application/x-www-form-urlencoded;charset=UTF-8");
    resolver.setPrefix("classpath:/templates/");
    resolver.setSuffix(".html");

    registry.viewResolver(resolver);
  }
  
  
}
