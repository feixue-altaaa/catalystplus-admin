package com.catalystplus.admin.constant;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 用户数据有关的常量
 */
public final class AdminUserConstant {

    // TODO: 2022/11/24 所有data改成admin 
    // TODO: 2022/11/24 常量类不是用接口，用静态终类变量 
    // TODO: 2022/11/24 常量里面写上注释 

    /**
     * 学历名称常量
     */
    public static final String[] EDUCATION = {"undergraduate", "master", "doctor", "teacher"};

    /**
     * 学校类型名称常量
     */
    public static final String[] UNIVERSITY_TYPE = {"c9", "985", "211", "other"};

    /**
     * 学科名称常量
     */
    public static final String[] DISCIPLINE = {"哲学", "经济学", "法学",
            "教育学", "文学", "历史学", "理学", "工学", "农学", "医学", "军事学", "管理学",
            "艺术学", "交叉学科"};

    /**
     * 学科编号常量
     */
    public static final String[] DISCIPLINE_CODE = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14"};

    public static final List<String> MAJOR_CODE = new ArrayList<>();

    static {
        try (
            // getClassLoader是直接从classpath开始查找文件的，因此使用这个就需要定位在classpath这个位置
            InputStream is = AdminUserConstant.class.getClassLoader().getResourceAsStream("UserMajorCode.properties");
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is)));
        ) {
            String str;
            while ((str = reader.readLine()) != null) {
                MAJOR_CODE.add(str);
            }
        } catch (Exception e) {
            throw new RuntimeException("加载userinfo.properties失败");
        }

    }

    /**
     * C9院校
     */
    public static final String[] LIST_C9 = {"清华大学", "北京大学", "浙江大学", "上海交通大学", "南京大学",
            "中国科学技术大学", "西安交通大学", "哈尔滨工业大学", "复旦大学"};

    /**
     * 985院校（未写完）
     */
    public static final String[] LIST_985 = {"北京航空航天大学", "中国人民大学", "中山大学", "东北大学"};

    /**
     * 211院校(未写完)
     */
    public static final String[] LIST_211 = {"安徽大学", "合肥工业大学", "南京航空航天大学"};

    /**
     * 冒号分隔符
     */
    public static final String SPLIT = ":";

    /**
     * 今日新增用户数
     */
    public static final String ADMIN_USER_ACTIVE_NNUT = "admin:user:active:nnut";

    /**
     * 日活跃用户数
     */
    public static final String ADMIN_USER_ACTIVE_DAU = "admin:user:active:dau";

    /**
     * 周活跃用户数
     */
    public static final String ADMIN_USER_ACTIVE_WAU = "admin:user:active:wau";

    /**
     * 月活跃用户数
     */
    public static final String ADMIN_USER_ACTIVE_MAU = "admin:user:active:mau";

    /**
     * 同时在线活跃用户数
     */
    public static final String ADMIN_USER_ACTIVE_NACU = "admin:user:active:nacu";

    /**
     * 同时在线新用户数
     */
    public static final String ADMIN_USER_ACTIVE_NNCU = "admin:user:active:nncu";

    /**
     * 七天前用户留存数
     */
    public static final String ADMIN_USER_ACTIVE_WNRU = "admin:user:active:wnru";

    /**
     * 一个月前用户留存数
     */
    public static final String ADMIN_USER_ACTIVE_MNRU = "admin:user:active:mnru";


    /**
     * 用户信息
     */
    public static final String ADMIN_USER_INFO = "admin:user:info";

    /**
     * 今日期刊订阅用户数
     */
    public static final String ADMIN_USER_TODAY_SUBSCRIPTION = "admin:user:today:subscription";

    /**
     * 今日阅读文章用户总数
     */
    public static final String ADMIN_USER_TODAY_READ = "admin:user:today:read";

    /**
     * 今日文章收藏用户总数
     */
    public static final String ADMIN_USER_TODAY_COLLECT = "admin:user:today:collect";

    /**
     * 今日打标签用户总数
     */
    public static final String ADMIN_USER_TODAY_TAG = "admin:user:today:tag";

    /**
     * 今日做笔记用户总数
     */
    public static final String ADMIN_USER_TODAY_NOTE = "admin:user:today:note";

    /**
     * 今日文章总点赞用户热度
     */
    public static final String ADMIN_USER_TODAY_GOOD = "admin:user:today:good";
}
