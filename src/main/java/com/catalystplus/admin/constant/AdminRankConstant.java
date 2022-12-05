package com.catalystplus.admin.constant;

public final class AdminRankConstant {

    /**
     *期刊订阅总数
     */
    public static final String ADMIN_RANK_TOTAL_SUBSCRIPTION = "admin:rank:total:subscription";

    /**
     * 今日期刊订阅数
     */
    public static final String ADMIN_RANK_TODAY_SUBSCRIPTION = "admin:rank:today:subscription";

    /**
     * 今日阅读文章总数
     */
    public static final String ADMIN_RANK_TODAY_READ = "admin:rank:today:read";

    /**
     * 阅读文章总数
     */
    public static final String ADMIN_RANK_TOTAL_READ = "admin:rank:total:read";

    /**
     * 今日文章收藏总数
     */
    public static final String ADMIN_RANK_TODAY_COLLECT = "admin:rank:today:collect";

    /**
     * 文章收藏总数
     */
    public static final String ADMIN_RANK_TOTAL_COLLECT = "admin:rank:total:collect";

    /**
     * 打标签总数
     */
    public static final String ADMIN_RANK_TOTAL_TAG = "admin:rank:total:tag";

    /**
     * 今日打标签总数
     */
    public static final String ADMIN_RANK_TODAY_TAG = "admin:rank:today:tag";


    /**
     * 做笔记总数
     */
    public static final String ADMIN_RANK_TOTAL_NOTE = "admin:rank:total:note";

    /**
     * 今日做笔记总数
     */
    public static final String ADMIN_RANK_TODAY_NOTE = "admin:rank:today:note";

    /**
     * 文章总点赞热度
     */
    public static final String ADMIN_RANK_TOTAL_GOOD = "admin:rank:total:good";

    /**
     * 今日文章总点赞热度
     */
    public static final String ADMIN_RANK_TODAY_GOOD = "admin:rank:today:good";


    /**
     * 期刊订阅总数
     */
    public static final String SUBSCRIPTION_TOTAL = "subscription_total";

    /**
     * 文章收藏总数
     */
    public static final String COLLECT_TOTAL = "collect_total";

    /**
     * 文章标签总数
     */
    public static final String TAG_TOTAL = "tag_total";

    /**
     * 文章笔记总数
     */
    public static final String NOTE_TOTAL = "note_total";

    /**
     * 文章点赞总数
     */
    public static final String GOOD_TOTAL = "good_total";

    /**
     * 文章排行榜数量
     */
    public static final Long rankNumber = 10L;

    /**
     * Redis起始点
     */
    public static final Long rankStart = 0L;

    /**
     * Redis结束点
     */
    public static final Long rankEnd = -1L;


}
