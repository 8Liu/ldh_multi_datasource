package com.liudehuang.datasource.mapper;

import com.liudehuang.datasource.entity.MchEntity;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.mapper
 * @Author: liudehuang
 * @CreateTime: 2019-07-15 14:32:02
 * @Description: todo
 **/
public interface MchMapper {

    int saveMch(MchEntity mchEntity);

    MchEntity queryMch(Integer id);

    MchEntity queryMchByMchId(Long mchId);
}
