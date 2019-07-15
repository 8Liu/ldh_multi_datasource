package com.liudehuang.datasource.autoconfigration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.autoconfigration
 * @Author: liudehuang
 * @CreateTime: 2019-07-12 11:40:18
 * @Description: 动态数据源类
 **/
@Slf4j
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    /**
     * 获取[确认]当前数据源的key
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        //从ThreadLocal中获取当前数据源的key
        Object dataSourceKey = DynamicDataSourceHolder.getDataSourceKey();
        log.info("current DataSourceKey:[{}]",dataSourceKey);
        return dataSourceKey;
    }

    /**
     * 设置数据源
     * @param targetDataSources
     */
    @Override
    public void setTargetDataSources(Map<Object,Object> targetDataSources){
        super.setTargetDataSources(targetDataSources);
        DynamicDataSourceHolder.getDataSourceMap().putAll(targetDataSources);
    }
}
