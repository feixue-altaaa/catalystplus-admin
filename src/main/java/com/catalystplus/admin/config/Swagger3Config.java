package com.catalystplus.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author 蓝染
 * @Date 2022/10/8 21:39
 * @Version 1.1
 */
@EnableOpenApi
@Configuration
public class Swagger3Config {

    @Bean
    public Docket createRestApi() {
        //返回文档概要信息
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                //不显示默认的错误页面接口
                .paths(PathSelectors.regex("/error").negate())
                .build();
    }

    /**
     * 生成接口信息，包括标题，联系人等
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Catalystplus-library接口文档")
                .description("接口文档属性说明")
                //           .contact(new Contact("百度","http://www.baidu.com","11017294@qq.com"))
                .version("1.0")
                .build();
    }

}
