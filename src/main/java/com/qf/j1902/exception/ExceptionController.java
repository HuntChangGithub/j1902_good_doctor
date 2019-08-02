package com.qf.j1902.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by asus on 2019/8/1.
 */

//标识为控制层拦截器
@ControllerAdvice
public  class ExceptionController {
        @ExceptionHandler(value=AuthorizationException.class)//标识需要拦截的异常
        public  String  defaultErrorHandler(HttpServletRequest request, Exception e){
            System.out.println(e.toString());
            return "unauth";
        }
}
