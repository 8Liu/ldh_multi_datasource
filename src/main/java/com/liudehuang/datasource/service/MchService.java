package com.liudehuang.datasource.service;

import com.liudehuang.datasource.entity.MchEntity;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.service
 * @Author: liudehuang
 * @CreateTime: 2019-07-15 14:41:34
 * @Description: todo
 **/
public interface MchService {

    int saveMch(MchEntity mchEntity);

    MchEntity queryMch(Integer id);

    MchEntity queryMchByMchId(Long mchId);
}
