package com.catalystplus.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@RefreshScope
@MapperScan("com.catalystplus.admin.mapper")
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class CatalystplusAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalystplusAdminApplication.class, args);
    }

}
