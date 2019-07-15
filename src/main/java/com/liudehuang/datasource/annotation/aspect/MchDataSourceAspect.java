package com.liudehuang.datasource.annotation.aspect;

import com.liudehuang.datasource.annotation.MchDataSource;
import com.liudehuang.datasource.autoconfigration.DataSourceProperties;
import com.liudehuang.datasource.autoconfigration.DynamicDataSourceHolder;
import com.liudehuang.datasource.entity.MchEntity;
import com.liudehuang.datasource.service.MchService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.prefs.PreferencesFactory;

@Configuration
@Slf4j
@Component
@Order(-1)
@Aspect
public class MchDataSourceAspect {


    @Autowired
    private DataSourceProperties dataSourceMap;

    @Autowired
    private MchService mchService;

    @Before(value = "@annotation(mchDataSource)")
    public void before(JoinPoint joinPoint, MchDataSource mchDataSource) throws Exception{
        Object[] args = joinPoint.getArgs();
        if(args==null||args.length==0){
            throw new RuntimeException("参数不能为空");
        }
        // 获取方法参数对象的商户编号字段属性值
        PropertyAccessor propertyAccessor = PropertyAccessorFactory.forDirectFieldAccess(args[0]);
        Object mchObject = propertyAccessor.getPropertyValue("mchId");
        Long mchId = 0L;
        if(mchObject!=null){
            // 从商户数据源编码存储器获取商户数据源编码
            mchId = (Long) mchObject;
        }
        MchEntity mchEntity = mchService.queryMchByMchId(mchId);
        Integer dataSourceNo = mchEntity.getDataSource();
        String dataSource = mchDataSource.value() + dataSourceNo;
        log.info("datasource:[{}]",dataSource);
        System.out.println("datasource:"+dataSource);
        if(dataSource!=null){
            DynamicDataSourceHolder.setDataSourceKey(dataSource);
        }else {
            DynamicDataSourceHolder.setDataSourceKey(dataSourceMap.getMainDatabase());
        }

    }


    @After("@annotation(com.liudehuang.datasource.annotation.MchDataSource)")
    public void doAfter(JoinPoint joinPoint) {
        log.debug("====>缓存清理");
        DynamicDataSourceHolder.clearDataSourceKey();
    }
}