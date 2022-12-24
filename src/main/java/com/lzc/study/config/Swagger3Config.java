package com.lzc.study.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger3Config {
    /**
     *创建Docket类型对象，并使用spring容器管理
     *Docket是Swagger中的全局配置对象
     */
    @Bean
    public Docket docket()
    {
        Docket docket=new Docket(DocumentationType.SWAGGER_2);
        ApiInfo newApiInfo= new ApiInfoBuilder().contact(
                //配置Swagger文档主体内容
                new Contact("amonstercat的开发文档",
                        "https://amonstercat.github.io/",
                        "amonstercattt@gmail.com")
        )
                .title("Swagger框架学习文档")
                .description("Swagger框架学习文档描述-Swagger是一个用于开发RestAPI帮助文档的框架")
                .version("1.0.0")
                .build();
        docket.apiInfo(newApiInfo);
        docket.select() //获取Docket中的选择器，返回ApiSelectorBuilder，构建选择器
                    .apis(RequestHandlerSelectors.basePackage("com.lzc.study.controller"))//设定扫描哪个路径下包及其子包的注解
                    .paths(PathSelectors.regex("/swagger/.*")) //使用正则表达式，约束可生成API文档的路径地址
         .build();
        return  docket;
    }
}
