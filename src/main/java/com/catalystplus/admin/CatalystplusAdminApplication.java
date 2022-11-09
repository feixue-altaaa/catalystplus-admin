package com.catalystplus.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@RefreshScope
@MapperScan("com.catalystplus.admin.mapper")
@SpringBootApplication
public class CatalystplusAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalystplusAdminApplication.class, args);
    }

}
