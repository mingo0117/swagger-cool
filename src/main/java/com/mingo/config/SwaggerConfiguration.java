package com.mingo.config;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Copyright@www.jd.com
 * Author:mingo
 * Date:2018/5/24 15:34
 * Description:Swagger的一些基本配置
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${env}")
    private String env;

    /**
     * 暂时只考虑支持json类型，保持简单。xml性能太差
     * @return
     */
    @Bean
    public Docket odmsPlugin() {
        Set envSet = new HashSet<>();
        if("prod".equalsIgnoreCase(env)){
            envSet.add("http");
            envSet.add("https");
        }else{
            envSet.add("http");
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("mingo-api")
                .produces(Sets.newHashSet("application/json"/*, "application/xml"*/))
                .consumes(Sets.newHashSet("application/json"/*, "application/xml"*/))
                .protocols(envSet)
                .directModelSubstitute(LocalDate.class, Long.class)//返回时间统一转为long
                .directModelSubstitute(DateTime.class, Long.class)
                .select().paths(or(
                        regex("/api/.*")))
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Mingo's OpenAPI")
                .description("对外接口文档示例。Swagger注解参考文档[swagger-api-annotations](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X#quick-annotation-overview)（test token：[123]）")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("明哥","", "mingo6666666@gmail.com"))
                .build();
    }
}
