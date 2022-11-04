package com.catalystplus.admin.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @author : 蓝染
 * date : 2022/9/26 14:02
 */
@Aspect
@Component
@Slf4j
public class GlobalAspect {
    public static final NamedThreadLocal<String> GLOBAL_ID = new NamedThreadLocal<>("GlobalId");
    public static final NamedThreadLocal<String> REQUEST_IP = new NamedThreadLocal<>("RequestIp");
    public static final NamedThreadLocal<LocalDateTime> REQUEST_TIME = new NamedThreadLocal<>("RequestTime");
    public static final NamedThreadLocal<Integer> PAGE_NO = new NamedThreadLocal<>("PageNo");
    public static final NamedThreadLocal<Integer> PAGE_SIZE = new NamedThreadLocal<>("PageSize");
    public static final NamedThreadLocal<Long> PAGE_TOTAL = new NamedThreadLocal<>("PageTotal");

    /**
     * 保存每个线程调用方法名
     */
    private static final NamedThreadLocal<String> REQUEST_METHOD_THREAD_LOCAL = new NamedThreadLocal<>("method");

    /**
     * 打印报文最大长度限制
     */
    private static final Integer MAX_LEN = 1024;
    /**
     * 保存每个线程调用方法开始时间
     */
    private static final NamedThreadLocal<Long> START_TIME_THREAD_LOCAL = new NamedThreadLocal<>("startTime");

    @Pointcut("execution(public * com.catalystplus.admin.controller..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("aaaaaaaaaaaaaaaa");
        try {
            REQUEST_TIME.set(LocalDateTime.now());
            final ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (null != attributes) {
                final HttpServletRequest request = attributes.getRequest();
                final String globalId = request.getHeader("GlobalId");
                REQUEST_IP.set(request.getHeader("origin-ip-address"));
                if (StringUtils.isNotEmpty(globalId)) {
                    GLOBAL_ID.set(globalId);
               //     log.info("GlobalId:{}", globalId);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("logAspect切面获取请求头异常", ex);
        }


        START_TIME_THREAD_LOCAL.set(System.currentTimeMillis());
        final String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        final String methodName = joinPoint.getSignature().getName();
        final String path = String.format("%s.%s", className, methodName);
        REQUEST_METHOD_THREAD_LOCAL.set(path);
//        log.info("请求方法:{}, GlobalId:{}", path, GLOBAL_ID.get());

//        final String args = JsonUtils.objectToJson(joinPoint.getArgs());
//        if (Objects.requireNonNull(args).length() > MAX_LEN){
//            log.info("请求方法:{}, GlobalId:{}, 入参:{}", path,  GLOBAL_ID.get(), args.substring(0, MAX_LEN));
//        }else {
//            log.info("请求方法:{}, GlobalId:{}, 入参:{}", path,  GLOBAL_ID.get(), args);
//        }
    }

    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public Object afterReturn(Object result) {
        final Long endTime = System.currentTimeMillis();
        final Long startTime = START_TIME_THREAD_LOCAL.get();
        log.info("请求方法: {}, GlobalId: {}, 耗时: {}ms", REQUEST_METHOD_THREAD_LOCAL.get(), GLOBAL_ID.get(), endTime - startTime);
//        final String response = JsonUtils.objectToJson(result);
//        assert response != null;
//        if (response.length() > MAX_LEN) {
//            log.info("请求方法:{}, GlobalId:{}  响应:{}  耗时(毫秒):{}", REQUEST_METHOD_THREAD_LOCAL.get(), GLOBAL_ID.get(), response.substring(0, MAX_LEN), endTime - startTime);
//        } else {
//            log.info("请求方法:{}, GlobalId:{}  响应:{}  耗时(毫秒):{}", REQUEST_METHOD_THREAD_LOCAL.get(), GLOBAL_ID.get(), response, endTime - startTime);
//        }

        removeThreadLocal();
        return result;
    }

    /**
     * 及时清除threadlocal变量 避免内存泄漏
     */
    public static void removeThreadLocal() {
        START_TIME_THREAD_LOCAL.remove();
        GLOBAL_ID.remove();
        REQUEST_METHOD_THREAD_LOCAL.remove();
        REQUEST_IP.remove();
        REQUEST_TIME.remove();
        PAGE_NO.remove();
        PAGE_SIZE.remove();
        PAGE_TOTAL.remove();
    }
}
