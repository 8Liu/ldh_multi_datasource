package com.liudehuang.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource
 * @Author: liudehuang
 * @CreateTime: 2019-07-11 20:10:51
 * @Description: todo
 **/
@SpringBootApplication
@MapperScan("com.liudehuang.datasource.mapper")
public class DataSourceApp {
    public static void main(String[] args) {
        SpringApplication.run(DataSourceApp.class,args);
    }
}
