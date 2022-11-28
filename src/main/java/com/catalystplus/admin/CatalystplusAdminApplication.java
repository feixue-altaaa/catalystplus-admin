package com.catalystplus.admin;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@RefreshScope
@MapperScan("com.catalystplus.admin.mapper")
@SpringBootApplication
@Slf4j
@EnableScheduling
public class CatalystplusAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalystplusAdminApplication.class, args);
    }

}
