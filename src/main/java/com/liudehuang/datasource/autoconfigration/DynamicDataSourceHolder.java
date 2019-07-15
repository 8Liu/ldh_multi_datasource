package com.liudehuang.datasource.autoconfigration;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.autoconfigration
 * @Author: liudehuang
 * @CreateTime: 2019-07-12 11:41:42
 * @Description: 数据源变量副本
 **/
public class DynamicDataSourceHolder {
    /**
     * 数据源线程：当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     *  所以每个线程都可以独立的改变自己的变量副本，而不会影响其他线程的所对应的变量副本
     */
    private static final ThreadLocal<String> currentDataSource = new ThreadLocal<>();

    /**
     * 用于存储已经实例化后的数据源
     */
    private static Map<Object,Object> dataSourceMap = new HashMap<>();

    /**
     * 切换数据源名
     *
     * @param dataSourceKey
     */
    public static void setDataSourceKey(String dataSourceKey) {
        currentDataSource.set(dataSourceKey);
    }

    /**
     * 获取当前数据源名
     *
     * @return
     */
    public static String getDataSourceKey() {
        return currentDataSource.get();
    }

    /**
     * 清除当前数据源名
     */
    public static void clearDataSourceKey() {
        currentDataSource.remove();
    }

    /**
     * 获取存储已实例的数据源map
     *
     * @return
     */
    public static Map<Object, Object> getDataSourceMap() {
        return dataSourceMap;
    }

    /**
     * 是否存在当前key的 DataSource
     *
     * @param key
     * @return 存在返回 true, 不存在返回 false
     */
    public static boolean isExistDataSource(String key) {
        return dataSourceMap.containsKey(key);
    }


}
