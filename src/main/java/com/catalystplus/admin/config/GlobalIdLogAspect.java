package com.catalystplus.admin.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import static com.catalystplus.admin.config.GlobalAspect.GLOBAL_ID;

/**
 * @author : 蓝染
 * date : 2022/9/26 14:02
 */
@Aspect
@Component
@Slf4j
public class GlobalIdLogAspect {

    @Pointcut("execution(public * com.catalystplus.admin..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        try {
            if (StringUtils.isNotEmpty(GLOBAL_ID.get())) {
                MDC.put("globalId", GLOBAL_ID.get());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("logAspect切面获取请求头异常", ex);
        }

    }

}
