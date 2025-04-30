package com.example.springsample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.springsample.controller..*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        
        // リクエスト情報の取得
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        // リクエスト前のログ
        logger.info("==================== Start API ====================");
        logger.info("URI       : {}", request.getRequestURI());
        logger.info("HTTP Method : {}", request.getMethod());
        logger.info("Controller : {}.{}", 
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        logger.info("Parameters : {}", Arrays.toString(joinPoint.getArgs()));

        try {
            // メソッド実行
            Object result = joinPoint.proceed();
            
            // 実行後のログ
            logger.info("Response   : {}", result);
            logger.info("Process Time : {}ms", System.currentTimeMillis() - start);
            logger.info("==================== End API ====================");
            
            return result;
        } catch (Exception e) {
            // エラー時のログ
            logger.error("==================== Error ====================");
            logger.error("Error Message : {}", e.getMessage());
            logger.error("Stack Trace   : ", e);
            throw e;
        }
    }
} 