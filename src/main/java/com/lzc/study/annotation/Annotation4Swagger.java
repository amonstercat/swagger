package com.lzc.study.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一个注解类
 * @Target-描述当前注解类作用于什么资源（类、方法）上
 * 属性value定义具体的资源包括：
 * -ElementType.METHOD 定义在方法上
 * -ElementType.TYPE   定义在类型上
 * -ElementType.FIELD  定义在属性上
 * -ElementType.PARAMETER  定义在方法的参数上
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation4Swagger {
      String value() default "amonstercat";
}
