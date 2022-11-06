package com.catalystplus.admin.exception;


import com.catalystplus.admin.response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
public class Assert {

    /**
     * 断言对象不为空
     * obj 为空则抛异常
     *
     * @param obj
     * @param responseCode
     */
    public static void notNull(Object obj, ResponseCode responseCode) {
        if (obj == null) {
            log.info("obj is null.....................");
            throw new BusinessException(responseCode);
        }
    }


    /**
     * 断言对象为空
     * 如果对象obj不为空，则抛出异常
     *
     * @param object
     * @param responseCode
     */
    public static void isNull(Object object, ResponseCode responseCode) {
        if (object != null) {
            log.info("obj is not null......");
            throw new BusinessException(responseCode);
        }
    }

    /**
     * 断言表达式为真
     * 如果不为真，则抛出异常
     *
     * @param expression 是否成功
     */
    public static void isTrue(boolean expression, ResponseCode responseCode) {
        if (!expression) {
            log.info("fail...............");
            throw new BusinessException(responseCode);
        }
    }

    /**
     * 断言两个对象不相等
     * 如果相等，则抛出异常
     *
     * @param m1
     * @param m2
     * @param responseCode
     */
    public static void notEquals(Object m1, Object m2, ResponseCode responseCode) {
        if (m1.equals(m2)) {
            log.info("equals...............");
            throw new BusinessException(responseCode);
        }
    }

    /**
     * 断言两个对象相等
     * 如果不相等，则抛出异常
     *
     * @param m1
     * @param m2
     * @param responseCode
     */
    public static void equals(Object m1, Object m2, ResponseCode responseCode) {
        if (!m1.equals(m2)) {
            log.info("not equals...............");
            throw new BusinessException(responseCode);
        }
    }

    /**
     * 断言参数不为空
     * 如果为空，则抛出异常
     *
     * @param s
     * @param responseCode
     */
    public static void notEmpty(String s, ResponseCode responseCode) {
        if (StringUtils.isEmpty(s)) {
            log.info("is empty...............");
            throw new BusinessException(responseCode);
        }
    }

    public static void notEmpty(Long s, ResponseCode responseCode) {
        if (null == s) {
            log.info("is empty...............");
            throw new BusinessException(responseCode);
        }
    }


    public static void notEmpty(Boolean s, ResponseCode responseCode) {
        if (null == s) {
            log.info("is empty...............");
            throw new BusinessException(responseCode);
        }
    }

    public static boolean notEmpty(String s, String a) {
        if (StringUtils.isEmpty(s) && StringUtils.isEmpty(a)) {
            log.info("is empty...............");
            return true;
        }
        return false;
    }

    public static boolean notEmpty(List<Long> s, List<Long> a) {
        if (null == s && null == a) {
            log.info("is empty...............");
            return true;
        } else if (null == s && a.size() == 0) {
            log.info("is empty...............");
            return true;
        } else if (null != s && s.size() == 0 && null == a) {
            log.info("is empty...............");
            return true;
        } else if (null != s && null != a && s.size() == 0 && a.size() == 0) {
            log.info("is empty...............");
            return true;
        }
        return false;
    }


    public static boolean notEmpty(Long s, Long a) {
        if (null == s && null == a) {
            log.info("is empty...............");
            return true;
        }
        return false;
    }


    public static boolean notEmpty(Long a) {
        if (null == a) {
            log.info("is empty...............");
            return true;
        }
        return false;
    }

    public static boolean notEmpty(String a) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(a)) {
            log.info("is empty...............");
            return true;
        }
        return false;
    }


    public static void notEmpty(List<Long> ids, ResponseCode responseCode) {
        if (null == ids || ids.size() == 0) {
            log.info("is empty...............");
            throw new BusinessException(responseCode);
        }
    }


}
