package com.liudehuang.datasource.annotation;

import java.lang.annotation.*;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.annotation.aspect
 * @Author: liudehuang
 * @CreateTime: 2019-07-15 11:42:22
 * @Description: todo
 **/
@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MchDataSource {
    String value() default "";
}
