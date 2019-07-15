package com.liudehuang.datasource.autoconfigration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.autoconfigration
 * @Author: liudehuang
 * @CreateTime: 2019-07-12 13:35:25
 * @Description: 数据源转化处理工具类
 **/
public class DataSourcePropertiesUtil {
    /**
     * 默认数据源名称
     */
    public static final String DEFAULT_SOURCE_NAME = "master_1";

    public static final Map<String, Properties> prop2DBMap(Map<String, String> properties,
                                                           Map<String, Object> dynamicDataBase) {
        Map<String, Properties> allMap = new HashMap<String, Properties>();
        if (null == dynamicDataBase || dynamicDataBase.isEmpty()) {
            // 单数据源
            Properties entryProperties = new Properties();
            entryProperties.putAll(properties);
            allMap.put(DEFAULT_SOURCE_NAME, entryProperties);
            return allMap;
        }

        // 多数据源
        for (Map.Entry<String, Object> entry : dynamicDataBase.entrySet()) {
            // 复制通用的数据源配置
            /**
             * key:"" value:""
             * name   ""
             * type -> com.alibaba.druid.pool.DruidDataSource
             * url -> jdbc:mysql://127.0.0.1:3306/member?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false
             */
            Properties entryProperties = new Properties();
            entryProperties.putAll(properties);

            // 获取数据源独立配置信息
            if (null != entry.getValue() && entry.getValue() instanceof Map) {
                Map<String, String> dataConfigMap = (Map<String, String>) entry.getValue();
                // 设置数据源的独立配置项
                for (Map.Entry<String, String> dataEntry : dataConfigMap.entrySet()) {
                    entryProperties.put(dataEntry.getKey(), dataEntry.getValue());
                }
            }
            allMap.put(entry.getKey(), entryProperties);
        }
        return allMap;
    }
}
