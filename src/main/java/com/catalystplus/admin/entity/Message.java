package com.catalystplus.admin.entity;


import java.util.HashMap;
import java.util.Map;

/**
 * 封装消息数据实体类
 */
public class Message {
    // 主题
    private String topic;
    // 标签
    private String tags;
    // 消息数据
    private final Map<String, Object> data = new HashMap<>();

    public String getTopic() {
        return topic;
    }

    public Message setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public String getTags() {
        return tags;
    }

    public Message setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Message setData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
