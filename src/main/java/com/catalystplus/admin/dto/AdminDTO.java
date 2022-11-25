package com.catalystplus.admin.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author 蓝染
 * @Date 2022/11/24 18:02
 * @Version 1.5
 */
@Data
public class AdminDTO implements Serializable {


    private static final long serialVersionUID = 7754458787662051239L;

    private Long userId;

    private Long paperId;

    private Integer onlineFlag;

    private Integer deviceFlag;

    private LocalDateTime loginTime;

    private LocalDateTime createdTime;

    public AdminDTO() {
    }
}
