package com.liudehuang.datasource.service.impl;

import com.liudehuang.datasource.entity.MchEntity;
import com.liudehuang.datasource.mapper.MchMapper;
import com.liudehuang.datasource.service.MchService;
import com.liudehuang.datasource.utils.KeyWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.service.impl
 * @Author: liudehuang
 * @CreateTime: 2019-07-15 14:42:22
 * @Description: todo
 **/
@Service
public class MchServiceImpl implements MchService {
    @Autowired
    private MchMapper mchMapper;

    @Override
    public int saveMch(MchEntity mchEntity) {
        mchEntity.setMchId(KeyWorker.nextId());
        return mchMapper.saveMch(mchEntity);
    }

    @Override
    public MchEntity queryMch(Integer id) {
        return mchMapper.queryMch(id);
    }

    @Override
    public MchEntity queryMchByMchId(Long mchId) {
        return mchMapper.queryMchByMchId(mchId);
    }
}
