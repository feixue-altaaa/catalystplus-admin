package com.catalystplus.admin.response.paperCount;

import lombok.Data;

import java.io.Serializable;

@Data
public class RiseResponse {

    /**
     * 文章较昨日增长比例
     */
    private Double paperRise;

    /**
     * 期刊较昨日增长比例
     */
    private Double journalRise;

}
