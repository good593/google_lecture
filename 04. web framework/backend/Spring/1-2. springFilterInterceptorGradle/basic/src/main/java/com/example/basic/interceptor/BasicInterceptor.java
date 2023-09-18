package com.example.basic.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class BasicInterceptor implements HandlerInterceptor {

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable Exception ex) throws Exception {
    // TODO Auto-generated method stub
    System.out.println("[BasicInterceptor][afterCompletion] Start!!");
    System.out.println("request: "+request.getRequestURL());
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable ModelAndView modelAndView) throws Exception {
    // TODO Auto-generated method stub
    System.out.println("[BasicInterceptor][postHandle] Start!!");
    System.out.println("response: "+response.getStatus());
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // TODO Auto-generated method stub
    System.out.println("[BasicInterceptor][preHandle] Start!!");
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }
  
}
