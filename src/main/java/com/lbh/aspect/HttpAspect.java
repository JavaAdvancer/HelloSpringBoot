package com.lbh.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * AOP 处理类
 * Created by Advancer on 2018/1/14 16:26.
 * auth: lbh
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.lbh.Controller.UserController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(){
        logger.info("doBefore()111");
        //  ....一些逻辑操作
    }

    @After("log()")
    public void doAfter(){
        logger.info("doAfter()222");
        //  ....一些逻辑操作
    }

}
