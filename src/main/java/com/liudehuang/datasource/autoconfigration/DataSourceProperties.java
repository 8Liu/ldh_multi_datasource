package com.liudehuang.datasource.autoconfigration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.autoconfigration
 * @Author: liudehuang
 * @CreateTime: 2019-07-11 20:22:25
 * @Description: todo
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "spring")
public class DataSourceProperties {
    /**
     * 数据源基础配置
     */
    private Map<String,String> dataSource;
    /**
     * 主数据源名称
     * 无数据源名称则不需要配置，如果配置了dynamicDataBase则必须配置，
     * 名称必须是dynamicDataBase的数据源名称的其中一个
     */
    private String mainDatabase = DataSourcePropertiesUtil.DEFAULT_SOURCE_NAME;
    /**
     * 动态数据源
     */
    private Map<String,Object> dynamicDataBase;
}
